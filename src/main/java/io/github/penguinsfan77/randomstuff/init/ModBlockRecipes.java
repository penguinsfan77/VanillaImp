package io.github.penguinsfan77.randomstuff.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlockRecipes {
	
	public static void init() {
		
		//Cracked stone
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.crackedStone), new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.crackedStone, 2), new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
				new ItemStack(Blocks.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.crackedStone, 3), new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
				new ItemStack(Blocks.stone), new ItemStack(Blocks.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.crackedStone, 4), new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
				new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.crackedStone, 5), new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
				new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.crackedStone, 6), new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
				new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.crackedStone, 7), new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
				new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.crackedStone, 8), new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone),
				new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone), new ItemStack(Blocks.stone));
		
	}

}
