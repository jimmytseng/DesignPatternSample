
public class StatePattern {

	public static void main(String[] args) {
		TraficLight light = new TraficLight();
		while (true) {
			light.changeLight();
		}

	}
}	

	interface LightState {

		void change();

		default void sleep(long sec) {
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	class RedState implements LightState {
		private TraficLight light;

		RedState(TraficLight light) {
			this.light = light;
		}

		@Override
		public void change() {
			System.out.println("RedLightState...");
			sleep(5000);
			this.light.setCurrentLight(this.light.getGreenLight());
		}

	}

	class GreenState implements LightState {
		private TraficLight light;

		GreenState(TraficLight light) {
			this.light = light;
		}

		@Override
		public void change() {
			System.out.println("GreenLightState...");
			sleep(10000);
			this.light.setCurrentLight(this.light.getYellowLight());
		}

	}

	class YellowState implements LightState {
		private TraficLight light;

		YellowState(TraficLight light) {
			this.light = light;
		}

		@Override
		public void change() {
			System.out.println("YellowLightState...");
			sleep(1000);
			this.light.setCurrentLight(this.light.getRedLigth());
		}

	}

class TraficLight {
	

	public LightState yellowLight = new YellowState(this);
	public LightState redLigth = new RedState(this);
	public LightState greenLight = new GreenState(this);

	LightState currentLight = this.redLigth;

	void setLight(LightState light) {
		this.currentLight = light;
	}
	
	void changeLight() {
		this.currentLight.change();
	}

	public LightState getYellowLight() {
		return yellowLight;
	}

	public void setYellowLight(LightState yellowLight) {
		this.yellowLight = yellowLight;
	}

	public LightState getRedLigth() {
		return redLigth;
	}

	public void setRedLigth(LightState redLigth) {
		this.redLigth = redLigth;
	}

	public LightState getGreenLight() {
		return greenLight;
	}

	public void setGreenLight(LightState greenLight) {
		this.greenLight = greenLight;
	}

	public LightState getCurrentLight() {
		return currentLight;
	}

	public void setCurrentLight(LightState currentLight) {
		this.currentLight = currentLight;
	}

}

