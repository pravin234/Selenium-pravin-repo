package TestNGParallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Demo1 {

	// run parallel testcases - 
	@Test
	public void facebookTestCase1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/reg");

		Thread.sleep(3000);

		driver.findElement(By.name("firstname")).sendKeys("Pravin");
		driver.findElement(By.name("lastname")).sendKeys("kadam");
		driver.findElement(By.name("reg_email__")).sendKeys("rajdhani234kadam@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("rajdhani234kadam@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("pravin234");
		WebElement day = driver.findElement(By.name("birthday_day"));

		Select sel = new Select(day);
		sel.selectByVisibleText("23");

		WebElement month = driver.findElement(By.name("birthday_month"));
		Select sel2 = new Select(month);
		sel2.selectByVisibleText("Apr");

		WebElement year = driver.findElement(By.name("birthday_year"));
		Select sel3	 = new Select(year);
		sel3.selectByVisibleText("1991");

		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void guru99TestCase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).sendKeys("pravin");
		driver.findElement(By.name("lastName")).sendKeys("Kadam");
		driver.findElement(By.name("phone")).sendKeys("9876543210");
		driver.findElement(By.name("userName")).sendKeys("rajdhani234@gmail.com");
		Thread.sleep(5000);
		driver.quit();

	}

}
