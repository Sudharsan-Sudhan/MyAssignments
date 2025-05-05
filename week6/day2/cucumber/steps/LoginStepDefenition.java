package steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefenition {
	
	public EdgeDriver driver; 
	
	@Given("Launch the browser")
	public void launch_the_browser() {
		driver = new EdgeDriver();
	}

	@And("Load the url")
	public void load_the_url() {
		// Passing the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Maximizing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("Enter the username as {string}")
	public void enter_the_username_as(String userName) {
		// Passing the input for user name 
		driver.findElement(By.id("username")).sendKeys(userName);
	}

	@And("Enter the password as {string}")
	public void enter_the_password_as(String password) {
		// Passing the input for password
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
		// clicking on login button
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("It should navigate to the next page")
	public void it_should_navigate_to_the_next_page() {
		
		String textLogin = driver.findElement(By.xpath("//div[@id='form']/h2")).getText();
		System.out.println("Current WebPage Title is : " + textLogin);
		if (textLogin.contains("Welcome")) {
			System.out.println("Login Successful");		
		} 
		driver.close();
	}

	@But("It should not navigate to the next page and it will remains in the same page")
	public void it_should_not_navigate_to_the_next_page_and_it_will_remains_in_the_same_page() {
		String textLogin = driver.findElement(By.xpath("//div[@id='form']/h2")).getText();
		System.out.println("Current WebPage Title is : " + textLogin);
		if (textLogin.contains("Leaftaps Login")) {
			System.out.println("User Id or Password is wrong, please check");	
		}
	    driver.close();
	}

}
