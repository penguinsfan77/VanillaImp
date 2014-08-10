package io.github.penguinsfan77.randomstuff.items.tools;

import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.references.Names;
import io.github.penguinsfan77.randomstuff.references.Textures;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;

import java.util.HashMap;
import java.util.Set;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ColoredTool extends ModItemTool {
	
	protected String toolName;
	
	protected HashMap handles = new HashMap<String, IIcon>();
	protected IIcon base;

	protected ColoredTool(float damage, ToolMaterial material, Set effectiveOn, String toolName) {
		
		super(damage, material, effectiveOn);
		
		this.toolName = toolName;
		
		this.setUnlocalizedName("colored_" + material.toString().toLowerCase() + "_" + toolName);

	}
	
	@Override
	public boolean requiresMultipleRenderPasses() {

		return true;
		
	}
	
	@Override
	public int getRenderPasses(int metadata) {

		return 2;
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		handles.put("wood", iconRegister.registerIcon(Textures.PREFIX + "wood_" + toolName + "_handle"));
		base = iconRegister.registerIcon(Textures.PREFIX + getToolMaterialName().toLowerCase() + "_" + toolName);
		
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {

		if (pass == 0) {
			return (IIcon) handles.get("wood");
		} else if (pass == 1) {
			return base;
		} else {
			return null;
		}
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack item, int renderPass) {
		
		if (renderPass == 0 && NBTHelper.hasTag(item, NBTTags.COLOR)) {
			return Integer.parseInt(Colors.fromNumber[NBTHelper.getInt(item, NBTTags.COLOR)], 16);
		}

		return super.getColorFromItemStack(item, renderPass);
		
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {

		LogHelper.info(NBTHelper.hasTag(p_77659_1_, NBTTags.COLOR));
		LogHelper.info(NBTHelper.getInt(p_77659_1_, NBTTags.COLOR));
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
		
	}

}
