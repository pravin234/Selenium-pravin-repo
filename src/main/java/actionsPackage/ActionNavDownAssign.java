package actionsPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionNavDownAssign {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//		open https://www.amazon.com/ 
		//			navigate end of page
		//			wait for 5 seconds
		//			navigate home page
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		// upcasting
		WebDriver driver = new ChromeDriver();

		// open url
		driver.get("https://www.amazon.in/");

		// create an object action class
		Actions act = new Actions(driver);

		// navigate end of page using page down

		act.keyDown(Keys.END).build().perform();

		// wait 
		Thread.sleep(5000);

		// again home page
		act.keyDown(Keys.HOME).build().perform();

	}

}
