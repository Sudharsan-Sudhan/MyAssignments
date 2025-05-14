package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import base.BaseClass;

public class EditAccountPage extends BaseClass {
	
	public EditAccountPage(EdgeDriver driver) {
		this.driver=driver;
	}
	
	
	public EditAccountPage enterAccountName(String AccountName) {
		WebElement AccNameWebElement = driver.findElement(By.xpath("//input[@id='accountName']"));
		AccNameWebElement.clear();
		AccNameWebElement.sendKeys(AccountName);
		return this;
	}
	
	public ViewAccountPage clickSaveButton()  {
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		return new ViewAccountPage(driver);	
	}
}
