
public class MediatorPattern {

	public static void main(String[] args) {
		MyHomeMemberMediatorImpl mediator = new MyHomeMemberMediatorImpl();
		Father f = new Father(mediator);
		Mother m = new Mother(mediator);
		Child c = new Child(mediator);
		mediator.setChild(c);
		mediator.setMother(m);
		mediator.setFather(f);
		mediator.collecDishes();
	}

}

interface MemberMediator {

	public void collecDishes();

	public void cleanDishes();

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
	public void collecDishes() {
		this.mother.doCollect();
	}

	@Override
	public void cleanDishes() {
		this.father.doWash();
	}

	@Override
	public void dryDishes() {
		this.child.doDry();
	}

}

class Father {

	public Father(MemberMediator mediator) {
		this.mediator = mediator;
	}

	MemberMediator mediator;

	public void doWash() {
		System.out.println(" father wash dishes ....");
		mediator.dryDishes();
	}
}

class Mother {

	public Mother(MemberMediator mediator) {
		this.mediator = mediator;
	}

	MemberMediator mediator;

	public void doCollect() {
		System.out.println(" mother collect dishes ....");
		mediator.cleanDishes();
	}

}

class Child {

	public Child(MemberMediator mediator) {
		this.mediator = mediator;
	}

	MemberMediator mediator;

	public void doDry() {
		System.out.println(" child dry dishes ....");
	}
}
