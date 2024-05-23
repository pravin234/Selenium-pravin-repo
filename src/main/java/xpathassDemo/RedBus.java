package xpathassDemo;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumProject\\Resources\\chromedriver.exe");
		//up casting
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.redbus.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(
				By.id("src"))
		.sendKeys("Bangalore");
		driver.findElement(By.id("dest")).sendKeys("Chennai");
		

	}
}


