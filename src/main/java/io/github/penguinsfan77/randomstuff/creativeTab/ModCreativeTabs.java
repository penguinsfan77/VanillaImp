package io.github.penguinsfan77.randomstuff.creativeTab;

import io.github.penguinsfan77.randomstuff.init.ModBlocks;
import io.github.penguinsfan77.randomstuff.init.ModItems;
import io.github.penguinsfan77.randomstuff.references.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs {
	
	public static final CreativeTabs RANDOM_STUFF_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
		
		@Override
		public Item getTabIconItem() {
			
			return Item.getItemFromBlock(ModBlocks.crackedStone);
			
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
