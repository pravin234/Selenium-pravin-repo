package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		open a https://prafpawar11.github.io/mainFrame.html
		//		enter the text in name text box
		//		select the TestNG and POM checkbox	
		//			
		WebDriver driver =new ChromeDriver();

		driver.get("https://prafpawar11.github.io/mainFrame.html");

		driver.getCurrentUrl();
		//enter the text in name text box

		WebElement wb = driver.findElement(By.id("name"));
		wb.sendKeys("Pravin");

		//		select the TestNG and POM checkbox	
		// switch to  frame
		WebElement framewb = driver.findElement(By.xpath("//iframe[@id='mainframe']"));
		driver.switchTo().frame(framewb);

		WebElement wb1 = driver.findElement(By.id("TestNG"));
		wb1.click();

		// step 6: find the TestNG and POM check box and click on it
		WebElement wb3= driver.findElement(By.xpath("//input[@id='TestNG']"));
		wb3.click();

		WebElement wb4 = driver.findElement(By.xpath("//input[@id='POM']"));
		wb4.click();


	}

}
