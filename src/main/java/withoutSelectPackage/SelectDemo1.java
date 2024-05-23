package withoutSelectPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDemo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//		Open a https://www.vsp.com/create-account
		//			find the language drop down and click on it
		//			capture all dropdown values
		//			select the Lao language.

		//step 1 
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.vsp.com/create-account");

		//find the language drop down and click on it

		WebElement wb1 = driver.findElement(By.name("preferredLanguage"));

		wb1.click();

		// capture all dropdown values
		List<WebElement> ls = driver.findElements(By.xpath("//span[@class='ng-option-label ng-star-inserted']"));
		
		// enhance loop 
		for(WebElement abc:ls) {
			
			Thread.sleep(2000);
			/// capture the drop down text
			String lang = abc.getText();
			System.out.println(lang);

			if (lang.equals("Korean")) {
				abc.click();
				break;
			}
		}
		








	}

}
