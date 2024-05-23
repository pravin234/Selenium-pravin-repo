package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo4 {

	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub
		// connect actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		//up casting
		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://www.google.com");
		
		// capture the current url , title
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Thread.sleep(5000);
		
//		 driver.navigate().to(")
		Navigation nvt = driver.navigate();
		nvt.to("https://www.facebook.com");
		
		String navUrl = driver.getCurrentUrl();
		System.out.println(navUrl);
		
		String navTitle = driver.getTitle();
		System.out.println(navTitle);
		
	}

}
