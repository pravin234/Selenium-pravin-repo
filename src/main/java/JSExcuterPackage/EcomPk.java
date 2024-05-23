package JSExcuterPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcomPk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// open a url using JavascriptExecutor interface.
		// open fb and login

		// Step 1: connect to actual browser

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		// step 3: convert WebDriver object into JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
	

		// step 4: use executeScript() method by passing window.location='url';

		js.executeScript("window.location = 'https://pravin234.github.io/ecom_pravin/pages/login.html'");
		// enter input email password 
//
//		js.executeScript("document.getElementById('email').value='admin@gmail.com'");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("useremail")));
        emailField.sendKeys("admin@gmail.com");

	
		
		
	}

}
