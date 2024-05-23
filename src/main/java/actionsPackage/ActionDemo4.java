package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// step 3: open a url
		driver.get("https://www.amazon.in");

		Thread.sleep(5000);

		// step 4: find the Account and Lists link
		WebElement wb1 = driver.findElement(By.id("nav-link-accountList"));

		// step 5: find Orders link
		WebElement wb2 = driver.findElement(By.xpath("//span[text()='Your Orders']"));

		// step 6: create Object of Actions class by passing WebDriver instance

		Actions act = new Actions(driver);

		// step 7: use moveToElement() by passing WebElement from Actions class and use
		// click() method by passing WebElement instance from Actions class and then
		// build() and perform() method

		act.moveToElement(wb1).click(wb2).build().perform();
	}

}
