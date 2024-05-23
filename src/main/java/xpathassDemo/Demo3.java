package xpathassDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();


		driver.get("https://ui.cogmento.com/");

		// click on login button div class name
		WebElement wb =  driver.findElement(By.xpath("//div[@class ='ui fluid large blue submit button']"));

		wb.click();

		Thread.sleep(5000);

		WebElement wb1 = driver.findElement(By.xpath("//a[contains(text(),'password')]"));

		wb1.click();




	}

}
