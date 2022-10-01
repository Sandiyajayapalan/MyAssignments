package wveek4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaApplication {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement brands = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		WebElement brandName = driver.findElement(By.xpath("//a[contains(@href,'/brands/loreal-paris/c/595?p')]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(brands).click(brandName).perform();
		System.out.println(driver.getTitle());
		// Click sort By and select customer top rated
		driver.findElement(By.className("arrow-icon")).click();
		Thread.sleep(3000);
		WebElement clc = driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]"));
		driver.executeScript("arguments[0].click();",clc );
		// Click Category and click Hair->Click haircare->Shampoo
		WebElement Category = driver.findElement(By.xpath("//span[text()='Category']"));
		Category.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		WebElement shampoo = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		shampoo.click();
		// Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		WebElement colorProtection = driver.findElement(By.xpath("//span[text()='Color Protection']"));
		builder.moveToElement(colorProtection).click(colorProtection).perform();
		//check whether the Filter is applied with Shampoo
		String text = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
		System.out.println(text);
		if(text.contains("Shampoo")) {
			System.out.println("Filter contains Shampoo : Verified");
			
		}else {
			System.out.println("Filter contains Shampoo : Not Verified");
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		
		WebElement product = driver.findElement(By.className("css-xrzmfa"));
		product.click();
		
		System.out.println(driver.getTitle());
		
		//GO to the new window and select size as 175ml
	    System.out.println(driver.getWindowHandle());
	    
	    Set<String> windowHandles = driver.getWindowHandles();//ctrl+2+l
	    System.out.println("How many window open"+windowHandles.size());
	    List<String> lstWindow = new ArrayList<String>(windowHandles);
	    driver.switchTo().window(lstWindow.get(1));
	    System.out.println(driver.getTitle());
	    
	    WebElement Size = driver.findElement(By.className("css-2t5nwu"));
	    Select source = new Select(Size);
	    source.selectByValue("0");
	    String text2 = driver.findElement(By.className("css-1jczs19")).getText();
	    System.out.println(text2);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[@class='btn-text']")).click();
	    WebElement bag = driver.findElement(By.xpath("//button[@class='css-g4vs13']"));
		bag.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		
		// Print the Grand Total amount
		String text3 = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("text3 : "+text3);
		// Click Proceed
		Thread.sleep(2000);
		WebElement proceed = driver.findElement(By.xpath("//span[text()='Proceed']"));
		proceed.click();
		
		//Click on Continue as Guest
		WebElement guest = driver.findElement(By.xpath("//button[@class='btn full big']"));
		guest.click();
		// Check if this grand total is the same in step 14
		Thread.sleep(2000);
		String text4 = driver.findElement(By.xpath("//span[text()='259']")).getText();
		System.out.println("text4 : " +text4);
		if (text4.equals(text3)) {
			System.out.println("Grand Amount same");
		}else {
			System.out.println("Grand Amount Not Same");
		}
		driver.quit();
		
	}

}
