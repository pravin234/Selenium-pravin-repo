package windowHandle;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleA1 {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
WebDriver driver=new ChromeDriver();
		
		//open https://prafpawar11.github.io/multiplewindows.html
		driver.get("https://prafpawar11.github.io/multiplewindows.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		
		//enter value in first name text box
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Pravin");
		
		//take screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"\\Screenshot\\a1.png");
		FileUtils.copyFile(src, des);

	}

}
