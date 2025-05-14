package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import base.BaseClass;

public class WelcomePage extends BaseClass {

	public WelcomePage(EdgeDriver driver) {
		this.driver=driver;
	}
	
	public MyHomePage clickCRMSFALink() {
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver);
	}
	
	
	public WelcomePage validateWelcomePage() {

		WebElement welcomeWebElement = driver.findElement(By.xpath("//div[@id='form']/h2"));
		String welcometext = welcomeWebElement.getText();
		if (welcometext.contains("Welcome") && welcometext.contains("Demo Sales Manager")) {
			System.out.println("Able to see the Welcome Page sucessfully");
		}
			
		return this;
	}
	
	public WelcomePage clickLogoutButton() {

		driver.findElement(By.xpath("//input[@value='Logout']")).click();
		return this;
	}
	
}

