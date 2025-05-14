package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import base.BaseClass;

public class MyAccountPage extends BaseClass{
	
	public MyAccountPage(EdgeDriver driver) {
		this.driver=driver;
	}
	
	public CreateAccountPage clickCreateAccountsLink() {
		driver.findElement(By.linkText("Create Account")).click();
        return new CreateAccountPage(driver);
	}
	
	public FindAccountPage clickFindAccountsLink() {
		driver.findElement(By.linkText("Find Accounts")).click();
        return new FindAccountPage(driver);
	}

}
