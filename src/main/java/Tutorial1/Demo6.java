package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//		- open orange hrm  url
		//		- capture the title
		//		- navigate to guru99 url
		//		capture the title
		//		- navigate back
		//		- capture url
		//		- navigate forward
		//		- capture url

		// Step 1: Connect to actual browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// Step 2: up casting
		WebDriver driver = new ChromeDriver();


		// Step 3: open a orange HRM url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Step 4: capture title
		String a = driver.getTitle();
		System.out.println(a);

		// Wait for 5 seconds
		Thread.sleep(5000);

		//Step 5: navigate to Guru99 URL
		Navigation nvt = driver.navigate();
		nvt.to("https://demo.guru99.com/test/newtours/register.php");
		//or
		//driver.navigate().to("https://demo.guru99.com/test/newtours/register.php");

		//step 6: capture title
		String b = driver.getTitle();
		System.out.println(b);

		//wait for 5 seconds
		Thread.sleep(5000);

		//step 7:navigate back
		driver.navigate().back();
		
			

		//step 8: capture url
		String c= driver.getCurrentUrl();
		System.out.println(c);

		//wait for 5 seconds
		Thread.sleep(5000);

		//step 9: navigate forward
		driver.navigate().forward();

		//step 10: capture url
		String d = driver.getCurrentUrl();
		System.out.println(d);
		
		driver.navigate().refresh();

	}

}
