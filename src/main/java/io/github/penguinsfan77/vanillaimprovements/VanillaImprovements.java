package io.github.penguinsfan77.vanillaimprovements;

import io.github.penguinsfan77.vanillaimprovements.crafting.ColoredItemsRecipe;
import io.github.penguinsfan77.vanillaimprovements.crafting.ReColoredItemsRecipe;
import io.github.penguinsfan77.vanillaimprovements.handlers.ConfigHandler;
import io.github.penguinsfan77.vanillaimprovements.handlers.ItemEventHandler;
import io.github.penguinsfan77.vanillaimprovements.init.ModBlockRecipes;
import io.github.penguinsfan77.vanillaimprovements.init.ModBlocks;
import io.github.penguinsfan77.vanillaimprovements.init.ModItemRecipes;
import io.github.penguinsfan77.vanillaimprovements.init.ModItems;
import io.github.penguinsfan77.vanillaimprovements.init.ModOreDictionary;
import io.github.penguinsfan77.vanillaimprovements.proxy.IProxy;
import io.github.penguinsfan77.vanillaimprovements.references.Reference;
import io.github.penguinsfan77.vanillaimprovements.utilities.LogHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
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
public class VanillaImprovements {

	//Instance of the mod
	@Mod.Instance(Reference.MOD_ID)
	public static VanillaImprovements instance;
	
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
    	
    	for (ItemStack item: OreDictionary.getOres("stickWood")) {
    		OreDictionary.registerOre("stick", item);
    	}
        LogHelper.info(Reference.MOD_NAME + " has been initialized!");
        
    }

}
