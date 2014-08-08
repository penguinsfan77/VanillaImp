package io.github.penguinsfan77.randomstuff.creativeTab;

import io.github.penguinsfan77.randomstuff.init.ModItems;
import io.github.penguinsfan77.randomstuff.references.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTab {
	
	public static final CreativeTabs RANDOM_STUFF_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
		
		@Override
		public Item getTabIconItem() {
			
			return ModItems.gold_trident;
			
		}
		
	};

}
