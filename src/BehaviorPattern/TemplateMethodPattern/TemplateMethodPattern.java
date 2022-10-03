package BehaviorPattern.TemplateMethodPattern;

public class TemplateMethodPattern {

	public static void main(String[] args) {
		BrewCoffeeTemplateMethod brewCoffeeTemplateMethod = new BlackCoffeeBrewMethod();
		brewCoffeeTemplateMethod.brewCoffee();
		brewCoffeeTemplateMethod = new CoffeeLatteBrewMethod();
		brewCoffeeTemplateMethod.brewCoffee();
	}
}

abstract class BrewCoffeeTemplateMethod {

	public void brewCoffee() {
		prepWater();
		grindCoffee();
		brew();
	}

	protected abstract void brew();

	protected abstract void grindCoffee();

	protected void prepWater() {
		System.out.println("boil water to 85 degree temperature");
	}
}

class BlackCoffeeBrewMethod extends BrewCoffeeTemplateMethod {

	@Override
	protected void brew() {
		System.out.println("brew black coffee");
	}

	@Override
	protected void grindCoffee() {
		System.out.println("grind coffee coarsely");
	}

}

class CoffeeLatteBrewMethod extends BrewCoffeeTemplateMethod {

	@Override
	protected void brew() {
		System.out.println("brew Latte");
	}

	@Override
	protected void grindCoffee() {
		System.out.println("grind coffee fine");
	}

}