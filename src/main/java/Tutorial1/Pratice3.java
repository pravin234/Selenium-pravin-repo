package Tutorial1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pratice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// connect to actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
    
		// up casting
		WebDriver driver  = new ChromeDriver();

		//1) Open a https://demo.guru99.com/test/newtours/register.php
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		// 2) find the form all input  text box by using findElement() method and using name locator
		
		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("Pravin");
		
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Kadam");
		
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("9876543210");
		
		WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys("9876543210");
		
		WebElement address1 = driver.findElement(By.name("address1"));
		address1.sendKeys("Pune");
		
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Pune");
		
		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("Maharashtra");
		
		WebElement postalCode = driver.findElement(By.name("postalCode"));
		postalCode.sendKeys("123456");
		
		WebElement country = driver.findElement(By.name("country"));
		country.sendKeys("India");
		
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("abc@gmail.com");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("abc@123");
		
		WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
		confirmPassword.sendKeys("abc@123");
		
		WebElement wb1 = driver.findElement(By.name("submit"));
		
		wb1.click();

	}

}
