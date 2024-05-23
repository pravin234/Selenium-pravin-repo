package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionFlipCartAssign2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Open a https://www.flipkart.com/
		//	mouse over on Electronics
		//	mouse over on Laptop and Desktop
		//	and click on Laptop
		//	Mouse on Login button
		//	click on SignUp link

		//  connect actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		//  upcasting

		WebDriver driver = new ChromeDriver();
		// open url 
		driver.get("https://www.flipkart.com/");
		//find element on webpage

		WebElement wb = driver.findElement(By.xpath("//div[@aria-label='Electronics']"));

		// create an object Action class
		Actions act = new Actions(driver);

		// mousemove event handle
		act.moveToElement(wb).build().perform();
		Thread.sleep(5000);

		//mouse over on Laptop and Desktop
		WebElement wb2= driver.findElement(By.xpath("//a[text()='Laptop and Desktop']"));
		act.moveToElement(wb2).build().perform();
		Thread.sleep(5000);

		//and click on Laptop 
		WebElement wb3= driver.findElement(By.xpath("//a[@class='_3490ry' and text()='Laptops']"));
		act.moveToElement(wb3).click(wb3).build().perform();
		Thread.sleep(5000);

		//Mouse on Login button
		WebElement wb4= driver.findElement(By.xpath("//a[@class='wsejfv' and text()='Login']"));
		act.moveToElement(wb4).build().perform();
		Thread.sleep(5000);

		//click on SignUp link
		WebElement wb5 = driver.findElement(By.xpath("//div[@class='yFCbwN']"));
		act.moveToElement(wb5).click(wb5).build().perform();
		Thread.sleep(2000);

		driver.quit();




	}

}
