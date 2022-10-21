package servicenowassignments.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderingMobile {
@Test
	public void runOrderingMobile() {
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
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		// Click on  mobiles
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		/* switch to the frame */
		driver.switchTo().frame(eleFrame);
		/* Element for Mobiles catalog is visible in DOM 
		 * Not necessary to use shadow object to locate the same
		 */
		driver.findElement(By.linkText("Mobiles")).click();
		driver.findElement(By.linkText("Apple iPhone 13 pro")).click();
		//	Update color field to rose gold and storage field to 128GB		
		//	Select  Order now option	
		//	Verify order is placed and copy the request number"		
		driver.findElement(By.xpath("(//label[@class='radio-label'])[5]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
		WebElement dropdown = driver.findElement(By.name("IO:ff1f478e9747011021983d1e6253af68"));
		Select source = new Select(dropdown);
		source.selectByValue("500MB");
		driver.findElement(By.xpath("//label[contains(text(),'128 GB')]")).click();
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
		String text1 = shadow.findElementByXPath("//dl[@class='dl-horizontal sc-dl-horizontal']").getText();
				
		System.out.println(text1);
		if (text1.contains("Order Placed: ")) {
			System.out.println("Order Placed");
		}else {
			System.out.println("Order Not Placed");
		}
		String text2 = shadow.findElementByXPath("//a[@id='requesturl']").getText();
		System.out.println(text2);
	}

}
