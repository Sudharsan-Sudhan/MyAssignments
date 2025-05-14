package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class DeleteLead {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("5858585858");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='Find Leads']")).isDisplayed();
		String leadId = driver.findElement(By.xpath("((//div[contains(text(),'5858585858')])[1]/ancestor::tr//a)[1]")).getText();
		driver.findElement(By.xpath("((//div[contains(text(),'5858585858')])[1]/ancestor::tr//a)[1]")).click();
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(companyName.contains(leadId)) {
			System.out.println("Opened the Lead Details : " + leadId);
		}
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//label[text()='Lead ID:']/parent::div//input")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//*[text()='Lead ID']/ancestor::div[6]/following-sibling::div//div)[2]")).isDisplayed();
		String recordsDisplay = driver.findElement(By.xpath("(//*[text()='Lead ID']/ancestor::div[6]/following-sibling::div//div)[2]")).getText();
		if(recordsDisplay.contains("No records to display")) {
			System.out.println("Lead id : " + leadId + " is deleted Sucessfully");
		}
		driver.close();
	}
}
