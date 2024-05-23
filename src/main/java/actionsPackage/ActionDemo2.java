package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//	Scenario:
		//	https://demoqa.com/buttons
		//	find the double click button and double click on it.

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		// step 3: open a url
		driver.get("https://demoqa.com/buttons");

		Thread.sleep(5000);
		// step 4: find the double click button/ element or object
		WebElement wb = driver.findElement(By.id("doubleClickBtn"));

		// step 5: create object of Actions class by passing WebDriver instance
		Actions act = new Actions(driver);

		// step 6: use doubleClick() method by passing WebElement instance from Actions
		// class and then use build() and perform() method
		
		Thread.sleep(4000);

		act.doubleClick(wb).build().perform();

		// find the message text
		WebElement wb1 = driver.findElement(By.id("doubleClickMessage"));
		String a = wb1.getText();
		System.out.println(a);





	}

}
