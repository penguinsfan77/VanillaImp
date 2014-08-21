package io.github.penguinsfan77.randomstuff.items.weapons;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class ColoredSword extends ModItemWeapon {

	public ColoredSword(ToolMaterial material) {
		
		super(material, "sword", "iron");

	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {

		return EnumAction.block;
		
	}

}
