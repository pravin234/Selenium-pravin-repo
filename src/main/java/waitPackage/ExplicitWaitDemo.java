package waitPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		Scenario 1:
		//			- if we define the Explicit wait as 30 seconds and if element is found within the 3  seconds then it will ignore remaining all seconds.
		//		Scenario 2:
		//			- if we define the explicit wait as 30 seconds and if element is not found within the mention time then it will throws the TimeoutsException.
		//		- how to define the explicit wait.

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		WebElement wb1 = driver.findElement(By.name("firstName"));
		wb1.sendKeys("Amruta");

		// Explicit wait
		// create Object of WebDriverWait by passing WebDriver instance and time in
		// seconds.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		// use until() method from WebDriverWait class by passing ExpectedConditions as
		// visibilityOfElementLocated
		WebElement wb2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));

		// perform the operation
		wb2.sendKeys("Patil");

		WebElement wb3 = driver.findElement(By.name("phone"));
		wb3.sendKeys("90909090");

		WebElement wb4 = driver.findElement(By.name("userName"));
		wb4.sendKeys("amruta@gmail.com");


	}

}
