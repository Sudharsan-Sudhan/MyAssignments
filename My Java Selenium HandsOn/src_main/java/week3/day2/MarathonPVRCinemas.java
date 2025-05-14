package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.edge.EdgeDriver;


public class MarathonPVRCinemas {

	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@Class='cities-placed'])[2]")).click();
		driver.findElement(By.xpath("//span[@Class='sc-gsTDqH ghtqhz pointer']")).click();
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		driver.findElement(By.xpath("//span[text()='PVR Grand Galada Chennai']")).click();
		driver.findElement(By.xpath("//span[text()='Tomorrow']")).click();
		driver.findElement(By.xpath("(//span[text()='GOOD BAD UGLY'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='10:45 PM']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Submit']")).click();
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		driver.findElement(By.xpath("(//td[@class='seats-col']/span[text()='20'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		String seatDetails = driver.findElement(By.xpath("//h6[text()='Seat Info']//following::p[2]")).getText();
		System.out.println("Selected Seat value is : " + seatDetails);
		
		String priceDetails = driver.findElement(By.xpath("//div[@class='all-grand']//following::h6/span")).getText();
		System.out.println("Selected Seat value is : " + priceDetails);
		
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		
		String pageTitle = driver.getTitle();
		String pageCurrentUrl = driver.getCurrentUrl();
		
		System.out.println("Current URL for the " + pageTitle + " is " + pageCurrentUrl);
		driver.close();
	}
}

