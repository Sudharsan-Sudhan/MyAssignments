package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteAccountStepDef extends BaseClass {
	
	@When("click on Delete button")
	public void click_on_Delete_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Deactivate Account']")).click();
		driver.switchTo().alert().accept();

	}
	
	@Then("account deleted sucessfully")
	public void account_deleted_sucessfully() {
		String confirmationText = driver.findElement(By.xpath("//span[@class='subSectionWarning']")).getText();
		if(confirmationText.contains("deactivated"))
		{
			System.out.println("Account is deleted sucessfully");
		}
	}

}
