package io.github.penguinsfan77.vanillaimprovements.items.tools;

import io.github.penguinsfan77.vanillaimprovements.VanillaImprovements;
import io.github.penguinsfan77.vanillaimprovements.creativeTab.ModCreativeTabs;
import io.github.penguinsfan77.vanillaimprovements.handlers.ConfigHandler;
import io.github.penguinsfan77.vanillaimprovements.items.ModItemMaterials;
import io.github.penguinsfan77.vanillaimprovements.references.Colors;
import io.github.penguinsfan77.vanillaimprovements.references.NBTTags;
import io.github.penguinsfan77.vanillaimprovements.references.Textures;
import io.github.penguinsfan77.vanillaimprovements.references.ToolTips;
import io.github.penguinsfan77.vanillaimprovements.utilities.LogHelper;
import io.github.penguinsfan77.vanillaimprovements.utilities.NBTHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemTool extends ItemTool {
	
	protected ToolMaterial material;

	protected String toolName;
	
	protected HashMap<String, IIcon> handles = new HashMap<String, IIcon>();
	protected IIcon base;
	protected String defualt;

	protected ModItemTool(float damage, ToolMaterial material, Set effectiveOn, String toolName, String defualtHandle) {
		
		super(damage, material, effectiveOn);
		this.material = material;
		
		this.toolName = toolName;
		this.defualt = defualtHandle;
		
		this.setUnlocalizedName(material.toString().toLowerCase() + "_" + toolName);
		
		this.setCreativeTab(ModCreativeTabs.RANDOM_STUFF_TOOLS_TAB);

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

		handles.put("wood", iconRegister.registerIcon(Textures.PREFIX + toolName + "_handle"));
		handles.put("colored", iconRegister.registerIcon(Textures.PREFIX + "colored_" + toolName + "_handle"));
		handles.put("stone", iconRegister.registerIcon(Textures.PREFIX + "stone_" + toolName + "_handle"));
		handles.put("iron", iconRegister.registerIcon(Textures.PREFIX + "iron_" + toolName + "_handle"));
		handles.put("gold", iconRegister.registerIcon(Textures.PREFIX + "gold_" + toolName + "_handle"));
		handles.put("diamond", iconRegister.registerIcon(Textures.PREFIX + "emerald_" + toolName + "_handle"));
		base = iconRegister.registerIcon(Textures.PREFIX + getToolMaterialName().toLowerCase() + "_" + toolName);
		
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {

		if (pass == 0) {
			if (NBTHelper.hasRenderTag(stack, NBTTags.HANDLE)) {
				return (IIcon) handles.get(NBTHelper.getRenderString(stack, NBTTags.HANDLE));
			} else {
				NBTHelper.setRenderString(stack, NBTTags.HANDLE, defualt);
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

		if (material.equals(ModItemMaterials.COLORED)) {
			if (NBTHelper.hasRenderTag(item, NBTTags.BASE_COLOR)) {
				list.add(StatCollector.translateToLocal(ToolTips.BASE) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.COLORS.get(NBTHelper.getRenderString(item, NBTTags.BASE_COLOR))));
			} else {
				list.add(StatCollector.translateToLocal(ToolTips.BASE) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.COLORS.get(Colors.WHITE)));
			}
		}
		if (NBTHelper.hasRenderTag(item, NBTTags.HANDLE)) {
			if (NBTHelper.getRenderString(item, NBTTags.HANDLE).equalsIgnoreCase(NBTTags.Values.COLORED)) {
				list.add(StatCollector.translateToLocal(ToolTips.COLOR) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.COLORS.get(NBTHelper.getRenderString(item, NBTTags.HANDLE_COLOR))));
			} else {
				list.add(StatCollector.translateToLocal(ToolTips.HANDLE) + ": " + StatCollector.translateToLocal((String) ToolTips.Values.TYPES.get(NBTHelper.getRenderString(item, NBTTags.HANDLE))));
			}
		}
		super.addInformation(item, player, list, bool);

	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		
		if (ConfigHandler.allTools) {

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
			if (toolName.equalsIgnoreCase("hammer")) {
				if (material.equals(ModItemMaterials.COLORED)) {
					for (int i = 0; i < 16; i++) {
						NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.WOOD);
						NBTHelper.setRenderString(stack, NBTTags.BASE_COLOR, Colors.fromNumber[i]);
						list.add(stack);
						stack = new ItemStack(this);
					}
				} else {
					NBTHelper.setRenderString(stack, NBTTags.HANDLE, NBTTags.Values.WOOD);
					list.add(stack);
					stack = new ItemStack(this);
				}
			}

		} else {
			list.add(new ItemStack(this));
		}

	}
	
	//Get the unlocalized name
    @Override
    public String getUnlocalizedName() {
    	
        return String.format("item.%s%s", Textures.PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    
    }

    //Get the unlocalized name of an ItemStack
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
    	
        return String.format("item.%s%s", Textures.PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    
    }

    //Get the unlocalized name without the prefix
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
    	
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    
    }

}
