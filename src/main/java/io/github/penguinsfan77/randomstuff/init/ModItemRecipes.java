package io.github.penguinsfan77.randomstuff.init;

import java.util.ArrayList;
import java.util.List;

import io.github.penguinsfan77.randomstuff.crafting.ColoredItemsRecipe;
import io.github.penguinsfan77.randomstuff.crafting.ReColoredItemsRecipe;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItemRecipes {
	
	public static void init() {
		
		List recipes = new ArrayList<IRecipe>();
		
		for (int meta = 0; meta < 16; meta++) {
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_sword), "d", "d", "s", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_sword), "d", "d", "s", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_sword), "d", "d", "s", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_sword), "d", "d", "s", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_sword), "d", "d", "s", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_sword), new ItemStack(Items.diamond_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_sword), new ItemStack(Items.iron_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_sword), new ItemStack(Items.golden_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_sword), new ItemStack(Items.stone_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_sword), new ItemStack(Items.wooden_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_sword), new ItemStack(ModItems.diamond_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_sword), new ItemStack(ModItems.iron_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_sword), new ItemStack(ModItems.gold_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_sword), new ItemStack(ModItems.stone_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_sword), new ItemStack(ModItems.wood_sword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_pickaxe), "ddd", " s ", " s ", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_pickaxe), "ddd", " s ", " s ", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_pickaxe), "ddd", " s ", " s ", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_pickaxe), "ddd", " s ", " s ", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_pickaxe), "ddd", " s ", " s ", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_pickaxe), new ItemStack(Items.diamond_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_pickaxe), new ItemStack(Items.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_pickaxe), new ItemStack(Items.golden_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_pickaxe), new ItemStack(Items.stone_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_pickaxe), new ItemStack(Items.wooden_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_pickaxe), new ItemStack(ModItems.diamond_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_pickaxe), new ItemStack(ModItems.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_pickaxe), new ItemStack(ModItems.gold_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_pickaxe), new ItemStack(ModItems.stone_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_pickaxe), new ItemStack(ModItems.wood_pickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_shovel), "d", "s", "s", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_shovel), "d", "s", "s", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_shovel), "d", "s", "s", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_shovel), "d", "s", "s", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_shovel), "d", "s", "s", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_shovel), new ItemStack(Items.diamond_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_shovel), new ItemStack(Items.iron_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_shovel), new ItemStack(Items.golden_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_shovel), new ItemStack(Items.stone_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_shovel), new ItemStack(Items.wooden_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_shovel), new ItemStack(ModItems.diamond_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_shovel), new ItemStack(ModItems.iron_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_shovel), new ItemStack(ModItems.gold_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_shovel), new ItemStack(ModItems.stone_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_shovel), new ItemStack(ModItems.wood_shovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_axe), "dd ", "ds ", " s ", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_axe), "dd ", "ds ", " s ", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_axe), "dd ", "ds ", " s ", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_axe), "dd ", "ds ", " s ", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_axe), "dd ", "ds ", " s ", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_axe), new ItemStack(Items.diamond_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_axe), new ItemStack(Items.iron_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_axe), new ItemStack(Items.golden_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_axe), new ItemStack(Items.stone_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_axe), new ItemStack(Items.wooden_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_axe), new ItemStack(ModItems.diamond_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_axe), new ItemStack(ModItems.iron_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_axe), new ItemStack(ModItems.gold_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_axe), new ItemStack(ModItems.stone_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_axe), new ItemStack(ModItems.wood_axe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_hoe), "dd", " s", " s", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_hoe), "dd", " s", " s", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_hoe), "dd", " s", " s", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_hoe), "dd", " s", " s", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_hoe), "dd", " s", " s", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_hoe), new ItemStack(Items.diamond_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_hoe), new ItemStack(Items.iron_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_hoe), new ItemStack(Items.golden_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_hoe), new ItemStack(Items.stone_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_hoe), new ItemStack(Items.wooden_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_hoe), new ItemStack(ModItems.diamond_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_hoe), new ItemStack(ModItems.iron_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_hoe), new ItemStack(ModItems.gold_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_hoe), new ItemStack(ModItems.stone_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_hoe), new ItemStack(ModItems.wood_hoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));

			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_hammer), "d", "s", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_hammer), "d", "s", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_hammer), "d", "s", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_hammer), "d", "s", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_hammer), "d", "s", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_hammer), new ItemStack(ModItems.diamond_hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_hammer), new ItemStack(ModItems.iron_hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_hammer), new ItemStack(ModItems.gold_hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_hammer), new ItemStack(ModItems.stone_hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_hammer), new ItemStack(ModItems.wood_hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, meta)));
			
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModItems.colored_stick, 1, meta), "stickWood", new ItemStack(Items.dye, 1, meta)));
		}
		
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.diamond_hammer), "d", "s", 'd', "gemDiamond", 's', "stickWood"));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.iron_hammer), "d", "s", 'd', "ingotIron", 's', "stickWood"));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.gold_hammer), "d", "s", 'd', "ingotGold", 's', "stickWood"));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.stone_hammer), "d", "s", 'd', "cobblestone", 's', "stickWood"));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.wood_hammer), "d", "s", 'd', "plankWood", 's', "stickWood"));
		
		for (int i = 0; i < recipes.size(); i++) {
			GameRegistry.addRecipe((IRecipe) recipes.get(i));
		}
		LogHelper.info("Registered " + recipes.size() + " item recipes!");
		
	}

}
