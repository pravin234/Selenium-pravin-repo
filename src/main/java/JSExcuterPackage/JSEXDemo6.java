package JSExcuterPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXDemo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// open a url using JavascriptExecutor interface.
		// open fb and login

		// Step 1: connect to actual browser

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		// step 3: convert WebDriver object into JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;


		// step 4: use executeScript() method by passing window.location='url';

		js.executeScript("window.location = 'https://www.facebook.com'");
		

		// enter input email password 

		js.executeScript("document.getElementById('email').value='9403739410'");

		js.executeScript("document.getElementById('pass').value='234786234@Prk'");


		WebElement login = driver.findElement(By.name("login"));
		js.executeScript("arguments[0].click();",login);
		
		
	}

}
