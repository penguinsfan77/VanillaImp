package io.github.penguinsfan77.vanillaimprovements.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import io.github.penguinsfan77.vanillaimprovements.items.*;
import io.github.penguinsfan77.vanillaimprovements.items.tools.*;
import io.github.penguinsfan77.vanillaimprovements.items.weapons.*;
import io.github.penguinsfan77.vanillaimprovements.references.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	//Create items
	public static final ModItemWeapon wood_wood_trident = new Trident(ToolMaterial.WOOD, ToolMaterial.WOOD);
	public static final ModItemWeapon wood_stone_trident = new Trident(ToolMaterial.STONE, ToolMaterial.WOOD);
	public static final ModItemWeapon wood_gold_trident = new Trident(ToolMaterial.GOLD, ToolMaterial.WOOD);
	public static final ModItemWeapon wood_iron_trident = new Trident(ToolMaterial.IRON, ToolMaterial.WOOD);
	public static final ModItemWeapon wood_diamond_trident = new Trident(ToolMaterial.EMERALD, ToolMaterial.WOOD);
	public static final ModItemWeapon wood_colored_trident = new Trident(ModItemMaterials.COLORED, ToolMaterial.WOOD);
	public static final ModItemWeapon stone_wood_trident = new Trident(ToolMaterial.WOOD, ToolMaterial.STONE);
	public static final ModItemWeapon stone_stone_trident = new Trident(ToolMaterial.STONE, ToolMaterial.STONE);
	public static final ModItemWeapon stone_gold_trident = new Trident(ToolMaterial.GOLD, ToolMaterial.STONE);
	public static final ModItemWeapon stone_iron_trident = new Trident(ToolMaterial.IRON, ToolMaterial.STONE);
	public static final ModItemWeapon stone_diamond_trident = new Trident(ToolMaterial.EMERALD, ToolMaterial.STONE);
	public static final ModItemWeapon stone_colored_trident = new Trident(ModItemMaterials.COLORED, ToolMaterial.STONE);
	public static final ModItemWeapon gold_wood_trident = new Trident(ToolMaterial.WOOD, ToolMaterial.GOLD);
	public static final ModItemWeapon gold_stone_trident = new Trident(ToolMaterial.STONE, ToolMaterial.GOLD);
	public static final ModItemWeapon gold_gold_trident = new Trident(ToolMaterial.GOLD, ToolMaterial.GOLD);
	public static final ModItemWeapon gold_iron_trident = new Trident(ToolMaterial.IRON, ToolMaterial.GOLD);
	public static final ModItemWeapon gold_diamond_trident = new Trident(ToolMaterial.EMERALD, ToolMaterial.GOLD);
	public static final ModItemWeapon gold_colored_trident = new Trident(ModItemMaterials.COLORED, ToolMaterial.GOLD);
	public static final ModItemWeapon iron_wood_trident = new Trident(ToolMaterial.WOOD, ToolMaterial.IRON);
	public static final ModItemWeapon iron_stone_trident = new Trident(ToolMaterial.STONE, ToolMaterial.IRON);
	public static final ModItemWeapon iron_gold_trident = new Trident(ToolMaterial.GOLD, ToolMaterial.IRON);
	public static final ModItemWeapon iron_iron_trident = new Trident(ToolMaterial.IRON, ToolMaterial.IRON);
	public static final ModItemWeapon iron_diamond_trident = new Trident(ToolMaterial.EMERALD, ToolMaterial.IRON);
	public static final ModItemWeapon iron_colored_trident = new Trident(ModItemMaterials.COLORED, ToolMaterial.IRON);
	public static final ModItemWeapon diamond_wood_trident = new Trident(ToolMaterial.WOOD, ToolMaterial.EMERALD);
	public static final ModItemWeapon diamond_stone_trident = new Trident(ToolMaterial.STONE, ToolMaterial.EMERALD);
	public static final ModItemWeapon diamond_gold_trident = new Trident(ToolMaterial.GOLD, ToolMaterial.EMERALD);
	public static final ModItemWeapon diamond_iron_trident = new Trident(ToolMaterial.IRON, ToolMaterial.EMERALD);
	public static final ModItemWeapon diamond_diamond_trident = new Trident(ToolMaterial.EMERALD, ToolMaterial.EMERALD);
	public static final ModItemWeapon diamond_colored_trident = new Trident(ModItemMaterials.COLORED, ToolMaterial.EMERALD);
	public static final ModItemWeapon colored_wood_trident = new Trident(ToolMaterial.WOOD, ModItemMaterials.COLORED);
	public static final ModItemWeapon colored_stone_trident = new Trident(ToolMaterial.STONE, ModItemMaterials.COLORED);
	public static final ModItemWeapon colored_gold_trident = new Trident(ToolMaterial.GOLD, ModItemMaterials.COLORED);
	public static final ModItemWeapon colored_iron_trident = new Trident(ToolMaterial.IRON, ModItemMaterials.COLORED);
	public static final ModItemWeapon colored_diamond_trident = new Trident(ToolMaterial.EMERALD, ModItemMaterials.COLORED);
	public static final ModItemWeapon colored_colored_trident = new Trident(ModItemMaterials.COLORED, ModItemMaterials.COLORED);
	public static final ModItemWeapon wood_sword = new ModSword(ToolMaterial.WOOD);
	public static final ModItemWeapon stone_sword = new ModSword(ToolMaterial.STONE);
	public static final ModItemWeapon gold_sword = new ModSword(ToolMaterial.GOLD);
	public static final ModItemWeapon iron_sword = new ModSword(ToolMaterial.IRON);
	public static final ModItemWeapon diamond_sword = new ModSword(ToolMaterial.EMERALD);
	public static final ModItemWeapon colored_sword = new ModSword(ModItemMaterials.COLORED);
	
	public static final ModItemTool wood_pickaxe = new ModPickaxe(ToolMaterial.WOOD);
	public static final ModItemTool stone_pickaxe = new ModPickaxe(ToolMaterial.STONE);
	public static final ModItemTool gold_pickaxe = new ModPickaxe(ToolMaterial.GOLD);
	public static final ModItemTool iron_pickaxe = new ModPickaxe(ToolMaterial.IRON);
	public static final ModItemTool diamond_pickaxe = new ModPickaxe(ToolMaterial.EMERALD);
	public static final ModItemTool colored_pickaxe = new ModPickaxe(ModItemMaterials.COLORED);
	public static final ModItemTool wood_shovel = new ModShovel(ToolMaterial.WOOD);
	public static final ModItemTool stone_shovel = new ModShovel(ToolMaterial.STONE);
	public static final ModItemTool gold_shovel = new ModShovel(ToolMaterial.GOLD);
	public static final ModItemTool iron_shovel = new ModShovel(ToolMaterial.IRON);
	public static final ModItemTool diamond_shovel = new ModShovel(ToolMaterial.EMERALD);
	public static final ModItemTool colored_shovel = new ModShovel(ModItemMaterials.COLORED);
	public static final ModItemTool wood_axe = new ModAxe(ToolMaterial.WOOD);
	public static final ModItemTool stone_axe = new ModAxe(ToolMaterial.STONE);
	public static final ModItemTool gold_axe = new ModAxe(ToolMaterial.GOLD);
	public static final ModItemTool iron_axe = new ModAxe(ToolMaterial.IRON);
	public static final ModItemTool diamond_axe = new ModAxe(ToolMaterial.EMERALD);
	public static final ModItemTool colored_axe = new ModAxe(ModItemMaterials.COLORED);
	public static final ModItemTool wood_hoe = new ModHoe(ToolMaterial.WOOD);
	public static final ModItemTool stone_hoe = new ModHoe(ToolMaterial.STONE);
	public static final ModItemTool gold_hoe = new ModHoe(ToolMaterial.GOLD);
	public static final ModItemTool iron_hoe = new ModHoe(ToolMaterial.IRON);
	public static final ModItemTool diamond_hoe = new ModHoe(ToolMaterial.EMERALD);
	public static final ModItemTool colored_hoe = new ModHoe(ModItemMaterials.COLORED);
	public static final ModItemTool diamond_hammer = new Hammer(ToolMaterial.EMERALD);
	public static final ModItemTool iron_hammer = new Hammer(ToolMaterial.IRON);
	public static final ModItemTool gold_hammer = new Hammer(ToolMaterial.GOLD);
	public static final ModItemTool stone_hammer = new Hammer(ToolMaterial.STONE);
	public static final ModItemTool wood_hammer = new Hammer(ToolMaterial.WOOD);
	public static final ModItemTool colored_hammer = new Hammer(ModItemMaterials.COLORED);
	
	public static final ModItem stick = new Sticks();
	public static final ModItem trident_head = new TridentHeads();
	
	public static void init() {
		
		//Register the items
		GameRegistry.registerItem(wood_wood_trident, "wood_wood_trident");
		GameRegistry.registerItem(wood_stone_trident, "wood_stone_trident");
		GameRegistry.registerItem(wood_gold_trident, "wood_gold_trident");
		GameRegistry.registerItem(wood_iron_trident, "wood_iron_trident");
		GameRegistry.registerItem(wood_diamond_trident, "wood_diamond_trident");
		GameRegistry.registerItem(wood_colored_trident, "wood_colored_trident");
		GameRegistry.registerItem(stone_wood_trident, "stone_wood_trident");
		GameRegistry.registerItem(stone_stone_trident, "stone_stone_trident");
		GameRegistry.registerItem(stone_gold_trident, "stone_gold_trident");
		GameRegistry.registerItem(stone_iron_trident, "stone_iron_trident");
		GameRegistry.registerItem(stone_diamond_trident, "stone_diamond_trident");
		GameRegistry.registerItem(stone_colored_trident, "stone_colored_trident");
		GameRegistry.registerItem(gold_wood_trident, "gold_wood_trident");
		GameRegistry.registerItem(gold_stone_trident, "gold_stone_trident");
		GameRegistry.registerItem(gold_gold_trident, "gold_gold_trident");
		GameRegistry.registerItem(gold_iron_trident, "gold_iron_trident");
		GameRegistry.registerItem(gold_diamond_trident, "gold_diamond_trident");
		GameRegistry.registerItem(gold_colored_trident, "gold_colored_trident");
		GameRegistry.registerItem(iron_wood_trident, "iron_wood_trident");
		GameRegistry.registerItem(iron_stone_trident, "iron_stone_trident");
		GameRegistry.registerItem(iron_gold_trident, "iron_gold_trident");
		GameRegistry.registerItem(iron_iron_trident, "iron_iron_trident");
		GameRegistry.registerItem(iron_diamond_trident, "iron_diamond_trident");
		GameRegistry.registerItem(iron_colored_trident, "iron_colored_trident");
		GameRegistry.registerItem(diamond_wood_trident, "diamond_wood_trident");
		GameRegistry.registerItem(diamond_stone_trident, "diamond_stone_trident");
		GameRegistry.registerItem(diamond_gold_trident, "diamond_gold_trident");
		GameRegistry.registerItem(diamond_iron_trident, "diamond_iron_trident");
		GameRegistry.registerItem(diamond_diamond_trident, "diamond_diamond_trident");
		GameRegistry.registerItem(diamond_colored_trident, "diamond_colored_trident");
		GameRegistry.registerItem(colored_wood_trident, "colored_wood_trident");
		GameRegistry.registerItem(colored_stone_trident, "colored_stone_trident");
		GameRegistry.registerItem(colored_gold_trident, "colored_gold_trident");
		GameRegistry.registerItem(colored_iron_trident, "colored_iron_trident");
		GameRegistry.registerItem(colored_diamond_trident, "colored_diamond_trident");
		GameRegistry.registerItem(colored_colored_trident, "colored_colored_trident");
		GameRegistry.registerItem(wood_sword, "wood_sword");
		GameRegistry.registerItem(stone_sword, "stone_sword");
		GameRegistry.registerItem(gold_sword, "gold_sword");
		GameRegistry.registerItem(iron_sword, "iron_sword");
		GameRegistry.registerItem(diamond_sword, "diamond_sword");
		GameRegistry.registerItem(colored_sword, "colored_sword");
		
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
		GameRegistry.registerItem(diamond_pickaxe, "diamond_pickaxe");
		GameRegistry.registerItem(diamond_shovel, "diamond_shovel");
		GameRegistry.registerItem(diamond_axe, "diamond_axe");
		GameRegistry.registerItem(diamond_hoe, "diamond_hoe");
		GameRegistry.registerItem(colored_pickaxe, "colored_pickaxe");
		GameRegistry.registerItem(colored_shovel, "colored_shovel");
		GameRegistry.registerItem(colored_axe, "colored_axe");
		GameRegistry.registerItem(colored_hoe, "colored_hoe");
		GameRegistry.registerItem(diamond_hammer, "diamond_hammer");
		GameRegistry.registerItem(iron_hammer, "iron_hammer");
		GameRegistry.registerItem(gold_hammer, "gold_hammer");
		GameRegistry.registerItem(stone_hammer, "stone_hammer");
		GameRegistry.registerItem(wood_hammer, "wood_hammer");
		GameRegistry.registerItem(colored_hammer, "colored_hammer");
		
		GameRegistry.registerItem(stick, "stick");
		GameRegistry.registerItem(trident_head, "trident_head");
	
	}

}
