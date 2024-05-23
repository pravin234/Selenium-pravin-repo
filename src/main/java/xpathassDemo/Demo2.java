package xpathassDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver =  new ChromeDriver(); 

		driver.get("https://www.facebook.com/reg");
		//availble option for x path 
		//		1) //select[@aria-label='Year']
		//		2) //select[@name='birthday_year']
		//		3) //select[@id='year']
		//		4) //select[@title='Year']
		//	
		WebElement wb = driver.findElement(By.xpath("//select[@id='year']"));
		
		// cretae select object
		Select sel = new Select(wb);
		sel.selectByVisibleText("2000");
	}

}
