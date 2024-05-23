package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameAssign2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//open a url https://chercher.tech/practice/frames-example-selenium-webdriver
		//		enter the topic name
		//		select the avatar
		//		select the  checkbox
		//		select the cat 
		//		capture the entered text and enter new text
		//		unselect the checkbox

		// step 1: connect to the actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		//step 2 upcasting 
		WebDriver driver =new ChromeDriver();

		//step 3 open url
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		//step 4  enter the topic name

		driver.switchTo().frame("frame1");

		WebElement wb = driver.findElement(By.xpath("//input[@type='text']"));

		wb.sendKeys("Pravin");

		Thread.sleep(3000);

		// step 5 select the avatar

		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement wb1= driver.findElement(By.xpath("//select[@id='animals']"));
		//create select class objec and passing driver class instance
		Select sel =new Select(wb1);

		sel.selectByVisibleText("Avatar");

		Thread.sleep(5000);

		//step 6 select the  checkbox
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame1");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();

		Thread.sleep(3000);
		//step 7 select the cat 
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		sel.selectByVisibleText("Cat");

		Thread.sleep(3000);

		// step 8 capture the entered text and enter new text
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		System.out.println(wb1.getAttribute("value"));
		wb1.clear();
		wb1.sendKeys("TestNg");

		Thread.sleep(3000);

		//step 9 unselect the checkbox
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();

		driver.quit();
	}

}
