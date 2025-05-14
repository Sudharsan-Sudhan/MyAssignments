package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	public static void main(String[] args) throws InterruptedException {
		
//		How to use the Edge Options
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver(edgeOptions);
		
//		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://orgfarm-5c1aab41f9-dev-ed.develop.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("vinothkumar.sanmugaraj848@agentforce.com");
		driver.findElement(By.id("password")).sendKeys("Sales@123");
		driver.findElement(By.id("Login")).click();

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
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("Salesforces");
		
//		Move to the element using actions class
//		Actions mouseHover = new Actions(driver);
//		WebElement elementActive = driver.findElement(By.xpath("//input[@name='city']"));
//		mouseHover.scrollToElement(elementActive).perform();
		
//		Alternate >> scroll down the cursor till end using javaScript executor 
//		driver.executeScript("window.scrollto(0, document.body.scrollHeight)");

//		Alternate >> scroll down the cursor until the particular element using javaScript executor
		WebElement elementCity = driver.findElement(By.xpath("//input[@name='city']"));
		driver.executeScript("arguments[0].scrollIntoView();", elementCity);

		driver.findElement(By.xpath("(//button[@part='input-button'])[2]")).click();
		driver.findElement(By.xpath("//span[@title='Active']")).click();
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String textConfirmation = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println("Text Confirmation = " + textConfirmation);
		
		if (textConfirmation.contentEquals("Legal Entity \"TestLeaf\" was created.")) {
			System.out.println("Legal Entity Created Sucessfully");
		}

	}

}
