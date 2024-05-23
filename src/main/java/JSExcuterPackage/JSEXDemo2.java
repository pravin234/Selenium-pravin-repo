package JSExcuterPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXDemo2 {

	public static void main(String[] args) throws InterruptedException {
		//		ii) by using getElementById('id value').click() method
		//	- document.getElementById().click() method it will find th element in web page and it will click on it.
		//	- if u want to use getElementById() method then inside HTML DOM structure id should be present.
		//syntax
		//	- convert the WebDriver Object into the JavascriptExecutor 
		//			JavascriptExecutor js = (JavascriptExecutor)driver;
		//
		//	- use executeScript() method by passing document.getElementById('id value').click() method. 
		//			js.executeScript("document.getElementById('id value').click();");
		//
		//Scenario: 	
		//	open a url https://demoqa.com/automation-practice-form
		//	find the element and click on it using JavascriptExecutor 

		// upcasting
		WebDriver driver = new ChromeDriver();

		//step 3 open url
		driver.get("https://demoqa.com/automation-practice-form");

		//step 4: convert the WebDriver object into the JavascriptExecutor 

		JavascriptExecutor js = (JavascriptExecutor)driver;

		// find getElementById

		
		js.executeScript("document.getElementById('gender-radio-3').click();");
		
		Thread.sleep(2000);
		driver.close();
	}

}
