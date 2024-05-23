package screenShotPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDemoProjct {

	public static void main(String[] args) throws IOException {


		//open gmail and save screen shot in project  direct

		// Step 1 connect to actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		//Step 2 upcastig 
		WebDriver driver = new ChromeDriver();

		// Step 3 open url 
		driver.get("https://google.com/");

		// downcasting using TakesScreenshot class interface 

		TakesScreenshot ts = (TakesScreenshot)driver;

		// hold or capture the web page screen shot using getScreenshot method 

		File src = ts.getScreenshotAs(OutputType.FILE);

		// file project level path dest using 

         
		File dest = new File(System.getProperty("user.dir")+"\\Screenshot\\b1.png");

		FileUtils.copyFile(src, dest);





	}

}
