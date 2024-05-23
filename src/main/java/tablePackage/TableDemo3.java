package tablePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// upcasting
		WebDriver driver = new ChromeDriver();

		//open url 
		driver.get("https://prafpawar11.github.io/emptable.html");

		// find all columns in table

		List<WebElement> ls = driver.findElements(By.tagName("th"));

		// count columns using size() method
		int a = ls.size();
		System.out.println(a);

		for (WebElement abc : ls) {
			String b = abc.getText();
			// Verify the Salary column is present or not
			if (b.equals("Salary1")) {
				System.out.println("test cases is pass");
			}
			
			

		}
	}

}
