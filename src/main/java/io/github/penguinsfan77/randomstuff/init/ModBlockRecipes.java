package io.github.penguinsfan77.randomstuff.init;

import java.util.ArrayList;
import java.util.List;

import io.github.penguinsfan77.randomstuff.items.tools.ModItemTool;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlockRecipes {
	
	public static void init() {
		
		List recipes = new ArrayList<IRecipe>();

		//Cracked stone
		ModItemTool[] hammers = {ModItems.diamond_hammer, ModItems.iron_hammer, ModItems.gold_hammer, ModItems.stone_hammer, ModItems.wood_hammer};
		for (ModItemTool hammer: hammers) {
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModBlocks.cracked_stone), new ItemStack(hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone)));
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModBlocks.cracked_stone, 2), new ItemStack(hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
					new ItemStack(Blocks.stone)));
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModBlocks.cracked_stone, 3), new ItemStack(hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
					new ItemStack(Blocks.stone), new ItemStack(Blocks.stone)));
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModBlocks.cracked_stone, 4), new ItemStack(hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
					new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone)));
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModBlocks.cracked_stone, 5), new ItemStack(hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
					new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone)));
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModBlocks.cracked_stone, 6), new ItemStack(hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
					new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone)));
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModBlocks.cracked_stone, 7), new ItemStack(hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
					new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone)));
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModBlocks.cracked_stone, 8), new ItemStack(hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
					new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone)));
		}
		
		for (int i = 0; i < recipes.size(); i++) {
			GameRegistry.addRecipe((IRecipe) recipes.get(i));
		}
		LogHelper.info("Registered " + recipes.size() + " block recipes!");
		
	}

}
