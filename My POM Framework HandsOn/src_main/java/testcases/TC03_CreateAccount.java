package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC03_CreateAccount extends BaseClass {
	
	
	@BeforeTest
	public void setValue() {
		filename="CreateAccount";
	}
	
	
	@Test(dataProvider="fetchData")
	public void createAccount(String username, String password, String AccountName) {
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickCRMSFALink()
		.clickAccountsLink()
		.clickCreateAccountsLink()
		.enterAccountName(AccountName)
		.clickCreateAccountButton()
		.validateAccountCreated(AccountName);
	}
}
