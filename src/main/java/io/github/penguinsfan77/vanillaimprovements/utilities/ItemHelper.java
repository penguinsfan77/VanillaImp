package io.github.penguinsfan77.vanillaimprovements.utilities;

import io.github.penguinsfan77.vanillaimprovements.init.ModItems;
import io.github.penguinsfan77.vanillaimprovements.items.ModItemMaterials;
import io.github.penguinsfan77.vanillaimprovements.items.tools.Hammer;
import io.github.penguinsfan77.vanillaimprovements.items.tools.ModAxe;
import io.github.penguinsfan77.vanillaimprovements.items.tools.ModHoe;
import io.github.penguinsfan77.vanillaimprovements.items.tools.ModPickaxe;
import io.github.penguinsfan77.vanillaimprovements.items.tools.ModShovel;
import io.github.penguinsfan77.vanillaimprovements.items.weapons.ModSword;
import io.github.penguinsfan77.vanillaimprovements.items.weapons.Trident;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.oredict.OreDictionary;

public class ItemHelper {
	
	private static final HashMap<String, ToolMaterial> MATERIALS = new HashMap<String, ToolMaterial>() {{
		put(ToolMaterial.WOOD.toString(), ToolMaterial.WOOD);
		put(ToolMaterial.STONE.toString(), ToolMaterial.STONE);
		put(ToolMaterial.IRON.toString(), ToolMaterial.IRON);
		put(ToolMaterial.GOLD.toString(), ToolMaterial.GOLD);
		put(ToolMaterial.EMERALD.toString(), ToolMaterial.EMERALD);
		put(ModItemMaterials.COLORED.toString(), ModItemMaterials.COLORED);
	}};
	
	public static ToolMaterial getToolMaterial(String materialName) {
		
		return MATERIALS.get(materialName);
		
	}
	
	public static Item getColoredVersion(Item tool) {
		
		if (tool instanceof ItemPickaxe || tool instanceof ModPickaxe) {
			return ModItems.colored_pickaxe;
		} else if (tool instanceof ItemSpade || tool instanceof ModShovel) {
			return ModItems.colored_shovel;
		} else if (tool instanceof ItemAxe || tool instanceof ModAxe) {
			return ModItems.colored_axe;
		} else if (tool instanceof ItemHoe || tool instanceof ModHoe) {
			return ModItems.colored_hoe;
		} else if (tool instanceof Hammer) {
			return ModItems.colored_hammer;
		} else if (tool instanceof Trident) {
			Trident trident = (Trident) tool;
			switch (trident.HeadMaterial) {
			case EMERALD:
				return ModItems.diamond_colored_trident;
			case GOLD:
				return ModItems.gold_colored_trident;
			case IRON:
				return ModItems.iron_colored_trident;
			case STONE:
				return ModItems.stone_colored_trident;
			case WOOD:
				return ModItems.wood_colored_trident;
			default:
				return ModItems.colored_colored_trident;
			}
		} else if (tool instanceof ItemSword || tool instanceof ModSword) {
			return ModItems.colored_sword;
		}
		return null;
		
	}

	public static Item getColoredTridentHeadVersion(Trident item) {

		switch (getToolMaterial(item.getToolMaterialName())) {
		case EMERALD:
			return ModItems.colored_diamond_trident;
		case GOLD:
			return ModItems.colored_gold_trident;
		case IRON:
			return ModItems.colored_iron_trident;
		case STONE:
			return ModItems.colored_stone_trident;
		case WOOD:
			return ModItems.colored_wood_trident;
		default:
			return ModItems.colored_colored_trident;
		}
		
	}

}
