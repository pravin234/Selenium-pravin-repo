package Tutorial1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDImentionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// upcasting
		ChromeDriver driver  = new ChromeDriver();
		// open url
		driver.get("https://www.facebook.com");
		// set dimention of window 
		Dimension d = new Dimension(400,400);
        // set postion  new window		
		driver.manage().window().setPosition(new Point(100, 100));

	}

}

