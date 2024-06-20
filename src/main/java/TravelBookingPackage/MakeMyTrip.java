package TravelBookingPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class MakeMyTrip {

	public void SearchFlight(String FromCity, String ToCity, String ExpectedMonthYear, String Day, String adultTraveller, String childrenTraveller, String Ticketclass) throws InterruptedException, IOException {
		// Ensure the 'From' and 'To' cities are different
		if (FromCity.equalsIgnoreCase(ToCity)) {
			System.out.println("From and To cities must be different.");
			return;
		}

		// Set up ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Open URL
		driver.get("https://www.makemytrip.com/");

		driver.manage().window().maximize();
		
		Thread.sleep(5000);

//		// Handle potential notification and modal dialogs 
//		WebElement closeModalButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']")));
//		
//		closeModalButton.click();
		
		// Handle potential notification and modal dialogs
        try {
            WebElement notificationFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[starts-with(@title, 'notification-frame')]")));
            driver.switchTo().frame(notificationFrame);
            WebElement closeNotificationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='wewidgeticon we_close']")));
            closeNotificationButton.click();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            // No notification frame found, continue execution
            driver.switchTo().defaultContent();
        }

        try {
            WebElement closeModalButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']")));
            closeModalButton.click();
        } catch (Exception e) {
            // No modal found, continue execution
        }



		// Interact with the "From" city input field
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		WebElement fromCityInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
		fromCityInput.sendKeys(FromCity);
		
		WebElement suggestionsList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-autosuggest__suggestions-list")));
		
		WebElement cityOption = suggestionsList.findElement(By.xpath("//li//span[contains(text(), '" + FromCity + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(cityOption)).click();

		// Interact with the "To" city input field
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		
		WebElement toCityInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
		toCityInput.sendKeys(ToCity);
		WebElement suggestionsToList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-autosuggest__suggestions-list")));
		WebElement toCityOption = suggestionsToList.findElement(By.xpath("//li//span[contains(text(), '" + ToCity + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(toCityOption)).click();

		// Departure date picker
		while (true) {
			WebElement monthYearWb = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/preceding-sibling::div/child::div[@class='DayPicker-Caption']/child::div"));
			String monthYear = monthYearWb.getText();
			if (monthYear.equals(ExpectedMonthYear)) {
				WebElement day = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/descendant::p[text()='" + Day + "']"));
				wait.until(ExpectedConditions.elementToBeClickable(day)).click();
				break;
			} else {
				WebElement nextBtn = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
			}
		}

		// Select number of travelers  
		WebElement travelerButton = driver.findElement(By.xpath("//span[text()='Travellers & Class']"));
		travelerButton.click();

//		int adult = Integer.parseInt(adultTraveller);
		
//		for (int i = adult; i <= adult; i++) {
//			String val = "adults-" + i; 
			WebElement adultsBtn = driver.findElement(By.xpath("//li[@data-cy='adults-"+ adultTraveller + "']"));
			wait.until(ExpectedConditions.elementToBeClickable(adultsBtn)).click();
//		}
		
			
		

//		if (childrenTraveller != null && !childrenTraveller.isEmpty()) {
//			int children = Integer.parseInt(childrenTraveller);
//			for (int j = 1; j <= children; j++) {
//				String val = "children-" + j; 
				WebElement childrenBtn = driver.findElement(By.xpath("//li[@data-cy='children-" + childrenTraveller + "']"));
				wait.until(ExpectedConditions.elementToBeClickable(childrenBtn)).click();
//			}
//		}
		

		// class select


		String classOptionXpath = "";
		if (Ticketclass.equalsIgnoreCase("Business")) {
			classOptionXpath = "//ul[@class='guestCounter classSelect font12 darkText']/li[@data-cy='travelClass-2']";
		} else if (Ticketclass.equalsIgnoreCase("Economy/Premium Economy")) {
			classOptionXpath = "//ul[@class='guestCounter classSelect font12 darkText']/li[@data-cy='travelClass-0']";
		} else if (Ticketclass.equalsIgnoreCase("Premium Economy")) {
			classOptionXpath = "//ul[@class='guestCounter classSelect font12 darkText']/li[@data-cy='travelClass-1']";
		}

		System.out.println(classOptionXpath);

		if (!classOptionXpath.isEmpty()) {
			WebElement classSelect = driver.findElement(By.xpath(classOptionXpath));
			wait.until(ExpectedConditions.elementToBeClickable(classSelect)).click();
		}

		// Apply the selection
		WebElement applyButton = driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", applyButton);
		wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
		//applyButton.click();
		

		Thread.sleep(5000); 

		//		// Search for flights
				WebElement searchButton = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn '][text()='Search']"));
				wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

		// Take a full-page screenshot
		takeScreenshot(driver, "tripBook");

		// Close the driver after the operation

		driver.quit();
	}

	public void takeScreenshot(WebDriver driver, String fileName) throws IOException {

		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000));
		Screenshot sc = ashot.takeScreenshot(driver);
		SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy_HHmmss");
		String date1 = simple.format(new Date());


		BufferedImage src = sc.getImage();
		File dest = new File(System.getProperty("user.dir")+ "\\MakeTrip\\" + fileName + date1 + ".png");
		ImageIO.write(src, "PNG", dest);
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		MakeMyTrip obj = new MakeMyTrip();
		obj.SearchFlight("Pune", "Delhi", "July 2024", "22", "5", "2", "Business");
		
//		obj.SearchFlight("Mumbai", "Chennai", "November 2024", "12", "2", "1", "Premium Economy");
	}
}
