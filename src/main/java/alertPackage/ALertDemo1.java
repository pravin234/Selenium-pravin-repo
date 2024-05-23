package alertPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ALertDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://demoqa.com/alerts");
		
		// find button id
		
		WebElement wb = driver.findElement(By.id("alertButton"));
		
		// clikc on button
		wb.click();
		
		// create an alert object 
		Alert alt = driver.switchTo().alert();
		
		alt.accept();
		

	}

}
