package Tutorial1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ElectionVoterDemo {

    public static void main(String[] args) throws InterruptedException {
        // Setting the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

        // Creating upcasting  object
        WebDriver driver = new ChromeDriver();

        // Opening the URL
        driver.get("https://electoralsearch.eci.gov.in/");

        Thread.sleep(4000);
        
        // Finding the dropdown element by its ID
        WebElement wb = driver.findElement(By.id("KeyboardID"));

        
        // Creating a Select object to work with the dropdown
        Select selectDropdown = new Select(wb);

        // Getting all options from the dropdown
        List<WebElement> options = selectDropdown.getOptions();

        
        
        // Printing the text and values of each option
        for (WebElement option : options) {
        	
            System.out.println("Text: " + option.getText() + ", Value: " + option.getAttribute("value"));
        }


        driver.quit();
    }
}
