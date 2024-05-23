package dragDropPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		//upcasting
		WebDriver driver =new ChromeDriver();
		//open new url with get method
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		// step 4; find the Washington element
		WebElement src = driver.findElement(By.id("box3"));

		// step 5: find US Element
		WebElement trg = driver.findElement(By.id("box103"));

		// step 6: create Object of Actions class by passing WebDriver instance
		Actions act = new Actions(driver);

		// step 7: use dragAndDrop() method by passing source and target location then
		// build() and perform() method
		act.dragAndDrop(src, trg).build().perform();
		
	


	}

}
