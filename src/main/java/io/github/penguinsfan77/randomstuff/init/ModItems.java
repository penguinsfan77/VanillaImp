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
	public static final ModItemWeapon diamond_trident = new Trident(ToolMaterial.EMERALD);
	
	public static final ModItemTool[] pickaxes = {new ColoredPickaxe(ToolMaterial.WOOD), new ColoredPickaxe(ToolMaterial.STONE), new ColoredPickaxe(ToolMaterial.GOLD), new ColoredPickaxe(ToolMaterial.IRON), new ColoredPickaxe(ToolMaterial.EMERALD)};
	public static final ModItemTool[] shovels = {new ColoredShovel(ToolMaterial.WOOD), new ColoredShovel(ToolMaterial.STONE), new ColoredShovel(ToolMaterial.GOLD), new ColoredShovel(ToolMaterial.IRON), new ColoredShovel(ToolMaterial.EMERALD)};
	public static final ModItemTool[] axes = {new ColoredAxe(ToolMaterial.WOOD), new ColoredAxe(ToolMaterial.STONE), new ColoredAxe(ToolMaterial.GOLD), new ColoredAxe(ToolMaterial.IRON), new ColoredAxe(ToolMaterial.EMERALD)};
	public static final ModItemTool[] hoes = {new ColoredHoe(ToolMaterial.WOOD), new ColoredHoe(ToolMaterial.STONE), new ColoredHoe(ToolMaterial.GOLD), new ColoredHoe(ToolMaterial.IRON), new ColoredHoe(ToolMaterial.EMERALD)};
	public static final ModItemTool hammer = new Hammer();
	
	public static final ModItem coloredStick = new ColoredStick();
	
	public static void init() {
		
		//Register the items
		GameRegistry.registerItem(stone_trident, "stone_trident");
		GameRegistry.registerItem(gold_trident, "gold_trident");
		GameRegistry.registerItem(iron_trident, "iron_trident");
		GameRegistry.registerItem(diamond_trident, "emerald_trident");
		
		for (int i = 0; i < 5; i++) {
			GameRegistry.registerItem(pickaxes[i], "colored_" + pickaxes[i].getToolMaterialName() + "_pickaxe");
			GameRegistry.registerItem(axes[i], "colored_" + axes[i].getToolMaterialName() + "_axe");
			GameRegistry.registerItem(shovels[i], "colored_" + shovels[i].getToolMaterialName() + "_shovel");
			GameRegistry.registerItem(hoes[i], "colored_" + hoes[i].getToolMaterialName() + "_hoe");
		}
		GameRegistry.registerItem(hammer, "hammer");
		
		GameRegistry.registerItem(coloredStick, "colored_stick");
		OreDictionary.registerOre("stickWood", new ItemStack(coloredStick, 1, OreDictionary.WILDCARD_VALUE));
	
	}

}
