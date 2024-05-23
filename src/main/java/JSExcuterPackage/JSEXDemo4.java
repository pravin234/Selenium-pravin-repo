package JSExcuterPackage;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXDemo4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//open fb and login
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		// find element login user pass
		
		Thread.sleep(5000);
		
		WebElement email = driver.findElement(By.id("email"));
		
		// Jascript excutor
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		
		js.executeScript("arguments[0].value ='9403739410';",email);
		
		WebElement password = driver.findElement(By.id("pass"));
		
		js.executeScript("arguments[0].value ='234786234@Prk';",password);
		
		// click on login button
		WebElement login = driver.findElement(By.name("login"));
		js.executeScript("arguments[0].click();",login);
		
		
	Thread.sleep(5000);
	driver.quit();


		
	}

}
