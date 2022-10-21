package servicenowassignments.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreatenewProposal {
@Test
	public void runCreatenewProposal() {
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
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Proposal",Keys.ENTER);
		shadow.findElementByXPath("//span[text()='My ']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame);
		WebElement newpro= shadow.findElementByXPath("//button[text()='New']");
		driver.executeScript("arguments[0].click();",newpro);
		shadow.findElementByXPath("//input[@id='std_change_proposal.short_description']").sendKeys("New employee hire",Keys.ENTER);
		WebElement submit = shadow.findElementByXPath("//button[text()='Submit']");
		driver.executeScript("arguments[0].click();",submit);
		String text3 = shadow.findElementByXPath("//table[text()='New employee hire']//tr[3]/td[4]").getText();
		System.out.println(text3);
		if(text3.contains("New employee hire")) {
			System.out.println("New Proposal is Successfully Created");
		}else {
			System.out.println("New Proposal Not Successfully Created");
		}
			
	}

}
