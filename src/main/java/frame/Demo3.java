package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//		Scenario 3:
		//			open a url https://prafpawar11.github.io/frame.html
		//			find the name text box and enter the name
		//			find address text box and enter the address
		//			find the cucumber check box and select
		//
		//			capture the entered address
		//			and enter new address
		//
		//			capture the enter name and clear the name
		//			unselect the cucumber checkbox

		// step 1: connect to the actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		// step 3: open a url
		driver.get("https://prafpawar11.github.io/frame.html");

		Thread.sleep(5000);
		// step 4:find the full name text box and enter the values
		WebElement wb = driver.findElement(By.id("name"));
		wb.sendKeys("abc xyz");

		// step 5: switch focus address frame
		driver.switchTo().frame("mainframe");

		// step 6: find the address text box and enter the values
		WebElement wb1 = driver.findElement(By.id("add"));
		wb1.sendKeys("Pune");
		Thread.sleep(5000);
		// step 7: switch focus to checkbox frame
		driver.switchTo().frame("child1");

		// step 8: find the Cucumber checkbox and click on it
		WebElement wb2 = driver.findElement(By.id("Cucumber"));
		wb2.click();

		// step 9: switch focus to address frame
		//				driver.switchTo().defaultContent();
		//				driver.switchTo().frame("mainframe");
		// or
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		// step 10: capture the entered addres and enter new address
		String a = wb1.getAttribute("value");
		System.out.println(a);
		wb1.clear();
		wb1.sendKeys("Mumbai");

		// step 11: switch focus to top frame
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		// step 12:capture the entered text and clear it
		String b = wb.getAttribute("value");
		System.out.println(b);
		wb.clear();

		Thread.sleep(5000);
		// step 13: switch focus to address frame
		driver.switchTo().frame(0);

		// step 14: switch focus to checkbox frame
		driver.switchTo().frame(0);

		// step 15: unselect the checkbox
		wb2.click();

	}

}
