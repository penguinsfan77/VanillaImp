package io.github.penguinsfan77.randomstuff.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	//Create the blocks
	public static final ModBlock crackedStone = new CrackedStone();

    public static void init() {
        
    	//Register the blocks
    	GameRegistry.registerBlock(crackedStone, "crackedStone");
    	
    }

}
