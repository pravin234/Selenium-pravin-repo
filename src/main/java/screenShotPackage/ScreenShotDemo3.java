package screenShotPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDemo3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// open url youube and take screen shot save it
		//https://www.youtube.com/watch?v=8oQNTAeesGg&list=RDMMWmjnthvZ5U8&index=2
		
		// Step 1 connect to actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://www.youtube.com/watch?v=8oQNTAeesGg&list=RDMMWmjnthvZ5U8&index=2");
		
		// convert the WebDriver Object into the TakesScreenshot here we perform down casting concept.
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		// create src and dest 
	
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		// destination store file
		File dest =new File("C:\\Users\\ABC\\Desktop\\Automationn\\screenshot\\Youtube1.jpg");
		
		FileUtils.copyFile(src, dest);
		
	}

}
