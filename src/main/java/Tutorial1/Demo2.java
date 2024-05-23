package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(" https://opensource-demo.orangehrmlive.com/web/index.php/auth/login\r\n");
  		
  		// get the current url 
  		String currentUrl = driver.getCurrentUrl();
  		System.out.println("current url " + currentUrl);
  		
  		
  		
  		
  		
	}

}
