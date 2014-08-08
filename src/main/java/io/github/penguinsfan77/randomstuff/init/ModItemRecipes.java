package io.github.penguinsfan77.randomstuff.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItemRecipes {
	
	public static void init() {
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.hammer, "   ", " i ", " s ", 'i', "ingotIron", 's', "stickWood"));
		
		for (int meta = 0; meta < 16; meta++) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.coloredStick, 1, meta), "stickWood", new ItemStack(Items.dye, 1, meta)));
		}
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick), new ItemStack(ModItems.coloredStick, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.water_bucket));
		
	}

}
