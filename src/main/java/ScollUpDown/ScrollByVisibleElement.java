package ScollUpDown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollByVisibleElement {

    WebDriver driver;
    @Test
    public void ByVisibleElement() {

        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launch the application		
        driver.get("http://demo.guru99.com/test/guru99home/");
        
        driver.manage().window().maximize();

        //Find element by link text and store in variable "Element"        		
        WebElement wb = driver.findElement(By.xpath("//label[@class='previewLabel']"));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", wb);
        
        
        //Find element by link text and store in variable Demo site     		
        WebElement wb1 = driver.findElement(By.xpath("//a[text()='Demo Site']"));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", wb1);
        
        
        
    }
}