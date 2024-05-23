package kyesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShiftDemo1 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		//upcasting
		WebDriver driver =new ChromeDriver();
		//open new url with get method

		driver.get("https://www.facebook.com/reg");
		
		WebElement wb = driver.findElement(By.name("firstname"));
		wb.sendKeys("pravin");
		
		//create an action obj 
		Actions act = new Actions(driver);
		
		
	
		
		// 
//		act.keyDown(Keys.SHIFT).sendKeys(w)

	
	}

}
