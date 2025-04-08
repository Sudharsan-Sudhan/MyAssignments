package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookLogin {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sudharsan");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Subramanian");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("username@gmail.com");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("password@123");
		
		WebElement dayWebElement = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dayDropDown = new Select(dayWebElement);
		dayDropDown.selectByValue("29");
		
		WebElement monthWebElement = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select monthDropDwon = new Select(monthWebElement);
		monthDropDwon.selectByIndex(7);
		
		WebElement yearWebElement = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yearDropDown = new Select (yearWebElement);
		yearDropDown.selectByVisibleText("1991");
		
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		driver.findElement(By.name("websubmit")).isDisplayed();
		driver.findElement(By.linkText("Already have an account?")).click();
		System.out.println("Facebook Login Creation Page Validation Completed Sucessfully");
		// Closing the browser opened by chromedriver
		driver.quit();
	}
}
