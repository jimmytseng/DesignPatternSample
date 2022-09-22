package StructuralPattern.BridgePattern;


public class BridgePattern {

	public static void main(String[] args) {
		IdentifySecurity fingerPrintIdentifySecurity = new FingerPrintIdentifySecurity();
		PasswordPrintIdentifySecurity passwordPrintIdentifySecurity = new PasswordPrintIdentifySecurity();
		Phone appleSmartPhone = new AppleSmartPhone(fingerPrintIdentifySecurity);
		Phone asusSmartPhone = new AsusSmartPhone(passwordPrintIdentifySecurity);
		appleSmartPhone.checkIdentity();
		asusSmartPhone.checkIdentity();
	}

}

interface IdentifySecurity {
	
	public void identify();
}

interface Phone {
	public void checkIdentity();
}

class FingerPrintIdentifySecurity implements IdentifySecurity{
	@Override
	public void identify() {
		System.out.print("FingerPrintIdentifySecurity");
	}
	
}

class PasswordPrintIdentifySecurity implements IdentifySecurity{
	@Override
	public void identify() {
		System.out.print("PasswordPrintIdentifySecurity");
	}
}

class AppleSmartPhone implements Phone{
	//bridge
	private IdentifySecurity identifySecurity;
	
	public AppleSmartPhone(IdentifySecurity indentifySecurity) {
		this.identifySecurity = identifySecurity;
	}

	@Override
	public void checkIdentity() {
		identifySecurity.identify();
	}
	
}

class AsusSmartPhone implements Phone{
	//bridge
	private IdentifySecurity identifySecurity;
	
	public AsusSmartPhone(IdentifySecurity indentifySecurity) {
		this.identifySecurity = identifySecurity;
	}
	
	@Override
	public void checkIdentity() {
		identifySecurity.identify();
	}
	
}