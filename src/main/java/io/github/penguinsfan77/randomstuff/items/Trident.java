package io.github.penguinsfan77.randomstuff.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class Trident extends ModItemSword {
	
	public Trident() {
		
		super(ToolMaterial.GOLD);
		this.setUnlocalizedName("trident");
		
		this.setFull3D();
		this.setMaxDamage(500);
		this.setMaxStackSize(1);
		
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {

		return EnumAction.none;
		
	}

}
