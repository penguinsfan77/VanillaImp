package io.github.penguinsfan77.randomstuff.blocks;

import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.Names;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

public class ColoredPlanks extends ModBlock {
	
	public ColoredPlanks() {
		
		super();
		this.setBlockName(Names.Blocks.COLORED_PLANKS);
		//this.setBlockTextureName(Names.Blocks.COLORED_PLANKS);
		
		this.setHardness(2.0F).setResistance(5.0F).setStepSound(soundTypeWood);
		
	}
	
	@Override
	public int colorMultiplier(IBlockAccess blockAccess, int x, int y, int z) {

		int meta = blockAccess.getBlockMetadata(x, y, z);
		
		return Integer.parseInt(Colors.fromNumber[meta], 16);
		
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {

		for (int meta = 0; meta < 16; meta++) {
			
			list.add(new ItemStack(this, 1, meta));
			
		}
		
	}
	
	@Override
	public int damageDropped(int meta) {

		return meta;
		
	}

}
