package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class MarathonTatacliqWatch {

	public static void main(String[] args) {
		
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver(edgeOptions);
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions mouseHover = new Actions(driver);
		WebElement brandWebElement = driver.findElement(By.xpath("//div[@class='DesktopHeader__categoryAndBrandWithArrow DesktopHeader__categoryAndBrand']"));
		mouseHover.moveToElement(brandWebElement).perform();
		
		WebElement watchesAccessoriesWebElement = driver.findElement(By.xpath("//div[@class='DesktopHeader__categoryDetailsValueWithArrow']"));
		mouseHover.moveToElement(watchesAccessoriesWebElement).perform();
		
		WebElement casioWebElement = driver.findElement(By.xpath("//div[text()='Casio']"));
		mouseHover.moveToElement(casioWebElement).perform();
		
//		
	}

}
