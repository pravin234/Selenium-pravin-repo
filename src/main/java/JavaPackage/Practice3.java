package JavaPackage;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3 {

	//	https://prafpawar11.github.io/multiplewindows.html
	//	create a non static method with String return type and 1 String arguments
	//			- open a application enter first name, last name and address
	//
	//			conditions
	//			- if click on  orange link name				
	//			- switch to it and enter credentials
	//			take screenshot
	//			- return url
	//
	//					- of click on facebook reg link
	//					- switch to it and enter firstname, last name, username, password and DOJ 
	//					- take screenshot
	//					- return type url
	//
	//							- if click on sauce demo link
	//							- switch to it and enter credentials and run end to end flow
	//							- return url



	public void clickLinkTest(String a) {
		WebDriver driver = new ChromeDriver();

		//open url

		driver.get("https://prafpawar11.github.io/multiplewindows.html");
		WebElement link = null;
		if(a.equals("orange")) {

			link = driver.findElement(By.linkText("Visit Orange HRM"));
		}
		else if(a.equalsIgnoreCase("Facebook")){
			link = driver.findElement(By.linkText("Visit Facebook"));	
		}
		else if(a.equalsIgnoreCase("sauce")){
			link = driver.findElement(By.linkText("SauceDemo Link")); 
		}
		else {
			driver.quit();
		}


		if(link != null) {
			link.click();

			Set<String> AllWIndowId = driver.getWindowHandles();
			// convert to array object
			ArrayList<String> arr = new ArrayList<String>(AllWIndowId);
			driver.switchTo().window(arr.get(1));
		
			System.out.println();
			
			
		}
		
	}
	public static void main(String[] args) {
		
		Practice3 obj = new Practice3();
		obj.clickLinkTest("orange");
		


	}

}
