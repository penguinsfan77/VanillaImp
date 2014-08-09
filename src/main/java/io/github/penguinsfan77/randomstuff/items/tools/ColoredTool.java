package io.github.penguinsfan77.randomstuff.items.tools;

import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.references.Names;
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

		handles.put("wood", iconRegister.registerIcon("wood_" + toolName + "_handle"));
		base = iconRegister.registerIcon(getToolMaterialName().toLowerCase() + "_" + toolName);
		
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
		
		if (renderPass == 0 && NBTHelper.getString(item, NBTTags.HANDLE).equalsIgnoreCase("wood")) {
			return Integer.parseInt(NBTHelper.getString(item, NBTTags.COLOR), 16);
		}

		return super.getColorFromItemStack(item, renderPass);
		
	}

}
