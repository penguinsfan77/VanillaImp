package io.github.penguinsfan77.randomstuff.items.tools;

import io.github.penguinsfan77.randomstuff.init.ModBlocks;
import io.github.penguinsfan77.randomstuff.references.Names;
import io.github.penguinsfan77.randomstuff.utilities.LogHelper;
import io.github.penguinsfan77.randomstuff.utilities.NBTHelper;

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
	
	public Hammer(ToolMaterial material) {
		
		super(2.0F, material, effectiveOn, "hammer", "wood");
		
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
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int face, float float1, float float2, float float3) {
		
		boolean sucsess = false;
		
		if (world.getBlock(x, y, z).equals(Blocks.stone)) {
			world.setBlock(x, y, z, ModBlocks.cracked_stone);
			sucsess = true;
		} else if (world.getBlock(x, y, z).equals(Blocks.stonebrick)) {
			world.setBlock(x, y, z, Blocks.stonebrick, 2, 3);
			sucsess = true;
		}
		
		if (sucsess) {
			item.damageItem(1, player);
			player.playSound(Block.soundTypeStone.getBreakSound(), 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
			return true;
		}
		
		return false;
		
	}
	
}
