package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FirstCryDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		// open a https://www.firstcry.com/
		//		- mouse over on ALL CATEGORIES
		//		- Mouse over on toys
		//		- click on Coloring, Sequencing & Engraving Art
		//		- select sort by top rated
		//		- select 1t product and click on add to cart
		//		- click on cart button

		//connect to the actual browser

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		//Up-casting
		WebDriver driver = new ChromeDriver();

		
		//open a url
		driver.get("https://www.firstcry.com/");
		
		driver.manage().window().maximize();
		
		//Find all categories element using locator
		WebElement wb = driver.findElement(By.xpath("//a[text()=' All Categories']"));
		
		
		//create object of Actions class and pass driver instance
		Actions act = new Actions(driver);
		
		//mouse over on ALL CATEGORIES
		act.moveToElement(wb).build().perform();
		
		Thread.sleep(5000);
		// Mouse over on toys
		WebElement wb1 = driver.findElement(By.xpath("//a[@class='M13_75' and text()='TOYS']"));
		
		act.moveToElement(wb1).build().perform();
		
		Thread.sleep(5000);
		
		WebElement wb2 = driver.findElement(By.xpath("(//a[text()='Coloring, Sequencing & Engraving Art' and @class='M13_75'])[1]"));
		act.click(wb2).build().perform();
		
		//find and select sort by using locator
		WebElement wb3 = driver.findElement(By.xpath("//div[@class='sort-select-content L12_42']"));
		act.moveToElement(wb3).build().perform();
		Thread.sleep(3000);
		
		//select top rated by using locator
		WebElement wb4 = driver.findElement(By.xpath("//a[text()='Top Rated']"));
		act.moveToElement(wb4).click(wb4).build().perform();
		Thread.sleep(3000);
		
		//Find and select 1t product using using locator
		WebElement wb5 = driver.findElement(By.xpath("//img[@title='EZ Life DIY Helicopter Paint Your Clock Kit']"));
		act.moveToElement(wb5).build().perform();
		Thread.sleep(3000);
		
		//Find add to cart button using locator click on add to cart
		WebElement wb6 = driver.findElement(By.xpath("//div[@class='bn_btn M14_white lft ga_bn_btn_addcart'][@id='2874328']"));
		act.click(wb6).build().perform();
		Thread.sleep(3000);
		
		//Find and click on cart button
		WebElement wb7 = driver.findElement(By.xpath("//span[@class='prodQuant cart-icon B18_orange paddinglft']"));
		act.click(wb7).build().perform();
		
		
		
		
		






	}



}
