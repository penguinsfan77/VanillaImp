package io.github.penguinsfan77.randomstuff.items.weapons;

import java.util.HashMap;
import java.util.List;

import io.github.penguinsfan77.randomstuff.creativeTab.ModCreativeTab;
import io.github.penguinsfan77.randomstuff.items.ModItemMaterials;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.references.Reference;
import io.github.penguinsfan77.randomstuff.references.Textures;
import io.github.penguinsfan77.randomstuff.references.ToolTips;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemWeapon extends ItemSword {
	
	protected ToolMaterial material;
	
	protected String weaponName;
	
	protected HashMap<String, IIcon> handles = new HashMap<String, IIcon>();
	protected IIcon base;
	protected String defualt;

	protected ModItemWeapon(ToolMaterial material, String weaponName, String defaultHandle) {
		
		super(material);
		this.material = material;
		
		this.weaponName = weaponName;
		this.defualt = defaultHandle;
		
		this.setUnlocalizedName(material.toString().toLowerCase() + "_" + weaponName);
		
		this.setCreativeTab(ModCreativeTab.RANDOM_STUFF_TAB);

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

		handles.put("colored", iconRegister.registerIcon(Textures.PREFIX + "colored_" + weaponName + "_handle"));
		handles.put("wood", iconRegister.registerIcon(Textures.PREFIX + weaponName + "_handle"));
		handles.put("stone", iconRegister.registerIcon(Textures.PREFIX + "stone_" + weaponName + "_handle"));
		handles.put("iron", iconRegister.registerIcon(Textures.PREFIX + "iron_" + weaponName + "_handle"));
		handles.put("gold", iconRegister.registerIcon(Textures.PREFIX + "gold_" + weaponName + "_handle"));
		handles.put("diamond", iconRegister.registerIcon(Textures.PREFIX + "emerald_" + weaponName + "_handle"));
		base = iconRegister.registerIcon(Textures.PREFIX + getToolMaterialName().toLowerCase() + "_" + weaponName);
		
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {

		if (pass == 0) {
			if (NBTHelper.hasTag(stack, NBTTags.HANDLE)) {
				return (IIcon) handles.get(NBTHelper.getString(stack, NBTTags.HANDLE));
			} else {
				return (IIcon) handles.get(defualt);
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
		
		if (renderPass == 0 && NBTHelper.hasTag(item, NBTTags.HANDLE_COLOR)) {
			return Integer.parseInt(NBTHelper.getString(item, NBTTags.HANDLE_COLOR), 16);
		} else if (renderPass == 1 && material.equals(ModItemMaterials.COLORED) && NBTHelper.hasTag(item, NBTTags.BASE_COLOR)) {
			return Integer.parseInt(NBTHelper.getString(item, NBTTags.BASE_COLOR), 16);
		}

		return super.getColorFromItemStack(item, renderPass);
		
	}
	
	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {

		if (NBTHelper.hasTag(item, NBTTags.HANDLE) && NBTHelper.getString(item, NBTTags.HANDLE).equalsIgnoreCase(NBTTags.Values.COLORED)) {
			list.add(StatCollector.translateToLocal(ToolTips.COLOR) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.COLORS.get(NBTHelper.getString(item, NBTTags.HANDLE_COLOR))));
		}
		super.addInformation(item, player, list, bool);
		
	}

	//Get the unlocalized name
    @Override
    public String getUnlocalizedName() {
    	
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    
    }

    //Get the unlocalized name of an ItemStack
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
    	
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    
    }

    //Get the unlocalized name without the prefix
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
    	
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    
    }

}
