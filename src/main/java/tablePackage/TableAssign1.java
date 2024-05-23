package tablePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableAssign1 {

	public static void main(String[] args) throws InterruptedException {
		//			open a url https://www.makemytrip.com/
		//			find and enter from city as Pune
		//			and suggestion list click on first Object
		//			find and enter to city as Delhi
		//			and suggestion list click on first Object
		//			find and select Departure 20 March 2025
		//			find and click on Travellers & Class
		//			select 5 ADULTS 
		//			and select the CHILDREN 
		//			and select the Business class
		//			click on apply
		//			click on search button


		// step 1: connect browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// step 3: open a url
		driver.get("https://www.makemytrip.com/");

		Thread.sleep(5000);
		// step 4: find and enter from city as Pune
//		WebElement wb = driver.findElement(
//				By.xpath("//span[text()='Departure']/following::span[@class='sc-12foipm-8 eXKWBG fswDownArrow']"));
//		wb.click();

	}

}
