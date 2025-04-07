package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		// Passing the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Maximizing the browser
		driver.manage().window().maximize();
		// Passing the input for user name 
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		// Passing the input for password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// clicking on login button
		driver.findElement(By.className("decorativeSubmit")).click();
		// verifying the welcome screen is displayed 
		driver.findElement(By.id("form")).getText().contains("Demo Sales Manager");
		// clicking on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// clicking on Leads Tab
		driver.findElement(By.linkText("Leads")).click();
		// clicking on Create Lead Shortcuts
		driver.findElement(By.linkText("Create Lead")).click();
		// Passing the input for Company Name 
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Google");
		// Passing the input for First Name 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sudharsan");
		// Passing the input for Last Name 
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Subramanian");
		//	Passing the input for Title 
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Mister");
		// finding the Webelement for dropdown 
		WebElement sourceWebElement = driver.findElement(By.id("createLeadForm_dataSourceId"));
		// assigning the webelement in a select class
		Select 	sourceDropDown = new Select (sourceWebElement);
		// Selecting the value for dropdown
		sourceDropDown.selectByVisibleText("Existing Customer");
		// clicking on Submit button
		driver.findElement(By.name("submitButton")).click();
		//	Validating that Title value is displayed as Mister
		driver.findElement(By.id("viewLead_generalProfTitle_sp")).getText().contentEquals("Mister");
		// clicking on logout button
		driver.findElement(By.linkText("Logout")).click();
		// Closing the browser opened by chromedriver
		driver.quit();
	}
}

