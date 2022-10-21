package week5.day2.dpassignments;



import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test(dataProvider = "duplicate")
public class DuplicateLead extends ProjectSpecificMethod {

	public void runDuplicateLead(String phnum) throws InterruptedException {
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phnum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider(name = "duplicate")
	public String[][] getdata() {
		String[][] data = new String[2][1];
		data[0][0] ="777";
		data[1][0] ="888";

		return data;
	}
}






