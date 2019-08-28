
public class SingletonPattern {

	private String name = "jimmy";

	public String getName() {
		return name;
	}

	private SingletonPattern() {

	}

	private static SingletonPattern singleton;

	public static SingletonPattern getInstance() {
		if (singleton == null) {
			synchronized (SingletonPattern.class) {
				if (singleton == null) {
					singleton = new SingletonPattern();
				}
			}

		}
		return singleton;
	}

	public static void main(String[] args) {
		SingletonPattern sigleton = SingletonPattern.getInstance();
		System.out.print(sigleton.getName());
	}
}
