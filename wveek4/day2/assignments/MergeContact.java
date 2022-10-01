package wveek4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//Find the password and enter the password value (crmsfa)
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//click the button
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();//ctrl+2+l
        System.out.println("How many window open "+windowHandles.size());
        List<String>lstWindow =new ArrayList<String>();

        List<String> lstWindow1 =new ArrayList<String>(windowHandles);
    
		driver.switchTo().window(lstWindow1.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='13958']")).click();
		
        
		driver.switchTo().window(lstWindow1.get(0));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();//ctrl+2+l
        System.out.println("How many window2 open "+windowHandles1.size());
        List<String>lstWindow2 =new ArrayList<String>();

        List<String> lstWindow21 =new ArrayList<String>(windowHandles1);
    
		driver.switchTo().window(lstWindow21.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='13960']")).click();
		driver.switchTo().window(lstWindow21.get(0));
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
        Alert alert = driver.switchTo().alert();
        String text1 = alert.getText();
        alert.accept();
        String text2 = driver.findElement(By.id("viewContact_fullName_sp")).getText();
        System.out.println(text2);
        if (text2.contains("Happy Happy 13960")) {
			System.out.println("Verified");
		}else {
			System.out.println(" Not Verified");
		}
       
	}
}
