package servicenow.dp.excel.assign;

import java.time.Duration;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller extends ProjectSpecificMethod{
	@BeforeTest
	   public void setup() {
	       excelfile = "SNCallerData";
	   }
@Test(dataProvider = "fetchData")
	public void runCreateNewCaller(String fname, String lname, String title ) {
		// TODO Auto-generated method stub
		shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers",Keys.ENTER);
		shadow.findElementByXPath("//span[text()='Callers']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame);
		WebElement newcaller= shadow.findElementByXPath("//button[text()='New']");
		driver.executeScript("arguments[0].click();",newcaller);
		shadow.findElementByXPath("//input[@id='sys_user.first_name']").sendKeys(fname,Keys.TAB);
		
		shadow.findElementByXPath("//input[@id='sys_user.last_name']").sendKeys(lname,Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.title']").sendKeys(title,Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.email']").sendKeys("sandiyajayapalan1234@gmail.com",Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.phone']").sendKeys("9999999999",Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.mobile_phone']").sendKeys("9999999988",Keys.TAB);
		WebElement submit = shadow.findElementByXPath("//button[text()='Submit']");
		driver.executeScript("arguments[0].click();",submit);
		//Search and verify the newly created Caller"
		shadow.findElementByXPath("//input[@class='form-control']").sendKeys("Sandiya",Keys.ENTER);
		
		String text3 = shadow.findElementByXPath("//table[text()='Sandiya']//tr/td[4]").getText();
		System.out.println(text3);
		
		if(text3.contains(fname)) {
			System.out.println("New Caller is Successfully Created");
		}else {
			System.out.println("New Caller Not Successfully Created");
		}
	}
	

}
