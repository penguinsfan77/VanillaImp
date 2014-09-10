package io.github.penguinsfan77.vanillaimprovements.creativeTab;

import io.github.penguinsfan77.vanillaimprovements.init.ModBlocks;
import io.github.penguinsfan77.vanillaimprovements.init.ModItems;
import io.github.penguinsfan77.vanillaimprovements.references.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs {
	
	public static final CreativeTabs RANDOM_STUFF_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
		
		@Override
		public Item getTabIconItem() {
			
			return Item.getItemFromBlock(ModBlocks.cracked_stone);
			
		}
		
	};
	
	public static final CreativeTabs RANDOM_STUFF_TOOLS_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "tools") {
		
		@Override
		public Item getTabIconItem() {
			
			return ModItems.iron_hammer;
			
		}
		
	};
	
	public static final CreativeTabs RANDOM_STUFF_WEAPONS_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "weapons") {
		
		@Override
		public Item getTabIconItem() {
			
			return ModItems.gold_diamond_trident;
			
		}
		
	};



}
