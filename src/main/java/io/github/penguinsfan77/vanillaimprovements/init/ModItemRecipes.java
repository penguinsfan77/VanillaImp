package io.github.penguinsfan77.vanillaimprovements.init;

import java.util.ArrayList;
import java.util.List;

import io.github.penguinsfan77.vanillaimprovements.crafting.ColoredItemsRecipe;
import io.github.penguinsfan77.vanillaimprovements.crafting.ReColoredItemsRecipe;
import io.github.penguinsfan77.vanillaimprovements.utilities.LogHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

//TODO: make completly ore dictionary compatible with sticks and planks
public class ModItemRecipes {

	private static String[] dyes = {
		"Black",
		"Red",
		"Green",
		"Brown",
		"Blue",
		"Purple",
		"Cyan",
		"LightGray",
		"Gray",
		"Pink",
		"Lime",
		"Yellow",
		"LightBlue",
		"Magenta",
		"Orange",
		"White"
	};

	public static void init() {
		
		List recipes = new ArrayList<IRecipe>();
		
		for (int meta = 0; meta < 16; meta++) {
			recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.stick, 1, meta), "p", "p", 'p', new ItemStack(ModBlocks.colored_planks, 1, meta)));
			recipes.add(new ShapelessOreRecipe(new ItemStack(ModItems.stick, 1, meta), "stickWood", "dye" + dyes[meta]));
			recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.trident_head, 1, meta), "sss", " p ", 'p', new ItemStack(ModBlocks.colored_planks, 1, meta), 's', new ItemStack(ModItems.stick, 1, meta)));
			for (int i = 0; i < 16; i++) {
				recipes.add(new ShapelessOreRecipe(new ItemStack(ModItems.trident_head, 1, meta), new ItemStack(ModItems.trident_head, 1, i), "dye" + dyes[meta]));
			}
		}
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.stick, 1, 16), "i", "i", 'i', "cobblestone"));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.stick, 1, 17), "i", "i", 'i', "ingotGold"));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.stick, 1, 18), "i", "i", 'i', "ingotIron"));
		recipes.add(new ShapedOreRecipe(new ItemStack(ModItems.stick, 1, 19), "i", "i", 'i', "gemDiamond"));
		
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_sword), "d", "d", "s", 'd', "gemDiamond", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_sword), "d", "d", "s", 'd', "ingotIron", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_sword), "d", "d", "s", 'd', "igontGold", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_sword), "d", "d", "s", 'd', "cobblestone", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_sword), "d", "d", "s", 'd', "plankWood", 's',"stick"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_sword), new ItemStack(Items.diamond_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_sword), new ItemStack(Items.iron_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_sword), new ItemStack(Items.golden_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_sword), new ItemStack(Items.stone_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_sword), new ItemStack(Items.wooden_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_sword), new ItemStack(ModItems.diamond_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_sword), new ItemStack(ModItems.iron_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_sword), new ItemStack(ModItems.gold_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_sword), new ItemStack(ModItems.stone_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_sword), new ItemStack(ModItems.wood_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_sword), new ItemStack(ModItems.colored_sword, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_wood_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 20), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_stone_trident), "t  ", " h ", "  s", 't', "cobblestone", 'h', new ItemStack(ModItems.trident_head, 1, 20), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_gold_trident), "t  ", " h ", "  s", 't', "ingotGold", 'h', new ItemStack(ModItems.trident_head, 1, 20), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_iron_trident), "t  ", " h ", "  s", 't', "ingotIron", 'h', new ItemStack(ModItems.trident_head, 1, 20), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_diamond_trident), "t  ", " h ", "  s", 't', "gemDiamond", 'h', new ItemStack(ModItems.trident_head, 1, 20), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_colored_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 20), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_wood_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 16), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_stone_trident), "t  ", " h ", "  s", 't', "cobblestone", 'h', new ItemStack(ModItems.trident_head, 1, 16), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_gold_trident), "t  ", " h ", "  s", 't', "ingotGold", 'h', new ItemStack(ModItems.trident_head, 1, 16), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_iron_trident), "t  ", " h ", "  s", 't', "ingotIron", 'h', new ItemStack(ModItems.trident_head, 1, 16), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_diamond_trident), "t  ", " h ", "  s", 't', "gemDiamond", 'h', new ItemStack(ModItems.trident_head, 1, 16), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_colored_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 16), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_wood_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 17), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_stone_trident), "t  ", " h ", "  s", 't', "cobblestone", 'h', new ItemStack(ModItems.trident_head, 1, 17), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_gold_trident), "t  ", " h ", "  s", 't', "ingotGold", 'h', new ItemStack(ModItems.trident_head, 1, 17), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_iron_trident), "t  ", " h ", "  s", 't', "ingotIron", 'h', new ItemStack(ModItems.trident_head, 1, 17), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_diamond_trident), "t  ", " h ", "  s", 't', "gemDiamond", 'h', new ItemStack(ModItems.trident_head, 1, 17), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_colored_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 17), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_wood_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 18), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_stone_trident), "t  ", " h ", "  s", 't', "cobblestone", 'h', new ItemStack(ModItems.trident_head, 1, 18), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_gold_trident), "t  ", " h ", "  s", 't', "ingotGold", 'h', new ItemStack(ModItems.trident_head, 1, 18), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_iron_trident), "t  ", " h ", "  s", 't', "ingotIron", 'h', new ItemStack(ModItems.trident_head, 1, 18), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_diamond_trident), "t  ", " h ", "  s", 't', "gemDiamond", 'h', new ItemStack(ModItems.trident_head, 1, 18), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_colored_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 18), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_wood_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 19), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_stone_trident), "t  ", " h ", "  s", 't', "cobblestone", 'h', new ItemStack(ModItems.trident_head, 1, 19), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_gold_trident), "t  ", " h ", "  s", 't', "ingotGold", 'h', new ItemStack(ModItems.trident_head, 1, 19), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_iron_trident), "t  ", " h ", "  s", 't', "ingotIron", 'h', new ItemStack(ModItems.trident_head, 1, 19), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_diamond_trident), "t  ", " h ", "  s", 't', "gemDiamond", 'h', new ItemStack(ModItems.trident_head, 1, 19), 's', "stickWood"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_colored_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, 19), 's', "stickWood"));
		for (int meta = 0; meta < 16; meta++) {
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.colored_wood_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, meta), 's', "stickWood"));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.colored_stone_trident), "t  ", " h ", "  s", 't', "cobblestone", 'h', new ItemStack(ModItems.trident_head, 1, meta), 's', "stickWood"));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.colored_gold_trident), "t  ", " h ", "  s", 't', "ingotGold", 'h', new ItemStack(ModItems.trident_head, 1, meta), 's', "stickWood"));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.colored_iron_trident), "t  ", " h ", "  s", 't', "ingotIron", 'h', new ItemStack(ModItems.trident_head, 1, meta), 's', "stickWood"));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.colored_diamond_trident), "t  ", " h ", "  s", 't', "gemDiamond", 'h', new ItemStack(ModItems.trident_head, 1, meta), 's', "stickWood"));
			recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.colored_colored_trident), "t  ", " h ", "  s", 't', "plankWood", 'h', new ItemStack(ModItems.trident_head, 1, meta), 's', "stickWood"));
		}
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_wood_trident), new ItemStack(ModItems.wood_wood_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_stone_trident), new ItemStack(ModItems.wood_stone_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_gold_trident), new ItemStack(ModItems.wood_gold_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_iron_trident), new ItemStack(ModItems.wood_iron_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_diamond_trident), new ItemStack(ModItems.wood_diamond_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_colored_trident), new ItemStack(ModItems.wood_colored_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_wood_trident), new ItemStack(ModItems.stone_wood_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_stone_trident), new ItemStack(ModItems.stone_stone_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_gold_trident), new ItemStack(ModItems.stone_gold_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_iron_trident), new ItemStack(ModItems.stone_iron_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_diamond_trident), new ItemStack(ModItems.stone_diamond_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_colored_trident), new ItemStack(ModItems.stone_colored_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_wood_trident), new ItemStack(ModItems.gold_wood_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_stone_trident), new ItemStack(ModItems.gold_stone_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_gold_trident), new ItemStack(ModItems.gold_gold_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_iron_trident), new ItemStack(ModItems.gold_iron_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_diamond_trident), new ItemStack(ModItems.gold_diamond_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_colored_trident), new ItemStack(ModItems.gold_colored_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_wood_trident), new ItemStack(ModItems.iron_wood_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_stone_trident), new ItemStack(ModItems.iron_stone_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_gold_trident), new ItemStack(ModItems.iron_gold_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_iron_trident), new ItemStack(ModItems.iron_iron_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_diamond_trident), new ItemStack(ModItems.iron_diamond_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_colored_trident), new ItemStack(ModItems.iron_colored_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_wood_trident), new ItemStack(ModItems.diamond_wood_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_stone_trident), new ItemStack(ModItems.diamond_stone_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_gold_trident), new ItemStack(ModItems.diamond_gold_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_iron_trident), new ItemStack(ModItems.diamond_iron_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_diamond_trident), new ItemStack(ModItems.diamond_diamond_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_colored_trident), new ItemStack(ModItems.diamond_colored_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_wood_trident), new ItemStack(ModItems.colored_wood_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_stone_trident), new ItemStack(ModItems.colored_stone_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_gold_trident), new ItemStack(ModItems.colored_gold_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_iron_trident), new ItemStack(ModItems.colored_iron_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_diamond_trident), new ItemStack(ModItems.colored_diamond_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_colored_trident), new ItemStack(ModItems.colored_colored_trident, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_pickaxe), "ddd", " s ", " s ", 'd', "gemDiamond", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_pickaxe), "ddd", " s ", " s ", 'd', "ingotIron", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_pickaxe), "ddd", " s ", " s ", 'd', "ingotGold", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_pickaxe), "ddd", " s ", " s ", 'd', "cobblestone", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_pickaxe), "ddd", " s ", " s ", 'd', "plankWood", 's',"stick"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_pickaxe), new ItemStack(Items.diamond_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_pickaxe), new ItemStack(Items.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_pickaxe), new ItemStack(Items.golden_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_pickaxe), new ItemStack(Items.stone_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_pickaxe), new ItemStack(Items.wooden_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_pickaxe), new ItemStack(ModItems.diamond_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_pickaxe), new ItemStack(ModItems.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_pickaxe), new ItemStack(ModItems.gold_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_pickaxe), new ItemStack(ModItems.stone_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_pickaxe), new ItemStack(ModItems.wood_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_pickaxe), new ItemStack(ModItems.colored_pickaxe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_shovel), "d", "s", "s", 'd', "gemDiamond", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_shovel), "d", "s", "s", 'd', "ingotIron", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_shovel), "d", "s", "s", 'd', "ingotGold", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_shovel), "d", "s", "s", 'd', "cobblestone", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_shovel), "d", "s", "s", 'd', "plankWood", 's',"stick"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_shovel), new ItemStack(Items.diamond_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_shovel), new ItemStack(Items.iron_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_shovel), new ItemStack(Items.golden_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_shovel), new ItemStack(Items.stone_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_shovel), new ItemStack(Items.wooden_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_shovel), new ItemStack(ModItems.diamond_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_shovel), new ItemStack(ModItems.iron_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_shovel), new ItemStack(ModItems.gold_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_shovel), new ItemStack(ModItems.stone_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_shovel), new ItemStack(ModItems.wood_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_shovel), new ItemStack(ModItems.colored_shovel, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_axe), "dd ", "ds ", " s ", 'd', "gemDiamond", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_axe), "dd ", "ds ", " s ", 'd', "ingotIron", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_axe), "dd ", "ds ", " s ", 'd', "ingotGold", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_axe), "dd ", "ds ", " s ", 'd', "cobblestone", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_axe), "dd ", "ds ", " s ", 'd', "plankWood", 's',"stick"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_axe), new ItemStack(Items.diamond_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_axe), new ItemStack(Items.iron_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_axe), new ItemStack(Items.golden_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_axe), new ItemStack(Items.stone_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_axe), new ItemStack(Items.wooden_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_axe), new ItemStack(ModItems.diamond_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_axe), new ItemStack(ModItems.iron_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_axe), new ItemStack(ModItems.gold_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_axe), new ItemStack(ModItems.stone_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_axe), new ItemStack(ModItems.wood_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_axe), new ItemStack(ModItems.colored_axe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_hoe), "dd", " s", " s", 'd', "gemDiamond", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_hoe), "dd", " s", " s", 'd', "ingotIron", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_hoe), "dd", " s", " s", 'd', "ingotGold", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_hoe), "dd", " s", " s", 'd', "cobblestone", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_hoe), "dd", " s", " s", 'd', "plankWood", 's',"stick"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_hoe), new ItemStack(Items.diamond_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_hoe), new ItemStack(Items.iron_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_hoe), new ItemStack(Items.golden_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_hoe), new ItemStack(Items.stone_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_hoe), new ItemStack(Items.wooden_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_hoe), new ItemStack(ModItems.diamond_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_hoe), new ItemStack(ModItems.iron_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_hoe), new ItemStack(ModItems.gold_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_hoe), new ItemStack(ModItems.stone_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_hoe), new ItemStack(ModItems.wood_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_hoe), new ItemStack(ModItems.colored_hoe, 1, OreDictionary.WILDCARD_VALUE), "dye"));

		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.diamond_hammer), "d", "s", 'd', "gemDiamond", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.iron_hammer), "d", "s", 'd', "ingotIron", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.gold_hammer), "d", "s", 'd', "ingotGold", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.stone_hammer), "d", "s", 'd', "cobblestone", 's',"stick"));
		recipes.add(new ColoredItemsRecipe(new ItemStack(ModItems.wood_hammer), "d", "s", 'd', "plankWood", 's',"stick"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.diamond_hammer), new ItemStack(ModItems.diamond_hammer, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.iron_hammer), new ItemStack(ModItems.iron_hammer, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.gold_hammer), new ItemStack(ModItems.gold_hammer, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.stone_hammer), new ItemStack(ModItems.stone_hammer, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.wood_hammer), new ItemStack(ModItems.wood_hammer, 1, OreDictionary.WILDCARD_VALUE), "dye"));
		recipes.add(new ReColoredItemsRecipe(new ItemStack(ModItems.colored_hammer), new ItemStack(ModItems.colored_hammer, 1, OreDictionary.WILDCARD_VALUE), "dye"));
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
