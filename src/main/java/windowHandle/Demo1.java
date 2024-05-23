package windowHandle;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//		Scenario 1:
		//			- Open a url https://prafpawar11.github.io/multiplewindows.html
		//
		//			- capture current window id number
		//			- Enter the values in first name text box
		//			- click on orange HRM link
		//			- capture all window id Number
		//			- capture the orange HRM id number
		//			- switch focus to orange HRM window
		//			- enter value in username text box 
		//			- switch focus to main window 
		//			- enter the text in last name text box.


		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// step 3: open a url
		driver.get("https://prafpawar11.github.io/multiplewindows.html");

		// step 4: capture the current or parent window id number

		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId);
		System.out.println("-------------------------------------------------");

		// step 5: find and enter values in first name text box
		driver.findElement(By.name("fname")).sendKeys("Amruta");

		Thread.sleep(5000);

		// step 6: find and click on orange HRM link
		driver.findElement(By.linkText("Visit Orange HRM")).click();

		// step 7: capture all window id numbers
		Set<String> allWindowId = driver.getWindowHandles();

		// step 8: capture the child window id or orange HRM application id Number
		// step 8a) define the string null variable

		String orangeHrmWindowID = null;

		// step 8a) : iterate the all window id numbers
		for (String abc : allWindowId) {

			if (!abc.equals(parentWindowId)) {
				// reassign value for orangeHrmWindowID
				orangeHrmWindowID = abc;
			}
		}

		// step 9: switch focus to Orange HRM application

		driver.switchTo().window(orangeHrmWindowID);

		// step 10: find and enter the value in username text box
		driver.findElement(By.name("username")).sendKeys("Admin");

		Thread.sleep(5000);

		// step 11: switch to parent window

		driver.switchTo().window(parentWindowId);

		// step 12: find and enter text in last name text box

		driver.findElement(By.name("lname")).sendKeys("Patil");

	}

}
