package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.base.Strings;

public class ActionAssignGuru {

	public static void main(String[] args) throws InterruptedException {

		//open https://demo.guru99.com/test/newtours/register.php
		//		find the first name text box only
		//	enter value
		//				First Name:	
		//				Last Name:	
		//				Phone:	
		//				Email:	
		//
		//				Address:	
		//				City:				
		//				State/Province:	
		//				Postal Code:	
		//				select Country			INDIA
		//
		//				User Name:	
		//				Password:	
		//				Confirm Password:	
		//			
		//				click on submit button
		//
		//				click on sign up link
		//				enter username
		//				enter password
		//				click on submit button


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		// upcasting
		WebDriver driver = new ChromeDriver();

		// open url
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		// find element  first name 
		WebElement wb = driver.findElement(By.name("firstName"));
		
		// create and actions class object
		
		Actions act = new Actions(driver);
		act.sendKeys(wb, "pravin").build().perform();
		
		// enter lastname 
		act.sendKeys(Keys.TAB).sendKeys("Kadam").build().perform();
		
		// enter phone number
		
		act.sendKeys(Keys.TAB).sendKeys("99899899890").build().perform();
		
		//email
		act.sendKeys(Keys.TAB).sendKeys("pravin@gmail.com").build().perform();
		
		//email
		act.sendKeys(Keys.TAB).sendKeys("pravin@gmail.com").build().perform();
		
		// address
		act.sendKeys(Keys.TAB).sendKeys("Sai Appertment").build().perform();
		
		// city
		act.sendKeys(Keys.TAB).sendKeys("Pune").build().perform();
		
		// state 
		act.sendKeys(Keys.TAB).sendKeys("Maharashtra").build().perform();
	 
		//postal code
		act.sendKeys(Keys.TAB).sendKeys("123456").build().perform();
	
		//tab , enter select 
		
		act.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys("INDIA").sendKeys(Keys.ENTER).build().perform();

		act.sendKeys(Keys.TAB).sendKeys("rajdhani234").build().perform();
		
		act.sendKeys(Keys.TAB).sendKeys("raj@234").build().perform();
		
		act.sendKeys(Keys.TAB).sendKeys("raj@234").build().perform();
		
		act.sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
		
		
	
	}

}
