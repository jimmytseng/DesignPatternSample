package StructuralPattern.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {

	public static void main(String[] args) {
		Tool tool = ToolFactory.getTool("cutting");
		tool.operate();
	}

}

class ToolFactory {

	private static Map<String, Tool> Tools = new HashMap<>();

	public static synchronized Tool getTool(String operation) {
		Tool tool = Tools.get(operation);
		if(tool==null) {
			switch (operation) {
			case "shovel":
				tool = new Shovel();
				break;
			case "cutting":
				tool = new Knife();
				break;
			}
			Tools.put(operation, tool);
		}
		return tool;
	}
}

interface Tool {
	public void operate();
}

class Knife implements Tool {

	@Override
	public void operate() {
		System.out.print("start cutting");
	}
}

class Shovel implements Tool {

	@Override
	public void operate() {
		System.out.print("start shoveling");
	}

}
