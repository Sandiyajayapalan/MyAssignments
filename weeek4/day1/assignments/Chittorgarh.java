package weeek4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement clc1 = driver.findElement(By.id("navbtn_stockmarket"));
		clc1.click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		List<String> lst = new ArrayList<String>();
		for (int i = 0; i < lst.size(); i++) {
		List<WebElement> secName = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered']//tr["+i+"]/td[3]"));
		
		
			String text = secName.get(i).getText();
			System.out.println(text);
		
		for (int j = 0; j < secName.size(); j++) {
		
			lst.add(text);
		}
		}
		Set<String> dupSet = new HashSet<String>(lst);
		if (dupSet.size()==lst.size()) {
			System.out.println("Duplicate Present");
		}
		else {
			System.out.println("Duplicate Not Present");
		}
	}

}
