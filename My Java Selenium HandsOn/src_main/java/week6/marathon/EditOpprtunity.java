package week6.marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditOpprtunity extends OpportunityBaseClass{

	@BeforeTest
	public void setValues() {
		fileName="EditOpprtunity";
	}
	
	@Test (dataProvider="fetchData") 
	public void EditOpportunity(String name, String date, String description) throws InterruptedException {

		driver.findElement(By.xpath("//div[contains(@class,'test-listviewdisplayswitcher')]")).click();
		driver.findElement(By.xpath("//li[@title='Display as kanban']")).click();
// Search the Opportunity 'Salesforce Automation by *Your Name*'
		WebElement oppName = driver.findElement(By.xpath("//label[text()='Search this list...']//following::input[1]"));
		oppName.sendKeys(name);
		Thread.sleep(2000);
		oppName.sendKeys(Keys.ENTER);
// Click on the Dropdown icon and Select Edit
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='showActionsButtonContainer'])[1]")).click();
		WebElement edit = driver.findElement(By.xpath("(//div[text()='Edit'])[1]"));
		driver.executeScript("arguments[0].click();", edit);
		Thread.sleep(3000);
		WebElement element = driver.findElement(
				By.xpath("(//button[contains(@class,'slds-button trigger slds-button_icon-border')])[4]//span[2]"));
		driver.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).clear();
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).sendKeys(date);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='slds-combobox_container'])[4]//button")).click();
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		Thread.sleep(3000);
		WebElement status = driver.findElement(By.xpath("//a[text()='Delivery Status']"));
		Actions delivery = new Actions(driver);
		delivery.scrollToElement(status).perform();
		driver.findElement(By.xpath("(//div[@class='slds-combobox_container'])[7]//button")).click();
		driver.findElement(By.xpath("(//span[text()='In progress'])[1]")).click();
		Thread.sleep(3000);
		driver.executeScript("document.body.style.zoom='80%'", "");
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys(description);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		WebElement verify = driver.findElement(By.xpath("(//span[text()='Perception Analysis'])[3]"));
		System.out.println(verify.getText());
	}

}
