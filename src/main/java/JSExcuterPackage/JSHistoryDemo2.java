package JSExcuterPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSHistoryDemo2 {

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

		driver.navigate().to("https://www.amazon.com");

		Thread.sleep(5000);
		driver.navigate().to("https://www.flipkart.com/");

		Thread.sleep(5000);
		driver.navigate().to("https://www.youtube.com");

		Thread.sleep(5000);

		js.executeScript("history.go(-1);");
		driver.quit();

	}

}
