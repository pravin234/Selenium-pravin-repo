package windowHandle;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowAssign2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		//		open a https://www.flipkart.com/
		//			mouse over Electronics
		//			mouse over Gaming
		//			take screenshot
		//			click on Gaming mouse
		//
		//			click on 1st one item
		//			capture the price
		//			take screenshot
		//
		//			go to main window or search window
		//			click on 2nd item
		//			capture the price
		//			take screenshot
		//
		//			compare the captured price


		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//open url 
		driver.get("https://www.flipkart.com");

		//find parent window id

		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId);

		// find element of electronics using moouse move

		WebElement wb = driver.findElement(By.xpath("//div[@class='_1ch8e_']/following::span[text()='Electronics']"));

		//create action class object 
		Actions act = new Actions(driver);

		act.moveToElement(wb).build().perform();

		WebElement wb2 = driver.findElement(By.xpath("//a[@class='_1BJVlg']/following::a[text()='Gaming']"));
		//a[@class="_3490ry"]/following::a[text()='Gaming Mouse']

		act.moveToElement(wb2).build().perform();


		//			take screenshot

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		// create destination path of file 
		File des= new File  (System.getProperty("user.dir")+"\\Screenshot\\Assign2_1.png");
		FileUtils.copyFile(src, des);

		//click on Gaming mouse
		WebElement wb1 = driver.findElement(By.xpath("//a[text()='Gaming']"));
		wb1.click();

		//click on 1st one item

		WebElement wb21 = driver.findElement(By.xpath("//a[@class='wjcEIp'][text()='Metashot Augmented Reality Bat with Game for TVs, PC/Ma...']"));

		wb21.click();

		Thread.sleep(3000);

		//here new window open so capture window id 
		Set<String> allWindowId = driver.getWindowHandles();

		String proDetailsWindowId = null;
		for(String abc : allWindowId) {
			if(!abc.equals(parentWindowId)) {
				proDetailsWindowId = abc;
			}
		}
		
		System.out.println(proDetailsWindowId);

		// swithc to new window 

		//capture the price
		WebElement wb31 = driver.findElement(By.xpath("//div[text()='₹5,499']"));

		String price = wb31.getText();
		System.out.println("price of product is "+price );

		//			take screenshot
		File src2 = ts.getScreenshotAs(OutputType.FILE);

		// create destination path of file 
		File des2= new File  (System.getProperty("user.dir")+"\\Screenshot\\Assign2_2.png");
		FileUtils.copyFile(src2, des2);

		//go to main window or search window

		driver.switchTo().window(parentWindowId);

		//	click on 2nd item

		WebElement wb3 = driver.findElement(By.xpath("//a[text()='Ant Esports GP300 Pro V2 Wireless Gaming controller, Co...']"));
		wb3.click();

		//			capture the price
		//
		//		//capture the price
		WebElement wb4 = driver.findElement(By.xpath("//div[text()='₹1,299']"));
		//
		String price1 = wb4.getText();
		System.out.println("Second product price is "+price1 );
		//
		//		//			take screenshot
		File src5 = ts.getScreenshotAs(OutputType.FILE);
		//
		//		// create destination path of file 
		File des5= new File  (System.getProperty("user.dir")+"\\Screenshot\\Assign5.png");
		FileUtils.copyFile(src5, des5);
		//		//			take screenshot
		//		
		//		
		//		driver.switchTo().window(parentWindowId);
















	}

}
