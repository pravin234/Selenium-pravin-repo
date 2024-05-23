package screenShotPackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDyanmcFIle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://amazon.in/");

		//downcasting for takes screenshot

		TakesScreenshot ts = (TakesScreenshot)driver;

		// use getScreenshotAs() method by passing OutputType.FILE
		File src = ts.getScreenshotAs(OutputType.FILE);

		
		// create object of SimpleDateFormat class by passing date and time format
		SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy_HHmmss");
    //   String todayDate = "23/03/23";
	
		// use format() method by passing Date class object
		//String abc = simple.format(Date(todayDate));
		String abc = simple.format(new Date());

		// store the screenshot in destination location by creating object of File
		// class and passing File destination location
		

		File dest = new File(System.getProperty("user.dir") + "\\PassScreenshot\\facebook" + abc + ".png");

		// copy the screenshot from source location and store in destination location
		// using copyFile() method

		FileUtils.copyFile(src, dest);



		//

	}

	


}

