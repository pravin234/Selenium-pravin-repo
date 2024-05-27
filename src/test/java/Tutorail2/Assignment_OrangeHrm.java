package Tutorail2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Assignment_OrangeHrm {

	WebDriver driver;
	WebDriverWait wait;
	String employeeID = "";

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void takeScreenshot(String screenshotName) throws IOException {

		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000));
		Screenshot sc = ashot.takeScreenshot(driver);
		SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy_HHmmss");
		String date1 = simple.format(new Date());

		try {
			BufferedImage src = sc.getImage();
			File dest = new File(System.getProperty("user.dir")+ "\\TestNgScrShot\\" +"Orange_"+screenshotName + date1 + ".png");
			ImageIO.write(src, "PNG", dest);
			System.out.println("Screenshot taken: " + screenshotName);
		}
		catch(IOException e) {
			System.out.println("Failed to take screenshot: " + e.getMessage());

		}

	}

	@Test(priority = 1)
	public void openLoginPage() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Login page opened");
	}


	@Test(priority = 2)
	public void LoginFunction() throws IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		System.out.println("Login attempted");

		// Wait for the dashboard to load
		takeScreenshot("Dashboard");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
	}

	@Test(priority = 3)
	public void Dashboard() throws IOException {
		System.out.println("Dashboard");

		// Click on the PIM menu item
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
		System.out.println("PIM clicked");

		// Wait for the new page to load and the Add Employee element to be visible and clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"))).click();
		System.out.println("Add Employee clicked");

		employeeID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))).getAttribute("value");
		System.out.println("Captured Employee ID: " + employeeID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName"))).sendKeys("Trupti");
		driver.findElement(By.name("lastName")).sendKeys("Kadam");

		driver.findElement(By.xpath("//button[text()=' Save ']")).click();

		System.out.println("Employee added");

		// Wait for the personal details page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Personal Details']")));

		takeScreenshot("Dashboard");
	}

	@Test(priority = 4)
	public void addMoreDetails() throws InterruptedException, IOException {
		employeeID = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")).getText();


		driver.findElement(By.xpath("//label[text()='Nationality']/parent::div/following-sibling::div/descendant::div[@class='oxd-select-text-input']")).click();

		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='oxd-select-option']/child::span"));

		for(WebElement abc: ls)
		{
			String country = abc.getText();

			if(country.equals("Indian"))
			{
				abc.click();
				break;
			}
		}

		driver.findElement(By.xpath("//label[text()='Gender']/parent::div/following-sibling::div/descendant::input[@value='1']")).click();

		driver.findElement(By.xpath("//p[text()=' * Required']/following-sibling::button")).click();


	}

	@Test(priority = 5)
	public void viewUser() throws IOException {
		// Click on the PIM menu item
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
		System.out.println("PIM clicked");

		System.out.println("Employee Listing page");

		// Wait for the Employee Id input field to be visible
		WebElement employeeIdInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")));
		employeeIdInput.sendKeys(employeeID);

		// Click the Search button
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Search ']")));
		searchButton.click();
		System.out.println("Search button clicked");

		takeScreenshot("SearchEmployee");

	}


	@Test(priority = 6)
	public void LogOut() {
		// Click on Profile symbol top right screen
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='profile picture']"))).click();

		System.out.println("profile dropdown open");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();


		System.out.println("Logout successfully");
	}

	@AfterClass
	public void closeBrowser() {
		//        driver.quit();
		System.out.println("Browser closed");
	}
}
