package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AjioListInterface {

	public static void main(String[] args) throws InterruptedException {

		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@placeholder='Search AJIO']")).sendKeys("bags");
		driver.findElement(By.xpath("//span[@class='ic-search']")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags')]")).click();
		
		String noOfItemsFound = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println("Number of Items found = " + noOfItemsFound);
		

		List<WebElement> listOfBrandsFound = driver.findElements(By.xpath("//div[@class='brand']/strong"));
		System.out.print("Total number of Brands found with the list of Brand Names :");	
		for(int i=0;i<listOfBrandsFound.size();i++){
			System.out.println(listOfBrandsFound.get(i).getText());
		} 
			
		List<WebElement> listOfBagsFound = driver.findElements(By.className("nameCls"));
		System.out.println("Total number of Bags found with the list of Bag Names :");
		for(int i=0;i<listOfBrandsFound.size();i++){
			System.out.println(listOfBagsFound.get(i).getText());
		} 

		driver.close();
		
	}

}

