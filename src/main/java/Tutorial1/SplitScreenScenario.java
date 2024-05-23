//package Tutorial1;
//
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Point;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class SplitScreenScenario {
//
//    public static void main(String[] args) {
//        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
//
//        // Initialize ChromeDriver
//        ChromeDriver driver = new ChromeDriver();
//
//        // Resize the first window to occupy the left half of the screen
//        Dimension firstWindowSize = new Dimension(700, 800);
//        driver.manage().window().setSize(firstWindowSize);
//        driver.manage().window().setPosition(new Point(0, 0));
//
//        // Navigate the first window to Google
//        driver.get("https://google.com");
//
//        // Open a new browser window
//        driver.switchTo().newWindow(WindowType.WINDOW);
//
//        // Resize the second window to occupy the right half of the screen
//        Dimension secondWindowSize = new Dimension(700, 800);
//        driver.manage().window().setSize(secondWindowSize);
//        driver.manage().window().setPosition(new Point(600, 0));
//
//        // Navigate the second window to Facebook
//        driver.get("https://www.facebook.com");
//    }
//}

package Tutorial1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;  // class lib set window location on screen
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class SplitScreenScenario {

    public static void main(String[] args) {
        // 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

        // Get the actual screen size   search on google  more info 
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        


        // upcasting
        WebDriver driver = new ChromeDriver();

        // Resize the first window to occupy the left half of the screen
        
        Dimension firstWindowSize = new Dimension(screenSize.width / 2, screenSize.height);
       
        driver.manage().window().setSize(firstWindowSize);
        driver.manage().window().setPosition(new Point(0, 0));

        // Navigate the first window to Google
        driver.get("https://google.com");

        // Open a new browser window
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Resize the second window to occupy the right half of the screen
        Dimension secondWindowSize = new Dimension(screenSize.width / 2, screenSize.height);
        driver.manage().window().setSize(secondWindowSize);
        driver.manage().window().setPosition(new Point(screenSize.width / 2, 0));

        // Navigate the second window to Facebook
        driver.get("https://www.facebook.com");
    }
}
