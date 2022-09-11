package AdapterPattern;

public class AdapterPattern {

	public static void main(String[] args) {
		GooglePayAdaptToApplePay adapter = new GooglePayAdaptToApplePay();
		MyWalletPay myPay = new MyWalletPay(adapter);
		myPay.PayMoney();
	}

}

interface Mypay {
	void PayMoney();
}

class MyWalletPay implements Mypay {

	public MyWalletPay(ApplePay applePay) {
		this.applePay = applePay;
	}

	ApplePay applePay;

	@Override
	public void PayMoney() {
		this.applePay.payAccount();
	}

}

interface ApplePay {
	void payAccount();
}

class ApplePayImpl implements ApplePay {
	@Override
	public void payAccount() {
		System.out.println("this is ApplePay");
	}
}

interface GooglePay {
	void payAccountMoney();
}

class GooglePayImpl implements GooglePay {
	@Override
	public void payAccountMoney() {
		System.out.println("this is GooglePay");
	}
}

class GooglePayAdaptToApplePay implements ApplePay {

	GooglePay googlePay = new GooglePayImpl();

	@Override
	public void payAccount() {
		this.googlePay.payAccountMoney();
	}

}