package io.github.penguinsfan77.randomstuff.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.penguinsfan77.randomstuff.init.ModBlocks;
import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.Names;
import io.github.penguinsfan77.randomstuff.references.Textures;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ColoredPlanksItemBlock extends ItemBlock {
	
	private Block block;

	public ColoredPlanksItemBlock(Block block) {
		
		super(block);
		this.block = block;
		this.setHasSubtypes(true);

	}
	
	@Override
	public int getMetadata(int meta) {

		return meta;
		
	}
	
	@Override
    public String getUnlocalizedName(ItemStack itemStack) {
    	
        return String.format("tile.%s%s.%s", Textures.PREFIX, Names.Blocks.COLORED_PLANKS, Names.Colors.COLOR[itemStack.getItemDamage()]);
   
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int pass) {
		
		return Integer.parseInt(Colors.fromNumber[itemStack.getItemDamage()], 16);
		
	}
	
}
