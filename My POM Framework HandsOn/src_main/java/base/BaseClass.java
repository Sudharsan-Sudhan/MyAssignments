package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ReadExcel;

public class BaseClass {
	public EdgeDriver driver;
	public String filename;
	
	@BeforeMethod
	public void preConditions() {
		driver=new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	@AfterMethod
   public void postConditions() {
		driver.close();

	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		String[][] readData = ReadExcel.readData(filename);
         return readData;
	}


}
