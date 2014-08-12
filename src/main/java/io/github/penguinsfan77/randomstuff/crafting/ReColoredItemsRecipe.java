package io.github.penguinsfan77.randomstuff.crafting;

import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ReColoredItemsRecipe implements IRecipe {
	
	/** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;
    /** Is a List of ItemStack that composes the recipe. */
    public final List recipeItems;

    public ReColoredItemsRecipe(ItemStack output, Object ... params) {
    	
    	ArrayList arraylist = new ArrayList();
        Object[] aobject = params;
        int i = params.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }
    	
        this.recipeOutput = output;
        this.recipeItems = arraylist;
        
    }

    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting grid, World world) {
    	
        ArrayList arraylist = new ArrayList(this.recipeItems);

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                ItemStack itemstack = grid.getStackInRowAndColumn(j, i);

                if (itemstack != null)
                {
                    boolean flag = false;
                    Iterator iterator = arraylist.iterator();

                    while (iterator.hasNext())
                    {
                        ItemStack itemstack1 = (ItemStack)iterator.next();

                        if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage()))
                        {
                            flag = true;
                            arraylist.remove(itemstack1);
                            break;
                        }
                    }

                    if (!flag)
                    {
                        return false;
                    }
                }
            }
        }

        return arraylist.isEmpty();
        
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting grid) {

    	ItemStack itemstack = this.recipeOutput.copy();
    	ItemStack dye = null;
    	ItemStack tool = null;

    	for (int i = 0; i < grid.getSizeInventory(); ++i) {
    		ItemStack item = grid.getStackInSlot(i);
    		if (item != null && item.getItem().equals(Items.dye)) {
    			dye = item;
    		} else if (item != null && (item.getItem() instanceof ItemTool || item.getItem() instanceof ItemSword)) {
    			tool = item;
    		}
    	}

    	if (dye != null && tool != null) {
    		itemstack.setItemDamage(tool.getItemDamage());
    		NBTHelper.setString(itemstack, NBTTags.COLOR, Colors.fromNumber[dye.getItemDamage()]);
    		NBTHelper.setString(itemstack, NBTTags.HANDLE, "colored");
    	}

    	return itemstack;

    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize() {
        return this.recipeItems.size();
    }

}
