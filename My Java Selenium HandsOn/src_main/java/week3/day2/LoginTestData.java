package week3.day2;

public class LoginTestData extends TestData {

	public void enterUsername() {
		System.out.println("Entered Username");
	}
	public void enterPassword() {
		System.out.println("Entered Password");
	}
	public static void main(String[] args) {
		LoginTestData ltd = new LoginTestData ();
		ltd.enterUsername();
		ltd.enterPassword();
		ltd.enterCredentials();
		ltd.navigateToHomePage();		
	}
}