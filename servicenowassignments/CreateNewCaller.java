package servicenowassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch =new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev56910.service-now.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Service@111");
		driver.findElement(By.id("sysverb_login")).click();
		//Click-AllEnter Service catalog in filter navigator and press enter 
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers",Keys.ENTER);
		shadow.findElementByXPath("//span[text()='Callers']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame);
		WebElement newcaller= shadow.findElementByXPath("//button[text()='New']");
		driver.executeScript("arguments[0].click();",newcaller);
		shadow.findElementByXPath("//input[@id='sys_user.first_name']").sendKeys("Sandiya",Keys.TAB);
		
		shadow.findElementByXPath("//input[@id='sys_user.last_name']").sendKeys("Jayapalan",Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.title']").sendKeys("Tester",Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.email']").sendKeys("sandiyajayapalan1234@gmail.com",Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.phone']").sendKeys("9999999999",Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.mobile_phone']").sendKeys("9999999998",Keys.TAB);
		WebElement submit = shadow.findElementByXPath("//button[text()='Submit']");
		driver.executeScript("arguments[0].click();",submit);
		//Search and verify the newly created Caller"
		shadow.findElementByXPath("//input[@class='form-control']").sendKeys("Sandiya",Keys.ENTER);
		
		String text3 = shadow.findElementByXPath("//table[text()='Sandiya']//tr/td[4]").getText();
		System.out.println(text3);
		
		if(text3.contains("Sandiya")) {
			System.out.println("New Caller is Successfully Created");
		}else {
			System.out.println("New Caller Not Successfully Created");
		}
	}
	
	

}
