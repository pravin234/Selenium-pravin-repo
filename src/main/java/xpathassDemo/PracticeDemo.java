package xpathassDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		
		WebElement wb = driver.findElement(By.xpath("//input[@id='user-name']"));
		wb.sendKeys("standard_user");
		
		WebElement wb1 = driver.findElement(By.xpath("//input[@id='password']"));
		wb1.sendKeys("secret_sauce");
		
		WebElement wb2 = driver.findElement(By.xpath("//input[@id='login-button']"));
		wb2.click();
		 
		Thread.sleep(3000);

		WebElement wb3 = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"));
		wb3.click();
		
		Thread.sleep(3000);
		
		WebElement wb4 = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
		wb4.click();
		 
		Thread.sleep(3000);
		
		WebElement wb5 = driver.findElement(By.xpath("//button[@id='checkout']"));
		wb5.click();
		
		Thread.sleep(3000);
		
		WebElement wb6 = driver.findElement(By.xpath("//input[@id='first-name']"));
		wb6.sendKeys("Tejal");
		
		WebElement wb7 = driver.findElement(By.xpath("//input[@name='lastName']"));
		wb7.sendKeys("Patil");
		
		WebElement wb8 = driver.findElement(By.xpath("//input[@name='postalCode']"));
		wb8.sendKeys("416005");
		
		
		WebElement wb9 = driver.findElement(By.xpath("//input[@name='continue']"));
		wb9.click();
		
		Thread.sleep(3000);
		
		WebElement wb10 = driver.findElement(By.xpath("//button[@name='finish']"));
		wb10.click();
		
		Thread.sleep(3000);
		
		
		WebElement wb11 = driver.findElement(By.xpath("//button[@id='back-to-products']"));
		wb11.click();
		
		Thread.sleep(3000);
		
		WebElement wb12 = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
		wb12.click();
		
		Thread.sleep(3000);
		
		WebElement wb13 = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		wb13.click();

	}

}
