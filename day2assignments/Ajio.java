package week3.day2assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("searchVal")).sendKeys("Bags",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		String totalItems = driver.findElement(By.className("length")).getText();
		System.out.println("The total number of items : " +totalItems);
		System.out.println(" List of Brands ");
		
		List<WebElement> BagBrandList = driver.findElements(By.className("brand"));
		System.out.println("Size is :" +BagBrandList.size());
		
		for (WebElement webelement : BagBrandList) {
			String text = webelement.getText();
			System.out.println(text);
	}
		List<WebElement> BagNameList = driver.findElements(By.className("nameCls"));
		System.out.println("Size : " +BagNameList.size());
		for (WebElement webelement : BagNameList) {
			String text = webelement.getText();
			System.out.println(text);
		}
			
		}
}