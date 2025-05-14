package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

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
		// clicking on Accounts Tab
		driver.findElement(By.linkText("Accounts")).click();
		// clicking on Create Create Account Shortcuts
		driver.findElement(By.linkText("Create Account")).click();
		// Passing the input for Account Name 
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Sudharsan Subramanian");
		// Passing the input for Description 
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");

		// finding the Webelement for dropdown
		WebElement industryWebElement = driver.findElement(By.name("industryEnumId"));
		// assigning the webelement in a select class
		Select selectIndustryDropDown = new Select(industryWebElement);
		// Selecting the value from dropdown
		selectIndustryDropDown.selectByIndex(4);
		
		// finding the Webelement for dropdown
		WebElement ownershipWebElement = driver.findElement(By.name("ownershipEnumId"));
		// assigning the webelement in a select class
		Select selectOwnershipDropDown = new Select(ownershipWebElement);
		// Selecting the value from dropdown
		selectOwnershipDropDown.selectByVisibleText("S-Corporation");
		
		// finding the Webelement for dropdown
		WebElement sourceWebElement = driver.findElement(By.id("dataSourceId"));
		// assigning the webelement in a select class
		Select selectSourceDropDown = new Select(sourceWebElement);
		// Selecting the value from dropdown
		selectSourceDropDown.selectByValue("LEAD_EMPLOYEE");
		
		// finding the Webelement for dropdown
		WebElement marketingWebElement = driver.findElement(By.id("marketingCampaignId"));
		// assigning the webelement in a select class
		Select selectMarketingDropDown = new Select(marketingWebElement);
		// Selecting the value from dropdown
		selectMarketingDropDown.selectByIndex(7);
		
		// finding the Webelement for dropdown
		WebElement stateWebElement = driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']"));
		// assigning the webelement in a select class
		Select selectstateDropDown = new Select(stateWebElement);
		// Selecting the value from dropdown
		selectstateDropDown.selectByValue("TX");
		// clicking on Create Account button
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		
		//wait for 30 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//	Validating that Account value is displayed as Sudharsan Subramanian
		String accountText = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		if(accountText.contains("Sudharsan Subramanian"))
		{
			System.out.println("Account Created Sucessfully");
		}
		
		// clicking on logout button
		driver.findElement(By.linkText("Logout")).click();
		// Closing the browser opened by chromedriver
		driver.quit();
	}
}
