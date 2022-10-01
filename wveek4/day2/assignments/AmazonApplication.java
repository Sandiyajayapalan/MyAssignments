package wveek4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		//Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[text()='29,990'])[4]")).getText();
		System.out.println("The First Product Price : "+price);
		Thread.sleep(2000);
		//Print the number of customer ratings for the first displayed product
		String customer = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base')])[1]")).getText();
		System.out.println("The number of customer ratings for the first displayed product : "+customer);
		// Mouse Hover on the stars
		//Get the percentage of ratings for the 5 star.
		//a-link-normal
		Actions builder = new Actions(driver);  
		WebElement Stars = driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']/i"));
		builder.moveToElement(Stars).click(Stars).perform();
		String Starpercentage = driver.findElement(By.xpath("//table[contains(@class,'a-normal a-align')]//tr[1]/td[3]/span[2]/a")).getText();
		
		System.out.println("The percentage of ratings for the 5 star " + Starpercentage);
		// First text Link of the product
		WebElement firstProduct  = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		firstProduct.click();
		System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());
		Set<String> windowHandles = driver.getWindowHandles();//ctrl+2+l
	    System.out.println("How many window open"+windowHandles.size());
	    List<String> lstWindow = new ArrayList<String>(windowHandles);
	    driver.switchTo().window(lstWindow.get(1));
	    System.out.println(driver.getTitle());
	    String firstProductName = driver.findElement(By.xpath("(//span[@class='a-size-large product-title-word-break'])[1]")).getText();
	    System.out.println("The first Product Name : " +firstProductName);
		//Take a screen shot of the product displayed
	    File source = driver.getScreenshotAs(OutputType.FILE);
        //Create physicalFile
        File dest=new File("./snaps/screenshort.png");
        //copy the source to destination
        FileUtils.copyFile(source, dest);
        //Click 'Add to Cart' button
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(2000);
        // Get the cart subtotal and verify if it is correct
        String CartSubTotal = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']/span")).getText();
		System.out.println("The Cart SubTotal : "+CartSubTotal);
		
	
	}

}
