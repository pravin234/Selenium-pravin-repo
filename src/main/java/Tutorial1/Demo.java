package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		
		  	WebDriver driver = new ChromeDriver();
	  		driver.get(" https://opensource-demo.orangehrmlive.com/web/index.php/aut\r\n");
	  		
	  		
	  		// get the current url 
	  		String currentUrl = driver.getCurrentUrl();
	  		System.out.println("current url " + currentUrl);
	  		
	  		//Get the current title
	  		String currentTitle = driver.getTitle();
	  		System.out.println("url title is" + currentTitle);
	  		
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Navigate forward
	        driver.navigate().forward();
	        System.out.println("Navigated forward. Current URL: " + driver.getCurrentUrl());

	        // Close the browser
	        driver.quit();
	        System.out.println("Browser closed.");
	  		
	  		
	  		
	  		
	}

}
