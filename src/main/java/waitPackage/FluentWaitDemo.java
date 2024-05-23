package waitPackage;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement wb1 = driver.findElement(By.name("firstName"));
		wb1.sendKeys("Raj");

		// we have to create Object of FluentWait class by passing WebDriver instance
		// and using WebDriver generic, and by calling withTimeout() method and by
		// passing time duration in withTimeout() method
		// and by calling pollingEvery() method ad by passing duration in seconds in
		// pollingEvery() method
		// and calling ignoring() method and passing Exception name.

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))		
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(Exception.class);

		// use until() method by passing the new Function() and generic as WebDriver and
		// WebElement and then use apply() method by passing WebDriver arguments and
		// inside the apply method find the web elements

		WebElement wb2 = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.name("lastName9887777"));
			}
		}
		);
		
		
		wb2.sendKeys("Kadam");
		

	}

}
