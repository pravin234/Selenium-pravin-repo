package JSExcuterPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEXGooglePopupDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Connect browser
				// up Casting
				WebDriver driver = new ChromeDriver();

				// open a url
				driver.get("https://www.google.com");

				Thread.sleep(5000);
				// convert the WebDriver object into the JavascriptExecutor
				JavascriptExecutor js = (JavascriptExecutor) driver;

				// use executeScript() method by passing confirm('custom message');

				js.executeScript("confirm('User is on Google home Page');");

				// switch focus to alert pop or confirm pop up using driver.switchTo().alert()
				// method

				Alert alt = driver.switchTo().alert();

				// capture the alert/confirm pop physical text
				String a = alt.getText();
				System.out.println(a);
				Thread.sleep(5000);
				// click on cancel button
				alt.dismiss();

				Thread.sleep(5000);

				driver.quit();

	}

}
