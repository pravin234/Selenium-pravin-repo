package Tutorail9;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTest {

	WebDriver driver;String employeeId;
	@BeforeClass
	public void Setup() {

		// Connect to actual browser
		// up casting ---> declare webdriver globally
		driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		// maximize
		driver.manage().window().maximize();
		// open a url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority=1)
	public void loginFunction() throws InterruptedException
	{  

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	}


	@Test(priority=3)
	public void DashBorad() throws InterruptedException
	{
		String Url = driver.getCurrentUrl();
		System.out.println(Url);

		driver.findElement(By.xpath("//span[text()='PIM']")).click();

		driver.findElement(By.xpath("//button[text()=' Add ']")).click();

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Pravin");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kadam");

		//capture the employee id using get Attribute method

		String EmpId = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");

		System.out.println(EmpId);

		driver.findElement(By.xpath("//button[text()=' Save ']")).click();

	}

	@Test(priority=4)
	public void personalInfo() throws InterruptedException {

		System.out.println(driver.getCurrentUrl());

		//Enter the middle name 
		driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("Ramdas");
		employeeId = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")).getText();

       Thread.sleep(5000);
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


		
		//driver.findElement(By.xpath("//label[text()='Gender']/parent::div/following-sibling::div/descendant::span[@value='1']")).click();

		driver.findElement(By.xpath("//p[text()=' * Required']/following-sibling::button")).click();

	}

	@Test(priority=5)
	public void searchEmployee()
	{
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")).sendKeys(employeeId);

		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
	}

	@Test(priority=6)
	public void logOutFunctionality()
	{
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}


}






