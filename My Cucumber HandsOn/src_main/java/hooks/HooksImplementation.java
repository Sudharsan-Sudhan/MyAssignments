package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import steps.BaseClass;

public class HooksImplementation extends BaseClass{
	
	@Before
	public void PreCondition() {
		driver = new EdgeDriver();
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
		// clicking on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// implicit Wait		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@After
	public void PostCondition() {
		// Closing the Browser
		driver.close();
	}

}
