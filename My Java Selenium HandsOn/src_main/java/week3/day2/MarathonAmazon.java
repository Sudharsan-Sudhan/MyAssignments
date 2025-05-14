package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class MarathonAmazon {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Bags for boys");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String searchResultsText = driver.findElement(By.xpath("//div[@class='sg-col-inner']/h2")).getText();
		System.out.println("Search Results will be : " + searchResultsText);
		driver.findElement(By.xpath("//span[text()='Brands']/ancestor::div[3]//span[text()='Safari']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text()='Brands']/ancestor::div[3]//span[text()='Skybags']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text()='Last 30 days']")).click();
		String firstSearchResultTitle = driver.findElement(By.xpath("((//h2[text()='Results']/ancestor::div[5]//following::div[@data-cy='title-recipe'])[1]//h2)[2]")).getText();
		String firstSearchResultDiscountPrice = driver.findElement(By.xpath("((//h2[text()='Results']/ancestor::div[5]//following::div[@data-cy='price-recipe'])[1]//span)[10]")).getText();
		String firstSearchResultOriginalPrice = driver.findElement(By.xpath("((//h2[text()='Results']/ancestor::div[5]//following::div[@data-cy='price-recipe'])[1]//span)[15]")).getText();
		String firstSearchResultDiscountPercentage = driver.findElement(By.xpath("((//h2[text()='Results']/ancestor::div[5]//following::div[@data-cy='price-recipe'])[1]//span)[17]")).getText();
		
		System.out.println("First Search Result Title : " + firstSearchResultTitle);
		
		System.out.println("First Search Result Original Price : " + firstSearchResultOriginalPrice);
		
		System.out.println("First Search Result Discount Percentage : " + firstSearchResultDiscountPercentage);
		
		System.out.println("First Search Result Discount Price : ₹" + firstSearchResultDiscountPrice);
		
		String pageTitle = driver.getTitle();
		String pageCurrentUrl = driver.getCurrentUrl();
		System.out.println("Current Page Tile is : " + pageTitle);
		System.out.println("Current URL for this page is : " + pageCurrentUrl);
		driver.close();

	}
}
