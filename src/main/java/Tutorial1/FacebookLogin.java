package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class FacebookLogin {

	public static void main(String[] args) {
		// Set the path for ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();

		// Open Facebook login page
		driver.get("https://www.facebook.com");

		// Get the current URL and print it
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		// Find and populate email field
		WebElement emailField = driver.findElement(By.name("email"));
		emailField.sendKeys("9403739410");

		// Find and populate password field
		WebElement passField = driver.findElement(By.name("pass"));
		passField.sendKeys("234786234@Prk");

		// Find and click the login button
		WebElement loginButton = driver.findElement(By.name("login"));

		loginButton.click();

		// Wait for the dashboard page to load

		// Capture and print dashboard URL
		String dashboardUrl = driver.getCurrentUrl();
		System.out.println("Dashboard URL: " + dashboardUrl);

		// Capture and print dashboard title
		String dashboardTitle = driver.getTitle();
		System.out.println("Dashboard Title: " + dashboardTitle);

		// Remember to close the WebDriver when done
		driver.quit();
	}
}
