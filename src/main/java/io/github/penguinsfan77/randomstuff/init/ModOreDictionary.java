package io.github.penguinsfan77.randomstuff.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDictionary {
	
	public static void init() {
		
		OreDictionary.registerOre("stickWood", new ItemStack(ModItems.colored_stick, 1, OreDictionary.WILDCARD_VALUE));
		
	}

}
