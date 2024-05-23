package xpathassDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagDemo {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver =  new ChromeDriver(); 
		driver.get("https://www.facebook.com/reg");
		
		// find xpath and fill  texbox value
		WebElement wb = driver.findElement(By.xpath("//input[@name='firstname']"));
		
		
		wb.sendKeys("Pravin");
		
		
	}
}
