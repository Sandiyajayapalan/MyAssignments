package week2day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
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
	    String text = driver.findElement(By.tagName("h2")).getText();
		//print the tagname
		System.out.println(text);
		//verify by title
		String title = driver.getTitle();
		//print the title 
		System.out.println(title);
		//Click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		// Click leads link
		driver.findElement(By.linkText("Leads")).click();
		//Click find leads
		driver.findElement(By.linkText("Find Leads")).click();
	    //Enter the first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Sandiya");
		//Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Click on first resulting lead
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='10257']")).click();
		//Verify title of the page
		String text1 = driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
		System.out.println(text1);
		//verify the tittle
		String tittle = driver.getTitle();
		//print the tittle
		System.out.println(tittle);
		//click edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		//change the company name
		driver.findElement(By.xpath("//input[@class='inputBox']")).clear();
		driver.findElement(By.xpath("//input[@class='inputBox']")).sendKeys("TCS");
		// Confirm the changed name appears
		driver.findElement(By.className("smallSubmit")).click();
		//driver.close();
		
		
	}
}


