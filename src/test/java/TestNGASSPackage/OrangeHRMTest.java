package TestNGASSPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	WebDriver driver;
	WebDriverWait wait;
	String employeeId;

	@BeforeClass
	public void setup() {
		System.out.println("Setting up the browser and navigating to the login page...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 1)
	public void loginFunction() throws InterruptedException {
		System.out.println("Logging in as Admin...");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))).click();
	}

	@Test(priority = 3)
	public void dashboard() throws InterruptedException {
		System.out.println("Navigating to PIM and adding a new employee...");
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		System.out.println(driver.getCurrentUrl());

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add ']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']"))).sendKeys("Pravin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']"))).sendKeys("Kadam");

		employeeId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))).getAttribute("value");
		System.out.println("Captured Employee ID: " + employeeId);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Save ']"))).click();
	}

	@Test(priority = 4)
	public void personalInfo() throws InterruptedException {
		System.out.println("Updating personal information...");
		wait.until(ExpectedConditions.urlContains("/pim/viewPersonalDetails"));
		System.out.println(driver.getCurrentUrl());

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Middle Name']"))).sendKeys("Ramdas");

		employeeId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/child::input"))).getAttribute("value");

		//	Thread.sleep(5000); // Adding a short wait to ensure the element is interactable

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Nationality']/parent::div/following-sibling::div/descendant::div[@class='oxd-select-text-input']"))).click();

		List<WebElement> nationalityOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-select-option']/child::span")));
		for (WebElement option : nationalityOptions) {
			if (option.getText().equals("Indian")) {
				option.click();
				break;
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Male']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()=' * Required']/following-sibling::button"))).click();
	}

	@Test(priority = 5)
	public void searchEmployee() throws InterruptedException {
		System.out.println("Searching for the newly added employee...");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Employee List']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/child::input"))).sendKeys(employeeId);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Search ']"))).click();
	}

	@Test(priority = 6)
	public void logOutFunctionality() throws InterruptedException {
		System.out.println("Logging out...");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='oxd-userdropdown-name']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();
	}

	@AfterMethod
	public void checkResults(ITestResult result) {
		if (!result.isSuccess()) {
			System.err.println("Test failed: " + result.getName());
			takeScreenshot(result.getName());
		}
	}

	@AfterClass
	public void tearDown() {
		System.out.println("Closing the browser...");
		if (driver != null) {
			driver.quit();
		}
	}

	// Utility method to take a screenshot
	public void takeScreenshot(String testName) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("screenshots/" + testName + ".png"));
			System.out.println("Screenshot taken for failed test: " + testName);
		} catch (IOException e) {
			System.err.println("Failed to save screenshot: " + e.getMessage());
		}
	}
}



