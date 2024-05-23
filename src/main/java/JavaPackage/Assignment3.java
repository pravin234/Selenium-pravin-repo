package JavaPackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	//	// Non-static method with String return type and one String argument
	//	https://prafpawar11.github.io/multiplewindows.html
	//		create a non static method with String return type and 1 String arguments
	//			- open a application enter first name, last name and address
	//	
	//		conditions
	//			- if click on  orange link name				
	//							- switch to it and enter credentials
	//							take screenshot
	//							- return url
	//
	//			- of click on facebook reg link
	//							- switch to it and enter firstname, last name, username, password and DOJ 
	//							- take screenshot
	//							- return type url
	//
	//			- if click on sauce demo link
	//							- switch to it and enter credentials and run end to end flow
	//							- return url
	//

	public String checkClick(String a) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		// Set the path to chromedriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://prafpawar11.github.io/multiplewindows.html");

		driver.manage().window().maximize();

		String originalWindow = driver.getWindowHandle();
		WebElement link = null;

		// Identify the link based on input
		if (a.equalsIgnoreCase("orange")) {

			link = driver.findElement(By.linkText("Visit Orange HRM"));

		} else if (a.equalsIgnoreCase("facebook")) {

			link = driver.findElement(By.linkText("Visit Facebook"));
		}
		else if (a.equalsIgnoreCase("sauceDemo")) {
			link = driver.findElement(By.linkText("SauceDemo Link"));
		}

		if (link != null) {
			link.click();
			Set<String> allWindows = driver.getWindowHandles();
			for (String window : allWindows) {
				if (!window.equals(originalWindow)) {
					driver.switchTo().window(window);
					break;
				}
			}

			// Perform actions based on the link clicked

			if (a.equalsIgnoreCase("orange")) {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

				WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
				usernameField.sendKeys("Admin");

				WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
				passwordField.sendKeys("admin123");

				WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")));
				loginButton.click();

				Thread.sleep(5000);

				takeScreenshot(driver, "orange");
				Thread.sleep(5000);
			}

			else if (a.equalsIgnoreCase("facebook")) {
				// Enter credentials on the Facebook registration page
				driver.findElement(By.name("firstname")).sendKeys("Pravin");

				driver.findElement(By.name("lastname")).sendKeys("Kadam");

				driver.findElement(By.name("reg_email__")).sendKeys("rajdhanra@gmail.com");

				driver.findElement(By.name("reg_passwd__")).sendKeys("admin@1234");


				Thread.sleep(5000);

				takeScreenshot(driver, "facebook");

				Thread.sleep(5000);

			}

			else if (a.equalsIgnoreCase("sauceDemo")) {
				// Enter credentials and perform end-to-end flow on the Sauce Demo page
				driver.findElement(By.name("user-name")).sendKeys("standard_user");

				driver.findElement(By.id("password")).sendKeys("secret_sauce");

				driver.findElement(By.name("login-button")).click();

				Thread.sleep(5000);

				takeScreenshot(driver, "sauceDemo");

				Thread.sleep(5000);
			}

			// Return the current URL of the new window
			String currentURL = driver.getCurrentUrl();

			driver.quit();

			return currentURL;
		} else {
			driver.quit();
			return "Link not found";
		}
	}

	// function to take a screenshot
	public void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		// create object of SimpleDateFormat class by passing date and time format
		SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy_HHmmss");

		// use format() method by passing Date class object
		String day = simple.format(new Date());

		File dest = new File(System.getProperty("user.dir") + "\\Assign\\" + fileName+ day + ".png");
		FileUtils.copyFile(src, dest);


	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Assignment3 obj = new Assignment3();
		String url = obj.checkClick("orange");
		System.out.println("URL of the new window: " + url);

		System.out.println();

		String url2 = obj.checkClick("facebook");
		System.out.println("URL of the new window: " + url2);

		System.out.println();

		String url3 = obj.checkClick("sauceDemo");
		System.out.println("URL of the new window: " + url3);
	}
}
