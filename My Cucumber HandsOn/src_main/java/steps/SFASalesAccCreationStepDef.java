package steps;

import java.time.Duration;

import org.apache.http.util.Args;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SFASalesAccCreationStepDef {
	
	public EdgeDriver driver;
	public EdgeOptions edgeOptions;
	
	@Given("Launch the Browser")
	public void launch_the_browser() {
		
		edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		driver = new EdgeDriver(edgeOptions);
	}
	
	@Given("Load the salesforce URL with {string} and {string}")
	public void login_to_https_login_salesforce_com(String uid , String pwd) {
		
		// Passing the URL
		driver.get("https://login.salesforce.com");
		// Maximizing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(uid);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
	}

	@Given("Click on toggle menu & Click view All & then click on Sales from App Launcher")
	public void click_on_toggle_menu_button_from_the_left_corner() {
		
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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(By.xpath("(//*[text()='Sales'])[6]")).click();
		} 
		catch(Exception e ) {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//div[@class='slds-r8']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(By.xpath("(//*[text()='Sales'])[6]")).click();
		}
	}

	@Given("Click on Accounts tab")
	public void click_on_accounts_tab() {
		
//		try {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
////		WebElement accountsTabElement = driver.findElement(By.xpath("//a[text()='View Accounts']"));
//		WebElement accountsTabElement = driver.findElement(By.xpath("//span[text()='Reports']/preceding::span[text()='Accounts']"));
//		wait.until(ExpectedConditions.visibilityOf(accountsTabElement));
////		accountsTabElement.click();
//		driver.executeScript("arguments[0].click();", accountsTabElement);
//		}catch (Exception e){
			driver.navigate().refresh();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			WebElement accountsTabElement = driver.findElement(By.xpath("//a[text()='View Accounts']"));
			WebElement accountsTabElement = driver.findElement(By.xpath("//span[text()='Reports']/preceding::span[text()='Accounts']"));
			wait.until(ExpectedConditions.visibilityOf(accountsTabElement));
//			accountsTabElement.click();
			driver.executeScript("arguments[0].click();", accountsTabElement);
//		}
	}

	@Given("Click on New button")
	public void click_on_new_button() {

		driver.findElement(By.xpath("//div[@title='New']")).click();
	}

	@When("Enter {string} as account name")
	public void enter_as_account_name(String name) {
	    
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
	}

	@When("Select Ownership as Public")
	public void select_ownership_as_public() {
	 
		WebElement accountSite = driver.findElement(By.xpath("//input[@name='Site']"));
		driver.executeScript("arguments[0].scrollIntoView();", accountSite);
		driver.findElement(By.xpath("(//button[@part='input-button'])[4]")).click();
		driver.findElement(By.xpath("//span[@title='Public']")).click();
	}

	@Then("Click save and verify Account name as {string}")
	public void click_save_and_verify_account_name(String name) {
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String textConfirmation = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println("Text Confirmation = " + textConfirmation);

		if (textConfirmation.contains(" was created.") && textConfirmation.contains(name)) {
				System.out.println("New Account under Sales section from the SalesForce Application was Created Sucessfully");
		}
		driver.close();
	}
}
