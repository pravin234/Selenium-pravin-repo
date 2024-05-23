package withoutSelectPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// upcasting
		WebDriver driver = new ChromeDriver();

		// open url 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();

		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(5000);
		// find username enter value

		WebElement username = driver.findElement(By.name("username"));

		if(username.isDisplayed() && username.isEnabled()) {

			username.sendKeys("Admin");

		}

		// apply second wait concept explicit wait

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

		password.sendKeys("admin123");

		Thread.sleep(5000);


		//click on login button using  wait concept 

		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Login ']")));
		loginButton.click();

		Thread.sleep(5000);


		WebElement pimLink = driver.findElement(By.xpath("//span[text()='PIM']"));
		pimLink.click();

		// job title 

		WebElement jobTitle = driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div/descendant::div[@class='oxd-select-text--after']"));
		jobTitle.click();

		//capture all dropdown option

		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='oxd-select-option']/child::span"));

		//iterate loop 

		for (WebElement abc : ls) {
			Thread.sleep(2000);
			// capture drop down element physical text
			String xyz = abc.getText();
			System.out.println(xyz);

			if(xyz.equals("IT Manager "))
			{
				abc.click();
				break;
			}
		}

		Thread.sleep(5000);

		driver.quit();







	}

}
