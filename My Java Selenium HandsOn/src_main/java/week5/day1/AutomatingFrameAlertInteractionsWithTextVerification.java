package week5.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class AutomatingFrameAlertInteractionsWithTextVerification {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		// Passing the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		// Maximizing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Switching to frame
		driver.switchTo().frame(1);
		// Finding the button and click on it 
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		// Switching to alert Popup and click on Ok button 
		driver.switchTo().alert().accept();
		// get the value of confirmation and print it
		String confirmationText = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println("Confirmation Message = " + confirmationText);
		driver.switchTo().defaultContent();
		System.out.println("Title of the page is = " + driver.getTitle());
		driver.close();
	}

}
