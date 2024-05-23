package tablePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//	open a https://prafpawar11.github.io/emptable.html
		//	count rows and print all rows values in console
		
		// step 1: connect to the actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		//step 2 upcasting 
		WebDriver driver =new ChromeDriver();

		//step 3 open url
		driver.get("https://prafpawar11.github.io/emptable.html");
		

		//step 4  find all rows using findElements() method
		List<WebElement> ls = driver.findElements(By.tagName("tr"));

		// step 5 count how many rows present
		int a = ls.size();
		System.out.println(a);

		// step 6 capture all rows values in console
		for (WebElement abc : ls) {
			String b = abc.getText();
			System.out.println(b);

		}
		


	}

}
