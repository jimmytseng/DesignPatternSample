package CreationalPattern.AbstractFactoryPattern;

import java.util.ArrayList;
import java.util.List;

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		BreadFactory breadFactory = new TWBreadFactory();
		BananaBread bananaBread = breadFactory.getBananaBread();
		bananaBread.addIngredient();
		breadFactory = new JapanBreadFactory();
		AppleBread appleBread = breadFactory.getAppleBread();
		appleBread.addIngredient();
	}

}

interface BreadFactory {
	public BananaBread getBananaBread();

	public AppleBread getAppleBread();
}

interface BananaBread {
	public void addIngredient();
}

interface AppleBread {
	public void addIngredient();
}

class TWBreadFactory implements BreadFactory {

	@Override
	public BananaBread getBananaBread() {
		return new TWBananaBread();
	}

	@Override
	public AppleBread getAppleBread() {
		return new TWAppleBread();
	}
}

class JapanBreadFactory implements BreadFactory {

	@Override
	public BananaBread getBananaBread() {
		return new JapanBananaBread();
	}

	@Override
	public AppleBread getAppleBread() {
		return new JapanAppleBread();
	}
}

class TWBananaBread implements BananaBread {

	List<String> ingredient = new ArrayList<>();

	public void addIngredient() {
		this.ingredient.add("TWBananaBread add resource");
		System.out.println("TWBananaBread add resource");
	}
}

class TWAppleBread implements AppleBread {
	List<String> ingredient = new ArrayList<>();

	public void addIngredient() {
		this.ingredient.add("TWAppleBread add resource");
		System.out.println("TWAppleBread add resource");
	}
}

class JapanBananaBread implements BananaBread {

	List<String> ingredient = new ArrayList<>();

	@Override
	public void addIngredient() {
		this.ingredient.add("JapanBananaBread add resource");
		System.out.println("JapanBananaBread add resource");
	}

}

class JapanAppleBread implements AppleBread {

	List<String> ingredient = new ArrayList<>();

	@Override
	public void addIngredient() {
		this.ingredient.add("JapanAppleBread add resource");
		System.out.println("JapanAppleBread add resource");
	}

}
