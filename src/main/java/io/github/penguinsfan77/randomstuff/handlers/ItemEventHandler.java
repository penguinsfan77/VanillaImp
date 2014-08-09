package io.github.penguinsfan77.randomstuff.handlers;

import io.github.penguinsfan77.randomstuff.init.ModItems;
import io.github.penguinsfan77.randomstuff.items.tools.ModItemTool;
import io.github.penguinsfan77.randomstuff.references.Colors;
import io.github.penguinsfan77.randomstuff.references.NBTTags;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class ItemEventHandler {
	
	@SubscribeEvent
	public void onItemCrafted(ItemCraftedEvent event) {
		
		ItemStack itemStack = event.crafting;
		Item item = itemStack.getItem();
		IInventory craftingMatrix = event.craftMatrix;

		for (int i = 0; i < 5; i++) {
			if (item.equals(ModItems.pickaxes[i]) || item.equals(ModItems.axes[i]) || item.equals(ModItems.shovels[i]) || item.equals(ModItems.hoes[i])) {
				for (int x = 0; x < craftingMatrix.getSizeInventory(); i++) {
					if (craftingMatrix.getStackInSlot(x).getItem().equals(ModItems.coloredStick)) {
						ItemStack stick = craftingMatrix.getStackInSlot(x);
						NBTHelper.setString(event.crafting, NBTTags.COLOR, Colors.fromNumber[stick.getItemDamage()]);
						NBTHelper.setString(event.crafting, NBTTags.HANDLE, "wood");
					}
				}
			}
		}
		
	}

}
