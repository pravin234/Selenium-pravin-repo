package screenShotPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ScreenShotDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//connect to actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		
		// upcasring
		
		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://amazon.in/");
		//convert webdriver object into TakesScreenshort here to perform downcasting concept
		
		//convert the WebDriver object into TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		// use getScreenshotAs() method by pasing OutputType.FILE to capture the actual screenshot
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		// store screenshot in destination location then we have to create object of file by passing destination path location
		
		File dest = new File("C:\\Users\\ABC\\Desktop\\Automationn\\screenshot\\gd1.jpg");
		
		FileUtils.copyFile(src,dest);
		
	   	

	}

}
