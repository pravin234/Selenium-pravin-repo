package windowHandle;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandleAssignment1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		//		Ass 1:
		//			open https://prafpawar11.github.io/multiplewindows.html
		//			enter value in first name text box
		//			take screenshot
		//			click on sauce demo link
		//						enter valid credential	
		//						take screenshot
		//						add 3 products in add to cart
		//						click on add to container
		//						take screenshot
		//						click on checkout
		//						enter first name, last name and pincode and click on continue
		//						click on finish
		//						take screenshot
		//			switch focus to main window
		//			enter lastname
		//			take screenshot
		//			click on cogmento CRM Link link
		//						enter valid credentials 					prafulp1010@gmail.com		Pr@ful0812
		//						take screenshot
		//						click on contact links
		//						click on create button
		//						enter firstname, last name , select status as on Hold,  click on do not call toggle switch
		//						take screenshot and click on save button
		//						delete the created user
		//						click on logout
		//
		//			switch focus to main window
		//			take screenshot


		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		//open url 
		driver.get("https://prafpawar11.github.io/multiplewindows.html");

		// capture the parent windowid

		String parentWindowID = driver.getWindowHandle();
		System.out.println(parentWindowID);
		System.out.println("");

		// find and enter values in first name text box
		driver.findElement(By.name("fname")).sendKeys("Pravin");

		Thread.sleep(5000);

		// take Screenshot downcasting and  take  capture screenshot

		TakesScreenshot ts = (TakesScreenshot)driver;

		File src1 = ts.getScreenshotAs(OutputType.FILE);
