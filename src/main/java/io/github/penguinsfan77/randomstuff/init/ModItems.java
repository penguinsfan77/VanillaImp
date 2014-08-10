package io.github.penguinsfan77.randomstuff.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import io.github.penguinsfan77.randomstuff.items.*;
import io.github.penguinsfan77.randomstuff.items.tools.*;
import io.github.penguinsfan77.randomstuff.items.weapons.*;
import io.github.penguinsfan77.randomstuff.references.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	//Create items
	public static final ModItemWeapon stone_trident = new Trident(ToolMaterial.STONE);
	public static final ModItemWeapon gold_trident = new Trident(ToolMaterial.GOLD);
	public static final ModItemWeapon iron_trident = new Trident(ToolMaterial.IRON);
	public static final ModItemWeapon emerald_trident = new Trident(ToolMaterial.EMERALD);
	
	public static final ModItemTool wood_pickaxe = new ColoredPickaxe(ToolMaterial.WOOD);
	public static final ModItemTool stone_pickaxe = new ColoredPickaxe(ToolMaterial.STONE);
	public static final ModItemTool gold_pickaxe = new ColoredPickaxe(ToolMaterial.GOLD);
	public static final ModItemTool iron_pickaxe = new ColoredPickaxe(ToolMaterial.IRON);
	public static final ModItemTool emerald_pickaxe = new ColoredPickaxe(ToolMaterial.EMERALD);
	public static final ModItemTool wood_shovel = new ColoredShovel(ToolMaterial.WOOD);
	public static final ModItemTool stone_shovel = new ColoredShovel(ToolMaterial.STONE);
	public static final ModItemTool gold_shovel = new ColoredShovel(ToolMaterial.GOLD);
	public static final ModItemTool iron_shovel = new ColoredShovel(ToolMaterial.IRON);
	public static final ModItemTool emerald_shovel = new ColoredShovel(ToolMaterial.EMERALD);
	public static final ModItemTool wood_axe = new ColoredAxe(ToolMaterial.WOOD);
	public static final ModItemTool stone_axe = new ColoredAxe(ToolMaterial.STONE);
	public static final ModItemTool gold_axe = new ColoredAxe(ToolMaterial.GOLD);
	public static final ModItemTool iron_axe = new ColoredAxe(ToolMaterial.IRON);
	public static final ModItemTool emerald_axe = new ColoredAxe(ToolMaterial.EMERALD);
	public static final ModItemTool wood_hoe = new ColoredHoe(ToolMaterial.WOOD);
	public static final ModItemTool stone_hoe = new ColoredHoe(ToolMaterial.STONE);
	public static final ModItemTool gold_hoe = new ColoredHoe(ToolMaterial.GOLD);
	public static final ModItemTool iron_hoe = new ColoredHoe(ToolMaterial.IRON);
	public static final ModItemTool emerald_hoe = new ColoredHoe(ToolMaterial.EMERALD);
	public static final ModItemTool hammer = new Hammer();
	
	public static final ModItem colored_stick = new ColoredStick();
	
	public static void init() {
		
		//Register the items
		GameRegistry.registerItem(stone_trident, "stone_trident");
		GameRegistry.registerItem(gold_trident, "gold_trident");
		GameRegistry.registerItem(iron_trident, "iron_trident");
		GameRegistry.registerItem(emerald_trident, "emerald_trident");
		
		GameRegistry.registerItem(wood_pickaxe, "wood_pickaxe");
		GameRegistry.registerItem(wood_shovel, "wood_shovel");
		GameRegistry.registerItem(wood_axe, "wood_axe");
		GameRegistry.registerItem(wood_hoe, "wood_hoe");
		GameRegistry.registerItem(stone_pickaxe, "stone_pickaxe");
		GameRegistry.registerItem(stone_shovel, "stone_shovel");
		GameRegistry.registerItem(stone_axe, "stone_axe");
		GameRegistry.registerItem(stone_hoe, "stone_hoe");
		GameRegistry.registerItem(gold_pickaxe, "gold_pickaxe");
		GameRegistry.registerItem(gold_shovel, "gold_shovel");
		GameRegistry.registerItem(gold_axe, "gold_axe");
		GameRegistry.registerItem(gold_hoe, "gold_hoe");
		GameRegistry.registerItem(iron_pickaxe, "iron_pickaxe");
		GameRegistry.registerItem(iron_shovel, "iron_shovel");
		GameRegistry.registerItem(iron_axe, "iron_axe");
		GameRegistry.registerItem(iron_hoe, "iron_hoe");
		GameRegistry.registerItem(emerald_pickaxe, "emerald_pickaxe");
		GameRegistry.registerItem(emerald_shovel, "emerald_shovel");
		GameRegistry.registerItem(emerald_axe, "emerald_axe");
		GameRegistry.registerItem(emerald_hoe, "emerald_hoe");
		GameRegistry.registerItem(hammer, "hammer");
		
		GameRegistry.registerItem(colored_stick, "colored_stick");
	
	}

}
