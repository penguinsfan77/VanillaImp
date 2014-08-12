package io.github.penguinsfan77.randomstuff.items.weapons;

import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.references.Textures;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;

import java.util.HashMap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;


public class Trident extends ColoredWeapon {
	
	private HashMap heads = new HashMap<String, IIcon>();
	
	public Trident(ToolMaterial mat) {
		
		super(mat, "trident");
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		heads.put("wood", iconRegister.registerIcon(Textures.PREFIX + "wood_trident_head"));
		heads.put("stone", iconRegister.registerIcon(Textures.PREFIX + "stone_trident_head"));
		heads.put("iron", iconRegister.registerIcon(Textures.PREFIX + "iron_trident_head"));
		heads.put("gold", iconRegister.registerIcon(Textures.PREFIX + "gold_trident_head"));
		heads.put("diamond", iconRegister.registerIcon(Textures.PREFIX + "emerald_trident_head"));
		heads.put("colored", iconRegister.registerIcon(Textures.PREFIX + "colored_trident_head"));
		super.registerIcons(iconRegister);
		
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {

		if (pass == 2) {
			if (NBTHelper.hasTag(stack, NBTTags.HEAD)) {
				return (IIcon) heads.get(NBTHelper.getString(stack, NBTTags.HEAD));
			} else {
				return (IIcon) heads.get("gold");
			}
		} else {
			return super.getIcon(stack, pass);
		}
		
	}
	
	@Override
	public int getRenderPasses(int metadata) {

		return 3;
		
	}

}
