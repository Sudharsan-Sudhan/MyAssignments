package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeDriver;


public class WebTableInteractionAndDataVerification {

	public static void main(String[] args) throws IOException {
		
//		How to use the Edge Options
//		EdgeOptions edgeOptions = new EdgeOptions();
//		edgeOptions.addArguments("private");
//		edgeOptions.addArguments("--disable-notifications");
//		EdgeDriver driver = new EdgeDriver(edgeOptions);
		
		EdgeDriver driver = new EdgeDriver();
		// Passing the URL
		driver.get("https://www.amazon.in/");
		// Maximizing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		// Take Screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot1.png"));
		
		String amountOfFirstProductResult = driver.findElement(By.xpath("(//h2[text()='Results']//following::span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Amount Of the Product's First Search Result for <<oneplus 9 pro>> is : " + amountOfFirstProductResult);
		
		driver.findElement(By.xpath("(//i[@data-cy='reviews-ratings-slot'])[1]")).click();
		String ratingsOfFirstProductResult = driver.findElement(By.xpath("//h2[@id='acr-popover-title']/span[1]")).getText();
		System.out.println("Amount Of the Product's First Search Result for <<oneplus 9 pro>> is : " + ratingsOfFirstProductResult);

		driver.findElement(By.xpath("(//h2[text()='Results']//following::img[@class='s-image'])[1]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		//Convert Set into List
		List<String> allAddress=new ArrayList<String>(allWindows);
		
		//switching to the new window
		driver.switchTo().window(allAddress.get(1));
		
		// Take Screenshot
		File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile2, new File("c:\\tmp\\screenshot2.png"));
		
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		
		// Take Screenshot
		File scrFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile3, new File("c:\\tmp\\screenshot3.png"));
		
		String textLabel = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-total-string']/b")).getText();
		String textValue = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		
		System.out.println(textLabel  + " = " + textValue);
		
		// Take Screenshot
		File scrFile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile4, new File("c:\\tmp\\screenshot4.png"));
		
		// Closing all windows
		driver.quit();

	}

}
