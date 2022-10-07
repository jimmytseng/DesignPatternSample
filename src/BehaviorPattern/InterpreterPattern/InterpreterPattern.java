package BehaviorPattern.InterpreterPattern;

import java.util.HashMap;
import java.util.Map;

public class InterpreterPattern {

	public static void main(String[] args) {
		Context context = new Context();

		context.addVaule("a", 1);
		context.addVaule("b", 2);
		context.addVaule("c", 3);

		TerminalExpression a = new TerminalExpression(context.getValue("a"));
		TerminalExpression b = new TerminalExpression(context.getValue("b"));
		TerminalExpression c = new TerminalExpression(context.getValue("c"));

		MultiplyExpression multiplyValue = new MultiplyExpression(a, b);

		SubtractExpression subtractValue = new SubtractExpression(a, b);

		AddExpression addValue = new AddExpression(subtractValue, c);

		DivisionExpression divisionValue = new DivisionExpression(multiplyValue, addValue);

		System.out.println("(a*b)/(a-b+c) = " + divisionValue.interpreter(context));

	}

}

class Context {
	private final Map<String, Integer> valueMap = new HashMap<String, Integer>();

	public void addVaule(String str, Integer value) {
		valueMap.put(str, Integer.valueOf(value));
	}

	public int getValue(String str) {
		return valueMap.get(str).intValue();
	}
}

abstract class AbstractExpression {
	public abstract int interpreter(Context context);
}

class AddExpression extends AbstractExpression {
	private AbstractExpression left;
	private AbstractExpression right;

	public AddExpression(AbstractExpression left, AbstractExpression right) {
		this.left = left;
		this.right = right;
	}

	public int interpreter(Context context) {
		return this.left.interpreter(context) + this.right.interpreter(context);
	}

}

class SubtractExpression extends AbstractExpression {

	private AbstractExpression left;
	private AbstractExpression right;

	public SubtractExpression(AbstractExpression left, AbstractExpression right) {
		this.left = left;
		this.right = right;
	}

	public int interpreter(Context context) {
		return this.left.interpreter(context) - this.right.interpreter(context);
	}

}

class MultiplyExpression extends AbstractExpression {

	private AbstractExpression left;
	private AbstractExpression right;

	public MultiplyExpression(AbstractExpression left, AbstractExpression right) {
		this.left = left;
		this.right = right;
	}

	public int interpreter(Context context) {
		return this.left.interpreter(context) * this.right.interpreter(context);
	}

}

class DivisionExpression extends AbstractExpression {

	private AbstractExpression left;
	private AbstractExpression right;

	public DivisionExpression(AbstractExpression left, AbstractExpression right) {
		this.left = left;
		this.right = right;
	}

	public int interpreter(Context context) {
		int value = this.right.interpreter(context);
		if (value != 0) {
			// 返回兩數的商
			return this.left.interpreter(context) / value;
		}
		return -999999;
	}
}

class TerminalExpression extends AbstractExpression {
	private int i;

	public TerminalExpression(int i) {
		this.i = i;
	}

	public int interpreter(Context context) {
		return this.i;
	}
}
