
public class MediatorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	public MyHomeMemberMediatorImpl(Father father, Mother mother, Child child) {
		this.father = father;
		this.mother = mother;
		this.child = child;
	}

	@Override
	public void collecDishes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cleanDishes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dryDishes() {
		// TODO Auto-generated method stub

	}

}

class Father {

	public Father(MemberMediator mediator) {
		this.mediator = mediator;
	}

	MemberMediator mediator;

	public void doWash() {
		System.out.print(" father wash dishes ....");
	}
}

class Mother {

	public Mother(MemberMediator mediator) {
		this.mediator = mediator;
	}

	MemberMediator mediator;

	public void doCollect() {
		System.out.print(" mother collect dishes ....");
	}

}

class Child {

	public Child(MemberMediator mediator) {
		this.mediator = mediator;
	}

	MemberMediator mediator;

	public void doDry() {
		System.out.print(" child dry dishes ....");
	}
}
