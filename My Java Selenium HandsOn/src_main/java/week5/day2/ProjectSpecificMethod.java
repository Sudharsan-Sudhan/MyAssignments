package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethod {

	public EdgeOptions edgeOptions;
	public EdgeDriver driver;
	
	@BeforeMethod
	public void preCondition() {

//		How to use the Edge Options
		edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");	
		driver = new EdgeDriver(edgeOptions);
//		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://orgfarm-5c1aab41f9-dev-ed.develop.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("vinothkumar.sanmugaraj848@agentforce.com");
		driver.findElement(By.id("password")).sendKeys("Sales@123");
		driver.findElement(By.id("Login")).click();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();	
	}
}
