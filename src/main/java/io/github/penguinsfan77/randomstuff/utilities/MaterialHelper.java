package io.github.penguinsfan77.randomstuff.utilities;

import io.github.penguinsfan77.randomstuff.items.ModItemMaterials;

import java.util.HashMap;

import net.minecraft.item.Item.ToolMaterial;

public class MaterialHelper {
	
	private static final HashMap<String, ToolMaterial> MATERIALS = new HashMap<String, ToolMaterial>() {{
		put(ToolMaterial.WOOD.toString(), ToolMaterial.WOOD);
		put(ToolMaterial.STONE.toString(), ToolMaterial.STONE);
		put(ToolMaterial.IRON.toString(), ToolMaterial.IRON);
		put(ToolMaterial.GOLD.toString(), ToolMaterial.GOLD);
		put(ToolMaterial.EMERALD.toString(), ToolMaterial.EMERALD);
		put(ModItemMaterials.COLORED.toString(), ModItemMaterials.COLORED);
	}};
	
	public static ToolMaterial getToolMaterial(String materialName) {
		
		return MATERIALS.get(materialName);
		
	}

}
