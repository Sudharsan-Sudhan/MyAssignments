package week6.marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteOpportunity extends OpportunityBaseClass{

	@BeforeTest
	public void setValues() {
		fileName="DeleteOpportunity";
	}
	
	@Test (dataProvider="fetchData") 
	public void DeleteOpportunies(String name) throws InterruptedException {

		driver.findElement(By.xpath("//div[contains(@class,'test-listviewdisplayswitcher')]")).click();
		driver.findElement(By.xpath("//li[@title='Display as kanban']")).click();
// Search the Opportunity 'Salesforce Automation by *Your Name*'
		WebElement oppName = driver.findElement(By.xpath("//label[text()='Search this list...']//following::input[1]"));
		oppName.sendKeys(name);
		Thread.sleep(2000);
		oppName.sendKeys(Keys.ENTER);
// Click on the Dropdown icon and Select Delete
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='showActionsButtonContainer'])[1]")).click();
		WebElement delete = driver.findElement(By.xpath("(//div[text()='Delete'])[1]"));
		driver.executeScript("arguments[0].click();", delete);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
	}
}
