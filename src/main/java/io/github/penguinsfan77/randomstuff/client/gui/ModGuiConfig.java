package io.github.penguinsfan77.randomstuff.client.gui;

import io.github.penguinsfan77.randomstuff.handlers.ConfigHandler;
import io.github.penguinsfan77.randomstuff.references.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

public class ModGuiConfig extends GuiConfig {
	
	public ModGuiConfig(GuiScreen guiScreen) {
		
        super(guiScreen,
                new ConfigElement(ConfigHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigHandler.configuration.toString()));
        
    }

}
