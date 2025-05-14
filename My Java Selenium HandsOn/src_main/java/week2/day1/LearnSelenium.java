package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		// Maximizing the browser
		driver.manage().window().maximize();
		
		// Passing the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Passing the input for user name 
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		// Passing the input for password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// clicking on login button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// verifying the welcome screen is displayed 
		driver.findElement(By.id("form")).getText().contains("Demo Sales Manager");
		
		// clicking on logout button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// Quiting the Driver
		driver.quit();
	}
}
