package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC02_LogOutTestCase  extends BaseClass {
	
	
	@BeforeTest
	public void setValue() {
		filename="logOutTestCase";
	}
	
	
	@Test(dataProvider="fetchData")
	public void logOutTestCase(String username, String password) {
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickLogoutButton();
	}

}
