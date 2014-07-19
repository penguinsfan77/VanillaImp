package io.github.penguinsfan77.randomstuff.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	//Create the blocks
	public static final ModBlock black = new Black();
	public static final ModBlock white = new White();
	public static final ModBlock crackedStone = new CrackedStone();

    public static void init() {
        
    	//Register the blocks
    	GameRegistry.registerBlock(black, "blackBlock");
    	GameRegistry.registerBlock(white, "white_block");
    	GameRegistry.registerBlock(crackedStone, "crackedStone");
    	
    }

}
