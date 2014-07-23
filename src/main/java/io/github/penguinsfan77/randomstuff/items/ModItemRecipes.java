package io.github.penguinsfan77.randomstuff.items;

import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItemRecipes {
	
	public static void init() {
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.hammer, "   ", " i ", " s ", 'i', "ingotIron", 's', "stickWood"));
		
	}

}
