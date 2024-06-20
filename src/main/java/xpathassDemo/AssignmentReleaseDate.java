package xpathassDemo;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentReleaseDate {

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

        System.out.println("Wikipedia Pushpa Release Date: " + releaseDateWiki);

        driver.navigate().back();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md' and text()='Pushpa: The Rise - Part 1 (2021)']"))
                .click();

        Thread.sleep(3000);
        WebElement imdbDateElement = driver.findElement(By.xpath(
                "//section[@data-testid='Details']/child::div[@class='sc-f65f65be-0 bBlII']/descendant::a[text()='Release date']/following-sibling::div/descendant::a[text()='December 17, 2021 (United States)']"));

        String releaseDateImdb1 = imdbDateElement.getText();
        System.out.println("IMDb capture Pushpa Release Date: " + releaseDateImdb1);
        String releaseDateImdb = releaseDateImdb1.replaceAll("\\s*\\(.*?\\)\\s*", "").replace(",", "");

        System.out.println("IMDb Pushpa Release Date: " + releaseDateImdb);
        
        char [] releaseDateWikiArray = releaseDateWiki.toCharArray();
		
		char [] releaseDateImdbArray = releaseDateImdb.toCharArray();

		//it used to convert the arrays values as per the ascending order.
		Arrays.sort(releaseDateImdbArray);

		Arrays.sort(releaseDateWikiArray);
		
		if(Arrays.equals(releaseDateWikiArray, releaseDateImdbArray))
				{
						return true;
				}
				else
				{
						return false;
				}
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
