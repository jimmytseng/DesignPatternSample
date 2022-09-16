package BehaviorPattern.ChainOfResponsibilityPattern;


public class ChainOfResponsibilityPattern {

	public static void main(String[] args) {
		NumberHandler evenHandler = new EvenNumberHandler();
		NumberHandler oddHandler = new OddNumberHandler();
		evenHandler.setHandler(oddHandler);
		oddHandler.setHandler(evenHandler);
		evenHandler.print(7);
	}

}

interface NumberHandler {

	public void print(Integer number);

	public void setHandler(NumberHandler handler);
}

class EvenNumberHandler implements NumberHandler {

	NumberHandler handler;

	@Override
	public void print(Integer number) {
		if (number % 2 == 0) {
			System.out.println(number + " is even");
		} else {
			this.handler.print(number);
		}
	}

	@Override
	public void setHandler(NumberHandler handler) {
		this.handler = handler;
	}

}

class OddNumberHandler implements NumberHandler {

	NumberHandler handler;

	@Override
	public void print(Integer number) {
		if (number % 2 != 0) {
			System.out.println(number + " is odd");
		} else {
			this.handler.print(number);
		}
	}

	@Override
	public void setHandler(NumberHandler handler) {
		this.handler = handler;
	}

}