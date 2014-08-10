package io.github.penguinsfan77.randomstuff.init;

import io.github.penguinsfan77.randomstuff.crafting.ColoredItemsRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItemRecipes {
	
	public static void init() {
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.hammer, "   ", " i ", " s ", 'i', "ingotIron", 's', "stickWood"));
		
		for (int meta = 0; meta < 16; meta++) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.colored_stick, 1, meta), "stickWood", new ItemStack(Items.dye, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.emerald_pickaxe), "ddd", " s ", " s ", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.iron_pickaxe), "ddd", " s ", " s ", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.gold_pickaxe), "ddd", " s ", " s ", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.stone_pickaxe), "ddd", " s ", " s ", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.wood_pickaxe), "ddd", " s ", " s ", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.emerald_shovel), "d", "s", "s", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.iron_shovel), "d", "s", "s", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.gold_shovel), "d", "s", "s", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.stone_shovel), "d", "s", "s", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.wood_shovel), "d", "s", "s", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.emerald_axe), "dd ", "ds ", " s ", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.iron_axe), "dd ", "ds ", " s ", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.gold_axe), "dd ", "ds ", " s ", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.stone_axe), "dd ", "ds ", " s ", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.wood_axe), "dd ", "ds ", " s ", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.emerald_hoe), "dd", " s", " s", 'd', Items.diamond, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.iron_hoe), "dd", " s", " s", 'd', Items.iron_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.gold_hoe), "dd", " s", " s", 'd', Items.gold_ingot, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.stone_hoe), "dd", " s", " s", 'd', Blocks.cobblestone, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
			GameRegistry.addRecipe(new ColoredItemsRecipe(new ItemStack(ModItems.wood_hoe), "dd", " s", " s", 'd', Blocks.planks, 's', new ItemStack(ModItems.colored_stick, 1, meta)));
		}
		
	}

}
