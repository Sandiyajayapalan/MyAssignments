package wveek4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraApplication1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		// Open https://www.myntra.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Mouse hover on MeN 
		//desktop-categoryLink
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		WebElement mens = driver.findElement(By.xpath("(//div[@class='desktop-navContent'])[1]"));
		
		builder.moveToElement(mens).perform(); 
		
		WebElement Jacket = driver.findElement(By.xpath("(//a[text()='Jackets'])[1]"));
		Jacket.click();
		//Find the total count of item 
		String text = driver.findElement(By.className("title-title")).getText();
		System.out.println("text : " +text);
		String count = driver.findElement(By.className("title-count")).getText();
		System.out.println("count : " + count);
		
		//Validate the sum of categories count matches
		String text2 = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		System.out.println("text2 : " +text2);
		
		String text3 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		System.out.println("text3 : " +text3);
		
		
		if (count.contains(text3+text2)) {
			System.out.println("SUm of count Matches");
		}
		else {
			System.out.println("Sum of count Not Matches");
		}
		//Click + More option under BRAND
		driver.findElement(By.className("brand-more")).click();
		//Type Duke and click checkbox
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[3]/div[1]/section/div/div[3]/div[3]/div[2]/ul/li[2]/label/div")).click();
		driver.getWindowHandles();
		List<WebElement> duke = driver.findElements(By.className("product-brand"));
		System.out.println("Size is : " +duke.size());
		Thread.sleep(2000);
		for (WebElement webElement : duke) {
			String brandname = webElement.getText();
			System.out.println( brandname );
			
		}
		WebElement sortBy = driver.findElement(By.className("sort-sortBy"));
		builder.moveToElement(sortBy).perform();
		Thread.sleep(2000);
		WebElement betterdiscount = driver.findElement(By.xpath("(//label[@class='sort-label ']) [4]"));
		builder.doubleClick(betterdiscount).perform();
		String firstproduct = driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]")).getText();
		System.out.println(firstproduct);
		//Find the price of first displayed item
		String firstproductprice = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("The price of a first product : " + firstproductprice);
		driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]")).click();
		System.out.println(driver.getWindowHandle());
	    
	    Set<String> windowHandles = driver.getWindowHandles();//ctrl+2+l
	    System.out.println("How many window open"+windowHandles.size());
	    List<String> lstWindow = new ArrayList<String>(windowHandles);
	    driver.switchTo().window(lstWindow.get(1));
	    System.out.println(driver.getTitle());
	    File source = driver.getScreenshotAs(OutputType.FILE);
        //Create physicalFile
        File dest=new File("./snaps/screenshort.png");
        //copy the source to destination
        FileUtils.copyFile(source, dest);
        driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite pdp-notWish')]")).click();
        Thread.sleep(10000);
        driver.quit();
	}

}
