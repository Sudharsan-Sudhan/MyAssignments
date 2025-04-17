package week3.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Google");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Sudharsan");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Subramanian");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Sudhan");
		driver.findElement(By.xpath("(//span[text()='Department']//ancestor::tr//input)[2]")).sendKeys("Department");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Description");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sudharsan@testleaf.com");
		WebElement stateWebElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateSelector = new Select(stateWebElement);
		stateSelector.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		driver.findElement(By.xpath("(//div[text()='Lead']/following::a)[3]")).click();
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Important Note");
		driver.findElement(By.xpath("//span[text()='Important Note']//ancestor::tbody[1]/tr[12]//input")).click();
		String pageTitle = driver.getTitle();
		String pageCurrentUrl = driver.getCurrentUrl();
		System.out.println("Current URL for the Page with the tile : " + pageTitle + " is : " + pageCurrentUrl);
		driver.close();
	}
}

