package SynchPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/reg");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement wb1 = driver.findElement(By.name("firstname"));
		wb1.sendKeys("Ajit");

		WebElement wb2 = driver.findElement(By.name("lastname"));
		wb2.sendKeys("Patil");

		WebElement wb3 = driver.findElement(By.name("reg_email__"));
		wb3.sendKeys("ajit@gmail.com");

		WebElement wb4 = driver.findElement(By.name("reg_passwd_"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		wait.until(ExpectedConditions.visibilityOf(wb4));

		wb4.sendKeys("Ajit@123");

	}

}
