package io.github.penguinsfan77.randomstuff.blocks;

import io.github.penguinsfan77.randomstuff.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlockRecipes {
	
	public static void init() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.crackedStone), new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone));
		
	}

}
