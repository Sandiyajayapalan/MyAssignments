package wveek4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("How many windows open " + windowHandles.size());
		List<String> lstWindow =new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstWindow.get(1));
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		driver.switchTo().window(lstWindow.get(0));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		System.out.println(driver.getTitle());
		//
		System.out.println(driver.getWindowHandle());
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println("How many windows open " + windowHandles1.size());
		List<String> lstWindow1 =new ArrayList<String>(windowHandles1);
		driver.switchTo().window(lstWindow1.get(1));
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getWindowHandle());
		driver.switchTo().window(lstWindow1.get(0));
		System.out.println(driver.getTitle());
		//
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println("How many windows open " + windowHandles2.size());
		List<String> lstWindow2 =new ArrayList<String>(windowHandles2);
		driver.switchTo().window(lstWindow2.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(lstWindow2.get(0));
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		Set<String> windowHandles3 = driver.getWindowHandles();
		System.out.println("How many windows open " + windowHandles2.size());
		List<String> lstWindow3 =new ArrayList<String>(windowHandles2);
		driver.switchTo().window(lstWindow3.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(lstWindow3.get(0));
		System.out.println(driver.getTitle());
		
		
	}

}
