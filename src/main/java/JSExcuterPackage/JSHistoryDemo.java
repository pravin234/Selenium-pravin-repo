package JSExcuterPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSHistoryDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com");

		JavascriptExecutor js = (JavascriptExecutor)driver ;

		//capture title
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title);

		//capture Url
		String url = js.executeScript("return document.URL;").toString();
		System.out.println(url);

		Thread.sleep(5000);
		driver.quit();

	}

}
