package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClassSFA {

	public EdgeOptions edgeOptions;
	public EdgeDriver driver;
	
	@Parameters({"URL", "UID", "PWD"})
	@BeforeMethod
	public void preCondition(String url, String user, String pswrd) {
//		How to use the Edge Options
		edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");	
		driver = new EdgeDriver(edgeOptions);
//		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pswrd);
		driver.findElement(By.id("Login")).click();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();	
	}
}
