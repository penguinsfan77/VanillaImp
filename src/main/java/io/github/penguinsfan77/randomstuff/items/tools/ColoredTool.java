package io.github.penguinsfan77.randomstuff.items.tools;

import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.references.Names;
import io.github.penguinsfan77.randomstuff.references.Textures;
import io.github.penguinsfan77.randomstuff.references.ToolTips;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
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

		handles.put("colored", iconRegister.registerIcon(Textures.PREFIX + "colored_" + toolName + "_handle"));
		handles.put("plain", iconRegister.registerIcon(Textures.PREFIX + toolName + "_handle"));
		base = iconRegister.registerIcon(Textures.PREFIX + getToolMaterialName().toLowerCase() + "_" + toolName);
		
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {

		if (pass == 0) {
			if (NBTHelper.hasTag(stack, NBTTags.HANDLE)) {
				return (IIcon) handles.get(NBTHelper.getString(stack, NBTTags.HANDLE));
			} else {
				return (IIcon) handles.get("plain");
			}
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
			return Integer.parseInt(NBTHelper.getString(item, NBTTags.COLOR), 16);
		}

		return super.getColorFromItemStack(item, renderPass);
		
	}
	
	@Override
	public void onCreated(ItemStack item, World world, EntityPlayer player) {

		if (!NBTHelper.hasTag(item, NBTTags.HANDLE)) {
			NBTHelper.setString(item, NBTTags.HANDLE, "plain");
		}
		
	}
	
	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {

		if (NBTHelper.hasTag(item, NBTTags.HANDLE) && NBTHelper.getString(item, NBTTags.HANDLE).equalsIgnoreCase("colored")) {
			list.add(StatCollector.translateToLocal(ToolTips.COLOR) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.COLORS.get(NBTHelper.getString(item, NBTTags.COLOR))));
		}
		super.addInformation(item, player, list, bool);
		
	}

}
