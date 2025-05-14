package week6.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import testcases.ReadExcel;

public class SFATestNGUsingExcel extends BaseClassSFA {

	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		
		String[][] readData = ReadExcelSFA.readData();
		 return readData;
	}
	
	@Test (dataProvider="fetchData")
	public void createLEgalEntity(String Name, String companyName) throws InterruptedException {
		
			driver.findElement(By.xpath("//div[@class='slds-r8']")).click();
			driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement spinnerElement = driver.findElement(By.xpath("//div[@part='spinner']"));
			wait.until(ExpectedConditions.invisibilityOf(spinnerElement)); 
		}
			catch(Exception e ) {
			driver.navigate().refresh();
			driver.findElement(By.xpath("//div[@class='slds-r8']")).click();
			driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		}
		
		try {
			driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
			driver.findElement(By.xpath("//*[text()='Legal Entities']")).click();
			driver.findElement(By.xpath("//div[@title='New']")).click();
		} catch(Exception e ) {
			driver.navigate().refresh();
			driver.findElement(By.xpath("//div[@class='slds-r8']")).click();
			driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
			driver.findElement(By.xpath("//*[text()='Legal Entities']")).click();
			driver.findElement(By.xpath("//div[@title='New']")).click();
		}
		
			driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by " + Name);
			driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(companyName);
			
			WebElement elementCity = driver.findElement(By.xpath("//input[@name='city']"));
			driver.executeScript("arguments[0].scrollIntoView();", elementCity);
	
			driver.findElement(By.xpath("//button[@part='input-button']")).click();
			driver.findElement(By.xpath("//span[@title='Active']")).click();
			
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
			String textConfirmation = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
			System.out.println("Text Confirmation = " + textConfirmation);
			
			if (textConfirmation.contains(Name) && textConfirmation.contains("was created.")) {
				System.out.println("Legal Entity Created Sucessfully");
			}
		
	}

}
