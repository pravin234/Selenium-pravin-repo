package TravelBookingPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GobiboHotel {
    public static void main(String[] args) {
        // Set up WebDriver (assuming ChromeDriver is in your PATH)
        WebDriver driver = new ChromeDriver();

        // Open the URL
        driver.get("https://www.goibibo.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Close the advertisement popup
        driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();

        // Click on the Hotels tab
        driver.findElement(By.xpath("//span[text()='Hotels']")).click();
        
        driver.findElement(By.xpath("//div[@data-id='dweb_pip_id']/p")).click();

        // Find and click the 'India' element to select the country
        WebElement indiaElement = driver.findElement(By.xpath("//label[@class='SearchBlockUIstyles__RadioButtonLabel-sc-fity7j-6 lmAyLO']/following::h4[text()='India']"));
        indiaElement.click();

        // Find the input element and enter the hotel name
        WebElement locationInput = driver.findElement(By.id("downshift-1-input"));
        locationInput.sendKeys("Mumbai");

        // Wait for the suggestion list to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        // Wait for the suggestion list to be visible
        WebElement suggestionList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downshift-1-menu")));
        
     

//        // Select the desired suggestion from the list by using the appropriate ID or text
//        // Update the locator based on the unique identifier or text content
//        WebElement suggestionListItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='downshift-1-item-POI53596']")));
        
        //Actions act = new Actions();
        
    }
}
