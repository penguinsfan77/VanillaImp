package io.github.penguinsfan77.randomstuff.items;

import java.util.Random;

import net.minecraft.item.ItemStack;

public class Hammer extends ModItem {
	
	public Hammer() {
		
		super();
		this.setUnlocalizedName("hammer");
		
		this.setMaxDamage(100);
		this.setMaxStackSize(1);
		
		this.setContainerItem(this);
		
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {

		if (itemStack.attemptDamageItem(1, new Random())) itemStack = null;

		return itemStack;

	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack p_77630_1_) {
		
		return false;
		
	}

}
