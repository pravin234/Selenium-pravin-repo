package xpathassDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class class3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		////tagname[contains(@attribute,'value')]  demo 

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg");

		WebElement wb = driver.findElement(By.xpath("//input[contains(@id,'u_0_g')]"));

		wb.sendKeys("Selenium@test.com");





	}

}
