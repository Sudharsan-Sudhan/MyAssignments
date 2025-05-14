package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountStepDef extends BaseClass {
	
	@Given("user clicks on the Accounts Tab")
	public void user_clicks_on_the_accounts_tab() {
		// clicking on Accounts Tab
		driver.findElement(By.linkText("Accounts")).click();
	}
	
	@Given("user clicks on the Create Accounts under Shortcuts")
	public void user_clicks_on_the_create_accounts_link() {
		// clicking on Create Create Account Shortcuts
		driver.findElement(By.linkText("Create Account")).click();
	}

	@Given("user enters the (.*) in the Account Name Field$")
	public void user_enters_the_accountName(String AccName) {
		// Passing the input for Account Name 
		WebElement AccNameWebElement = driver.findElement(By.xpath("//input[@id='accountName']"));
		AccNameWebElement.clear();
		AccNameWebElement.sendKeys(AccName);	    
	}	

	@When("user clicks on Create Account button")
	public void user_clicks_on_create_account_button() {
		// clicking on Create Account button
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
	}

	@Then("Account created sucessfully in View account page & the user is able to see the account as (.*)$")
	public void user_is_able_to_see_the_account_created_sucessfully_in_view_lead_page(String AccName) {
			String accountText = driver.findElement(By.xpath("//span[contains(text(),'" + AccName +"')]")).getText();
			if(accountText.contains(AccName))
			{
				System.out.println("Account Created Sucessfully");
			}   
	}
}
