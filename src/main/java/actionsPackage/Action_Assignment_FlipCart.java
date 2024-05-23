package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Assignment_FlipCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Open a https://www.flipkart.com/
		//mouse over on Electronics
		//mouse over on Laptop and Desktop
		//and click on Laptop
		//Mouse on Login button
		//click on SignUp link

		//connect to the actual browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		//upcasting
		//	WebDriver driver =new ChromeDriver();

		//   FireFox driver
		//		System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\ABC\\Documents\\browserExternsion\\geckodriver.exe");
		//		WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.edge.driver", "C:\\Users\\ABC\\Documents\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();




		//open new url with get method

		driver.get("https://www.flipkart.com/");

		//find the  Electronics icon
		WebElement wb= driver.findElement(By.xpath("//img[@ class='_2puWtW _3a3qyb'][@ alt='Electronics']"));


		//create Object of Actions class by passing WebDriver instance

		Actions act=new Actions(driver);

		//use moveToElement() by passing WebElement from Actions class 

		act.moveToElement(wb).build().perform();

		//find the object laptop and Desktop

		WebElement wb1=driver.findElement(By.xpath("//a[@text()='Laptop and Desktop']"));
		act.moveToElement(wb1).build().perform();

		//find the element and click on laptop 
		WebElement wb2=driver.findElement(By.xpath("//a[@class='_3490ry'][text()='Laptops']"));
		wb2.click();

		//find the login button and mouse on login button

		WebElement wb3=driver.findElement(By.xpath("//a[]@text()='Login']"));

		act.moveToElement(wb3).build().perform();

		//find and click on sign up button

		WebElement wb4=driver.findElement(By.xpath("//div[text()='sign up']"));

		wb4.click();



	}

}
