package io.github.penguinsfan77.randomstuff.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.penguinsfan77.randomstuff.creativeTab.ModCreativeTabs;
import io.github.penguinsfan77.randomstuff.references.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ModBlock extends Block {
	
	//Constructor
	public ModBlock(Material material) {
		
        super(material);
        
        this.setCreativeTab(ModCreativeTabs.RANDOM_STUFF_TAB);
        
    }

	//Default Constructor
    public ModBlock() {
    	
        this(Material.rock);
        
    }

    //Get the unlocalized name
    @Override
    public String getUnlocalizedName() {
    	
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    
    }

    //Set the texture
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
    	
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
   
    }

    //Get unlocalized name without the prefix
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
    	
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
        
    }

}
