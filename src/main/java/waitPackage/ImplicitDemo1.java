package waitPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitDemo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement wb1 = driver.findElement(By.name("firstName"));//30
		wb1.sendKeys("Amruta");

		WebElement wb2 = driver.findElement(By.name("lastName"));//30

		//WebElement wb2 = driver.findElement(By.name("lastName11111"));//30 
		//then it will wait 30 second and throw  show exception NoSuchElementException.
		wb2.sendKeys("Patil");

		WebElement wb3 = driver.findElement(By.name("phone"));//30 
		wb3.sendKeys("90909090");

		WebElement wb4 = driver.findElement(By.name("userName"));//30
		wb4.sendKeys("amruta@gmail.com");

		Thread.sleep(5000);

		driver.quit();

	}

}



