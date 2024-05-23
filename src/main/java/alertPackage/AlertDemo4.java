package alertPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://demoqa.com/alerts");
		
		// find button id
		
		WebElement wb4 = driver.findElement(By.id("promtButton"));
		
		wb4.click();
		//switch to alert 
	
		Alert alt = driver.switchTo().alert();
		
		alt.sendKeys("WElcome Pravin");
		Thread.sleep(5000);
		
		alt.dismiss();

	}

}
