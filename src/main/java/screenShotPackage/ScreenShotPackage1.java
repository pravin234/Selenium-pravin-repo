package screenShotPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotPackage1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// step 1: connect to actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		// step 3: open a URL
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		// step 4: find the first name text box and enter the values
		driver.findElement(By.name("firstName")).sendKeys("Aboli");

		// step 5: find the last name text box and enter the values
		driver.findElement(By.name("lastName")).sendKeys("Shinde");

		// step 6: convert the WebDriver object into the TakesScreenshot

		TakesScreenshot ts = (TakesScreenshot) driver;

		// step 7: use getScreenshotAs() method by passing OutputType.FILE to capture
		// the actual screenshot in file format

		File src = ts.getScreenshotAs(OutputType.FILE);

		// step 8: store the screenshot in destination location then we have to create
		// Object of File class by passing file destination location

		File dest = new File("C:\\Users\\ABC\\Desktop\\Automationn\\screenshot\\XYZ.jpg");

		// step 9: copy the screenshot from source location to destination location by
		// using copyFile() and by passing
		// source and destination location

		FileUtils.copyFile(src, dest);


	}

}
