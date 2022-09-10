package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//we have to call WDM for browser driver
				WebDriverManager.chromedriver().setup();
				//Launch the browser(chrome)
				ChromeDriver driver=new ChromeDriver();
				// Load the Url
				driver.get("http://leaftaps.com/opentaps/control/login");
				//Maximize the browser
				driver.manage().window().maximize();
				//Find the username and enter the username value(demosalesmanager)
				driver.findElement(By.id("username")).sendKeys("demosalesmanager");
				//Find the password and enter the password value (crmsfa)
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				//click the button
				driver.findElement(By.className("decorativeSubmit")).click();
				//GetText
				String text = driver.findElement(By.tagName("h2")).getText();
				//print the tagname
				System.out.println(text);
				//verify by title
				String title = driver.getTitle();
				//print the title 
				System.out.println(title);
				//Click CRM/SFA
				driver.findElement(By.linkText("CRM/SFA")).click();
				//click Leads
				driver.findElement(By.linkText("Leads")).click();
				 //click Create Lead
				driver.findElement(By.linkText("Create Lead")).click();
				//Find Company name Enter the company name
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
				 //Enter first name
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sandiya");
				 //Enter last name
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Jayapalan");
				//Enter the department name
				driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Tester");
				//Enter the description
				driver.findElement(By.id("createLeadForm_description")).sendKeys("Best Tester");
				//Enter the Email
				driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sandiyajayapalan@gmail.com");
				//click create lead button
				driver.findElement(By.className("smallSubmit")).click();
				//Click the duplicate lead
				driver.findElement(By.className("subMenuButton")).click();
				//Clear the CompanyName Field using .clear()
				driver.findElement(By.id("createLeadForm_companyName")).clear();
				//Enter new CompanyName
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
				//Clear the FirstName Field using .clear() 
				driver.findElement(By.id("createLeadForm_firstName")).clear();
				//Enter new FirstName
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rakshan");
				//Click on Create Lead Button
				driver.findElement(By.className("smallSubmit")).click();
				String title2 = driver.getTitle();
				 System.out.println(title2);
				//close the browser
				//driver.close();
				

	}

}
