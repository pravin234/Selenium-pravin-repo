package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo1 {

	public static void main(String[] args) throws InterruptedException {
		//		Scenario 1:
		//		open a https://www.facebook.com/reg
		//		click on forgot link using Actions class.

		//Step 1: connect to browser code

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		//step 2: up casting
		WebDriver driver =new ChromeDriver();

		//step 3: open a url
		driver.get("https://www.facebook.com/reg");

		//step 4: find the element

		WebElement wb = driver.findElement(By.xpath("//a[text()='Already have an account?']"));

		//step 5: create object of Actions class by passing """WebDriver instance."""

		Actions act =new Actions(driver);
		
	    Thread.sleep(5000);

		//step 6: use click() method by passing WebDriver instance from Actions class then build() and perform() method

		act.click(wb).build().perform();


	}

}
