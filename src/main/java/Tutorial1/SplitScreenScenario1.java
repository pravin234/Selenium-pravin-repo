package Tutorial1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class SplitScreenScenario1 {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

        // Get the actual screen size
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Resize the first window to occupy the left half of the screen
        Dimension firstWindowSize = new Dimension(screenSize.width / 2, screenSize.height);
        driver.manage().window().setSize(firstWindowSize);
        driver.manage().window().setPosition(new Point(0, 0));

        // Navigate the first window to Google using different navigation methods
        driver.get("https://google.com");
        driver.navigate().to("https://google.com"); // Navigating to the same URL
        driver.navigate().back(); // Navigating back to the previous page

        // Open a new browser window
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Resize the second window to occupy the right half of the screen
        Dimension secondWindowSize = new Dimension(screenSize.width / 2, screenSize.height);
        driver.manage().window().setSize(secondWindowSize);
        driver.manage().window().setPosition(new Point(screenSize.width / 2, 0));

        // Navigate the second window to Facebook using the same navigation methods
        driver.get("https://www.facebook.com");
        driver.navigate().to("https://www.amazon.com"); 
        Thread.sleep(5000);
        
//        driver.manage().window().fullscreen();
        
        driver.navigate().back(); // Navigating back to the previous page
    }
}
