package servicenowassignments.testng.dp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller extends ProjectSpecificMethod{
	
@Test(dataProvider="caller")
	public void runCreateNewCaller(String fname, String lname, String title, String email, String phnum, String mobphnum ) {
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
		shadow.findElementByXPath("//input[@id='sys_user.email']").sendKeys(email,Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.phone']").sendKeys(phnum,Keys.TAB);
		shadow.findElementByXPath("//input[@id='sys_user.mobile_phone']").sendKeys(mobphnum,Keys.TAB);
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
	@DataProvider(name="caller")
	public String[][] getdata() {
		String[][] data = new String[3][6];
		data[0][0]="Sandiya";
		data[0][1]="Jayapalan";
		data[0][2]="tester";
		data[0][3]="sandiyajayapalan1234@gmail.com";
		data[0][4]="9999999999";
		data[0][5]="9989999998";
		data[1][0]="Sandiya";
		data[1][1]="Vinopriyan";
		data[1][2]="Tester";
		data[1][3]="sandiyajayapalan1234@gmail.com";
		data[1][4]="9989999998";
		data[1][5]="9989999988";
		data[2][0]="Sandiya";
		data[2][1]="Vino";
		data[2][2]="Tester";
		data[2][3]="sandiyajayapalan1234@gmail.com";
		data[2][4]="9988999998";
		data[2][5]="9989999888";
	return data;
}
	

}
