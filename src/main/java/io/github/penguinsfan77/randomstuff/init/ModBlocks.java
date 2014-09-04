package io.github.penguinsfan77.randomstuff.init;

import io.github.penguinsfan77.randomstuff.blocks.ColoredPlanks;
import io.github.penguinsfan77.randomstuff.blocks.ColoredPlanksItemBlock;
import io.github.penguinsfan77.randomstuff.blocks.CrackedStone;
import io.github.penguinsfan77.randomstuff.blocks.ModBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	//Create the blocks
	public static final ModBlock cracked_stone = new CrackedStone();
	public static final ModBlock colored_planks = new ColoredPlanks();

    public static void init() {
        
    	//Register the blocks
    	GameRegistry.registerBlock(cracked_stone, "cracked_stone");
    	GameRegistry.registerBlock(colored_planks, ColoredPlanksItemBlock.class, "colored_planks");
    	
    }

}
