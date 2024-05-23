package tablePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDemo6 {


	public static void main(String[] args) throws InterruptedException {
		// step 1: connect browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// step 3: open a url
		driver.get("https://www.goibibo.com/");

		Thread.sleep(5000);
		// step 4: find and click on date object
		WebElement wb = driver.findElement(
				By.xpath("//span[text()='Departure']/following::span[@class='sc-12foipm-8 eXKWBG fswDownArrow']"));
		wb.click();
		Thread.sleep(5000);
		// step 5: run infinite loop
		while (true) {
			// capture the displayed month and year value
			WebElement monthYearWb = driver.findElement(By.xpath("(//div[@role='heading'])[1]/div"));
			String monthYearText = monthYearWb.getText();
			Thread.sleep(5000);
			// compare the captured values with expected value
			if (monthYearText.equalsIgnoreCase("April 2025")) {
				// if captured values with expected value is equal then select date and break
				// while loop.
				WebElement dateWb = driver.findElement(By.xpath("(//p[text()='22'])[1]"));
				dateWb.click();

				break;

			} else {
				// if captured values with expected value is not equal then click on next button
				WebElement nextwb = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				nextwb.click();
			}

		}

	}

}
