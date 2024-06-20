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

public class Goibibo {

	public void SearchFunction(String FromCity ,String ToCity,String expectedmonthYear,String date,String expectedAdults,
			String className ,String fileName					
			) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.goibibo.com/");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// first text div click
		driver.findElement(By.xpath("//span[text()='From']/following-sibling::p")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(FromCity);

		driver.findElement(By.xpath("//li[@tabindex='0']")).click();

		// To City 

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ToCity");
		driver.findElement(By.xpath("//li[@tabindex='0']")).click();

		// click on date object

		driver.findElement(By.xpath("//span[text()='Departure']/following-sibling::p[@class='sc-12foipm-4 czGBLf fswWidgetTitle']")).click();

		//use infinite while loop
		while(true)
		{
			//find the month year webelement value
			WebElement monthYearwb = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/preceding-sibling::div/child::div[@class='DayPicker-Caption']/child::div"));

			String monthYear =monthYearwb.getText();
			System.out.println(monthYear);
			if(monthYear.equals(expectedmonthYear)) {
				driver.findElement(By.xpath("//div[@class='DayPicker-Month']/preceding-sibling::div/descendant::p[text()='"+date+"']")).click();

				break;
			}
			else {

				//here if current month year not expecgted then clcik not month

				//find out web element for next button
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();


			}
		}



		// adult  first clcik on open it
		driver.findElement(By.xpath("//span[@class='sc-12foipm-8 eXKWBG fswDownArrow fswDownArrowTraveller']")).click();

		while(true) {
		    WebElement adultNumwb = driver.findElement(By.xpath("//p[text()='Adults']/parent::div/child::div/span[2]"));
		    String adultCount = adultNumwb.getText();
		    
		    System.out.println(adultCount);
		    if(adultCount.equals(String.valueOf(expectedAdults))) {
		        System.out.println(adultCount);
		        break; // Exit the loop when the condition is met
		    } else {
		        WebElement adultIncrementwb = driver.findElement(By.xpath("//p[text()='Adults']/parent::div/child::div/span[3]"));
		        adultIncrementwb.click();
		    }
		}
		
		// click on travel class 
		
		WebElement classWb = driver.findElement(By.xpath("//li[text()='"+ className +"']"));
		classWb.click();
		
		//click on done button
		
		driver.findElement(By.xpath("//a[text() ='Done']")).click();
			
		// take screenShot
		TakesScreenshot shot = (TakesScreenshot)driver ;
		File searchBarSrc = shot.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy_HHmmss");

		// use format() method by passing Date class object
		String day = simple.format(new Date());

		File searchBarDest = new File(System.getProperty("user.dir") + "\\Assign\\" + fileName+ day + ".png");
		
		FileUtils.copyFile(searchBarSrc, searchBarDest);
	
		
		Thread.sleep(5000);
		// clcik on search button 
				driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();		
			
		
		

	}
	public static void main(String[] args) throws InterruptedException, IOException {
		Goibibo obj = new Goibibo();
		obj.SearchFunction("Pune","Delhi","December 2024" ,"15" ,"3","premium economy","SearchBar");

	}

}
