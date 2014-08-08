package io.github.penguinsfan77.randomstuff.items.tools;

import io.github.penguinsfan77.randomstuff.init.ModBlocks;
import io.github.penguinsfan77.randomstuff.references.Names;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class Hammer extends ModItemTool {
	
	private static final Set effectiveOn = Sets.newHashSet(new Block[] {Blocks.stone, Blocks.stonebrick});
	
	public Hammer() {
		
		super(2.0F, ToolMaterial.STONE, effectiveOn);
		this.setUnlocalizedName(Names.Tools.HAMMER);
		
		this.efficiencyOnProperMaterial = 999F;
		
		this.setContainerItem(this);
		
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {

		if (itemStack.attemptDamageItem(1, new Random())) {
			itemStack = null;
		}

		return itemStack;

	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack p_77630_1_) {
		
		return false;
		
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x, int y, int z, EntityLivingBase player) {

		item.damageItem(1, player);
		
		if (block.equals(Blocks.stone)) {
			world.setBlock(x, y, z, ModBlocks.crackedStone);
		}
		
		return true;
		
	}
	
}
