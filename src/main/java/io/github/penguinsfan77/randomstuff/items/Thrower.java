package io.github.penguinsfan77.randomstuff.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class Thrower extends ModItem {
	
	public Thrower() {
		
		super();
		this.setUnlocalizedName("thrower");
		
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {

		entity.setVelocity(0, 5, 0);
		
		return true;
		
	}

}
