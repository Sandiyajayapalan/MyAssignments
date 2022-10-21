package servicenow.dp.excel.assign;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class ProjectSpecificMethod {
	RemoteWebDriver driver;
	String excelfile;
	Shadow shadow;
	Shadow shadow1;
	@Parameters({"browser","url","user_name","user_password"})
	@BeforeMethod
	public void setup(String browser,String URL, String USERNAME, String PASSWORD) throws InterruptedException {
		// TODO Auto-generated method stub
		if(browser.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions ch =new ChromeOptions();
			ch.addArguments("--disable-notifications");
	        driver = new ChromeDriver(ch);
	        
	    }
	    else if(browser.equalsIgnoreCase("edge")) {
	        WebDriverManager.edgedriver().setup();
	        EdgeOptions edg = new EdgeOptions();
	        driver = new EdgeDriver(edg);
	        
	    }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys(USERNAME);
		driver.findElement(By.id("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("sysverb_login")).click();
		
		
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
