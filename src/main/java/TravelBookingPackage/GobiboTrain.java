package TravelBookingPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GobiboTrain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 WebDriver driver = new ChromeDriver();

	        // Open the URL
	        driver.get("https://www.goibibo.com/");

	        // Maximize the window
	        driver.manage().window().maximize();

	        // Add implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	        // Close the advertisement popup
	        driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();

	        // Click on the Hotels tab
	        driver.findElement(By.xpath("//span[text()='Trains']")).click();
	        driver.findElement(By.xpath("//div[@data-id='dweb_pip_id']/p")).click();
	        
	        
	        // from
//	        WebElement wb = driver.findElement(By.xpath("//span[text()='From']/following-sibling::input"));
//	     
//	        
//			WebElement wb1 =driver.findElement(By.xpath("//p[text()='Enter Source Name']"));
//			
//			Actions act = new Actions(driver);
//			
//			act.contextClick(wb1).build().perform();
			
			
			WebElement wb = driver.findElement(By.xpath("//p[text()='From']"));
			System.out.println(wb.isEnabled());
			wb.click();
			
			WebElement wb1 = driver.findElement(By.xpath("//input[@type='text']"));
			wb1.sendKeys("Mumbai");
			

		
	        
	        


	}

}
