package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionFbAssign2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//	open a fb register page https://www.facebook.com/reg
		// enter value in first name box and delete the last 2 character.

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		//upcastig
		WebDriver driver = new ChromeDriver();

		// open fb url

		driver.get("https://facebook.com/reg");

		//find firstname 
		WebElement wb = driver.findElement(By.name("firstname"));

		//Action class object create and pass name
		Actions act = new Actions(driver);

		//pass value
		act.sendKeys(wb, "pravin").build().perform();

		Thread.sleep(5000);
		//basckspace 2 letter

		act.keyDown(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).build().perform();

	}

}
