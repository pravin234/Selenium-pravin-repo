package SelectDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//	https://demo.guru99.com/test/newtours/register.php
		//	verify the ""INDIA""" value is present or not in country drop down	
		// 1 connect to actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// 2 upcasting 
		WebDriver driver = new ChromeDriver();
		//open url 
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		// find web-element dropdown select on  web page

		WebElement wb= driver.findElement(By.name("country"));

		//create object of Select class by passing WebElement instance name or object name
		Select sel = new Select(wb);
		//capture all dropdown value
		List<WebElement> ls  = sel.getOptions();

		for(WebElement abc :ls) {
			String a = 	abc.getText();
			System.out.println(a);
		}




	}

}
