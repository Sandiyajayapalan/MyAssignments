package servicenowassignments.testng.dp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import week7.day1.ltp.excelassignments.ReadExcel;

public class ProjectSpecificMethod {
	ChromeDriver driver;
	
	Shadow shadow;
	Shadow shadow1;
	@Parameters({"url","user_name","user_password"})
	@BeforeMethod
	public void setup(String URL, String USERNAME, String PASSWORD) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
        ChromeOptions ch =new ChromeOptions();
        ch.addArguments("--disable-notifications");
        driver = new ChromeDriver(ch);
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
	
}
