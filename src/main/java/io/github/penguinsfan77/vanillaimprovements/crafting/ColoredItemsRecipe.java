package io.github.penguinsfan77.vanillaimprovements.crafting;

import io.github.penguinsfan77.vanillaimprovements.init.ModBlocks;
import io.github.penguinsfan77.vanillaimprovements.init.ModItems;
import io.github.penguinsfan77.vanillaimprovements.references.Colors;
import io.github.penguinsfan77.vanillaimprovements.references.NBTTags;
import io.github.penguinsfan77.vanillaimprovements.utilities.ItemHelper;
import io.github.penguinsfan77.vanillaimprovements.utilities.NBTHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ColoredItemsRecipe implements IRecipe {

	private static final int MAX_CRAFT_GRID_WIDTH = 3;
    private static final int MAX_CRAFT_GRID_HEIGHT = 3;

    private ItemStack output = null;
    private Object[] input = null;
    private int width = 0;
    private int height = 0;
    private boolean mirrored = true;

    public ColoredItemsRecipe(Block     result, Object... recipe){ this(new ItemStack(result), recipe); }
    public ColoredItemsRecipe(Item      result, Object... recipe){ this(new ItemStack(result), recipe); }
	public ColoredItemsRecipe(ItemStack result, Object ... recipe) {
		
		output = result.copy();

        String shape = "";
        int idx = 0;

        if (recipe[idx] instanceof Boolean)
        {
            mirrored = (Boolean)recipe[idx];
            if (recipe[idx+1] instanceof Object[])
            {
                recipe = (Object[])recipe[idx+1];
            }
            else
            {
                idx = 1;
            }
        }

        if (recipe[idx] instanceof String[])
        {
            String[] parts = ((String[])recipe[idx++]);

            for (String s : parts)
            {
                width = s.length();
                shape += s;
            }

            height = parts.length;
        }
        else
        {
            while (recipe[idx] instanceof String)
            {
                String s = (String)recipe[idx++];
                shape += s;
                width = s.length();
                height++;
            }
        }

        if (width * height != shape.length())
        {
            String ret = "Invalid shaped ore recipe: ";
            for (Object tmp :  recipe)
            {
                ret += tmp + ", ";
            }
            ret += output;
            throw new RuntimeException(ret);
        }

        HashMap<Character, Object> itemMap = new HashMap<Character, Object>();

        for (; idx < recipe.length; idx += 2)
        {
            Character chr = (Character)recipe[idx];
            Object in = recipe[idx + 1];

            if (in instanceof ItemStack)
            {
                itemMap.put(chr, ((ItemStack)in).copy());
            }
            else if (in instanceof Item)
            {
                itemMap.put(chr, new ItemStack((Item)in));
            }
            else if (in instanceof Block)
            {
                itemMap.put(chr, new ItemStack((Block)in, 1, OreDictionary.WILDCARD_VALUE));
            }
            else if (in instanceof String)
            {
                itemMap.put(chr, OreDictionary.getOres((String)in));
            }
            else
            {
                String ret = "Invalid shaped ore recipe: ";
                for (Object tmp :  recipe)
                {
                    ret += tmp + ", ";
                }
                ret += output;
                throw new RuntimeException(ret);
            }
        }

        input = new Object[width * height];
        int x = 0;
        for (char chr : shape.toCharArray())
        {
            input[x++] = itemMap.get(chr);
        }
    }

	/**
     * Returns the size of the recipe area
     */
    @Override
    public int getRecipeSize(){ return input.length; }

    @Override
    public ItemStack getRecipeOutput(){ return output; }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(InventoryCrafting inv, World world)
    {
        for (int x = 0; x <= MAX_CRAFT_GRID_WIDTH - width; x++)
        {
            for (int y = 0; y <= MAX_CRAFT_GRID_HEIGHT - height; ++y)
            {
                if (checkMatch(inv, x, y, false))
                {
                    return true;
                }

                if (mirrored && checkMatch(inv, x, y, true))
                {
                    return true;
                }
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    private boolean checkMatch(InventoryCrafting inv, int startX, int startY, boolean mirror)
    {
        for (int x = 0; x < MAX_CRAFT_GRID_WIDTH; x++)
        {
            for (int y = 0; y < MAX_CRAFT_GRID_HEIGHT; y++)
            {
                int subX = x - startX;
                int subY = y - startY;
                Object target = null;

                if (subX >= 0 && subY >= 0 && subX < width && subY < height)
                {
                    if (mirror)
                    {
                        target = input[width - subX - 1 + subY * width];
                    }
                    else
                    {
                        target = input[subX + subY * width];
                    }
                }

                ItemStack slot = inv.getStackInRowAndColumn(x, y);

                if (target instanceof ItemStack)
                {
                    if (!OreDictionary.itemMatches((ItemStack)target, slot, false))
                    {
                        return false;
                    }
                }
                else if (target instanceof ArrayList)
                {
                    boolean matched = false;

                    Iterator<ItemStack> itr = ((ArrayList<ItemStack>)target).iterator();
                    while (itr.hasNext() && !matched)
                    {
                        matched = OreDictionary.itemMatches(itr.next(), slot, false);
                    }

                    if (!matched)
                    {
                        return false;
                    }
                }
                else if (target == null && slot != null)
                {
                    return false;
                }
            }
        }

        return true;
    }
    
    public ColoredItemsRecipe setMirrored(boolean mirror)
    {
        mirrored = mirror;
        return this;
    }

    /**
     * Returns the input for this recipe, any mod accessing this value should never
     * manipulate the values in this array as it will effect the recipe itself.
     * @return The recipes input vales.
     */
    public Object[] getInput()
    {
        return this.input;
    }

	/**
	 * Returns an Item that is the result of this recipe
	 */
	public ItemStack getCraftingResult(InventoryCrafting grid) {
		
		ItemStack itemstack = this.getRecipeOutput().copy();
		ItemStack stick1 = null;
		ItemStack stick2 = null;
		ItemStack head = null;
		ItemStack plank1 = null;
		ItemStack plank2 = null;
		ItemStack plank3 = null;
		
		for (int i = 0; i < grid.getSizeInventory(); i++) {
			ItemStack item = grid.getStackInSlot(i);
			if (item != null && item.getItem().equals(ModItems.stick)) {
				if (stick1 == null) {
					stick1 = item;
				} else {
					stick2 = item;
				}
			} else if (item != null && item.getItem().equals(ModItems.trident_head)) {
				head = item;
			} else if (item != null && item.getItem().equals(new ItemStack(ModBlocks.colored_planks).getItem())) {
				if (plank1 == null) plank1 = item;
				else if (plank2 == null) plank2 = item;
				else plank3 = item;
			}
		}
		
		if (plank1 != null) {
			itemstack = new ItemStack(ItemHelper.getColoredVersion(itemstack.getItem()));
			if (plank2 != null) {
				if (plank3 != null) {
					if (plank1.getItemDamage() == plank2.getItemDamage() && plank1.getItemDamage() == plank3.getItemDamage()) {
						NBTHelper.setRenderString(itemstack, NBTTags.BASE_COLOR, Colors.fromNumber[plank1.getItemDamage()]);
					}
				} else {
					if (plank1.getItemDamage() == plank2.getItemDamage()) {
						NBTHelper.setRenderString(itemstack, NBTTags.BASE_COLOR, Colors.fromNumber[plank1.getItemDamage()]);
					}
				}
			} else {
				NBTHelper.setRenderString(itemstack, NBTTags.BASE_COLOR, Colors.fromNumber[plank1.getItemDamage()]);
			}
		}
		
		if (head != null) {
			if (head.getItemDamage() < 16) {
				NBTHelper.setRenderString(itemstack, NBTTags.HEAD_COLOR, Colors.fromNumber[head.getItemDamage()]);
			}
		}
		if (stick2 != null) {
			if (stick1.getItemDamage() == stick2.getItemDamage()) {
				if (stick1.getItemDamage() < 16) {
					NBTHelper.setRenderString(itemstack, NBTTags.HANDLE_COLOR, Colors.fromNumber[stick1.getItemDamage()]);
					NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.COLORED);
				} else if (stick1.getItemDamage() == 16) {
					NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.STONE);
				} else if (stick1.getItemDamage() == 17) {
					NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.GOLD);
				} else if (stick1.getItemDamage() == 18) {
					NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.IRON);
				} else if (stick1.getItemDamage() == 19) {
					NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.DIAMOND);
				}
				return itemstack;
			} else {
				return null;
			}
		} else if (stick1 != null) {
			if (stick1.getItemDamage() < 16) {
				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE_COLOR, Colors.fromNumber[stick1.getItemDamage()]);
				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.COLORED);
			} else if (stick1.getItemDamage() == 16) {
				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.STONE);
			} else if (stick1.getItemDamage() == 17) {
				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.GOLD);
			} else if (stick1.getItemDamage() == 18) {
				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.IRON);
			} else if (stick1.getItemDamage() == 19) {
				NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.DIAMOND);
			}
			return itemstack;
		} else {
			NBTHelper.setRenderString(itemstack, NBTTags.HANDLE, NBTTags.Values.WOOD);
			return itemstack;
		}
	}

}
