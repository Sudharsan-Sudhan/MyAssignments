package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import base.BaseClass;

public class FindAccountPage extends BaseClass {
	
	public FindAccountPage(EdgeDriver driver) {
		this.driver=driver;
	}
	
	public FindAccountPage enterAccountName(String AccountName) {
		driver.findElement(By.xpath("(//input[@name='accountName'])[2]")).sendKeys(AccountName);
		return this;
	}
	
	public FindAccountPage clickFindAccountsButton () {
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		return this;
	}
	
	public ViewAccountPage clickAccountNameFromSearchResults(String AccountName) throws InterruptedException {
	
		Thread.sleep(2000);
		WebElement accountNameWebElement = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//following::a)[2]"));
		String accountNameValue = accountNameWebElement.getText();
		if(accountNameValue.contains(AccountName))
		{
			accountNameWebElement.click();
		}
		return new ViewAccountPage(driver);	
	}
}
