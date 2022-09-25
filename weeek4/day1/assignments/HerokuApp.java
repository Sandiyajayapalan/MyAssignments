package weeek4.day1.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HerokuApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get(" http://testleaf.herokuapp.com/pages/table.html ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> table = driver.findElements(By.xpath("//table[@cellspacing='0']"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@cellspacing='0']//tr"));
		System.out.println(rows.size());
		List<WebElement> columns = driver.findElements(By.xpath("//table[@cellspacing='0']//th"));
		System.out.println(columns.size());
		List<WebElement> learnto = driver.findElements(By.xpath("//table[@cellspacing='0']//tr[3]/td"));
		for (int i = 0; i < learnto.size(); i++) {
			String text = learnto.get(i).getText();
			System.out.println(text);
		}
		WebElement clc = driver.findElement(By.xpath("//table[@cellspacing='0']//tr[4]/td[3]"));
		clc.click();
	}

}
