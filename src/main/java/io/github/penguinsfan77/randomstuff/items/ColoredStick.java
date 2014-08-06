package io.github.penguinsfan77.randomstuff.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.Names;
import io.github.penguinsfan77.randomstuff.references.Textures;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ColoredStick extends ModItem {
	
	public ColoredStick() {
		
		super();
		this.setUnlocalizedName(Names.Items.COLORED_STICK);
		
		this.setMaxStackSize(64);
		this.setHasSubtypes(true);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {

		return Integer.parseInt(Colors.fromNumber[itemStack.getItemDamage()], 16);
		
	}
	
	@Override
    public String getUnlocalizedName() {
		
        return String.format("item.%s%s", Textures.PREFIX, Names.Items.COLORED_STICK);
        
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
    	
        return String.format("item.%s%s.%s", Textures.PREFIX, Names.Items.COLORED_STICK, Names.Colors.COLOR[itemStack.getItemDamage()]);
   
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list) {

    	for (int meta = 0; meta < 16; meta++) {
    		
    		list.add(new ItemStack(this, 1, meta));
    		
    	}
    	
    }

}
