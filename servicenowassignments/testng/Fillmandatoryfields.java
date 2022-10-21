package servicenowassignments.testng;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Fillmandatoryfields {
@Test
	public void runFillmandatoryfields() throws InterruptedException {
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
		shadow.setImplicitWait(30);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge",Keys.ENTER);
		shadow.findElementByXPath("//span[text()='Create New']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame);
		shadow.findElementByXPath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']").click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
	    Set<String> windowHandles = driver.getWindowHandles();
	    System.out.println("How many window open"+windowHandles.size());
	    List<String> lstWindow =new ArrayList<String>(windowHandles);
	    driver.switchTo().window(lstWindow.get(1));
        System.out.println(driver.getTitle());
      
		driver.findElement(By.className("glide_ref_item_link")).click();
		driver.switchTo().window(lstWindow.get(0));
		 System.out.println(driver.getTitle());
		 Shadow shadow1 = new Shadow(driver);
		shadow1.setImplicitWait(30);
		WebElement eleFrame1= shadow1.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame1);
		 
		WebElement category = shadow1.findElementByXPath("//button[@id='lookup.kb_knowledge.kb_category']");
		Actions builder = new Actions(driver);
		builder.moveToElement(category).click(category).perform();
		WebElement CatIt = shadow1.findElementByXPath("//span[text()='IT']");
		CatIt.click();
		WebElement CatJava = shadow1.findElementByXPath("//span[text()='Java']");
		builder.moveToElement(CatJava).click(CatJava).perform();
		WebElement CatOk = shadow1.findElementByXPath("//button[text()='OK']");
		CatOk.click();
		shadow1.findElementByXPath("//input[@id='kb_knowledge.short_description']").sendKeys("Knowledge - IT - Java");
		WebElement submit = shadow1.findElementByXPath("//button[text()='Submit']");
		driver.executeScript("arguments[0].click();",submit);
	
	}

}
