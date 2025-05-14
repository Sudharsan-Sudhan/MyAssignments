package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC04_EditAccount extends BaseClass {
	
	
	@BeforeTest
	public void setValue() {
		filename="EditAccount";
	}
	
	
	@Test(dataProvider="fetchData")
	public void editAccount(String username, String password, String AccountName, String NewAccountName) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickCRMSFALink()
		.clickAccountsLink()
		.clickFindAccountsLink()
		.enterAccountName(AccountName)
		.clickFindAccountsButton()
		.clickAccountNameFromSearchResults(AccountName)
		.clickEditButton()
		.enterAccountName(NewAccountName)
		.clickSaveButton()
		.validateAccountCreated(NewAccountName);
		
	}
}
