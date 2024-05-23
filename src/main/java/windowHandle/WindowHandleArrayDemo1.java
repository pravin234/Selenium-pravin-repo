package windowHandle;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleArrayDemo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//		Scenario 1:
		//			- open a url https://prafpawar11.github.io/multiplewindows.html
		//			- capture  the parent window id number
		//			- find and enter the value in first name text box
		//			- click on sauce demo link
		//			- capture all window id number
		//			- convert the Set<String> into ArrayList<String> because we capture the window id number as per the index position.
		//			- capture sauce demo window id number
		//			- switch focus to sauce demo application
		//			- enter valid credentials
		//			- switch focus to main window
		//			- find and enter values in last name text

		//broswer connect t

		//step 2 upcasting
		WebDriver driver = new ChromeDriver();

		// step 3 - open url 
		driver.get("https://prafpawar11.github.io/multiplewindows.html");

		//capture parent window id

		//step 4 find and enter the value in first name text box

		driver.findElement(By.name("fname")).sendKeys("Pravin");

		//step 5 click on sauce demo link

		driver.findElement(By.linkText("SauceDemo Link")).click();

		//captuare all window id 

		Set<String> AllwindowId
		= driver.getWindowHandles();

		//  convert Set<String> into ArrayList becasue by using arraylist object we can easily find window id using index
		ArrayList<String> arr = new ArrayList<String>(AllwindowId);

		// now we get array list  we can get(index) of method

		String parentWindowId = arr.get(0);
		String SauceDemoWindowId = arr.get(1);
		System.out.println(parentWindowId    + "  "+ SauceDemoWindowId   );
		//		 switch focus to sauce demo application
		driver.switchTo().window(SauceDemoWindowId);

		//enter valid credentials

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		Thread.sleep(4000);

		// step 11: capture the parent window id
		String parentWindowID = arr.get(0);
		System.out.println(parentWindowID);
		driver.switchTo().window(parentWindowID);

		//		 find and enter values in last name text

		
		driver.findElement(By.name("lname")).sendKeys("Kadam");

		Thread.sleep(4000);


	}

}
