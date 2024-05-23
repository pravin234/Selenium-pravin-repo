package JavaPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	
	public void loginFunction(String username, String password) throws InterruptedException {
		
		//connect to browser
		//upcasting
		WebDriver driver =new ChromeDriver();
		//open url 
		driver.get("https://www.saucedemo.com");
		
		WebElement userName = driver.findElement(By.name("user-name"));
		// here pass argument paremeter username
		userName.sendKeys(username);
		
		
		WebElement pass = driver.findElement(By.name("password"));
		// here pass argument paremeter username
		pass.sendKeys(password);
		
		Thread.sleep(5000);
		
		WebElement login = driver.findElement(By.name("login-button"));
		login.click();
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
	}


	
	public static void main(String[] args) throws InterruptedException {
		
		Demo1 obj = new Demo1();
		obj.loginFunction("standard_user", "secret_sauce");

	}

}
