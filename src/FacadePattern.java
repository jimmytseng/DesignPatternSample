
public class FacadePattern {

	public static void main(String ags[]) {

		SmartApplianceFacade applianceFacade = new SmartApplianceFacade(() -> System.out.println("Philips bulb is on"),
				() -> System.out.println("Sharp TV is on"));
		applianceFacade.allTurnOn();

	}
}

class SmartApplianceFacade {

	public SmartApplianceFacade(SmartLight smartLight, SmartTelevision smartTelevision) {
		this.smartLight = smartLight;
		this.smartTelevision = smartTelevision;
	}

	private SmartLight smartLight;

	private SmartTelevision smartTelevision;

	public SmartLight getSmartLight() {
		return smartLight;
	}

	public void setSmartLight(SmartLight smartLight) {
		this.smartLight = smartLight;
	}

	public SmartTelevision getSmartTelevision() {
		return smartTelevision;
	}

	public void setSmartTelevision(SmartTelevision smartTelevision) {
		this.smartTelevision = smartTelevision;
	}

	public void allTurnOn() {
		this.smartLight.turnOn();
		this.smartTelevision.turnOn();
	}
}

interface SmartLight {
	public void turnOn();
}

interface SmartTelevision {
	public void turnOn();
}