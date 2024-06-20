package TravelBookingPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {

		// open browser
		// upcasting
		WebDriver driver = new ChromeDriver();

		// window maxmize
		driver.manage().window().maximize();

		//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get("https://www.spicejet.com/");

		// from
		driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input")).sendKeys("Mumbai");

		// To
		WebElement dest = driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input"));
		dest.clear();
		dest.sendKeys("Delhi");
		// dest.findElement(By.xpath("//div[text()='All
		// Cities']/parent::div/following::div[@class='css-76zvg2 r-12rm3iy r-ubezar'
		// and contains(text(),'Bengaluru')]")).click();

		Thread.sleep(2000);
		WebElement calender = driver.findElement(By.xpath("//div[text()='Departure Date']"));
		calender.click();
		while (true) {
			WebElement monthElement = driver.findElement(By.xpath(
					"//div[@data-testid='undefined-calendar-picker']/descendant::div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79'][1]"));
			String monthText = monthElement.getText();
			System.out.println(monthText);
		}

	}

}


//driver.findElement(By.xpath("//div[@data-testid='undefined-month-August-2024']")).click();

		// driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-day-4']")).click();

		// driver.findElement(By.xpath("//div[text()='Search Flight']")).click();

