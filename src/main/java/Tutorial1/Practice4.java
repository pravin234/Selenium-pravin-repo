package Tutorial1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice4 {

	private static final String WebElelement = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		open a url 	https://www.saucedemo.com/inventory.html
		//			find username 
		//					- check displayed status
		//					- check enabled status
		//					- enter value			
		//					- capture the entered value
		//
		//			find  password
		//					- check displayed status
		//					- check enabled status
		//					- enter value			
		//					- capture the entered value
		//			find the login button
		//					- check displayed status
		//					- check enabled status
		//					- click on button
		//
		//			- capture the home page title and url
		//			
		//			- find the Sauce Labs Backpack add to cart
		//					- click on it
		//
		//			- find the Sauce Labs Bike Light add to cart
		//					- click on it

		// connect to the actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// upcasting
		WebDriver driver = new ChromeDriver();

		// open url 
		driver.get("https://www.saucedemo.com/inventory.html");

		// find username element in webpage

		WebElement userName = driver.findElement(By.name("user-name"));


		// check username is display and enable status 
		Boolean disUserName = userName.isDisplayed();
		System.out.println("display username textbox status is " +disUserName);

		Boolean enableUserNameStatus = userName.isEnabled();
		System.out.println(" check enable UserName Status " + enableUserNameStatus);

		//enter input  username
		userName.sendKeys("standard_user");
		
		// check input enter value
		String UserInput = userName.getAttribute("value");
		System.out.println("user enter input is " +UserInput);


		//find  password
		//check displayed status
		//check enabled status
		//enter value			
		//capture the entered value
		
		WebElement wb2 = driver.findElement(By.name("password"));
		
		//pass display or not
		Boolean passDisplay = wb2.isDisplayed();
		System.out.println("password check displayed status" + passDisplay);
		
		
		Boolean passEnable = wb2.isEnabled();
		System.out.println("password check displayed status" + passEnable);
		wb2.sendKeys("secret_sauce");

		String passInput = wb2.getAttribute("value");
		System.out.println("password enter input is " +passInput);

		
		
		// find login button
		WebElement submitButton = driver.findElement(By.name("login-button"));
		Boolean btn = submitButton.isDisplayed();
		submitButton.isEnabled();
		submitButton.click();
		
		String title=driver.getTitle();
		System.out.println(title);
		
		//capture url
		String url =driver.getCurrentUrl();
		System.out.println(url);
		
		
		
		
		
		
		
		

	}

}
