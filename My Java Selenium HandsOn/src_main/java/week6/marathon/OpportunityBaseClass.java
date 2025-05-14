package week6.marathon;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class OpportunityBaseClass {

	public ChromeOptions options;
	public ChromeDriver driver;
	public String fileName;

	@Parameters({"url" , "user", "pass"})
	@BeforeMethod
	public void preConditions(String URL, String uid, String pwd) throws InterruptedException {
		
		// Disable Notification		
				options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Get Url		
				driver.get(URL);
		// Enter Username & Password
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uid);
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		// Click Login
				driver.findElement(By.xpath("//input[@id='Login']")).click();
				Thread.sleep(4000);
		// Click on toggle menu button
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//  Click view All
				driver.findElement(By.xpath("//button[text()='View All']")).click();
		//  Click Sales from App Launcher		
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
		// Click on Opportunity tab 		
				WebElement opportunities = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
				driver.executeScript("arguments[0].click();", opportunities);
				Thread.sleep(4000);
	}
	
	@AfterMethod
	public void postConditions() {
		driver.close();
	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
	
	String[][] readData = ReadExcel.readData(fileName);
	 return readData;
	}


	
}
