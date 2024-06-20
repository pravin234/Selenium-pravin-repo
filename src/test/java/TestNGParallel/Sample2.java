package TestNGParallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Sample2 {

	@Test
	public void facebookTestCase1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/reg");

		Thread.sleep(3000);

		driver.findElement(By.name("firstname")).sendKeys("rajdhara");
		driver.findElement(By.name("lastname")).sendKeys("kadam");
		driver.findElement(By.name("reg_email__")).sendKeys("rajdhara234kadam@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("rajdhara234kadam@gmail.com");
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


}
