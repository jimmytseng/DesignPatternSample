package BehaviorPattern.IteratorPattern;

import java.util.Iterator;

public class IteratorPattern {

	public static void main(String[] args) {
		Food matsusakabeef = new Beef("Matsusaka");
		Food kobebeef = new Beef("kobe");
		Food[] food = new Food[2];
		food[0] = matsusakabeef;
		food[1] = kobebeef;
		FoodIterator foodIterator = new FoodIterator(food);
		if (foodIterator.hasNext()) {
			Food beeffood = foodIterator.next();
			System.out.print("get beef from " + beeffood.getOrigin());
		}
	}

}

interface Food {
	public void cooked();

	public String getOrigin();
}

class Beef implements Food {

	String origin;

	public Beef(String origin) {
		this.origin = origin;
	}

	public String getOrigin() {
		return this.origin;
	}

	@Override
	public void cooked() {
		System.out.print("beef is cooked");
	}
}

class FoodIterator implements Iterator<Food> {

	Food[] food = new Food[3];
	int pos;

	public FoodIterator(Food[] food) {
		this.food = food;
	}

	@Override
	public boolean hasNext() {
		if (pos >= food.length || food[pos] == null)
			return false;
		return true;
	}

	@Override
	public Food next() {
		return food[pos++];
	}

	@Override
	public void remove() {
		if (pos <= 0)
			throw new IllegalStateException("Illegal position");
		if (food[pos - 1] != null) {
			for (int i = pos - 1; i < (food.length - 1); i++) {
				food[i] = food[i + 1];
			}
			food[food.length - 1] = null;
		}
	}

}