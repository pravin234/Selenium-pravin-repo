package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSwitch7 {

	public static void main(String[] args) throws InterruptedException {
		// Step 1: Connect to actual browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");


		// Step 2: up casting
		WebDriver driver = new ChromeDriver();

		// step 3: open a url
		driver.get("https://www.facebook.com");

		// wait for 7 seconds
		Thread.sleep(7000);

		// step 4: open a new tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		

		// wait for 7 seconds
		Thread.sleep(7000);

		// step 5: open a google url
		driver.get("https://www.google.com");

	}



}
