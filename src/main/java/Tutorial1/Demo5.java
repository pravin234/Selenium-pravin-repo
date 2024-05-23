package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		open a amazon url
//		capture the title
//		navigate to flipkart url
//		capture the title
//		navigate back amazon url
//		capture the Url
		
		//  connect the actual browser 
		
		// connect actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		//up casting
		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://www.amazon.com");
		
		// capture the current url , title
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Thread.sleep(5000);
		
		Navigation nvt = driver.navigate();
		nvt.to("https://www.flipcart.com");
		
		String navUrl = driver.getCurrentUrl();
		System.out.println(navUrl);
		
		String navTitle = driver.getTitle();
		System.out.println(navTitle);
		
		
		driver.navigate().back();

		System.out.println(navUrl);
		
		String currentUrl = driver.getTitle();
		System.out.println(currentUrl);
		
		

	}

}
