package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import base.BaseClass;

public class ViewAccountPage extends BaseClass{
	
	public ViewAccountPage(EdgeDriver driver) {
		this.driver=driver;
	}
	
	public ViewAccountPage validateAccountCreated(String AccountName) { 
	
		String accountText = driver.findElement(By.xpath("//span[contains(text(),'" + AccountName +"')]")).getText();
		if(accountText.contains(AccountName))
		{
			System.out.println("Account Created Sucessfully");
		}
	return this;
	}
	
	public EditAccountPage clickEditButton() throws InterruptedException { 
		driver.findElement(By.xpath("(//div[contains(text(),'Account')])[3]//following-sibling::div/a[1]")).click();
		return new EditAccountPage(driver); 
	}
}
