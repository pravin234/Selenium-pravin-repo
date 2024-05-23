package NonStaticJava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assigment2 {

	//	https://prafpawar11.github.io/emptable.html
	//	- create non static method without return type and with 1 String arguments
	//	- if we pass tr keyword it should print all table rows 
	//	- if we pass th keyword it should print all table columns
	//	-if we pass td keyword it should print all table data

	public void TableCount(String table) {


		WebDriver driver = new ChromeDriver();

		driver.get("https://prafpawar11.github.io/emptable.html");

		// first count all elements of table //td data ,tr row ,th head coloum
		List<WebElement> tableCol =driver.findElements(By.tagName("th"));

		List<WebElement> tableRow =driver.findElements(By.tagName("tr"));

		List<WebElement> tableData=driver.findElements(By.tagName("td"));

		if(table.equals("tr"))
		{	
			for(WebElement abc : tableRow)
			{
				String row = abc.getText();
				System.out.println(row);
			}

		}

		if(table.equals("th"))
		{
			for(WebElement abc : tableCol)
			{
				String coloumn = abc.getText();
				System.out.println(coloumn);
			}
		}

		if(table.equals("td"))
		{
			for(WebElement abc : tableData)
			{
				String data = abc.getText();
				System.out.println(data);
			}
		}



	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Assigment2 obj = new Assigment2();

		
		obj.TableCount("th");
		
		System.out.println("----------------------------------------------------------------");
		
		obj.TableCount("tr");
		
		System.out.println("----------------------------------------------------------------");
		
		
		obj.TableCount("td");
		
		

	}

}




