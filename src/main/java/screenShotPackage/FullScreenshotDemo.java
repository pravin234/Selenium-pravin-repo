package screenShotPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FullScreenshotDemo {

	public static void main(String[] args) throws IOException {
		// Set the path to the chromedriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://github.com/rest-assured/rest-assured/wiki/Usage");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Create an AShot object with viewportPasting strategy
		AShot aShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000));

		// Take screenshot
		Screenshot screenshot = aShot.takeScreenshot(driver);

		// Get the BufferedImage
		BufferedImage image = screenshot.getImage();

		// Define the destination file path
		File destinationFile = new File(System.getProperty("user.dir") + "\\PassScreenshot\\p2.png");
		

		// Write the image to file
		ImageIO.write(image, "PNG", destinationFile);

		// Close the browser
		driver.quit();
	}
}
