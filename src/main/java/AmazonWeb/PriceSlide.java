package AmazonWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PriceSlide {
    public static void main(String[] args) {
        // Set up WebDriver (make sure to set the correct path to your ChromeDriver)
        WebDriver driver = new ChromeDriver();
        
        // Open Amazon India website
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        
        // Perform search (if not already on the search results page)
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("oneplus mobile");
        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchBtn.click();
        
        // Locate slider elements
        WebElement lowerBoundSlider = driver.findElement(By.id("p_36/range-slider_slider-item_lower-bound-slider"));
        WebElement upperBoundSlider = driver.findElement(By.id("p_36/range-slider_slider-item_upper-bound-slider"));
        
        // Set values using JavaScript Executor
        setSliderValue(driver, lowerBoundSlider, 0.4);  // Set lower bound to 40,000 (example value)
        setSliderValue(driver, upperBoundSlider, 0.9);  // Set upper bound to 90,000 (example value)
        
        // Click on 'Go' button to apply the filter
        WebElement goButton = driver.findElement(By.id("a-autoid-17"));
        goButton.click();
        
        // Add a delay to see the results (not recommended for production code)
        try {
            Thread.sleep(3000);  // Wait for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        // Close the browser
//        driver.quit();
    }
    
    private static void setSliderValue(WebDriver driver, WebElement slider, double value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Calculate the pixel position for the value
        int sliderWidth = slider.getSize().getWidth();
        int pixelValue = (int) (value * sliderWidth);  // Adjust this calculation based on actual slider width
        String script = "arguments[0].style.setProperty('left', '" + pixelValue + "px')";
        js.executeScript(script, slider);
    }
}
