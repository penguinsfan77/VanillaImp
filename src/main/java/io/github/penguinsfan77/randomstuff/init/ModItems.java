package io.github.penguinsfan77.randomstuff.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import io.github.penguinsfan77.randomstuff.items.ColoredStick;
import io.github.penguinsfan77.randomstuff.items.ModItem;
import io.github.penguinsfan77.randomstuff.items.tools.Hammer;
import io.github.penguinsfan77.randomstuff.items.tools.ModItemTool;
import io.github.penguinsfan77.randomstuff.items.weapons.ModItemSword;
import io.github.penguinsfan77.randomstuff.items.weapons.Trident;
import io.github.penguinsfan77.randomstuff.references.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	//Create items
	public static final ModItemSword stone_trident = new Trident(ToolMaterial.STONE);
	public static final ModItemSword gold_trident = new Trident(ToolMaterial.GOLD);
	public static final ModItemSword iron_trident = new Trident(ToolMaterial.IRON);
	public static final ModItemSword diamond_trident = new Trident(ToolMaterial.EMERALD);
	
	public static final ModItemTool hammer = new Hammer();
	
	public static final ModItem coloredStick = new ColoredStick();
	
	public static void init() {
		
		//Register the items
		GameRegistry.registerItem(stone_trident, "stone_trident");
		GameRegistry.registerItem(gold_trident, "gold_trident");
		GameRegistry.registerItem(iron_trident, "iron_trident");
		GameRegistry.registerItem(diamond_trident, "diamond_trident");
		
		GameRegistry.registerItem(hammer, "hammer");
		
		GameRegistry.registerItem(coloredStick, "colored_stick");
		OreDictionary.registerOre("stickWood", new ItemStack(coloredStick, 1, OreDictionary.WILDCARD_VALUE));
	
	}

}
