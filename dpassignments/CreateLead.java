package week5.day2.dpassignments;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends ProjectSpecificMethod {
	
@Test(dataProvider = "create")
	public void runCreateLead(String cname, String fname, String lname, String phnum) {
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnum);
		driver.findElement(By.name("submitButton")).click();
		
}	
@DataProvider(name = "create")
	public String[][] getdata() {
		String[][] data = new String[3][4];
		data[0][0] ="TCS";
		data[0][1] ="Sandiya";
		data[0][2] ="Jayapalan";
		data[0][3] ="999";
		data[1][0] ="HCL";
		data[1][1] ="Sandiya";
		data[1][2] ="J";
		data[1][3] ="888";
		data[2][0] ="CTS";
		data[2][1] ="Sandiya";
		data[2][2] ="V";
		data[2][3] ="777";
		return data;
	
	}
}






