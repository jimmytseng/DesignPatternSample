package CreationalPattern.PrototypePattern;

import java.util.HashMap;
import java.util.Map;

public class PrototypePattern {
	public static void main(String[] args) {
		AccessControl userAccessControl = AccessControlProvider.getAccessControlObject("user");
		System.out.println("AccessControlLevel:" + userAccessControl.getControlLevel());
	}
}

interface Prototype extends Cloneable {
	public AccessControl clone() throws CloneNotSupportedException;
}

class AccessControl implements Prototype {

	private final String controlLevel;
	private String access;

	public AccessControl(String controlLevle, String access) {
		this.controlLevel = controlLevle;
		this.access = access;
	}

	@Override
	public AccessControl clone() {
		try {
			return (AccessControl) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getControlLevel() {
		return controlLevel;
	}

}

class AccessControlProvider {

	private static Map<String, AccessControl> accessControlMap = new HashMap<>();

	static {
		accessControlMap.put("user", new AccessControl("user", "only select"));
		accessControlMap.put("manager", new AccessControl("manager", "do all things"));
	}

	public static AccessControl getAccessControlObject(String type) {
		AccessControl accessControl = null;
		accessControl = accessControlMap.get(type);
		if (accessControl != null) {
			return accessControl.clone();
		}
		return null;

	}
}