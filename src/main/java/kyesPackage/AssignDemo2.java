package kyesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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
		
		Thread.sleep(5000);
		act.keyUp(wb,Keys.CONTROL).build().perform();
		act.sendKeys(wb,Keys.BACK_SPACE).sendKeys(wb,Keys.BACK_SPACE).build().perform();
		

	}

}
