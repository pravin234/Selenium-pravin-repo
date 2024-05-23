package JavaPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NonStatic {
	

//		Praful Pawar  to  Everyone 8:37 PM
//		https://demoqa.com/buttons
//		https://demoqa.com/buttons
	public String checkButtonType(String a) {

		WebDriver  driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/buttons");
		
		// find doublic
		WebElement wb1 = driver.findElement(By.id("doubleClickBtn"));
		
		WebElement wb2 = driver.findElement(By.id("rightClickBtn"));
		
		WebElement wb3 = driver.findElement(By.id("JKBUN"));
		
		Actions act = new Actions(driver);
		
		if(a.equals("double")) {}
		return "";
		
	}

	public static void main(String[] args) {
		

	}

}
