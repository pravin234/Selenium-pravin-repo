package alertPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://demoqa.com/alerts");
		
		// find button id
		
		WebElement wb2 = driver.findElement(By.id("timerAlertButton"));

		// step 5: click on click me button
		wb2.click();
		
		Alert alt2 = driver.switchTo().alert();
		
		String b = alt2.getText();
		System.out.println(b);
		
		alt2.accept();
		
		driver.quit();


	}

}
