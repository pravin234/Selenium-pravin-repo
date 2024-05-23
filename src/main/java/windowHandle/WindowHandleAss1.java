package windowHandle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class WindowHandleAss1 {

	private static final ShootingStrategy ShootingStatergy = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		//
		//		open a https://prafpawar11.github.io/multiplewindows.html
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
		//
		//			switch focus to main window
		//			find and enter address
		//			take screenshot
		//Step 1 Upcasting
		WebDriver driver = new ChromeDriver();

		//step 2 open url
		driver.get("https://prafpawar11.github.io/multiplewindows.html");
		//step 3 finde text box element on webpage and enter value in texbox
		driver.findElement(By.name("fname")).sendKeys("Pravin");

		// step 4 click on fb link
		driver.findElement(By.linkText("Visit Facebook")).click();

		Set<String> allwindowid = driver.getWindowHandles();
		ArrayList<String> arr = new ArrayList<String>(allwindowid);

		driver.switchTo().window(arr.get(1));


		// step 5 enter fname, lastname , username ,dob
		driver.findElement(By.name("firstname")).sendKeys("Pravin");

		driver.findElement(By.name("lastname")).sendKeys("Kadam");
		driver.findElement(By.name("reg_email__")).sendKeys("pravinkadam98@gmail.com");

		// dob dropdwon so we create select class object
		//find day
		WebElement wb1 = driver.findElement(By.id("day"));
		Select sel = new Select(wb1);
		sel.selectByVisibleText("23");

		WebElement wb2 = driver.findElement(By.id("month"));
		Select sel2 = new Select(wb2);

		sel2.selectByVisibleText("Jul");

		WebElement wb31 = driver.findElement(By.id("year"));
		Select sel3 = new Select(wb31);

		sel3.selectByVisibleText("2000");

		//switch focus to main window
		driver.switchTo().window(arr.get(0));
		//	find and enter lastname
		driver.findElement(By.name("lname")).sendKeys("Kadam");
		//	click on sauce demo

		Thread.sleep(3000);

		driver.findElement(By.linkText("SauceDemo Link")).click();
		//	enter valid credentials

		allwindowid= driver.getWindowHandles();

		arr = new ArrayList<String>(allwindowid);

		driver.switchTo().window(arr.get(2));

		driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");

		//		take screenshot
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\Screenshot\\arrayss1.png");
		FileUtils.copyFile(src, dest);

		//	switch focus to fb window	

		driver.switchTo().window(arr.get(1));
		//	take screenshot----------> take full screenshot
		AShot shot = new AShot();
		shot.shootingStrategy(ShootingStrategies.viewportPasting(3000));
		Screenshot ss1= shot.takeScreenshot(driver);
		BufferedImage source= ss1.getImage();
		File destination = new File(System.getProperty("user.dir")+"\\Screenshot\\fullsss.png");
		ImageIO.write(source, "PNG", destination);


		// switch focus to main window
		driver.switchTo().window(arr.get(0));
		//	find and enter address
		driver.findElement(By.name("address")).sendKeys("Pune");

		//	take screenshot

		File dest2= new File(System.getProperty("user.dir")+"\\Screenshot\\arrayss2.png");
		FileUtils.copyFile(src, dest2);
		Thread.sleep(3000);
		driver.quit();






	}

}
