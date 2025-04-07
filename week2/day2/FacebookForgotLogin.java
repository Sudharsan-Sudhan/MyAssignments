package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookForgotLogin {

	public static void main(String[] args) {
		// initializing the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		// Maximize the Browser
		driver.manage().window().maximize();
		// loading the facebook URL
		driver.get("https://www.facebook.com/");
		// providing the facebook loginid as "testleaf.2023@gmail.com"
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testleaf.2023@gmail.com");
		// providing the password value as "Tuna@321"
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Tuna@321");
		// clicking on login button
		driver.findElement(By.xpath("//button[@name='login']")).click();
		// Wait for 30 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on forgot password link
		driver.findElement(By.linkText("Forgotten password?")).click();
		// validate the title of the window
		driver.getTitle().contentEquals("Forgotten Password | Can't Log In | Facebook");
		// Closing the browser opened by chromedriver
		driver.quit();
	}
}
