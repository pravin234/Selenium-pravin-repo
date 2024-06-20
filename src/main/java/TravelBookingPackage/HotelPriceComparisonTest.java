package TravelBookingPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelPriceComparisonTest {

		public static void main(String[] args) throws InterruptedException {
			 // Set system property for ChromeDriver
			 // Launch ChromeDriver
			 WebDriver driver = new ChromeDriver();
			 // Navigate to the website
			        driver.get("https://www.makemytrip.com/hotels/");
			 // Wait for the page to load
			 Thread.sleep(5000);
			 // Select worldwide search
			 WebElement worldwideSearch = driver.findElement(By.id("searchBtn"));
			        worldwideSearch.click();
			 // Wait for the search bar to appear
			 Thread.sleep(5000);
			 // Select location and date range
			 WebElement locationInput = driver.findElement(By.id("city"));
			        locationInput.sendKeys("Delhi");
			 WebElement fromDateInput = driver.findElement(By.id("checkin"));
			        fromDateInput.clear();
			        fromDateInput.sendKeys("22/06/2024");
			 WebElement toDateInput = driver.findElement(By.id("checkout"));
			        toDateInput.clear();
			        toDateInput.sendKeys("24/06/2024");
			 // Search for hotels
			 WebElement searchButton = driver.findElement(By.xpath("//button[@data-cy='submitHotels']"));
			        searchButton.click();
			 // Wait for search results to load
			 Thread.sleep(10000);
			 // Get top two hotels
			 List<WebElement> hotelCards = driver.findElements(By.xpath("//div[@class='makeFlex column']//div[@class='cardSection']"));
			 WebElement hotelCard1 = hotelCards.get(0);
			 WebElement hotelCard2 = hotelCards.get(1);
			 // Get hotel rates from search results
			 WebElement hotelRate1 = hotelCard1.findElement(By.xpath("//span[@class='ListingPrice__finalPrice']"));
			 WebElement hotelRate2 = hotelCard2.findElement(By.xpath("//span[@class='ListingPrice__finalPrice']"));
			 System.out.println("Top two hotels and their rates:");
			 System.out.println(hotelCard1.getText() + " - " + hotelRate1.getText());
			 System.out.println(hotelCard2.getText() + " - " + hotelRate2.getText());
			 // Open detail page for first hotel
			        hotelCard1.click();
			 // Wait for detail page to load
			 Thread.sleep(5000);
			 // Get rate from detail page
			 WebElement detailPageRate1 = driver.findElement(By.xpath("//div[@class='base_price_section clearfix']//span[@class='discounted_price']"));
			 // Navigate back to search results
			        driver.navigate().back();
			 // Open detail page for second hotel
			        hotelCard2.click();
			 // Wait for detail page to load
			 Thread.sleep(5000);
			 // Get rate from detail page
			 WebElement detailPageRate2 = driver.findElement(By.xpath("//div[@class='base_price_section clearfix']//span[@class='discounted_price']"));
			 // Compare rates and provide conclusion
			 if (hotelRate1.getText().equals(detailPageRate1.getText()) && hotelRate2.getText().equals(detailPageRate2.getText())) {
			 System.out.println("Rates are the same");
			 } else {
			 System.out.println("Rates are different");
			 }
			 // Close the browser
			        driver.quit();
			 }

	}

