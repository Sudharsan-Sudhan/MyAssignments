package week5.day1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class AutomationUsingActionsClassInSelenium {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		// Passing the URL
		driver.get("https://erail.in/");
		// Maximizing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Clearing the text in From Station and entering the station name as "MAS"-Mgr Chennai Ctr 
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS");
		driver.findElement(By.xpath("//div[@title='Mgr Chennai Ctr']")).click();
		// Clearing the text in From Station and entering the station name as "MDU"-Madurai
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
		driver.findElement(By.xpath("//div[@title='Madurai Jn']")).click();
		boolean sortOnDateCheckBox = driver.findElement(By.id("chkSelectDateOnly")).isSelected();
		Assert.assertEquals(sortOnDateCheckBox, true, "By Default, Sort On Date Check Box is Selected");
		driver.findElement(By.id("chkSelectDateOnly")).click();
		boolean sortOnDateCheckBoxSecondTime = driver.findElement(By.id("chkSelectDateOnly")).isSelected();
		Assert.assertFalse(sortOnDateCheckBoxSecondTime, "Second Time, Sort On Date Check Box is Not Selected");
		
		WebElement trainTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']"));
				
		List<WebElement> rowsInTrainTable = trainTable.findElements(By.tagName("tr"));
		int countOfRowsInTrainTable = rowsInTrainTable.size();
		// Printing the total trains listed here without the Table Header 
		System.out.println("Total number of Trains listed here is " + (countOfRowsInTrainTable-1) );
		
		List<WebElement> trainNamesInTrainTable = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//td[2]/a"));

		int countOfTrainsInTrainTable = trainNamesInTrainTable.size();
		System.out.println("Total number of Trains listed are : " + countOfTrainsInTrainTable);
	
		for (int i = 0; i < countOfTrainsInTrainTable; i++) {
			for (int j = i+1; j < countOfTrainsInTrainTable; j++) {	
			if ((trainNamesInTrainTable.get(i).getText()).equals(trainNamesInTrainTable.get(j).getText())) {
				System.out.println("Duplicate Train Name found for this train : " + trainNamesInTrainTable.get(i).getText());	
			}
		}
			System.out.println("There is NO duplicate Train Name found for this train : " + trainNamesInTrainTable.get(i).getText());
	}
		driver.close();
	}
}
