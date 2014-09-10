package io.github.penguinsfan77.vanillaimprovements.utilities;

import io.github.penguinsfan77.vanillaimprovements.references.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class NBTHelper {
	
	public static boolean hasTag(ItemStack itemStack, String keyName) {
		
        return itemStack != null && itemStack.stackTagCompound != null && itemStack.stackTagCompound.hasKey(keyName);
        
    }
	
	public static boolean hasRenderTag(ItemStack itemStack, String keyName) {
		
		initNBTRenderTagList(itemStack);
		
        return getRenderTagList(itemStack).getCompoundTagAt(0).hasKey(keyName);
        
    }

    public static void removeTag(ItemStack itemStack, String keyName) {
    	
        if (itemStack.stackTagCompound != null)
        {
        	itemStack.stackTagCompound.removeTag(keyName);
        }
        
    }

    /**
     * Initializes the NBT Tag Compound for the given ItemStack if it is null
     *
     * @param itemStack
     *         The ItemStack for which its NBT Tag Compound is being checked for initialization
     */
    private static void initNBTTagCompound(ItemStack itemStack) {

    	if (itemStack.stackTagCompound == null)
    	{
    		itemStack.setTagCompound(new NBTTagCompound());
    	}

    }
    
    private static void initNBTRenderTagList(ItemStack itemStack) {
    	
    	initNBTTagCompound(itemStack);

    	if (!itemStack.stackTagCompound.hasKey("RenderData"))
    	{
    		itemStack.stackTagCompound.setTag("RenderData", new NBTTagList());
    		((NBTTagList) itemStack.stackTagCompound.getTag("RenderData")).appendTag(new NBTTagCompound());
    	}

    }
    
    private static NBTTagList getRenderTagList(ItemStack stack) {
    	
    	initNBTRenderTagList(stack);
    	
    	return (NBTTagList) stack.stackTagCompound.getTag("RenderData");
    	
    }

    public static void setLong(ItemStack itemStack, String keyName, long keyValue) {
    	
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setLong(keyName, keyValue);
        
    }

    // String
    public static String getString(ItemStack itemStack, String keyName) {
    	
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setString(itemStack, keyName, "");
        }

        return itemStack.stackTagCompound.getString(keyName);
        
    }

    public static void setString(ItemStack itemStack, String keyName, String keyValue) {
    	
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setString(keyName, keyValue);
        
    }

    // boolean
    public static boolean getBoolean(ItemStack itemStack, String keyName) {
    	
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setBoolean(itemStack, keyName, false);
        }

        return itemStack.stackTagCompound.getBoolean(keyName);
        
    }

    public static void setBoolean(ItemStack itemStack, String keyName, boolean keyValue) {
    	
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setBoolean(keyName, keyValue);
        
    }

    // byte
    public static byte getByte(ItemStack itemStack, String keyName) {
    	
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setByte(itemStack, keyName, (byte) 0);
        }

        return itemStack.stackTagCompound.getByte(keyName);
        
    }

    public static void setByte(ItemStack itemStack, String keyName, byte keyValue) {
    	
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setByte(keyName, keyValue);
        
    }

    // short
    public static short getShort(ItemStack itemStack, String keyName) {
    	
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setShort(itemStack, keyName, (short) 0);
        }

        return itemStack.stackTagCompound.getShort(keyName);
        
    }

    public static void setShort(ItemStack itemStack, String keyName, short keyValue) {
    	
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setShort(keyName, keyValue);
        
    }

    // int
    public static int getInt(ItemStack itemStack, String keyName) {
    	
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setInteger(itemStack, keyName, 0);
        }

        return itemStack.stackTagCompound.getInteger(keyName);
        
    }

    public static void setInteger(ItemStack itemStack, String keyName, int keyValue) {
    	
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setInteger(keyName, keyValue);
        
    }

    // long
    public static long getLong(ItemStack itemStack, String keyName) {
    	
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setLong(itemStack, keyName, 0);
        }

        return itemStack.stackTagCompound.getLong(keyName);
        
    }

    // float
    public static float getFloat(ItemStack itemStack, String keyName) {
    	
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setFloat(itemStack, keyName, 0);
        }

        return itemStack.stackTagCompound.getFloat(keyName);
        
    }

    public static void setFloat(ItemStack itemStack, String keyName, float keyValue) {
    	
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setFloat(keyName, keyValue);
        
    }

    // double
    public static double getDouble(ItemStack itemStack, String keyName) {
    	
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setDouble(itemStack, keyName, 0);
        }

        return itemStack.stackTagCompound.getDouble(keyName);
        
    }

    public static void setDouble(ItemStack itemStack, String keyName, double keyValue) {
    	
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setDouble(keyName, keyValue);
        
    }
    
    public static void setRenderString(ItemStack stack, String key, String value) {
    	
    	initNBTRenderTagList(stack);
    	
    	getRenderTagList(stack).getCompoundTagAt(0).setString(key, value);
    	
    }
    
    public static String getRenderString(ItemStack stack, String key) {
    	
    	initNBTRenderTagList(stack);
    	
    	return getRenderTagList(stack).getCompoundTagAt(0).getString(key);
    	
    }
    
    public static NBTTagCompound getRenderTags(ItemStack stack) {
    	
    	return getRenderTagList(stack).getCompoundTagAt(0);
    	
    }
    
    public static void setRenderTags(ItemStack stack, NBTTagCompound tag) {
    	
    	getRenderTagList(stack).func_150304_a(0, tag);
    	
    }

}
