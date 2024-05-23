package alertPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Connecting to Actual browser

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// Upcasting

		WebDriver driver = new ChromeDriver();

		// maximize window size

		driver.manage().window().maximize();

		// Open url in browser

		driver.get("https://demoqa.com/alerts");

		// find button using findElement

		System.out.println("1");

		WebElement wb = driver.findElement(By.id("promtButton")); 

		System.out.println("2");

		// click on button

		wb.click();

		System.out.println("3");

		// wait 4 sec

		Thread.sleep(4000);

		Alert alt = driver.switchTo().alert();

		alt.sendKeys("Automation");

		System.out.println("4");


		alt.dismiss();

		String a =alt.getText();
		//
		System.out.println("Alert Pop up Message: "+a);

		// wait 4 sec

		Thread.sleep(4000);

		// close all window

		driver.quit();



	}

}
