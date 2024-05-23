package JavaPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public  void screenShotFuntion(String a) throws IOException, InterruptedException  
	{
		// open url google and take screen shot save it
		
		// Step 1 connect to actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://www.google.com");
		// convert the WebDriver Object into the TakesScreenshot here we perform down casting concept.
		TakesScreenshot ts = (TakesScreenshot)driver;
		// create src and dest 
		File src = ts.getScreenshotAs(OutputType.FILE);
		// destination store file
		File dest =new File(System.getProperty("user.dir")+"\\ScrenShotFunction\\"+a);

		FileUtils.copyFile(src, dest);
		
		Thread.sleep(5000);
		
		driver.quit();

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		Demo3  obj = new Demo3();

		obj.screenShotFuntion("cap.png");
		
		
		
		

	}

}
