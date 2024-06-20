package TestNgDataDriver;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeSample1 {
	
	public static WebDriver driver ;
	public static String empid;
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=1)
	public void loginFunctionality()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	
	@Test(priority=2)
	public void validateHomePageTitle()
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
		System.out.println("Title is verified");
	}
	
	@Test(priority=3)
	public void validateHomePageUrl()
	{
		String actualUrl = driver.getCurrentUrl();
		boolean actualResult = actualUrl.contains("hrm");
		Assert.assertEquals(actualResult, true);
		System.out.println("URL is verified");
	}
	
	@Test(priority=4)
	public void validatePIMPage()
	{
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		String pimUrl = driver.getCurrentUrl();
		boolean actualpimResult = pimUrl.contains("pim");
		Assert.assertEquals(actualpimResult, true);
		System.out.println("pim page is verified");
	}
	
	@Test(priority=5, dataProvider="testdata")
	public void createEmployee(String firstname, String middlename, String lastname) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("middleName")).sendKeys(middlename);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		Thread.sleep(3000);
		empid = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")).getAttribute("value");
		System.out.println(empid);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		Thread.sleep(3000);
	}
	
	@DataProvider(name="testdata")
	public Object[][] getTestData() throws IOException
	{
		ExcelReader obj = new ExcelReader("C:\\Users\\ABC\\Desktop\\Automationn\\TestNG\\OrangeHRMData.xlsx");
		Object[][] data = obj.getAllSheetTestData(0);
		return data;
	}
	
	@Test(priority=6)
	public void logout()
	{
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
