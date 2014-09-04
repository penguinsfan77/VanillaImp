package io.github.penguinsfan77.randomstuff.items.weapons;

import java.util.HashMap;
import java.util.List;

import io.github.penguinsfan77.randomstuff.RandomStuff;
import io.github.penguinsfan77.randomstuff.creativeTab.ModCreativeTabs;
import io.github.penguinsfan77.randomstuff.items.ModItemMaterials;
import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.references.Reference;
import io.github.penguinsfan77.randomstuff.references.Textures;
import io.github.penguinsfan77.randomstuff.references.ToolTips;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
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
		
		this.setCreativeTab(ModCreativeTabs.RANDOM_STUFF_WEAPONS_TAB);

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
			if (NBTHelper.hasRenderTag(stack, NBTTags.HANDLE)) {
				return (IIcon) handles.get(NBTHelper.getRenderString(stack, NBTTags.HANDLE));
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
		
		if (renderPass == 0 && NBTHelper.hasRenderTag(item, NBTTags.HANDLE_COLOR)) {
			return Integer.parseInt(NBTHelper.getRenderString(item, NBTTags.HANDLE_COLOR), 16);
		} else if (renderPass == 1 && material.equals(ModItemMaterials.COLORED) && NBTHelper.hasRenderTag(item, NBTTags.BASE_COLOR)) {
			return Integer.parseInt(NBTHelper.getRenderString(item, NBTTags.BASE_COLOR), 16);
		}

		return super.getColorFromItemStack(item, renderPass);
		
	}
	
	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {

		if (NBTHelper.hasRenderTag(item, NBTTags.HANDLE)) {
			if (NBTHelper.getRenderString(item, NBTTags.HANDLE).equalsIgnoreCase(NBTTags.Values.COLORED)) {
				list.add(StatCollector.translateToLocal(ToolTips.COLOR) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.COLORS.get(NBTHelper.getRenderString(item, NBTTags.HANDLE_COLOR))));
			} else {
				list.add(StatCollector.translateToLocal(ToolTips.HANDLE) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.HANDLES.get(NBTHelper.getRenderString(item, NBTTags.HANDLE))));
			}
		}
		super.addInformation(item, player, list, bool);

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
				list.add(stack);
				stack = new ItemStack(this);
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
				list.add(stack);
				stack = new ItemStack(this);
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
				list.add(stack);
				stack = new ItemStack(this);
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
				list.add(stack);
				stack = new ItemStack(this);
			}
		} else {
			NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.STONE);
			list.add(stack);
			stack = new ItemStack(this);
		}
		
		LogHelper.info(list.size() + " different weapons!");
		
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
