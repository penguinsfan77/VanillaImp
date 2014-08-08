package io.github.penguinsfan77.randomstuff.blocks;

import io.github.penguinsfan77.randomstuff.references.Names;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CrackedStone extends ModBlock {
	
	public CrackedStone() {
		
		super();
		this.setBlockName(Names.Blocks.CRACKED_STONE);
		this.setBlockTextureName(Names.Blocks.CRACKED_STONE);
		
		this.setHardness(1.5F).setResistance(10.0F).setStepSound(soundTypePiston);
		
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {

		return Item.getItemFromBlock(Blocks.cobblestone);
		
	}
	
	@Override
	protected boolean canSilkHarvest() {
		
		return true;
		
	}

}
