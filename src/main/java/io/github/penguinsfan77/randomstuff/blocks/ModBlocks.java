package io.github.penguinsfan77.randomstuff.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	//Create the blocks
	public static final ModBlock black = new Black();

    public static void init() {
        
    	//Register the blocks
    	GameRegistry.registerBlock(black, "blackBlock");
    	
    }

}
