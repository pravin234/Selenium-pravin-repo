package windowHandle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WIndowDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scenario: 
//			open a https://prafpawar11.github.io/multiplewindows.html
//			find and enter value in first name text  box in main window
//			click on fb link
//			enter fname, lastname , username ,dob 
//			switch focus to main window
//			find and enter lastname
//			click on sauce demo
//			enter valid credentials
//			take screenshot
//			switch focus to fb window	
//			take screenshot----------> take full screenshot
//			switch focus to main window
//			find and enter address
//			take screenshot
		
		// step 1: connect browser
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
				WebDriver driver = new ChromeDriver();
				
				driver.get("https://prafpawar11.github.io/multiplewindows.html");
				
				

	}

}
