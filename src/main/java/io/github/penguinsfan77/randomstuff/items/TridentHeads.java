package io.github.penguinsfan77.randomstuff.items;

import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.references.Names;
import io.github.penguinsfan77.randomstuff.references.Textures;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;

import java.util.HashMap;
import java.util.List;

import javax.lang.model.element.Modifier;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TridentHeads extends ModItem {
	
	private HashMap icons = new HashMap<Integer, IIcon>();
	
	public TridentHeads() {

		super();
		this.setUnlocalizedName(Names.Items.TRIDENT_HEAD);
		
		this.setMaxStackSize(64);
		this.setHasSubtypes(true);
		
	}
	
	public ToolMaterial getToolMaterial(ItemStack item) {
		
		if (item.getItemDamage() < 16) {
			return ModItemMaterials.COLORED;
		} else if (item.getItemDamage() == 16) {
			return ToolMaterial.STONE;
		} else if (item.getItemDamage() == 17) {
			return ToolMaterial.GOLD;
		} else if (item.getItemDamage() == 18) {
			return ToolMaterial.IRON;
		} else if (item.getItemDamage() == 19) {
			return ToolMaterial.EMERALD;
		} else if (item.getItemDamage() == 20) {
			return ToolMaterial.WOOD;
		} else {
			return null;
		}
		
	}
	
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {

		if (itemStack.getItemDamage() < 16) {
			return Integer.parseInt(Colors.fromNumber[itemStack.getItemDamage()], 16);
		} else {
			return super.getColorFromItemStack(itemStack, renderPass);
		}
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		
		icons.put(0, iconRegister.registerIcon(Textures.PREFIX + "colored_trident_head_item"));
		icons.put(16, iconRegister.registerIcon(Textures.PREFIX + "stone_trident_head_item"));
		icons.put(17, iconRegister.registerIcon(Textures.PREFIX + "gold_trident_head_item"));
		icons.put(18, iconRegister.registerIcon(Textures.PREFIX + "iron_trident_head_item"));
		icons.put(19, iconRegister.registerIcon(Textures.PREFIX + "emerald_trident_head_item"));
		icons.put(20, iconRegister.registerIcon(Textures.PREFIX + "wood_trident_head_item"));
		
	}
	
	@Override
	public IIcon getIcon(ItemStack item, int pass) {

		if (item.getItemDamage() < 16) {
			return (IIcon) icons.get(0);
		} else {
			return (IIcon) icons.get(item.getItemDamage());
		}
		
	}
	
	@Override
    public String getUnlocalizedName() {
		
        return String.format("item.%s%s", Textures.PREFIX, Names.Items.TRIDENT_HEAD);
        
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
    	
        return String.format("item.%s%s.%s", Textures.PREFIX, Names.Items.TRIDENT_HEAD, Names.Items.Types.fromDamage[itemStack.getItemDamage()]);
   
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list) {

    	for (int meta = 0; meta < 21; meta++) {
    		
    		list.add(new ItemStack(this, 1, meta));
    		
    	}
    	
    }

}
