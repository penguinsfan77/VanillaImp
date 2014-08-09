package io.github.penguinsfan77.randomstuff.items.weapons;


public class Trident extends ModItemWeapon {
	
	public Trident(ToolMaterial mat) {
		
		super(mat);
		this.setUnlocalizedName(mat.name().toLowerCase() + "_trident");
		
	}

}
