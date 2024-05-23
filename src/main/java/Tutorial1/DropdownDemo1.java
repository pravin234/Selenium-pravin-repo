package Tutorial1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

        // Creating a WebDriver object
        WebDriver driver = new ChromeDriver();

        // Opening the URL
        driver.get("https://www.facebook.com/reg");

        // Capturing URL and title
        String currentUrl = driver.getCurrentUrl();
        String currentTitle = driver.getTitle();

        // Printing URL and title
        System.out.println("Welcome to the Election Commission portal: " + currentUrl + " - Title: " + currentTitle);

        // Finding the dropdown element by its name
        WebElement dayDropdown = driver.findElement(By.name("birthday_day"));
        WebElement monthDropdown = driver.findElement(By.name("birthday_month"));
        WebElement YearDropdown = driver.findElement(By.name("birthday_year"));

        // Creating a Select object to work with the dropdown
        Select selectDay = new Select(dayDropdown);
        Select selectMonth = new Select(monthDropdown);
        Select selectYear = new Select(YearDropdown);
        

        // Getting all options from the dropdown
        List<WebElement> options = selectDay.getOptions();
        
        List<WebElement> options2 = selectMonth.getOptions();
        List<WebElement> options3 = selectYear.getOptions();

        // Printing the text of each option
        System.out.println("Day  option ");
     
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        Thread.sleep(3000);
        
        System.out.println("Month  option ");
        
        for (WebElement option : options2) {
            System.out.println(option.getText());
        }
        
        System.out.println("Year  option ");
        Thread.sleep(3000);
        
        for (WebElement option : options3) {
            System.out.println(option.getText());
        }
		
		
		

	}

}
