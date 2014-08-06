package io.github.penguinsfan77.randomstuff.items;

import io.github.penguinsfan77.randomstuff.blocks.ModBlocks;
import io.github.penguinsfan77.randomstuff.references.Names;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class Hammer extends ModItem {
	
	public Hammer() {
		
		super();
		this.setUnlocalizedName(Names.Tools.HAMMER);
		
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
