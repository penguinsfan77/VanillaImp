package io.github.penguinsfan77.vanillaimprovements.handlers;

import java.io.File;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import io.github.penguinsfan77.vanillaimprovements.references.Reference;

public class ConfigHandler {
	
	public static Configuration configuration;
	
	public static boolean allTools = false;

    public static void init(File configFile) {
    	
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
        
    }

    private static void loadConfiguration() {

    	//Load the config values from the file
    	allTools = configuration.getBoolean("allToolVarities", Configuration.CATEGORY_GENERAL, false, StatCollector.translateToLocal("config.desc.allTools"), "gui.config.allTools");
    	
    	//Save config if it changed
        if (configuration.hasChanged())
        {
            configuration.save();
        }
        
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
    	
    	//Reload the config when it changes
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
        
    }

}
