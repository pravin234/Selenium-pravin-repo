package JSExcuterPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXDemo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// open a url in new tab using JavascriptExecutor interface.
		// open fb and login

		// Step 1: connect to actual browser

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");

		// step 3: convert WebDriver object into JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;


		// step 4: use executeScript() method by passing window.location='url';
		js.executeScript("window.open('https://www.saucedemo.com/');");
		



	}

}
