package io.github.penguinsfan77.randomstuff.crafting;

import io.github.penguinsfan77.randomstuff.init.ModItems;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;

import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ColoredItemsRecipe implements IRecipe {

	/** How many horizontal slots this recipe is wide. */
	public final int recipeWidth;
	/** How many vertical slots this recipe uses. */
	public final int recipeHeight;
	/** Is a array of ItemStack that composes the recipe. */
	public final ItemStack[] recipeItems;
	/** Is the ItemStack that you get when craft the recipe. */
	private ItemStack recipeOutput;

	public ColoredItemsRecipe(ItemStack output, Object ... params) {
		
		String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (params[i] instanceof String[])
        {
            String[] astring = (String[])((String[])params[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (params[i] instanceof String)
            {
                String s2 = (String)params[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < params.length; i += 2)
        {
            Character character = (Character)params[i];
            ItemStack itemstack1 = null;

            if (params[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)params[i + 1]);
            }
            else if (params[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)params[i + 1], 1, 32767);
            }
            else if (params[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)params[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, output);
        
        this.recipeWidth = j;
		this.recipeHeight = k;
		this.recipeItems = aitemstack;
		this.recipeOutput = output;
        
	}

	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(InventoryCrafting grid, World world) {
		
		for (int i = 0; i <= 3 - this.recipeWidth; ++i)
		{
			for (int j = 0; j <= 3 - this.recipeHeight; ++j)
			{
				if (this.checkMatch(grid, i, j, true))
				{
					return true;
				}

				if (this.checkMatch(grid, i, j, false))
				{
					return true;
				}
			}
		}

		return false;
		
	}

	/**
	 * Checks if the region of a crafting inventory is match for the recipe.
	 */
	private boolean checkMatch(InventoryCrafting grid, int i, int j, boolean exact) {
		
		for (int k = 0; k < 3; ++k)
		{
			for (int l = 0; l < 3; ++l)
			{
				int i1 = k - i;
				int j1 = l - j;
				ItemStack itemstack = null;

				if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
				{
					if (exact)
					{
						itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
					}
					else
					{
						itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
					}
				}

				ItemStack itemstack1 = grid.getStackInRowAndColumn(k, l);

				if (itemstack1 != null || itemstack != null)
				{
					if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
					{
						return false;
					}

					if (itemstack.getItem() != itemstack1.getItem())
					{
						return false;
					}

					if (itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage())
					{
						return false;
					}
				}
			}
		}

		return true;
		
	}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	public ItemStack getCraftingResult(InventoryCrafting grid) {
		
		ItemStack itemstack = this.getRecipeOutput().copy();

		for (int i = 0; i < grid.getSizeInventory(); i++) {
			ItemStack item = grid.getStackInSlot(i);
			if (item != null && item.getItem().equals(ModItems.colored_stick)) {
				NBTHelper.setInteger(itemstack, NBTTags.COLOR, item.getItemDamage());
				return itemstack;
			}
		}
		
		return itemstack;
	}

	/**
	 * Returns the size of the recipe area
	 */
	public int getRecipeSize() {
		return this.recipeWidth * this.recipeHeight;
	}

}
