package wveek4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryResizable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/resizable");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.switchTo().frame(0);
        Actions builder = new Actions(driver);
        WebElement Resize = driver.findElement(By.xpath("(//div[@class='ui-widget-content ui-resizable'])[1]"));
        builder.moveToElement(Resize).clickAndHold().moveByOffset(90, 90).release().perform();
       
		
	}

}
