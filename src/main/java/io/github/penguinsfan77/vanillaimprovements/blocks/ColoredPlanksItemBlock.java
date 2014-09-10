package io.github.penguinsfan77.vanillaimprovements.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.penguinsfan77.vanillaimprovements.init.ModBlocks;
import io.github.penguinsfan77.vanillaimprovements.references.Colors;
import io.github.penguinsfan77.vanillaimprovements.references.Names;
import io.github.penguinsfan77.vanillaimprovements.references.Textures;
import io.github.penguinsfan77.vanillaimprovements.utilities.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ColoredPlanksItemBlock extends ItemColored {
	
	private Block block;

	public ColoredPlanksItemBlock(Block block) {
		
		super(block, true);
		this.block = block;
		this.setHasSubtypes(true);

	}
	
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
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
