package io.github.penguinsfan77.randomstuff.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDictionary {
	
	public static void init() {
		
		for (int i = 0; i < 16; i++) {
			OreDictionary.registerOre("stickWood", new ItemStack(ModItems.stick, 1, i));
		}
		OreDictionary.registerOre("stickStone", new ItemStack(ModItems.stick, 1, 16));
		OreDictionary.registerOre("stickGold", new ItemStack(ModItems.stick, 1, 17));
		OreDictionary.registerOre("stickIron", new ItemStack(ModItems.stick, 1, 18));
		OreDictionary.registerOre("stickDiamond", new ItemStack(ModItems.stick, 1, 19));
		
	}

}
