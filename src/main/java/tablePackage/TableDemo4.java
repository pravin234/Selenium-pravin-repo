package tablePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		Scenario 3:
		//			- count how many values present inside the table
		//			- capture all table values
		//			- check specific value is present or not?
		//step 1connect to actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		//Step 2 upcasting
		WebDriver driver = new ChromeDriver();
		//Step 3 open url
		driver.get("https://prafpawar11.github.io/emptable.html");
		//Step 4 find table on webpage using findElements() method

		List<WebElement> ls = driver.findElements(By.tagName("td"));

		//step 4  find count in table

		int a = ls.size();
		System.out.println(a);

		//step 6: capture all table values
		for(WebElement abc:ls) {
			String b = abc.getText();
			//check specific value is present or not?
			if(b.equals("Pravin"))
			{	
				System.out.println("test cases is pass");
			}	

		}
	}

}
