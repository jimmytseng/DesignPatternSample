package CreationalPattern.SingletonPattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonPattern implements Serializable {

	public static void main(String[] args) {
		SingletonPattern sigleton = SingletonPattern.getInstance();
		System.out.print(sigleton.getName());
	}

	private String name = "jimmy";

	public String getName() {
		return name;
	}

	private SingletonPattern() {

	}

	private static SingletonPattern singleton;

	// double locking
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

	private Object readResolve() throws ObjectStreamException {
		return singleton;
	}

	private Object writeReplace() throws ObjectStreamException {
		return singleton;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("cannot be clonned");
	}

	private static Class getClass(String classname) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null)
			classLoader = SingletonPattern.class.getClassLoader();
		return (classLoader.loadClass(classname));
	}
}
