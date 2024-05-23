package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//		open a facebook application
		//		capture the title
		//		navigate to google application
		//		capture the URL

		//		step 1: connect to actual browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		//step 2 upcasting
		WebDriver driver = new ChromeDriver();
		//step 3 open url  
		driver.get("https://www.facebook.com"); // 
		
		// step 4 capture url 
		String url = driver.getCurrentUrl();
		System.out.println("first url" +url);

		//step 5 capture the title
		String title = driver.getTitle();
		System.out.println(title);
		
		Thread.sleep(5000);

		//step 6 navigate the url on google.com
		driver.navigate().to("https://www.google.com"); // 

		//step 7 capture the current url 
		String newUrl = driver.getCurrentUrl();
		System.out.println("new url " +newUrl);
		
		Thread.sleep(5000);
		driver.close();

	}
}
