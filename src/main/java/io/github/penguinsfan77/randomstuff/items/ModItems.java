package io.github.penguinsfan77.randomstuff.items;

import io.github.penguinsfan77.randomstuff.references.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	//Create items
	public static final ModItemSword stone_trident = new StoneTrident();
	public static final ModItemSword gold_trident = new GoldTrident();
	public static final ModItemSword iron_trident = new IronTrident();
	public static final ModItemSword diamond_trident = new DiamondTrident();
	public static final ModItem thrower = new Thrower();
	
	public static void init() {
		
		//Register the items
		GameRegistry.registerItem(stone_trident, "stone_trident");
		GameRegistry.registerItem(gold_trident, "gold_trident");
		GameRegistry.registerItem(iron_trident, "iron_trident");
		GameRegistry.registerItem(diamond_trident, "diamond_trident");
		GameRegistry.registerItem(thrower, "thrower");
	
	}

}
