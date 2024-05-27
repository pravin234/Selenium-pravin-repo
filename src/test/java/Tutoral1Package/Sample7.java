package Tutoral1Package;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample7 {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// connect browser
		//System.setProperty("webdriver.chrome.driver",
				//"C:\\Users\\praf0\\OneDrive\\Desktop\\Automation Testing 27th April 2024 Batch\\chromedriver.exe");
		// up casting
		driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// maximize
		driver.manage().window().maximize();

	}

	@Test
	public void google() {
		// open a google application
		driver.get("https://www.google.com");
		// capture title
		System.out.println(driver.getTitle());
	}

	@Test
	public void facebook() {
		// open a facebook application
		driver.get("https://www.facebook.com");
		// capture title
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		// quit browser
		driver.quit();
	}


}
