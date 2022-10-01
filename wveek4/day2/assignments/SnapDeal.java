package wveek4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Go to Mens Fashion
		//Go to Sports Shoes
		Actions builder = new Actions(driver);
		WebElement menfashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		WebElement Sportshoes = driver.findElement(By.xpath("(//span[@class='linkTest'])[1]"));
		Thread.sleep(2000);
		builder.moveToElement(menfashion).scrollToElement(Sportshoes).click(Sportshoes).perform();
		String count = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("The count of Sport Shoes :" +count);
		//Click Training shoes
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		//Sort by Low to High
		driver.findElement(By.xpath("//span[@class='sort-label']")).click();
		Thread.sleep(3000);
		WebElement clc = driver.findElement(By.xpath("(//li[@class='search-li'])[1]"));
		driver.executeScript("arguments[0].click();",clc );
		String SortBy = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).getText();
		System.out.println("The Selected Sort By dropdown :" +SortBy);
		if (SortBy.contains("Price Low To High")) {
			System.out.println("Item Displayed Correctly");
		}else {
			System.out.println("Item Not Displayed Correctly");
		}
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900",Keys.TAB);
		
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200",Keys.ENTER);
		Thread.sleep(2000);
		//Filter with yellow 
		driver.findElement(By.xpath("//label[@for='Color_s-Yellow']/span")).click();
		//verify the all applied filters 
		
		String Color = driver.findElement(By.xpath("//a[@data-key='Color_s|Color']")).getText();
		System.out.println("The Color of the product : " +Color);
		
		String Price = driver.findElement(By.xpath("//span[@class='lfloat product-price']")).getText();
		System.out.println("The price of the product : " +Price);
		Thread.sleep(2000);
		WebElement Image = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		
		
		Thread.sleep(2000);
		builder.moveToElement(Image).perform();
		WebElement QuickView = driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]"));
		driver.executeScript("arguments[0].click();",QuickView );
		String PriceOftheProduct = driver.findElement(By.className("payBlkBig")).getText();
		System.out.println("The price of the product : " + PriceOftheProduct);
		String discountOfProduct = driver.findElement(By.xpath("//span[text()='23% Off']")).getText();
		System.out.println("The discount of the product : " + discountOfProduct);
		Thread.sleep(2000);
		//Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
        //Create physicalFile
        File dest=new File("./snaps/screenshort.png");
        //copy the source to destination
        FileUtils.copyFile(source, dest);
        //Close the current window
        WebElement CloseWindow = driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]"));
        CloseWindow.click();
		driver.close();
	}

}
