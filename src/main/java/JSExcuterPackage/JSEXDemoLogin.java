package JSExcuterPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXDemoLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//suacedemo 
		
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.saucedemo.com");
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement username = driver.findElement(By.name("user-name"));
		js.executeScript("arguments[0].value='standard_user';", username);
		
		
		WebElement password = driver.findElement(By.id("password"));
		js.executeScript("arguments[0].value='secret_sauce';", password);
		
	
		
		// its not working because of 
		
//		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
//		login.submit();

	}

}
