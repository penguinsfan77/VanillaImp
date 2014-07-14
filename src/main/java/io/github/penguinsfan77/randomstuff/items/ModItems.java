package io.github.penguinsfan77.randomstuff.items;

import io.github.penguinsfan77.randomstuff.references.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	//Create items
	public static final ModItemSword trident = new Trident();
	public static final ModItem thrower = new Thrower();
	
	public static void init() {
		
		//Register the items
		GameRegistry.registerItem(trident, "trident");
		GameRegistry.registerItem(thrower, "thrower");
	
	}

}
