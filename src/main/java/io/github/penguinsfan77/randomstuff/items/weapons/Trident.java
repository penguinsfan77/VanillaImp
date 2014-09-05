package io.github.penguinsfan77.randomstuff.items.weapons;

import io.github.penguinsfan77.randomstuff.RandomStuff;
import io.github.penguinsfan77.randomstuff.items.ModItemMaterials;
import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.references.Textures;
import io.github.penguinsfan77.randomstuff.references.ToolTips;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;

import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;


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
			if (NBTHelper.hasRenderTag(item, NBTTags.HEAD_COLOR)) {
				return Integer.parseInt(NBTHelper.getRenderString(item, NBTTags.HEAD_COLOR), 16);
			}
		}
		return super.getColorFromItemStack(item, renderPass);
		
	}
	
	@Override
	public int getRenderPasses(int metadata) {

		return 3;
		
	}
	
	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		
		super.addInformation(item, player, list, bool);
		if (HeadMaterial.equals(ModItemMaterials.COLORED)) {
			if (NBTHelper.hasRenderTag(item, NBTTags.HEAD_COLOR)) {
				list.add(StatCollector.translateToLocal(ToolTips.HEAD) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.COLORS.get(NBTHelper.getRenderString(item, NBTTags.HEAD_COLOR))));
			} else {
				list.add(StatCollector.translateToLocal(ToolTips.BASE) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.COLORS.get(Colors.WHITE)));
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		
		ItemStack stack = new ItemStack(this);
		
		for (int i = 0; i < 16; i++) {
			NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.COLORED);
			NBTHelper.setRenderString(stack, NBTTags.HANDLE_COLOR, Colors.fromNumber[i]);
			if (material.equals(ModItemMaterials.COLORED)) {
				for (int x = 0; x < 16; x++) {
					NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.COLORED);
					NBTHelper.setRenderString(stack, NBTTags.HANDLE_COLOR, Colors.fromNumber[i]);
					NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[x]);
					if (HeadMaterial.equals(ModItemMaterials.COLORED)) {
						for (int y = 0; y < 16; y++) {
							NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.COLORED);
							NBTHelper.setRenderString(stack, NBTTags.HANDLE_COLOR, Colors.fromNumber[i]);
							NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[x]);
							NBTHelper.setRenderString(stack, NBTTags.HEAD_COLOR, Colors.fromNumber[y]);
							list.add(stack);
							stack = new ItemStack(this);
						}
						continue;
					}
					list.add(stack);
					stack = new ItemStack(this);
				}
				continue;
			}
			list.add(stack);
			stack = new ItemStack(this);
		}
		if (material.equals(ModItemMaterials.COLORED)) {
			for (int i = 0; i < 16; i++) {
				NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.DIAMOND);
				NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
				if (HeadMaterial.equals(ModItemMaterials.COLORED)) {
					for (int y = 0; y < 16; y++) {
						NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.DIAMOND);
						NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
						NBTHelper.setRenderString(stack, NBTTags.HEAD_COLOR, Colors.fromNumber[y]);
						list.add(stack);
						stack = new ItemStack(this);
					}
				} else {
					list.add(stack);
					stack = new ItemStack(this);
				}
			}
		} else {
			NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.DIAMOND);
			list.add(stack);
			stack = new ItemStack(this);
		}
		if (material.equals(ModItemMaterials.COLORED)) {
			for (int i = 0; i < 16; i++) {
				NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.GOLD);
				NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
				if (HeadMaterial.equals(ModItemMaterials.COLORED)) {
					for (int y = 0; y < 16; y++) {
						NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.GOLD);
						NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
						NBTHelper.setRenderString(stack, NBTTags.HEAD_COLOR, Colors.fromNumber[y]);
						list.add(stack);
						stack = new ItemStack(this);
					}
				} else {
					list.add(stack);
					stack = new ItemStack(this);
				}
			}
		} else {
			NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.GOLD);
			list.add(stack);
			stack = new ItemStack(this);
		}
		if (material.equals(ModItemMaterials.COLORED)) {
			for (int i = 0; i < 16; i++) {
				NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.IRON);
				NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
				if (HeadMaterial.equals(ModItemMaterials.COLORED)) {
					for (int y = 0; y < 16; y++) {
						NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.IRON);
						NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
						NBTHelper.setRenderString(stack, NBTTags.HEAD_COLOR, Colors.fromNumber[y]);
						list.add(stack);
						stack = new ItemStack(this);
					}
				} else {
					list.add(stack);
					stack = new ItemStack(this);
				}
			}
		} else {
			NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.IRON);
			list.add(stack);
			stack = new ItemStack(this);
		}
		if (material.equals(ModItemMaterials.COLORED)) {
			for (int i = 0; i < 16; i++) {
				NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.STONE);
				NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
				if (HeadMaterial.equals(ModItemMaterials.COLORED)) {
					for (int y = 0; y < 16; y++) {
						NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.STONE);
						NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
						NBTHelper.setRenderString(stack, NBTTags.HEAD_COLOR, Colors.fromNumber[y]);
						list.add(stack);
						stack = new ItemStack(this);
					}
				} else {
					list.add(stack);
					stack = new ItemStack(this);
				}
			}
		} else {
			NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.STONE);
			list.add(stack);
			stack = new ItemStack(this);
		}
		if (material.equals(ModItemMaterials.COLORED)) {
			for (int i = 0; i < 16; i++) {
				NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.WOOD);
				NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
				if (HeadMaterial.equals(ModItemMaterials.COLORED)) {
					for (int y = 0; y < 16; y++) {
						NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.WOOD);
						NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
						NBTHelper.setRenderString(stack, NBTTags.HEAD_COLOR, Colors.fromNumber[y]);
						list.add(stack);
						stack = new ItemStack(this);
					}
				} else {
					list.add(stack);
					stack = new ItemStack(this);
				}
			}
		} else {
			NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.WOOD);
			list.add(stack);
			stack = new ItemStack(this);
		}
		
		LogHelper.info(list.size() + " different tridents!");

	}

}
