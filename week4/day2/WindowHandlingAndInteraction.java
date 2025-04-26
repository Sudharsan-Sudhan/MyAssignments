package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandlingAndInteraction {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		// Passing the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Maximizing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Passing the input for user name 
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		// Passing the input for password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// clicking on login button
		driver.findElement(By.className("decorativeSubmit")).click();
		// verifying the welcome screen is displayed 
		driver.findElement(By.id("form")).getText().contains("Demo Sales Manager");
		// clicking on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// clicking on Contacts Tab
		driver.findElement(By.linkText("Contacts")).click();
		// clicking on Contacts Tab
		driver.findElement(By.linkText("Merge Contacts")).click();

		System.out.println("Cuurent Window Title : " + driver.getTitle());
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		Set<String> fromWindow = driver.getWindowHandles();
		List<String> fromWindowList = new ArrayList<String>(fromWindow);
		driver.switchTo().window(fromWindowList.get(1));
		driver.manage().window().maximize();
		
		System.out.println("Cuurent Window Title : " + driver.getTitle());
		
		driver.findElement(By.xpath("(//td/following::div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		driver.switchTo().window(fromWindowList.get(0));
		
		System.out.println("Cuurent Window Title : " + driver.getTitle());
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> toWindow = driver.getWindowHandles();
		List<String> toWindowList = new ArrayList<String>(toWindow);
		driver.switchTo().window(toWindowList.get(1));
		driver.manage().window().maximize();
		
		System.out.println("Cuurent Window Title : " + driver.getTitle());
		
		driver.findElement(By.xpath("(//td/following::div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(fromWindowList.get(0));
		
		// clicking on Merge button
		driver.findElement(By.linkText("Merge")).click();		
		
		Alert alertPopup = driver.switchTo().alert();
		alertPopup.accept();
		
		System.out.println("Cuurent Window Title : " + driver.getTitle());
		driver.close();
		

	}
}
