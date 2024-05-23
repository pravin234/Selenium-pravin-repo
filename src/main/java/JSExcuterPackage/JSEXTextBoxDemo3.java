package JSExcuterPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.AsyncFunction;

public class JSEXTextBoxDemo3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//		Scenario 1:
		//			open a https://demoqa.com/automation-practice-form
		//			find first name text box and enter Anjali value using JavascriptExecutor interface.

		//Step 1:connect to actual browser

		//step 2: upcasting

		WebDriver driver = new ChromeDriver();

		// step 3: open url
		driver.get("https://demoqa.com/automation-practice-form");

		Thread.sleep(5000);
		// step 4: find the first name text box
		WebElement firstName = driver.findElement(By.id("firstName"));


		//step 5: convert the WebDriver object into JavascriptExecutor

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//step 6: use executeScript() method by passing arguments[0].value='expected value' and WebElement instance
		js.executeScript("arguments[0].value ='pravin';", firstName);

		WebElement lastName = driver.findElement(By.id("lastName"));
		js.executeScript("arguments[0].value='Kadam';", lastName);

		WebElement userEmail = driver.findElement(By.id("userEmail"));
		js.executeScript("arguments[0].value='rajdhani@gmail.com';", userEmail);


		Thread.sleep(3000);
		driver.quit();


	}



}

