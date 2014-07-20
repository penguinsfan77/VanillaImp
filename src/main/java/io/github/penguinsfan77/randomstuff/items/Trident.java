package io.github.penguinsfan77.randomstuff.items;

public class Trident extends ModItemSword {
	
	public Trident(ToolMaterial mat) {
		
		super(mat);
		this.setUnlocalizedName(mat.name().toLowerCase() + "_trident");
		
	}

}
