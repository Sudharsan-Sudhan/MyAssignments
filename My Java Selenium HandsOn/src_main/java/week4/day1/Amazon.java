package week4.day1;

public class Amazon extends CanaraBank{

	public static void main(String[] args) {
		Amazon amazonOptions = new Amazon();
		amazonOptions.cashOnDelivery();
		amazonOptions.upiPayments();
		amazonOptions.cardPayments();
		amazonOptions.internetBanking();
		amazonOptions.recordPaymentDetails();
	}
	
	public void recordPaymentDetails() {
		super.recordPaymentDetails();
		System.out.println("record Payment Details - Amazon");
	}
	public void cashOnDelivery() {
		System.out.println("Cash on Delivey");
	}
	public void upiPayments() {
		System.out.println("UPI Payments");
	}
	public void cardPayments() {
		System.out.println("Card Payments");
	}
	public void internetBanking() {
		System.out.println("Internet Banking");
	}
}
