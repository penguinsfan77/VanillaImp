package io.github.penguinsfan77.randomstuff.items.tools;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Sets;

public class ColoredAxe extends ColoredTool {
	
	protected static final Set effectiveOn = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});

	public ColoredAxe(ToolMaterial material) {
		
		super(3.0F, material, effectiveOn, "axe");

	}
	
	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
		
        return p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    
	}

}
