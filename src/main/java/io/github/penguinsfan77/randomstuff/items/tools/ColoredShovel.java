package io.github.penguinsfan77.randomstuff.items.tools;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import com.google.common.collect.Sets;

public class ColoredShovel extends ModItemTool {
	
	protected static final Set effectiveOn = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

	public ColoredShovel(ToolMaterial material) {
		
		super(1.0F, material, effectiveOn, "shovel", "iron");

	}
	
	public boolean func_150897_b(Block p_150897_1_) {
		
        return p_150897_1_ == Blocks.snow_layer ? true : p_150897_1_ == Blocks.snow;
        
    }

}
