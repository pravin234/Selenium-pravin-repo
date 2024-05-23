package JSExcuterPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXDemo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/automation-practice-form");

		WebElement wb = driver.findElement(By.id("gender-radio-1"));

		JavascriptExecutor js = (JavascriptExecutor)driver;	

		js.executeScript("arguments[0].click();", wb);
			
		Thread.sleep(2000);
		
		driver.close();
	
	}

}

