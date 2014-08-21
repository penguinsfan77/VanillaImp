package io.github.penguinsfan77.randomstuff.items.tools;

import io.github.penguinsfan77.randomstuff.creativeTab.ModCreativeTab;
import io.github.penguinsfan77.randomstuff.references.Textures;

import java.util.Set;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ModItemTool extends ItemTool {
	
	protected ToolMaterial material;

	protected ModItemTool(float damage, ToolMaterial material, Set effectiveOn) {
		
		super(damage, material, effectiveOn);
		this.material = material;
		
		this.setCreativeTab(ModCreativeTab.RANDOM_STUFF_TAB);

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

    //Set the texture
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
    	
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
   
    }

    //Get the unlocalized name without the prefix
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
    	
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    
    }

}
