package StaticJavaPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonMaxValue {

	public static int searchMobileAndFindMaxValue(String mobileName) throws InterruptedException {
		int max = 0;
		// Setup Chrome options for incognito mode
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--incognito");
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver(opt);

		// Open Amazon India website
		driver.get("https://www.amazon.in");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Find search bar and input the mobile name
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys(mobileName);

		// Click on the search button
		driver.findElement(By.id("nav-search-submit-button")).click();

		// Find all elements containing the prices of the searched mobile phones
		List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		// Iterate through the price elements to find the maximum price
		for (WebElement priceElement : priceElements) {
			String priceText = priceElement.getText();

			// Remove all non-numeric characters
			String mobilePrice = priceText.replaceAll("[^0-9]", "");

			// Check if mobilePrice is not empty before parsing
			if (!mobilePrice.isEmpty()) {
				// Convert the price to an integer
				int price = Integer.parseInt(mobilePrice);
				if (price > max) {
					max = price;
				}
			}
		}

		driver.quit();
		return max;
	}

	public static void main(String[] args) throws InterruptedException {
		// Search for Samsung mobile phones and find the maximum price
		int samsungPrice = searchMobileAndFindMaxValue("Samsung mobile Phone");
		System.out.println("Maximum Samsung Mobile Phone Price: " + samsungPrice);

		// Search for Apple mobile phones and find the maximum price
		int applePrice = searchMobileAndFindMaxValue("Apple mobile Phone");
		System.out.println("Maximum Apple Mobile Phone Price: " + applePrice);

		// Compare the maximum prices and print the higher one
		if (samsungPrice > applePrice) {
			System.out.println("Maximum price found: " + samsungPrice + " (Samsung mobile phone)");
		} else if (applePrice > samsungPrice) {
			System.out.println("Maximum price found: " + applePrice + " (Apple mobile phone)");
		} else {
			System.out.println("Both Samsung and Apple mobile phones have the same maximum price: " + samsungPrice);
		}
	}
}

//

//Maximum Samsung Mobile Phone Price: 39900
//Maximum Apple Mobile Phone Price: 137990
//Maximum price found: 137990 (Apple mobile phone)