//		File dsc1 = new File("C:\\Users\\ABC\\Desktop\\Automationn\\screenshot\file123.jpg");

		// now create destination of screenshot  passing project folder name as assignScreeshot
		
		File dsc1 = new File(System.getProperty("user.dir")+"\\assignScreeshot\\a1.jpg");

		FileUtils.copyFile(src1, dsc1);

		//click on sauce demo link find path using link text

		driver.findElement(By.linkText("SauceDemo Link")).click();

		//

		Set<String> allWindowsId = driver.getWindowHandles();

		// use enhance loop  using loop find  all window id and match new window id
		String saucedemoId = null;
		for(String abc : allWindowsId) {
			if(!abc.equals(parentWindowID)) {
				saucedemoId = abc;
			}
		}

		// swithc to new window 

		driver.switchTo().window(saucedemoId);


		driver.findElement(By.name("user-name")).sendKeys("standard_user");

		driver.findElement(By.name("password")).sendKeys("secret_sauce");

		File src2 = ts.getScreenshotAs(OutputType.FILE);

		// now create destination of screenshot  passing project folder name as assignScreeshot
		File dsc2 = new File(System.getProperty("user.dir")+"\\assignScreeshot\\shot2.jpg");

		FileUtils.copyFile(src2, dsc2);

		driver.findElement(By.name("login-button")).click();

		Thread.sleep(2000);

		//add 3 products in add to cart
		//Sauce Labs Backpack ,-bolt-t-shirt,
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();

		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		//click on checkout
		driver.findElement(By.name("checkout")).click();
		Thread.sleep(2000);

		//enter first name, last name and pincode and click on continue
		driver.findElement(By.name("firstName")).sendKeys("pravin R");
		driver.findElement(By.name("lastName")).sendKeys("Kadam");
		driver.findElement(By.name("postalCode")).sendKeys("411045");
		Thread.sleep(5000);

		driver.findElement(By.name("continue")).click();
		driver.findElement(By.name("finish")).click();

		File src3 = ts.getScreenshotAs(OutputType.FILE);

		// now create destination of screenshot  passing project folder name as assignScreeshot
		File dsc3 = new File(System.getProperty("user.dir")+"\\assignScreeshot\\finalOrder.jpg");

		FileUtils.copyFile(src3, dsc3);

		Thread.sleep(6000);

		//switch focus to main window

		driver.switchTo().window(parentWindowID);
		driver.findElement(By.name("lname")).sendKeys("Kadam");

		//take screenshot

		File src4 = ts.getScreenshotAs(OutputType.FILE);

		// now create destination of screenshot  passing project folder name as assignScreeshot
		File dsc4 = new File(System.getProperty("user.dir")+"\\assignScreeshot\\screen4.jpg");

		FileUtils.copyFile(src4, dsc4);

		Thread.sleep(5000);



		//click on cogmento CRM Link link



		driver.findElement(By.xpath("//a[text()='cogmento CRM Link']")).click();

		Set<String> allWindowsId2 = driver.getWindowHandles();

		// use enhance loop  using loop find  all window id and match new window id
		String CogmentoWindowId = null;
		for(String abc1 : allWindowsId2) {
			if(!abc1.equals(parentWindowID) || !abc1.equals(saucedemoId)) {
				CogmentoWindowId = abc1;
			}
		}


		driver.switchTo().window(CogmentoWindowId);
		//enter valid credentials
		Thread.sleep(2000);

		//enter valid credentials 	pravinkadam234@gmail.com		password Pravin@234

		//		driver.findElement(By.name("email")).sendKeys("pravinkadam234@gmail.com");
		//		driver.findElement(By.name("password")).sendKeys("Pravin@234");
		//		driver.findElement(By.xpath("//div[@class=\"ui fluid large blue submit button\"]")).click();
		//		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pravinkadam234@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pravin@234");
		driver.findElement(By.xpath("//Div[text()='Login']")).click();

		//take screenshots
		File src5 = ts.getScreenshotAs(OutputType.FILE);
		// now create destination of screenshot  passing project folder name as assignScreeshot
		File dsc5 = new File(System.getProperty("user.dir")+"\\assignScreeshot\\cogmentoscreenshot.jpg");

		FileUtils.copyFile(src5, dsc5);

		Thread.sleep(5000);


		//click on contact links inside sidebar and add(+) button click
		//Action class object create and pass instance of webdriver
		Actions act = new Actions(driver);

		WebElement contact=driver.findElement(By.xpath("//a[@href='/contacts']"));
		act.moveToElement(contact);
		driver.findElement(By.xpath("//a[@href='/contacts']//span[text()='Contacts']")).click();

		//click on create button
		driver.findElement(By.xpath("//button[@class='ui linkedin button']//following::button[text()='Create']")).click();

		//enter firstname, last name , select status as on Hold,  click on do not call toggle switch
		driver.findElement(By.name("first_name")).sendKeys("Ravina");
		driver.findElement(By.name("last_name")).sendKeys("Kadam");

		WebElement wb = driver.findElement(By.xpath("//div[@name='status'][@class='ui selection dropdown']"));
		Actions act1 = new Actions(driver);
		act1.click(wb).build().perform();	

		act1.keyDown(Keys.ARROW_DOWN)
		.keyDown(Keys.ARROW_DOWN)
		.keyDown(Keys.ARROW_DOWN)
		.keyDown(Keys.ARROW_DOWN)
		.keyDown(Keys.ENTER).build().perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Do not Call'])[2]")).click();		


		driver.findElement(By.xpath("//button[@class=\"ui linkedin button\"][text()='Save']")).click();

		//take screenshot and click on save button

		File src6 = ts.getScreenshotAs(OutputType.FILE);

		// now create destination of screenshot  passing project folder name as assignScreeshot

		File dsc6 = new File(System.getProperty("user.dir")+"\\assignScreeshot\\UserAddscreenshot.jpg");

		FileUtils.copyFile(src6, dsc6);


		Thread.sleep(5000);		
		//delete the created user
		driver.findElement(By.xpath("//i[@class='trash icon']")).click();
		driver.findElement(By.xpath("//button[@class='ui red button']")).click();

		Thread.sleep(4000);

		//click on logout
		driver.findElement(By.xpath("//div[@role='listbox']")).click();
		driver.findElement(By.xpath("//span[text()='Log Out']")).click();

		//switch focus to main window
		driver.switchTo().window(parentWindowID);




	}

}
