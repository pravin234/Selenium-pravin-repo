package JSExcuterPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXFBPopupDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//		open a fb application
		//		generate alert pop up
		//		handle alert pop up

		WebDriver driver = new ChromeDriver();

		// open a url
		driver.get("https://www.facebook.com/reg");

		Thread.sleep(5000);

		JavascriptExecutor  js = (JavascriptExecutor )driver;

		js.executeScript("alert('User is on facebook Register page');");

		// switch focus to alert pop up by using switchTo().alert() method

		Alert alt = driver.switchTo().alert();

		// capture the physical text in alert pop uo
		String a = alt.getText();
		System.out.println(a);

		Thread.sleep(5000);
		// click on ok button
		alt.accept();

		Thread.sleep(5000);

		driver.quit();




	}

}
