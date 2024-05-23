package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// open https://demoqa.com/buttons
		// find the right click button and right click on it.
		
		WebDriver driver = new ChromeDriver();
		
		//open url 
		
		driver.get("https://demoqa.com/buttons");
		
		//find right click button 
		
		WebElement wb =driver.findElement(By.id("rightClickBtn"));
	
		Actions act = new Actions(driver);
		
		act.contextClick(wb).build().perform();
		
		WebElement wb2 = driver.findElement(By.id("rightClickMessage"));
		System.out.println(wb2.getText());
		
		
		

	}

}
