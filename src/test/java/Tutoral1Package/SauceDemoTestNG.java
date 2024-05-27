package Tutoral1Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SauceDemoTestNG {

	//	Sauce Demo application
	//	- Test case 1
	//						open a  browser and url
	//	- test cases 2
	//						login  functionality
	//	Test cases 3
	//						add product to cart and click on cart container
	//						click on continue button
	//	test cases 4
	//						Enter personal information
	//						and click on continue
	//
	//	test cases 5;
	//						click on finish button
	//						capture order message


	WebDriver driver;
	@Test(priority=1)
	public void connectBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@Test(priority=2)
	public void Login()  {
		System.out.println();

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}
	
	@Test(priority=3)
	public void addToCart()
	{
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
			driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
			
			driver.findElement(By.id("checkout")).click();
	}

	@Test(priority=4)
	public void enterPersonalInformation() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.id("first-name")).sendKeys("Pravin");
		driver.findElement(By.id("last-name")).sendKeys("Kadam");
		driver.findElement(By.id("postal-code")).sendKeys("411034");
		driver.findElement(By.id("continue")).click();
	}

	@Test(priority=5)
	public void captureOrderDetails()
	{
		driver.findElement(By.id("finish")).click();
		String a = driver.findElement(By.id("//h2[@class='complete-header']")).getText();
	}

}
