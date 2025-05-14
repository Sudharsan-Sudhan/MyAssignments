package week4.day1;

public class LoginPage extends BasePage{

	public void performCommonTasks() {
		super.performCommonTasks();
		System.out.println("Perform the Common Tasks from Login Page");
	}
	public static void main(String[] args) {
	LoginPage lp = new LoginPage();
	lp.findElement();
	lp.clickElement();
	lp.enterText();
	lp.performCommonTasks();
		
	}
}
