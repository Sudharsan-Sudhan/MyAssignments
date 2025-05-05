package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {

	
	public EdgeDriver driver;
	public String fileName;

	@Parameters({"url" , "user", "pass"})
	@BeforeMethod
	public void preConditions(String URL, String uid, String pwd) {
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uid);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
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
