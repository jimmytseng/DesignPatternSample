package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

	public static void main(String[] args) {
		Observable commentary = new Commentary();
		Observer radioObserver = new RadioObserver(commentary);
		Observer radioObserver1 = new RadioObserver(commentary);
		radioObserver.subscribe();
		radioObserver1.subscribe();
		commentary.setLiveStr("Game kick off");
		commentary.setLiveStr("Barcelona goal!!");
		radioObserver1.unsubscribe();
		commentary.setLiveStr("Mache goal 1-1 !!");
	}

}

interface Observable {
	public void notifyObserver();

	public void addObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void setLiveStr(String liveStr);
}

interface Observer {
	public void update(String liveStr);

	void unsubscribe();

	void subscribe();
}

class Commentary implements Observable {

	List<Observer> obList = new ArrayList<>();
	String liveStr;

	public void setLiveStr(String liveStr) {
		this.liveStr = liveStr;
		notifyObserver();
	}

	@Override
	public void notifyObserver() {
		for (Observer ob : obList) {
			ob.update(this.liveStr);
		}
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		if (observer != null) {
			obList.add(observer);
		}
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		int i = 0;
		if ((i = obList.indexOf(observer)) > 0) {
			obList.remove(i);
		}
	}
}

class RadioObserver implements Observer {

	Observable observabel;

	public RadioObserver(Observable observable) {
		this.observabel = observable;
	}

	@Override
	public void update(String liveStr) {
		System.out.println(liveStr);
	}

	@Override
	public void subscribe() {
		this.observabel.addObserver(this);
	}

	@Override
	public void unsubscribe() {
		this.observabel.removeObserver(this);
	}

}