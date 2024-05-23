package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demomaxmize {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		Scenario:
//			open application
//			maximize the window
		
		
		// step 1 connect to the actual browser
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		// step 2 upcasting 
		WebDriver driver = new ChromeDriver();
		
		// step 3 open  url google
		driver.get("https://www.facebook.com");
		// maxmize window
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		driver.manage().window().minimize();
		
		Thread.sleep(5000);
		
		driver.manage().window().fullscreen();
		
		driver.quit();


	}

}
