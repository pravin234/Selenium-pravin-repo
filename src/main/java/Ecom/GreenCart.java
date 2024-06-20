package Ecom;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GreenCart {

	public static void main(String[] args) throws InterruptedException {

		// Set the path to the chromedriver executable

		// Initialize the Chrome driver
		WebDriver driver = new ChromeDriver();

		// Array of products to purchase
		String[] purchaseProduct = { "Almonds", "Pista", "Nuts Mixture", "Cashews" };

		// Navigate to the GreenCart website
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Find all product name elements
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// Loop through each product and check if it is in the purchaseProduct array
		for (WebElement product : products) {
			// Split the product name to remove any additional text
			String[] name = product.getText().split("-");
			String formatProductName = name[0].trim();
//			System.out.println(formatProductName);

			// Convert purchaseProduct array to a list
			List<String> purchaseProductList = Arrays.asList(purchaseProduct);

			// If the product is in the purchaseProductList, click the add-to-cart button
			if (purchaseProductList.contains(formatProductName)) {
				driver.findElement(
						By.xpath("//h4[contains(text(),'" + formatProductName + "')]/following-sibling::div/button"))
						.click();
			}
		}

		// Wait for 5 seconds
		Thread.sleep(5000);

		// Click on the cart icon to view the cart
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

		// Click on the 'PROCEED TO CHECKOUT' button
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		// Wait for 5 seconds
		Thread.sleep(5000);

		// Click on the 'Place Order' button
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		// Select country from the dropdown
		WebElement country = driver
				.findElement(By.xpath("//label[text()='Choose Country']/parent::div/child::div/select"));
		Select sel = new Select(country);
		sel.selectByVisibleText("India");

		// Wait for 3 seconds
		Thread.sleep(3000);

		// Click on the checkbox to agree to the terms and conditions
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();

		// Click on the 'Proceed' button to complete the order
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

		Thread.sleep(5000);

		// Close the browser
		driver.quit();
	}
}
