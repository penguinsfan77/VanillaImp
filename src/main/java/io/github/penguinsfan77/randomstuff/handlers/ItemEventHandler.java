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
	
	/*@SubscribeEvent
	public void onItemCrafted(ItemCraftedEvent event) {

		ItemStack itemStack = event.crafting;
		Item item = itemStack.getItem();
		IInventory craftingMatrix = event.craftMatrix;

		if (item.equals(ModItems.wood_pickaxe) || item.equals(ModItems.stone_pickaxe) || item.equals(ModItems.gold_pickaxe) || item.equals(ModItems.iron_pickaxe) || item.equals(ModItems.emerald_pickaxe)
				|| item.equals(ModItems.wood_shovel) || item.equals(ModItems.stone_shovel) || item.equals(ModItems.gold_shovel) || item.equals(ModItems.iron_shovel) || item.equals(ModItems.emerald_shovel)
				|| item.equals(ModItems.wood_axe) || item.equals(ModItems.stone_axe) || item.equals(ModItems.gold_axe) || item.equals(ModItems.iron_axe) || item.equals(ModItems.emerald_axe)
				|| item.equals(ModItems.wood_hoe) || item.equals(ModItems.stone_hoe) || item.equals(ModItems.gold_hoe) || item.equals(ModItems.iron_hoe) || item.equals(ModItems.emerald_hoe)) {
			for (int x = 0; x < craftingMatrix.getSizeInventory(); x++) {
				if (craftingMatrix.getStackInSlot(x).getItem().equals(ModItems.coloredStick)) {
					ItemStack stick = craftingMatrix.getStackInSlot(x);
					NBTHelper.setString(event.crafting, NBTTags.COLOR, Colors.fromNumber[stick.getItemDamage()]);
					NBTHelper.setString(event.crafting, NBTTags.HANDLE, "wood");
				}
			}
		}

	}
	*/

}
