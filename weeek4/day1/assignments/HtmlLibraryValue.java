package weeek4.day1.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlLibraryValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://html.com/tags/table/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> table = driver.findElements(By.xpath("//div[@class='render']/table//tr[2]/td"));
		for (int i = 0; i < table.size(); i++) {
			
			System.out.println(table.get(i).getText());
		}
		
	}

}
