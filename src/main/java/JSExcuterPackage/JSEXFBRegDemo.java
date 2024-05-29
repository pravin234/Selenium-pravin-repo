package JSExcuterPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXFBRegDemo {

	public static void main(String[] args) throws InterruptedException {

		// Set the path to the ChromeDriver executable
		//ss   System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://www.facebook.com/reg");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//      Thread.sleep(5000);

		// Display an alert message
		//    js.executeScript("alert('User is on Facebook Register page');");

		// Wait for the user to manually close the alert
		//  Thread.sleep(3000);  // Adjust the wait time if necessary

		// Interact with the first name field
		WebElement firstNamewb = driver.findElement(By.name("firstname"));
		js.executeScript("arguments[0].value='pravin';", firstNamewb);

		// Interact with the last name field
		WebElement lastNamewb = driver.findElement(By.name("lastname"));
		js.executeScript("arguments[0].value='Kadam';", lastNamewb);
		

		// Add more interactions if needed
		WebElement emailwb = driver.findElement(By.name("reg_email__"));
		js.executeScript("arguments[0].value='rajdhani@gmail.com';",emailwb);
		
		

		Thread.sleep(3000);  // Wait for a bit to observe the result if necessary
		//driver.quit();
	}
}
