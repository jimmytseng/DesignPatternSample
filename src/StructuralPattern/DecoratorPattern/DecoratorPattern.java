package StructuralPattern.DecoratorPattern;

public class DecoratorPattern {

	public static void main(String[] args) {
		Beverage coffee = new Coffee();
		Beverage syrupCoffee = new Syrup(coffee);
		System.out.println(syrupCoffee.getDesc());
		System.out.println("syrupCoffee prise is " + syrupCoffee.getPrice());
		
		Beverage bronwSugarAndSyrupCoffee = new BrownSugar(syrupCoffee);
		System.out.println(bronwSugarAndSyrupCoffee.getDesc());
		System.out.println("bronwSugarAndSyrupCoffee prise is " + bronwSugarAndSyrupCoffee.getPrice());
		
	}

}

interface Beverage {
	public String getDesc();

	public Integer getPrice();
}

abstract class BeverageDecorator implements Beverage {
	protected String name;
	protected Beverage beverage;

	public String getDesc() {
		return "add " + this.name + " "+ this.beverage.getDesc();
	}
}

class Coffee implements Beverage {
	@Override
	public String getDesc() {
		return "BlackCoffee";
	}

	@Override
	public Integer getPrice() {
		return 5;
	}
}

class Syrup extends BeverageDecorator {

	public Syrup(Beverage beverage) {
		this.beverage = beverage;
		this.name = "syrup";
	}

	@Override
	public Integer getPrice() {
		return this.beverage.getPrice() + 1;
	}

}

class BrownSugar extends BeverageDecorator {

	public BrownSugar(Beverage beverage) {
		this.beverage = beverage;
		this.name = "brownSugar";
	}

	@Override
	public Integer getPrice() {
		return this.beverage.getPrice() + 2;
	}

}