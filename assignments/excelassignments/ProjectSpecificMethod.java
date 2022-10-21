package week7.day1.ltp.excelassignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethod {

		RemoteWebDriver driver;
		String excelfile;
		@Parameters({"browser","url","username","password"})
		@BeforeMethod
		public  void setup(String browser,String URL, String USERNAME, String PASSWORD) {
			// TODO Auto-generated method stub
		 if(browser.equalsIgnoreCase("chrome")) {
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		    }
		    else if(browser.equalsIgnoreCase("edge")) {
		        WebDriverManager.edgedriver().setup();
		        driver = new EdgeDriver();
		    }
		
			
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.id("username")).sendKeys(USERNAME);
			driver.findElement(By.id("password")).sendKeys(PASSWORD);
			driver.findElement(By.className("decorativeSubmit")).click();
			
		}
		@AfterMethod
		public void teardown() {
			driver.close();
			
	}
		
		@DataProvider(name="fetchData")
	      public String[][] getData() throws IOException  {
	          String[][] readData = ReadExcel.readData(excelfile);
	        return readData;

}
}