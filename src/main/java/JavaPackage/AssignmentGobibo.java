package JavaPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentGobibo {

	//	Open a application 	https://www.goibibo.com/
	//		create non static method without return type and  6 arguments
	//				- enter from city name
	//				- enter to city name
	//				- select date .month and year
	//				- select adult traveller
	//				- select travel class
	//				- click on search button
	//				- take screenshot
	//				at the time of calling this method it should ask for, from city name, to city name, expected date, expected month and year, total adult traveller, and travel class.

	public void functionGobiboSearch(String fromCity) {
		
		// upcasting
		WebDriver driver = new ChromeDriver();
		
		//open url
		driver.get("https://www.goibibo.com/");
		
		WebElement fromCity1 = driver.findElement(By.xpath("//span[text()='From']"));
		
		fromCity1.sendKeys("Pune");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AssignmentGobibo gobibo = new AssignmentGobibo();
		
		gobibo.functionGobiboSearch("pune");
		

	}

}
