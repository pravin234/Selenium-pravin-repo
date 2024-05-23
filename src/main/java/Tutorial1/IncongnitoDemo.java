package Tutorial1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncongnitoDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
       //create chromoption object
		ChromeOptions op = new ChromeOptions();
		
		// passs argument --incognito
		
		op.addArguments("--incognito");
			
		
		ChromeDriver driver  = new ChromeDriver(op);
		
		
		driver.get("https://www.facebook.com");
		
		
		
	}

}
