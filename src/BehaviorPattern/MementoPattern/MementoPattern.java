package BehaviorPattern.MementoPattern;

import java.util.HashMap;
import java.util.Map;

public class MementoPattern {

	public static void main(String[] args) {
		CareTaker careTaker = new CareTaker();
		Coordinate coordinate = new Coordinate(5, 10, careTaker);
		System.out.println("Init coordinate x:" + coordinate.getX() + " y:" + coordinate.getY());
		coordinate.setX(10);
		coordinate.setY(20);
		coordinate.createSavepoint("second savePoint");
		System.out.println("Init coordinate x:" + coordinate.getX() + " y:" + coordinate.getY());
		coordinate.setCoordinateState("firstSavePoint");
		System.out.println("Init coordinate x:" + coordinate.getX() + " y:" + coordinate.getY());
	}

}

class Coordinate {
	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	private String lastSavePoint;
	private CareTaker careTaker;

	public Coordinate(double x, double y, CareTaker careTaker) {
		this.x = x;
		this.y = y;
		this.careTaker = careTaker;
		createSavepoint("firstSavePoint");
	}

	public void createSavepoint(String savePoint) {
		careTaker.saveMemento(new Memento(this.x, this.y), savePoint);
		this.lastSavePoint = savePoint;
	}

	public void undo(String savepointName) {
		setCoordinateState(savepointName);
	}

	public void setCoordinateState(String savePoint) {
		Memento mem = careTaker.getMemento(savePoint);
		this.x = mem.getX();
		this.y = mem.getY();
	}
}

class Memento {
	private double x;
	private double y;

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public Memento(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class CareTaker {

	private final Map<String, Memento> savepointMap = new HashMap<String, Memento>();

	public void saveMemento(Memento memento, String savePoint) {
		savepointMap.put(savePoint, memento);
	}

	public Memento getMemento(String savePoint) {
		return savepointMap.get(savePoint);
	}

	public void clearSavepoints() {
		savepointMap.clear();
	}
}