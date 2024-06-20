package TravelBookingPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip1 {


	public void SearchFlight(String FromCity, String ToCity,String ExpectedMonthYear , String Day,String adultTraveller,String Ticketclass) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		// Open URL
		driver.get("https://www.makemytrip.com/");

		// Apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Maximize window
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement notificationFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[starts-with(@title, 'notification-frame')]")));
		driver.switchTo().frame(notificationFrame);

		
		WebElement closeNotificationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='wewidgeticon we_close']")));
		closeNotificationButton.click();
		

		// Switch back to the default content
		driver.switchTo().defaultContent();
		
		
		WebElement closeModalButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']")));
		closeModalButton.click();


//		// Interact with fromCity field
//		System.out.println(FromCity);
//		WebElement fromCity = wait.until(ExpectedConditions.elementToBeClickable(By.id("fromCity")));
//		fromCity.click();
//		fromCity.sendKeys(FromCity);
//		
//		Thread.sleep(5000);
//		
//		WebElement suggestionClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-autowhatever-1-section-0-item-0")));
//		suggestionClick.click();
//
//		// Interact with toCity field
//		System.out.println(ToCity);
//		
//		WebElement toCity = wait.until(ExpectedConditions.elementToBeClickable(By.id("toCity")));
//		toCity.click();
//		toCity.sendKeys(ToCity);
//		Thread.sleep(5000);
//		
//		WebElement suggestionToClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-autowhatever-1-section-0-item-0")));
//		suggestionToClick.click();
		
		// Interact with fromCity field
		   WebElement fromCityInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
	        fromCityInput.click();

	        // Enter the city name
	        fromCityInput.sendKeys(FromCity);

	        // Wait for the suggestions dropdown to be visible
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-autowhatever-1']")));

	        // Select the first suggestion from the suggestions
	        WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='react-autowhatever-1']//li)[1]")));
	        firstSuggestion.click();

		// Select the first suggestion
		WebElement suggestionClick = driver.findElement(By.xpath("//ul[@id='react-autowhatever-1-section-0-item-0']"));
		suggestionClick.click();

		
		// Interact with toCity field
		WebElement toCity = wait.until(ExpectedConditions.elementToBeClickable(By.id("toCity")));
		toCity.sendKeys(ToCity);
		toCity.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='react-autowhatever-1']")));

		// Select the first suggestion
		WebElement suggestionToClick = driver.findElement(By.xpath("//ul[@id='react-autowhatever-1-section-0-item-0']"));
		suggestionToClick.click();


		// Select the date
		while (true) {
			WebElement monthYearWb = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/preceding-sibling::div/child::div[@class='DayPicker-Caption']/child::div"));
			String monthYear = monthYearWb.getText();
			if (monthYear.equals(ExpectedMonthYear)) {
				WebElement day = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/preceding-sibling::div/descendant::p[text()='"+Day+"']"));
				day.click();
				break;
			} else {
				WebElement nextBtn = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				nextBtn.click();
			}
		}

		// Select number of travelers
		WebElement travelerButton = driver.findElement(By.xpath("//span[text()='Travellers & Class']"));
		travelerButton.click();

		WebElement adultBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-cy='adults-4']")));
		adultBtn.click();

		int adult = Integer.parseInt(adultTraveller);

		for (int i = 1; i <= adult; i++) {
			String val = "adults-" + i;
			
			WebElement adultsBtn = driver.findElement(By.xpath("//li[@data-cy='" + val + "']"));
			adultsBtn.click();
		}

		
		
		if (Ticketclass.equalsIgnoreCase("Business")) {
		    WebElement classSelect = driver.findElement(By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/child::li[2]"));
		    classSelect.click();  // Assuming clicking the list item selects the option
		} else if (Ticketclass.equalsIgnoreCase("Economy/Premium Economy")) {
		    WebElement classSelect = driver.findElement(By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/child::li[1]"));
		    classSelect.click();  // Indices updated to 1-based
		} else if (Ticketclass.equalsIgnoreCase("Premium Economy")) {
		    WebElement classSelect = driver.findElement(By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/child::li[3]"));
		    classSelect.click();  // Assuming Premium Economy is the third item
		}

//		WebElement applyBtn = driver.findElement(By.linkText("APPLY"));
		
		WebElement applyButton = driver.findElement(By.xpath("//div[@class='fltTravellers gbTravellers']/div[2]/child::button"));

		applyButton.click();
		
driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn '][text()='Search']")).click();
	
		// Close the driver
	}


	public static void main(String[] args) throws InterruptedException {
		MakeMyTrip1 travel = new MakeMyTrip1();
		travel.SearchFlight("Pune","Delhi","July 2024","22","4","Business");
	}

}
