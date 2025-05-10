package week5.day2;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MarathonTatacliqWatch {

	public static void main(String[] args) throws IOException {
		
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver(edgeOptions);
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions mouseHover = new Actions(driver);
		WebElement brandWebElement = driver.findElement(By.xpath("//div[text()='Brands']"));
		mouseHover.moveToElement(brandWebElement).perform();

		WebElement watchesAccessoriesWebElement = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		mouseHover.moveToElement(watchesAccessoriesWebElement).perform();
		
		WebElement casioWebElement = driver.findElement(By.xpath("(//div[text()='Featured brands']/following-sibling::div)[1]"));
		mouseHover.moveToElement(casioWebElement).perform();
		
		driver.findElement(By.xpath("(//div[text()='Featured brands']/following-sibling::div)[1]")).click();
		
		WebElement sortByDropDown = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select selectSortByDropDown = new Select(sortByDropDown);
		selectSortByDropDown.selectByVisibleText("New Arrivals");
		
		driver.findElement(By.xpath("//div[(text()='Men')]/preceding-sibling::div/div")).click();
				
		List<WebElement> watchPrice = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));
		int sizeNoOfWatch = watchPrice.size();
		System.out.println("Size No Of Watch : " + sizeNoOfWatch);

		String firstWatchPrice = watchPrice.get(0).getText();
		System.out.println("First Watch Price : " + firstWatchPrice);
		
		driver.findElement(By.xpath("//a[@class='ProductModule__base']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List <String> windowHandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		
		String actualPrice = driver.findElement(By.xpath("//h3[contains(text(),'MRP')]")).getText();
		
		System.out.println("Actual Price of the watch : "+ actualPrice);
		
		String actualPriceFinal = actualPrice.replaceAll("[^0-9]", "");
		String firstWatchPriceFinal = firstWatchPrice.replaceAll("[^0-9]", "");
		
		System.out.println("Actual Price of the watch Final : "+ actualPriceFinal);
		System.out.println("First Watch Price Final : " + firstWatchPriceFinal);
		
		if (actualPriceFinal.contains(firstWatchPriceFinal)) { 
			System.out.println("Amount Value is Same for the watch we checked in Summary Page as well as detailed page");
		} else {
			System.out.println("Amount is Not Same for the watch we checked in Summary Page as well as detailed page");
		}
		
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		String cartValue = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		System.out.println("Cart Value : "+ cartValue);
	
		driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).click();
		
		// Take Screenshot
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("c:\\tmp\\TataCliq\\screenshot1.png"));
				
		driver.close();
		
		driver.switchTo().window(windowHandlesList.get(0));
		
		driver.close();
		
	}

}
