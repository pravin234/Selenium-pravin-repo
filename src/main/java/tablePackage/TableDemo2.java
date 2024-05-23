package tablePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open https://prafpawar11.github.io/emptable.html
		//find and count total columns present in table and capture all values

		// up casting
		WebDriver driver = new ChromeDriver();

		// open a url
		driver.get("https://prafpawar11.github.io/emptable.html");

		// find all columns in table
		List<WebElement> ls = driver.findElements(By.tagName("th"));

		// count columns using size() method
		int a = ls.size();
		System.out.println(a);

		// capture all colums names in console

		for (WebElement abc : ls) {
			String b = abc.getText();
			System.out.println(b);
		}

	}

}
