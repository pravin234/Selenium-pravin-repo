package JavaPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo2 {

    public void registerFacebook(String firstname, String lastname, String email, String pass,
                                 String day, String month, String year, String gender,String screenname) throws InterruptedException, IOException {

        // connect to browser
        WebDriver driver = new ChromeDriver();

        // open url
        driver.get("https://www.facebook.com/reg");

        // Wait for elements to be available and interact with them
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement wb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
        wb.sendKeys(firstname);

        WebElement wb1 = driver.findElement(By.name("lastname"));
        wb1.sendKeys(lastname);

        WebElement wb2 = driver.findElement(By.name("reg_email__"));
        wb2.sendKeys(email);

        WebElement wb9 = driver.findElement(By.name("reg_email_confirmation__"));
        wb9.sendKeys(email);

        WebElement wb3 = driver.findElement(By.name("reg_passwd__"));
        wb3.sendKeys(pass);

        WebElement wb4 = driver.findElement(By.name("birthday_day"));
        Select sel = new Select(wb4);
        sel.selectByVisibleText(day);

        WebElement wb5 = driver.findElement(By.name("birthday_month"));
        Select sel1 = new Select(wb5);
        sel1.selectByVisibleText(month);

        WebElement wb6 = driver.findElement(By.name("birthday_year"));
        Select sel3 = new Select(wb6);
        sel3.selectByVisibleText(year);

        // Select radio button 1 st way 
//        WebElement wb7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Male']//following::input[@value='2']")));
//
//        // Scroll to the element
//        JavascriptExecutor js =  (JavascriptExecutor)driver;
//        .executeScript("arguments[0].scrollIntoView(true);", wb7);
//
//        // Click the element using JavaScript
//        js.executeScript("arguments[0].click();", wb7);
        
        WebElement wb7 =driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input[@value='2']"));
        wb7.click();

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "\\Screenshot\\"+ screenname);
        FileUtils.copyFile(src, dest);

        Thread.sleep(5000);
        driver.quit();
        
        
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Demo2 obj = new Demo2();
        obj.registerFacebook("pravin", "kadam", "pravin@gmail.com", "pravin@1234", "23", "Apr", "1995", "2","pqr.png");
    }
}
