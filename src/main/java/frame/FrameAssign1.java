package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameAssign1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//		open a https://praf002.github.io/
		//			find the full name text box and enter the value
		//			find the GitHub checkbox and click on it
		//			find and select the Database Automation values from drop down
		//			find and Enter the mobile numbers 
		//			Find and Enter the address 
		//			unselect the GitHub checkbox
		//			click on selenium click
		//			capture the entered full name and enter new name
		//			select the Java Script Executor value
		//			capture entered address and enter new address

		// step 1: connect to the actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		//upcasting 
		WebDriver driver =new ChromeDriver();

		//url
		driver.get("https://praf002.github.io/");
		//maximize   
		driver.manage().window().maximize();

		//find the full name text box and enter the value
		WebElement w= driver.findElement(By.xpath("//input[@id='name']"));
		w.sendKeys("Pravin Kadam");

		Thread.sleep(5000);

		//find the GitHub checkbox and click on it 
		driver.switchTo().frame("mobileFrame");
		driver.switchTo().frame("showcheckbox");
		WebElement w1=driver.findElement(By.xpath("//input[@id='GitHub']"));
		w1.click();

		Thread.sleep(5000);

		//find and select the Database Automation values from drop down
		driver.switchTo().defaultContent();
		driver.switchTo().frame("addressframe");
		driver.switchTo().frame("toolframe");
		WebElement w2 =driver.findElement(By.xpath("//select[@name='course']"));
		Select s = new Select(w2);
		s.selectByVisibleText("Database Automation");

		Thread.sleep(5000);

		//find and Enter the mobile numbers 
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mobileFrame");
		WebElement w3 = driver.findElement(By.xpath("//input[@id='mob']"));
		w3.sendKeys("9876543210");

		Thread.sleep(5000);

		//Find and Enter the address 
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		WebElement w4 =driver.findElement(By.xpath("//input[@id='add']"));
		w4.sendKeys("Pune"); 

		Thread.sleep(3000);	

		//unselect the GitHub checkbox
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mobileFrame");
		driver.switchTo().frame("showcheckbox");   
		w1.click();

		Thread.sleep(3000);

		// click on selenium click
		driver.findElement(By.xpath("//input[@id='Selenium']")).click();

		//capture the entered full name and enter new name
		driver.switchTo().defaultContent();
		System.out.println("value");
		w.clear();
		w.sendKeys("Rajdhani ");

		Thread.sleep(3000);

		// select the Java Script Executor value
		driver.switchTo().frame(1);
		driver.switchTo().frame("toolframe");
		s.selectByVisibleText("Java Script Executor");

		Thread.sleep(3000);
		// capture entered address and enter new address
		driver.switchTo().parentFrame();
		System.out.println(w4.getAttribute("value"));
		w4.clear();
		w4.sendKeys("Pancard Club road Baner, ");

	}
}