package io.github.penguinsfan77.randomstuff.references;

import java.util.HashMap;

public class ToolTips {
	
	public static final String COLOR = "tooltip.name.handleColor";
	public static final String HANDLE = "tooltip.name.handleType";
	
	public static final class Values {
		
		public static final HashMap COLORS = new HashMap<String, String>() {{
			put("FFFFFF", "tooltip.value.color.white");
			put("D87F33", "tooltip.value.color.orange");
			put("B24CD8", "tooltip.value.color.magenta");
			put("6699D8", "tooltip.value.color.light_blue");
			put("E5E533", "tooltip.value.color.yellow");
			put("7FCC19", "tooltip.value.color.lime");
			put("F27FA5", "tooltip.value.color.pink");
			put("4C4C4C", "tooltip.value.color.gray");
			put("999999", "tooltip.value.color.light_gray");
			put("4C7F99", "tooltip.value.color.cyan");
			put("7F3FB2", "tooltip.value.color.purple");
			put("334CB2", "tooltip.value.color.blue");
			put("664F33", "tooltip.value.color.brown");
			put("667F33", "tooltip.value.color.green");
			put("993333", "tooltip.value.color.red");
			put("191919", "tooltip.value.color.black");
		}};
		public static final HashMap HANDLES = new HashMap<String, String>() {{
			put("diamond", "tooltip.value.handle.diamond");
			put("gold", "tooltip.value.handle.gold");
			put("iron", "tooltip.value.handle.iron");
			put("stone", "tooltip.value.handle.stone");
			put("wood", "tooltip.value.hanlde.wood");
		}};
		
	}

}
