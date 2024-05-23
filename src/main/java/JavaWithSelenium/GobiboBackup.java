package JavaWithSelenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GobiboBackup {

	public void SearchFunction(String FromCity ,String ToCity,String expectedmonthYear,String date,String expectedAdults,
	        String className ,String fileName) throws InterruptedException, IOException {

	WebDriver driver = new ChromeDriver();
		
		//open a url
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		//maximize the window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//add wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Find from City Elementby using findElement() method
		WebElement wb = driver.findElement(By.xpath("//span[text()='From']/following-sibling::p"));
		wb.click();
		
		WebElement wb1 = driver.findElement(By.xpath("//input[@type='text']"));
		wb1.sendKeys(FromCity);
		
		driver.findElement(By.xpath("//li[@tabindex='0']")).click();
		
		//find tocity textbox
		
		WebElement wb2 =driver.findElement(By.xpath("//input[@type='text']"));
		wb2.sendKeys(ToCity);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//li[@tabindex='0']")).click();
		
		//find date object
		driver.findElement(By.xpath("//span[text()='Departure']/following-sibling::p[@class='sc-12foipm-4 czGBLf fswWidgetTitle']")).click();
	
	    // Select the number of adults
	    WebElement adultCounter = driver.findElement(By.xpath("//p[text()='Adults']/parent::div/child::div/span[2]"));
	    while(true) {
	        String adultCount = adultCounter.getText();
	        if(adultCount.equals(expectedAdults)) {
	            break;
	        } else {
	            WebElement adultIncrementwb = driver.findElement(By.xpath("//p[text()='Adults']/parent::div/child::div/span[3]"));
	            adultIncrementwb.click();
	        }
	    }

	    // Select travel class
//	    WebElement classWb = driver.findElement(By.xpath("//li[text()='"+ className +"']"));
//	    classWb.click();

	    // Click on Done button
	    driver.findElement(By.xpath("//a[text() ='Done']")).click();

	    // Take screenshot of the search bar
	    TakesScreenshot shot = (TakesScreenshot)driver;
	    File searchBarSrc = shot.getScreenshotAs(OutputType.FILE);
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File searchBarDest = new File(System.getProperty("user.dir") + "\\Assign\\" + fileName + timestamp + ".png");
	    FileUtils.copyFile(searchBarSrc, searchBarDest);

	    // Click on the search button
	    driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();

	    // Wait for the search page to load completely
	   // wait.until(ExpectedConditions.urlContains("https://www.goibibo.com/flights/"));
	   

	    
	   // Thread.sleep(5000);
	    
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//	    wait.until(ExpectedConditions.urlContains("https://www.goibibo.com/flights/"));

        // Capture URL and title
        String currentURL = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("Current URL: " + currentURL);
        System.out.println("Title: " + title);

        // Take screenshot of the search results page
        File searchResultsSrc = shot.getScreenshotAs(OutputType.FILE);
        File searchResultsDest = new File(System.getProperty("user.dir") + "\\Assign\\" + "SearchResults.png");
        FileUtils.copyFile(searchResultsSrc, searchResultsDest);

	    // Close the browser
	    driver.quit();

	}
	public static void main(String[] args) throws InterruptedException, IOException {
		Goibibo obj = new Goibibo();
		obj.SearchFunction("Mumbai","New Delhi","June 2024" ,"8" ,"7","economy","SearchBar");

	}

}
