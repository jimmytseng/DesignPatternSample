package BehaviorPattern.MediatorPattern;

public class MediatorPattern {

	public static void main(String[] args) {
		MyHomeMemberMediatorImpl mediator = new MyHomeMemberMediatorImpl();
		Father father = new Father();
		father.setMediator(mediator);
		Mother mother = new Mother();
		mother.setMediator(mediator);
		Child child = new Child();
		child.setMediator(mediator);
		mediator.setChild(child);
		mediator.setMother(mother);
		mediator.setFather(father);
		mediator.collectDishes();
	}

}

interface Colleague {
	public void setMediator(MemberMediator memberMediator);
}

interface MemberMediator {

	public void collectDishes();

	public void washDishes();

	public void dryDishes();
}

class MyHomeMemberMediatorImpl implements MemberMediator {

	Father father;
	Mother mother;
	Child child;

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public Mother getMother() {
		return mother;
	}

	public void setMother(Mother mother) {
		this.mother = mother;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
	
	@Override
	public void collectDishes() {
		this.mother.doCollect();
	}

	@Override
	public void washDishes() {
		this.father.doWash();
	}

	@Override
	public void dryDishes() {
		this.child.doDry();
	}

}

class Father implements Colleague {

	MemberMediator mediator;

	@Override
	public void setMediator(MemberMediator memberMediator) {
		this.mediator = memberMediator;
	}

	public void doWash() {
		System.out.println(" father wash dishes ....");
		mediator.dryDishes();
	}

}

class Mother implements Colleague {

	MemberMediator mediator;

	@Override
	public void setMediator(MemberMediator memberMediator) {
		this.mediator = memberMediator;
	}

	public void doCollect() {
		System.out.println(" mother collect dishes ....");
		mediator.washDishes();
	}

}

class Child implements Colleague {

	private MemberMediator mediator;

	@Override
	public void setMediator(MemberMediator memberMediator) {
		this.mediator = memberMediator;
	}

	public void doDry() {
		System.out.println(" child dry dishes ....");
	}

}
