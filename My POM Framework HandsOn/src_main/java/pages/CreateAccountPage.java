package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import base.BaseClass;

public class CreateAccountPage extends BaseClass{
	
	public CreateAccountPage(EdgeDriver driver) {
		this.driver=driver;
	}
	
	public CreateAccountPage enterAccountName(String AccountName) {
		WebElement AccNameWebElement = driver.findElement(By.xpath("//input[@id='accountName']"));
		AccNameWebElement.clear();
		AccNameWebElement.sendKeys(AccountName);
		return this;
	}
	
	public ViewAccountPage clickCreateAccountButton() {
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		return new ViewAccountPage(driver);
	}

}
