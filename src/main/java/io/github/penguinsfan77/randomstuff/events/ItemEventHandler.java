package io.github.penguinsfan77.randomstuff.events;

import io.github.penguinsfan77.randomstuff.blocks.ModBlocks;
import io.github.penguinsfan77.randomstuff.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class ItemEventHandler {
	
	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		if (event.action.equals(Action.LEFT_CLICK_BLOCK) && event.entityPlayer.getHeldItem() != null && event.entityPlayer.getHeldItem().getItem().equals(ModItems.hammer)) {

			Block block = event.entityPlayer.getEntityWorld().getBlock(event.x, event.y, event.z);

			if (block.equals(Blocks.stone)) {

				event.entityPlayer.getEntityWorld().setBlock(event.x, event.y, event.z, ModBlocks.crackedStone);
				event.entityPlayer.getHeldItem().damageItem(1, event.entityLiving);
				event.useItem = Result.DENY;

			}

		}
		
	}


}
