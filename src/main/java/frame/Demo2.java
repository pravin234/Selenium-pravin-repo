package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		open a https://prafpawar11.github.io/twoFrame.html
//			enter the full name
//			select the Jenkins checkbox
//			select the BDD framework values from drop down
//			
//	step 1: connect actual browser
//			System.setProperty("webdriver.chrome.driver","path of chrome driver");
//
//	step 2: up casting
//			WebDriver driver =new ChromeDriver();
//
//	step 3: open a url
//			driver.get("https://prafpawar11.github.io/twoFrame.html");
//
//	step 4; find the full name text box and enter the values
//			WebElement wb = driver.findElement(By.id("name"));
//			wb.sendKeys("abc xyz");
//
//	step 5: switch focus to checkbox frame or child frame1 
//			driver.switchTo().frame("chk");
//
//	step 6: find the Jenkins checkbox and click on it
//		WebElement wb1 = driver.findElement(By.id("Jenkins"));
//		wb1.click();
//
//	step 7: switch to the top frame or main frame or main window
//			driver.switchTo().defaultContent();
//
//	step 8: switch to drop down frame or child frame 2
//			driver.switchTo().frame(1);
//
//	step 9: find the drop down and select the BDD framework values
//			WebElement wb2 = driver.findElement(By.id("course"));
//			Select sel =new Select(wb2);
//			sel.selectByVisibleText("BDD Framework");
//
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		// upcasting 

		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://prafpawar11.github.io/twoFrame.html");
		
//		step 4; find the full name text box and enter the values
		WebElement wb = driver.findElement(By.id("name"));
		wb.sendKeys("abc xyz");	
		
		// switch foucus  to checkbox  frame
		driver.switchTo().frame("chk");
		
		Thread.sleep(5000);
		// step 6: find the Jenkins checkbox and click on it
		WebElement wb2 = driver.findElement(By.id("Jenkins"));
		wb2.click();

		// step 7: switch focus to main frame or top frame or top window
		driver.switchTo().defaultContent();

		// step 8: switch to child frame 2 or drop down frame
		driver.switchTo().frame(1);

		Thread.sleep(5000);

		// step 9: find the drop down and select the BDD Framework value
		WebElement wb3 = driver.findElement(By.id("course"));
		Select sel = new Select(wb3);
		sel.selectByVisibleText("BDD Framework");

	}

}
