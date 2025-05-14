package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class EditAccountStepDef extends BaseClass {
	
	@Given ("user clicks on the Find Accounts under Shortcuts")
	public void user_clicks_on_the_Find_Accounts_under_Shortcuts() {
		driver.findElement(By.linkText("Find Accounts")).click();
		
	}
	
	@Given("Enter the Account Name in the search as (.*)$")
	public void Enter_Account_Name_in_search(String AccName) {
		driver.findElement(By.xpath("(//input[@name='accountName'])[2]")).sendKeys(AccName);
	}
	
	@Given("click on Find Accounts button")
	public void click_on_Find_Accounts_button() {
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
	}
	
	@Given("click on the Account Name from search results as (.*)$")
	public void click_on_the_Account_Name_from_searchResults (String AccName) throws InterruptedException {
		Thread.sleep(2000);
		WebElement accountNameWebElement = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//following::a)[2]"));
		String accountNameValue = accountNameWebElement.getText();
		if(accountNameValue.contains(AccName))
		{
			accountNameWebElement.click();
		}   
	}

	@Given("click on Edit button")
	public void click_on_Edit_button() {
		driver.findElement(By.xpath("(//div[contains(text(),'Account')])[3]//following-sibling::div/a[1]")).click();
	}
	
	@When("user clicks on Save button")
	public void clicks_on_Save_button(){
		driver.findElement(By.xpath("//input[@value='Save']")).click();

	}
}
