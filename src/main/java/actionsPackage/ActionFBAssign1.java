package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionFBAssign1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		open a fb register page https://www.facebook.com/reg
		//			enter the value in
		//			first name text, 		
		//			last name
		//			username
		//			confirm username
		//			password
		//			select date
		//			select month
		//			select year
		//			select gender

		// step 1 connect actual broswer

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2 upcasting
		WebDriver driver =new ChromeDriver();

		//open new url with get method
		driver.get("https://www.facebook.com/reg");

		WebElement wb1 = driver.findElement(By.name("firstname"));
		// create an object of action class
		Actions act = new Actions(driver);
		act.sendKeys(wb1, "Pravin").build().perform();

		//  tab and move to next element
		act.keyDown(Keys.TAB).build().perform();
		
		act.keyDown(Keys.CONTROL).sendKeys("C").build().perform();
		
		

		// now you are in lastname textbox

		act.sendKeys("Kadam").build().perform();

		// now tab and move next element 

		act.keyDown(Keys.TAB).build().perform();

		// move to next element reg email or mob number
		act.sendKeys("neeraj@gmail.com").build().perform();
		act.keyDown(Keys.TAB).build().perform();

		//confirm email 
		// move to next element reg email or mob number
		act.sendKeys("neeraj@gmail.com").build().perform();

		act.keyDown(Keys.TAB).build().perform();

		//password input
		//	    WebElement wb5  = driver.findElement(By.name("reg_passwd__"));
		act.sendKeys("neeraj@234").build().perform(); 

		act.keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.ENTER).build().perform();

		//		select date
		act.sendKeys("15").keyDown(Keys.ENTER).build().perform();
		


		// move to month dropdown and open it
		act.keyDown(Keys.TAB).keyDown(Keys.ENTER).sendKeys("Nov").keyDown(Keys.ENTER).build().perform();

		act.keyDown(Keys.TAB).keyDown(Keys.ENTER).sendKeys("1995").keyDown(Keys.ENTER).build().perform();
		//		
		//					select gender

		act.keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ARROW_UP).build().perform();

		for(int i = 0;i<=4; i++)
		{
			act.keyDown(Keys.TAB).build().perform();

		}

		act.keyDown(Keys.ENTER).build().perform();



















	}

}
