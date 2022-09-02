package AbstractFactoryPattern;

import java.util.ArrayList;
import java.util.List;

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		TWBread bread = TWBreadFactory.getInstance("TypeA");
		bread.addIngredient();
		System.out.println("");
		JapanBread jbread = JapanBreadFactory.getInstance("TypeB");
		jbread.addIngredient();
	}

}

class TWBreadFactory {

	public static TWBread getInstance(String breadType) {
		switch (breadType) {
		case "TypeA":
			return new TWBread_A();
		case "TypeB":
			return new TWBread_B();
		}
		return null;
	}
}

class JapanBreadFactory {
	public static JapanBread getInstance(String breadType) {
		switch (breadType) {
		case "TypeA":
			return new JapanBread_A();
		case "TypeB":
			return new JapanBread_B();
		}
		return null;
	}
}

interface TWBread {
	public TWBread addIngredient();
}

class TWBread_A implements TWBread {

	List<String> ingredient = new ArrayList<>();

	public TWBread addIngredient() {
		this.ingredient.add("TWBread_A add resource");
		System.out.print("TWBread_A add resource");
		return this;
	}
}

class TWBread_B implements TWBread {
	List<String> ingredient = new ArrayList<>();

	public TWBread addIngredient() {
		this.ingredient.add("TWBread_B add resource");
		System.out.print("TWBread_B add resource");
		return this;
	}
}

interface JapanBread {
	public JapanBread addIngredient();
}

class JapanBread_A implements JapanBread {

	List<String> ingredient = new ArrayList<>();

	@Override
	public JapanBread addIngredient() {
		this.ingredient.add("JapanBread_A add resource");
		System.out.print("JapanBread_A add resource");
		return this;
	}

}

class JapanBread_B implements JapanBread {

	List<String> ingredient = new ArrayList<>();

	@Override
	public JapanBread addIngredient() {
		this.ingredient.add("JapanBread_B add resource");
		System.out.print("JapanBread_B add resource");
		return this;
	}

}
