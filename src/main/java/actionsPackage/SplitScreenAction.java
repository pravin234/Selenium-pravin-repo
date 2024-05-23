package actionsPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SplitScreenAction {

    public static void main(String[] args) {
        // Instantiate ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the first window and maximize it
        driver.get("https://www.example.com");
        driver.manage().window().maximize();

        // Open a new window using keyboard shortcut (Ctrl + N)
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).sendKeys("n").keyUp(Keys.CONTROL).perform();

        // Switch to the new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Navigate to a different website (e.g., Wikipedia)
        driver.get("https://www.wikipedia.org");
        driver.manage().window().maximize();

        // Perform actions to align windows (Left half and Right half)
        act.keyDown(Keys.CONTROL).sendKeys(Keys.LEFT).keyUp(Keys.CONTROL).perform();
        act.keyDown(Keys.CONTROL).sendKeys(Keys.RIGHT).keyUp(Keys.CONTROL).perform();
    }
}
