package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC01_LoginTestCase extends BaseClass {
	
	
	@BeforeTest
	public void setValue() {
		filename="loginTestCase";
	}
	
	
	@Test(dataProvider="fetchData")
	public void loginTestCase(String username, String password) {
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.validateWelcomePage();
	}

}
