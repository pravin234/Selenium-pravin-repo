package AmazonWeb;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaptchaSolver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Open the webpage with CAPTCHA
        driver.get("https://www.irctc.co.in/nget/train-search");

        driver.manage().window().maximize();
        Thread.sleep(10000);

        // Click on LOGIN link
        driver.findElement(By.xpath("//a[text()=' LOGIN ']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for the popup to be visible
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-trigger ng-trigger-animation ng-tns-c19-13 ui-dialog ui-widget ui-widget-content ui-corner-all ui-shadow ui-dialog-draggable ng-star-inserted']")));

        // Enter User Name and Password
        driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys("Prk234");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("OmKar@0805");

        // Wait for CAPTCHA entry
        Thread.sleep(10000);  // Used to enter CAPTCHA value manually

        driver.findElement(By.xpath("//input[@id='loginbutton']")).click();//clicks on sign in

        Thread.sleep(2000);

        
//        // Wait for the login button to be clickable and then click it
//        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginbutton']")));
//        loginButton.click();
//        Thread.sleep(2000);

        // Perform logout action
        try {
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Logout']")));
            logoutButton.click();
            System.out.println("Logged out successfully.");
        } catch (Exception e) {
            System.out.println("Logout button not found or not clickable.");
        }

        // Close the browser
        driver.quit();
    }
}
