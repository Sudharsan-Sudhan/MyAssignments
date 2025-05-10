package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class IrctcFlights {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[contains(text(),' FLIGHTS ')]")).click();
		
		Set<String> irctcWindowHandles = driver.getWindowHandles();
		
		List<String> allWindowsAddress=new ArrayList<String>(irctcWindowHandles);
		System.out.println("The List of irctc opened windows are : " + allWindowsAddress);
		
		driver.switchTo().window(allWindowsAddress.get(1));
		
		String secondWindowsTitle = driver.getTitle();
		System.out.println("The Second Windows Title is : " + secondWindowsTitle);
		
		driver.switchTo().window(allWindowsAddress.get(0));
		
		driver.close();
		
		driver.switchTo().window(allWindowsAddress.get(1));
		
		System.out.println(driver.getTitle() + " is opened again");
		
		driver.close();
		

	}

}
