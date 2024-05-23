package Tutorial1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkDemo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//- open a fb register page url
		//		-find the link in web page using findElement() method and using given locator	
		//		-verify the link is displayed or not
		//		- verify the link is enabled or not?	
		//		- capture the link Text	
		//		- click on link
		// step 1 connect to actual browser	

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2  upcasting or create object
		WebDriver driver = new ChromeDriver();

		// step 3: open a fb register page url
		driver.get("https://www.facebook.com/reg");

		// step 4: find the link in web page using findElement() and given locators
		WebElement wb = driver.findElement(By.linkText("Already have an account?"));

		// step 5: verify the link is displayed or not
		boolean a = wb.isDisplayed();
		System.out.println(a);
		
		// step 6: verify the link is enabled or not?
		boolean b = wb.isEnabled();
		System.out.println(b);
		
		// step 7: capture the link text or physical text
		String linktext = wb.getText();
		
	
		
		System.out.println(linktext);
		
		//step 8: click on link
		wb.click();
		
		Thread.sleep(5000);
		driver.quit();
		
		
		

	}

}
