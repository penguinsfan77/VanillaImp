package io.github.penguinsfan77.randomstuff.items.weapons;

import io.github.penguinsfan77.randomstuff.items.ModItemMaterials;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.references.Textures;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;

import java.util.HashMap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;


public class Trident extends ModItemWeapon {
	
	private HashMap heads = new HashMap<ToolMaterial, IIcon>();
	
	public ToolMaterial HeadMaterial;
	
	public Trident(ToolMaterial tipMat, ToolMaterial headMat) {
		
		super(tipMat, "trident", "gold");
		
		this.HeadMaterial = headMat;
		
		this.setUnlocalizedName(headMat.toString().toLowerCase() + "_" + tipMat.toString().toLowerCase() + "_trident");
		super.setMaxDamage(headMat.getMaxUses());
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		heads.put(ToolMaterial.WOOD, iconRegister.registerIcon(Textures.PREFIX + "wood_trident_head"));
		heads.put(ToolMaterial.STONE, iconRegister.registerIcon(Textures.PREFIX + "stone_trident_head"));
		heads.put(ToolMaterial.IRON, iconRegister.registerIcon(Textures.PREFIX + "iron_trident_head"));
		heads.put(ToolMaterial.GOLD, iconRegister.registerIcon(Textures.PREFIX + "gold_trident_head"));
		heads.put(ToolMaterial.EMERALD, iconRegister.registerIcon(Textures.PREFIX + "emerald_trident_head"));
		heads.put(ModItemMaterials.COLORED, iconRegister.registerIcon(Textures.PREFIX + "colored_trident_head"));
		super.registerIcons(iconRegister);
		
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {

		if (pass == 2) {
			return (IIcon) heads.get(HeadMaterial);
		} else {
			return super.getIcon(stack, pass);
		}
		
	}
	
	@Override
	public int getColorFromItemStack(ItemStack item, int renderPass) {
		
		if (renderPass == 2 && HeadMaterial.equals(ModItemMaterials.COLORED)) {
			if (NBTHelper.hasTag(item, NBTTags.HEAD_COLOR)) {
				return Integer.parseInt(NBTHelper.getString(item, NBTTags.HEAD_COLOR), 16);
			}
		}
		return super.getColorFromItemStack(item, renderPass);
		
	}
	
	@Override
	public int getRenderPasses(int metadata) {

		return 3;
		
	}

}
