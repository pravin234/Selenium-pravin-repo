import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsExcuterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		Scenario 1: 
		//			open a url https://demoqa.com/automation-practice-form
		//			find and click on female radio button using JavascriptExecutor interface

		//Step 1: connect to actual browser
		//Step 2: up casting
		
		WebDriver driver = new ChromeDriver();
		
		// open url
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		WebElement wb = driver.findElement(By.id("gender-radio-2"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		
		js.executeScript("arguments[0].click();", wb);



	}

}
