package io.github.penguinsfan77.vanillaimprovements.crafting;

import io.github.penguinsfan77.vanillaimprovements.items.ModItemMaterials;
import io.github.penguinsfan77.vanillaimprovements.items.weapons.Trident;
import io.github.penguinsfan77.vanillaimprovements.references.Colors;
import io.github.penguinsfan77.vanillaimprovements.references.NBTTags;
import io.github.penguinsfan77.vanillaimprovements.utilities.ItemHelper;
import io.github.penguinsfan77.vanillaimprovements.utilities.LogHelper;
import io.github.penguinsfan77.vanillaimprovements.utilities.NBTHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class ReColoredItemsRecipe implements IRecipe {
	
	private ItemStack output = null;
    private ArrayList<Object> input = new ArrayList<Object>();

    public ReColoredItemsRecipe(Block result, Object... recipe){ this(new ItemStack(result), recipe); }
    public ReColoredItemsRecipe(Item  result, Object... recipe){ this(new ItemStack(result), recipe); }
    public ReColoredItemsRecipe(ItemStack result, Object... recipe)
    {
        output = result.copy();
        for (Object in : recipe)
        {
            if (in instanceof ItemStack)
            {
                input.add(((ItemStack)in).copy());
            }
            else if (in instanceof Item)
            {
                input.add(new ItemStack((Item)in));
            }
            else if (in instanceof Block)
            {
                input.add(new ItemStack((Block)in));
            }
            else if (in instanceof String)
            {
                input.add(OreDictionary.getOres((String)in));
            }
            else
            {
                String ret = "Invalid shapeless ore recipe: ";
                for (Object tmp :  recipe)
                {
                    ret += tmp + ", ";
                }
                ret += output;
                throw new RuntimeException(ret);
            }
        }
    }

    /**
     * Returns the size of the recipe area
     */
    @Override
    public int getRecipeSize(){ return input.size(); }

    @Override
    public ItemStack getRecipeOutput(){ return output; }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean matches(InventoryCrafting var1, World world)
    {
        ArrayList<Object> required = new ArrayList<Object>(input);

        for (int x = 0; x < var1.getSizeInventory(); x++)
        {
            ItemStack slot = var1.getStackInSlot(x);

            if (slot != null)
            {
                boolean inRecipe = false;
                Iterator<Object> req = required.iterator();

                while (req.hasNext())
                {
                    boolean match = false;

                    Object next = req.next();

                    if (next instanceof ItemStack)
                    {
                        match = OreDictionary.itemMatches((ItemStack)next, slot, false);
                    }
                    else if (next instanceof ArrayList)
                    {
                        Iterator<ItemStack> itr = ((ArrayList<ItemStack>)next).iterator();
                        while (itr.hasNext() && !match)
                        {
                            match = OreDictionary.itemMatches(itr.next(), slot, false);
                        }
                    }

                    if (match)
                    {
                        inRecipe = true;
                        required.remove(next);
                        break;
                    }
                }

                if (!inRecipe)
                {
                    return false;
                }
            }
        }

        return required.isEmpty();
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting grid) {

    	ItemStack itemstack = this.output.copy();
    	ItemStack dye = null;
    	int dyeRow = 0;
    	ItemStack tool = null;

    	for (int i = 0; i < grid.getSizeInventory(); ++i) {
    		ItemStack item = grid.getStackInSlot(i);
    		if (item != null && item.getItem().equals(Items.dye)) {
    			dye = item;
    			if (i <= 2) dyeRow = 0;
    			else if (i <= 5) dyeRow = 1;
    			else dyeRow = 2;
    		} else if (item != null && (item.getItem() instanceof ItemTool || item.getItem() instanceof ItemSword)) {
    			if (i != 4) return null;
    			tool = item;
    		}
    	}

    	if (dye != null && tool != null) {
    		ItemTool toolItem = null;
    		ItemSword toolSword = null;
    		if (tool.getItem() instanceof ItemTool) toolItem = (ItemTool) tool.getItem();
    		if (tool.getItem() instanceof ItemSword) toolSword = (ItemSword) tool.getItem();
    		itemstack.setItemDamage(tool.getItemDamage());
    		NBTTagCompound nbtCopy = (NBTTagCompound) NBTHelper.getRenderTags(tool).copy();
    		NBTHelper.setRenderTags(itemstack, nbtCopy);
    		if (dyeRow == 2) {
    			if (NBTHelper.hasRenderTag(tool, NBTTags.HANDLE) && (NBTHelper.getRenderString(tool, NBTTags.HANDLE).equalsIgnoreCase(NBTTags.Values.COLORED) || NBTHelper.getRenderString(tool, NBTTags.HANDLE).equalsIgnoreCase(NBTTags.Values.WOOD))) {
    				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE_COLOR, Colors.fromNumber[dye.getItemDamage()]);
    				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.COLORED);
    				return itemstack;
    			} else {
    				return null;
    			}
    		}
    		if (tool.getItem() instanceof Trident && dyeRow == 1) {
    			Trident trident = (Trident) tool.getItem();
    			if (trident.HeadMaterial.equals(ToolMaterial.WOOD) || trident.HeadMaterial.equals(ModItemMaterials.COLORED)) {
    				itemstack = new ItemStack(ItemHelper.getColoredTridentHeadVersion((Trident) tool.getItem()), 1, tool.getItemDamage());
    				NBTHelper.setRenderTags(itemstack, nbtCopy);
    				NBTHelper.setRenderString(itemstack, NBTTags.HEAD_COLOR, Colors.fromNumber[dye.getItemDamage()]);
    				return itemstack;
    			} else {
    				return null;
    			}
    		}
    		if (toolItem != null) {
    			if (dyeRow == 0) {
    				if (ItemHelper.getToolMaterial(toolItem.getToolMaterialName()).equals(ToolMaterial.WOOD) || ItemHelper.getToolMaterial(toolItem.getToolMaterialName()).equals(ModItemMaterials.COLORED)) {
    					itemstack = new ItemStack(ItemHelper.getColoredVersion(tool.getItem()), 1, tool.getItemDamage());
    					NBTHelper.setRenderTags(itemstack, nbtCopy);
    					NBTHelper.setRenderString(itemstack, NBTTags.BASE_COLOR, Colors.fromNumber[dye.getItemDamage()]);
    					return itemstack;
    				} else {
    					return null;
    				}
    			} else if (dyeRow == 1) {
    				if (NBTHelper.hasRenderTag(tool, NBTTags.HANDLE) && (NBTHelper.getRenderString(tool, NBTTags.HANDLE).equalsIgnoreCase(NBTTags.Values.COLORED) || NBTHelper.getRenderString(tool, NBTTags.HANDLE).equalsIgnoreCase(NBTTags.Values.WOOD))) {
        				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE_COLOR, Colors.fromNumber[dye.getItemDamage()]);
        				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.COLORED);
        				return itemstack;
        			} else {
        				return null;
        			}
    			}
    		} else if (toolSword != null) {
    			if (dyeRow <= 1) {
    				if (ItemHelper.getToolMaterial(toolSword.getToolMaterialName()).equals(ToolMaterial.WOOD) || ItemHelper.getToolMaterial(toolSword.getToolMaterialName()).equals(ModItemMaterials.COLORED)) {
    					itemstack = new ItemStack(ItemHelper.getColoredVersion(tool.getItem()), 1, tool.getItemDamage());
    					NBTHelper.setRenderTags(itemstack, nbtCopy);
    					NBTHelper.setRenderString(itemstack, NBTTags.BASE_COLOR, Colors.fromNumber[dye.getItemDamage()]);
    					return itemstack;
    				} else {
    					return null;
    				}
    			}
    		}
    	}

    	return itemstack;

    }

}
