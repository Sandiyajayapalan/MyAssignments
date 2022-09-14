package week2day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
	    driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
	    driver.findElement(By.linkText("CRM/SFA")).click();
	    driver.findElement(By.linkText("Leads")).click();
	   
	    driver.findElement(By.linkText("Find Leads")).click();
	    
	    driver.findElement(By.xpath("//span[text()='Phone']")).click();
	    
	    driver.findElement(By.name("phoneCountryCode")).clear();
	    
	    driver.findElement(By.name("phoneCountryCode")).sendKeys("91");
	    
		driver.findElement(By.name("phoneNumber")).sendKeys("9600057495");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String leadid = driver.findElement(By.xpath("//a[text()='10723']")).getText();
		System.out.println(leadid);
		
		
		
		driver.findElement(By.xpath("//a[text()='10723']")).click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.name("id")).sendKeys(leadid);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String leadlist = driver.findElement(By.xpath("No records to display")).getText();
		System.out.println(leadlist);
		String tittle1 = driver.getTitle();
		System.out.println(tittle1);
		driver.close();
		
	}

}
