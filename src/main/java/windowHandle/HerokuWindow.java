package windowHandle;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuWindow {

	public static void main(String[] args) {
		// Initialize the Chrome driver
		WebDriver driver = new ChromeDriver();

		// Navigate to the website
		driver.get("https://the-internet.herokuapp.com/windows");

		// Get the handle of the parent window
		String parentWindow = driver.getWindowHandle();

		System.out.println("Parent window handle: " + parentWindow);

		// Click on the link to open a new window
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		// Get the handles of all windows
		Set<String> windows = driver.getWindowHandles();

		// Loop through all window handles
		for (String windowHandle : windows) {
			// If the window handle is not the parent window handle, switch to the new
			// window
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Title of the new window: " + driver.getTitle());
				System.out.println("URL of the new window: " + driver.getCurrentUrl());

				driver.switchTo().window(parentWindow);
			}
		}

		// Quit the driver
		driver.quit();
	}
}
