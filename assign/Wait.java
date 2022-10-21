  package week7.day2.assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://leafground.com/waits.xhtml");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//find the element
			WebElement visiblity = driver.findElement(By.xpath("(//span[text()='Click'])[1]"));
			visiblity.click();
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(visiblity));
			String text = driver.findElement(By.xpath("(//span[text()='I am here'])[1]")).getText();
			System.out.println(text);
			WebElement invisiblity = driver.findElement(By.xpath("(//span[text()='Click'])[2]"));
			invisiblity.click();
			WebElement text2 = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
			String text1 = driver.findElement(By.xpath("//span[text()='I am about to hide']")).getText();
			System.out.println(text1);
			wait.until(ExpectedConditions.invisibilityOf(text2));
			WebElement clc1st = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]"));
			clc1st.click();
			wait.until(ExpectedConditions.visibilityOf(clc1st));
			String msg1 = driver.findElement(By.xpath("(//span[@class='ui-growl-title'])[1]")).getText();
			System.out.println(msg1);
			String msg2 = driver.findElement(By.xpath("(//span[@class='ui-growl-title'])[2]")).getText();
			System.out.println(msg2);
			String msg3 = driver.findElement(By.xpath("(//span[@class='ui-growl-title'])[3]")).getText();
			System.out.println(msg3);
			
			String text3 = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).getText();
			System.out.println(text3);
			WebElement clc = driver.findElement(By.xpath("(//span[text()='Click'])[3]"));
			clc.click();
			wait.until(ExpectedConditions.visibilityOf(clc));
			String text4 = driver.findElement(By.xpath("//span[text()='Did you notice?']")).getText();
			System.out.println(text4);
			
	}
	

}
