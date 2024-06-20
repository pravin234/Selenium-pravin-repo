package xpathassDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RelaeDate {

	public static boolean releaseDateCheck() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.name("q")).sendKeys("Pushpa the rise");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//li[@class='sbct PZPZlf sbre']")).click();

		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//h3[text()='Pushpa: The Rise']/following-sibling::div/descendant::span[text()='Wikipedia']"))
		.click();

		Thread.sleep(2000);
		WebElement wikiDateElement = driver.findElement(By.xpath(
				"//table[@class='infobox vevent']/tbody/tr/th/div[text()='Release date']/parent::th/following-sibling::td"));
		String releaseDateWiki = wikiDateElement.getText();

		System.out.println("Wikipedia Release Date: " + releaseDateWiki);

		driver.navigate().back();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md' and text()='Pushpa: The Rise - Part 1 (2021)']"))
		.click();

		Thread.sleep(3000);
		WebElement imdbDateElement = driver.findElement(By.xpath(
				"//section[@data-testid='Details']/child::div[@class='sc-f65f65be-0 bBlII']/descendant::a[text()='Release date']/following-sibling::div/descendant::a[text()='December 17, 2021 (United States)']"));

		String releaseDateImdb1 = imdbDateElement.getText();
		String releaseDateImdb = releaseDateImdb1.replaceAll("\\s*\\(.*?\\)\\s*", "");

		System.out.println("IMDb Release Date: " + releaseDateImdb);

		// Convert strings to LocalDate objects directly within the method
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.US);
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.US);

		LocalDate wikiDate;
		LocalDate imdbDate;

		try {
			// Try to parse the Wikipedia date
			wikiDate = LocalDate.parse(releaseDateWiki, formatter1);
		} catch (Exception e) {
			wikiDate = LocalDate.parse(releaseDateWiki, formatter2);
		}

		try {
			// Try to parse the IMDb date
			imdbDate = LocalDate.parse(releaseDateImdb, formatter1);
		} catch (Exception e) {
			imdbDate = LocalDate.parse(releaseDateImdb, formatter2);
		}

		// Compare the release dates
		boolean sameReleaseDate = wikiDate.equals(imdbDate);

		driver.quit(); // close the WebDriver instance

		return sameReleaseDate;
	}

	public static void main(String[] args) throws InterruptedException {
			boolean sameDate = releaseDateCheck();
			if (sameDate) {
				System.out.println("The release dates are the same.");
			} else {
				System.out.println("The release dates are different.");
			}
	}
}
