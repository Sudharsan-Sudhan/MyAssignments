package week6.marathon;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreateNewOpportunity extends OpportunityBaseClass {

	@BeforeTest
	public void setValues() {
		fileName="CreateNewOpportunity";
	}
	
	@Test (dataProvider="fetchData") 
	public void NewOpportunity(String name, String date) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
// Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
// Select 'Stage' as Need Analysis
				driver.findElement(By.xpath("(//div[@class='slds-combobox_container']//following::button)[10]")).click();
				driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
// Enter Opportunity name & Store it
		WebElement oppName = driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[1]"));
		oppName.sendKeys(name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
// Choose close date as Today
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).clear();
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).sendKeys(date);
// click Save
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
// VerifyOppurtunity Name		
		String verifymsg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/a"))
				.getAttribute("title");
		if (verifymsg.contains("Ramkumar")) {
			System.out.println("New Oppurtunity Created");
		} else {
			System.out.println("Oppurtunity not Created");
		}
	}
}
