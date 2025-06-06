package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {

	@DataProvider(name="fetchData")
	public String[][] sendData() {
		
		String[][] data = new String [2][3];
		
		data[0][0] = "TestLeaf";
		data[0][1] = "Vineeth";
		data[0][2] = "Rajendran";
		
		data[1][0] = "Qeagle";
		data[1][1] = "Vinoth";
		data[1][2] = "Sanmugaraj";
		
		return data;
	}
	
	@Test (dataProvider="fetchData")
	public void testCreateLead(String companyName, String firstName, String lastName) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.name("submitButton")).click();
	}
}






