package io.github.penguinsfan77.randomstuff;

import io.github.penguinsfan77.randomstuff.crafting.ColoredItemsRecipe;
import io.github.penguinsfan77.randomstuff.crafting.ReColoredItemsRecipe;
import io.github.penguinsfan77.randomstuff.handlers.ConfigHandler;
import io.github.penguinsfan77.randomstuff.handlers.ItemEventHandler;
import io.github.penguinsfan77.randomstuff.init.ModBlockRecipes;
import io.github.penguinsfan77.randomstuff.init.ModBlocks;
import io.github.penguinsfan77.randomstuff.init.ModItemRecipes;
import io.github.penguinsfan77.randomstuff.init.ModItems;
import io.github.penguinsfan77.randomstuff.init.ModOreDictionary;
import io.github.penguinsfan77.randomstuff.proxy.IProxy;
import io.github.penguinsfan77.randomstuff.references.Reference;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Reference.MOD_ID, 
name= Reference.MOD_NAME, 
version= Reference.VERSION,
guiFactory= Reference.GUI_FACTORY_CLASS)
public class RandomStuff {

	//Instance of the mod
	@Mod.Instance(Reference.MOD_ID)
	public static RandomStuff instance;
	
	//The proxy
	@SidedProxy(clientSide= Reference.CLIENT_PROXY_CLASS, serverSide= Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	//Pre-Init
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		
		//Setup the config
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        
        //Register items and blocks
        ModItems.init();
        ModBlocks.init();
        
    }

	//Init
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    	
        //Register recipes
    	RecipeSorter.register("randomstuff:colored", ColoredItemsRecipe.class, Category.SHAPED, "before:forge:shapedore");
    	RecipeSorter.register("randomstuff:recolored", ReColoredItemsRecipe.class, Category.SHAPELESS, "before:forge:shapedore after:randomstuff:colored");
    	ModItemRecipes.init();
    	ModBlockRecipes.init();
    	ModOreDictionary.init();
    	
    	//Register event handlers
    	FMLCommonHandler.instance().bus().register(new ItemEventHandler());
        
    }

    //Post-Init
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
        LogHelper.info(Reference.MOD_NAME + " has been initialized!");
        
    }

}
