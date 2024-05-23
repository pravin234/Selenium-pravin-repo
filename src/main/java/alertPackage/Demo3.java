package alertPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		// step 3: open a url
		driver.get("https://demoqa.com/alerts");

		Thread.sleep(5000);
		// step 4: find the click me button
		WebElement wb = driver.findElement(By.id("alertButton"));

		// step 5: click on click me button
		wb.click();

		// step 6: switch focus to alert pop up window
		Alert alt = driver.switchTo().alert();

		/// step 7: capture the alert pop up physical text
		String a = alt.getText();
		System.out.println(a);

		Thread.sleep(5000);

		// step 8: click on ok button
		alt.accept();
		
		Thread.sleep(5000);
		
		// for second click window 
		
		// step 4: find the click me button
		WebElement wb2 = driver.findElement(By.id("timerAlertButton"));

		// step 5: click on click me button
		wb2.click();
		
		Alert alt2 = driver.switchTo().alert();
		
		String b = alt2.getText();
		System.out.println(b);
		
		alt2.accept();

		//for third button click 
		System.out.println("3rd ");
		WebElement wb3 = driver.findElement(By.id("confirmButton"));

		//  click on click me button
		wb3.click();

		Alert alt3 = driver.switchTo().alert();

		String c = alt3.getText();
		System.out.println(c);

		// Accepting the confirmation dialog by clicking OK
		alt3.accept();
		Thread.sleep(5000);
		
		


		
		
	}

}
