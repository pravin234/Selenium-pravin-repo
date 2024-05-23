package kyesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// scenario 
		// enter the texbox firstname value 
		// select enter value  and control + A 
		//cop text from name textbox
		// tab from firstname to lastname
		//paste inside lastname
		// connect to actual broser
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		//upcasting
		WebDriver driver =new ChromeDriver();
		//open new url with get method

		driver.get("https://www.facebook.com/reg");
		
		// find webelements 
		WebElement wb = driver.findElement(By.name("firstname"));
		
		// crete an actions class object passing parmeter driver instance varible
		Actions act = new Actions(driver);
		
		//enter the value in textbox
		act.sendKeys(wb,"pravin").build().perform();
		
		// select all text inside textbox
		act.keyDown(Keys.CONTROL).sendKeys("A").build().perform();
		
		//copy the text 
		act.keyDown(Keys.CONTROL).sendKeys("C").build().perform();
		
		act.keyUp(Keys.CONTROL).build().perform();
		//tab
		
		act.keyDown(Keys.TAB).build().perform();
		
		act.keyDown(Keys.CONTROL).sendKeys("V").build().perform();
		
		
		
	    
		
	

	}

}
