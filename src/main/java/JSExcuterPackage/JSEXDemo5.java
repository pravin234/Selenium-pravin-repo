package JSExcuterPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXDemo5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//		open a https://demoqa.com/automation-practice-form
		//			find and enter value using JavascriptExecutor 

		// Step 1: connect to actual browser

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		// step 3: open a url
		driver.get("https://demoqa.com/automation-practice-form");

		Thread.sleep(5000);

		//step 4: convert the WebDriver object into the JavascriptExecutor 
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//step 5: use executeScript() method by passing document.getElementById('id value').value='Expected value'
		
		js.executeScript("document.getElementById('firstName').value='Pravin';");
		

	



	}

}
