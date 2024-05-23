package tablePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDemo5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// step 1: connect browser
		
		// step 2: up casting
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		// step 3: open a url
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(2000);
		// step 4: find the date object and click on it
		WebElement wb = driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']/input"));
		wb.click();

		// step 5: run infinite while loop

		while (true) {
			Thread.sleep(5000);
			// capture the displayed month and year values
			WebElement monthwb = driver
					.findElement(By.xpath("//span[@class='ui-datepicker-month ng-tns-c58-10 ng-star-inserted']"));

			WebElement yearwb = driver
					.findElement(By.xpath("//span[@class='ui-datepicker-year ng-tns-c58-10 ng-star-inserted']"));

			String monthText = monthwb.getText();
			String yearText = yearwb.getText();

			String monthYearText = monthText.concat(yearText);

			// compare captured values with expected value

			if (monthYearText.equalsIgnoreCase("September2024")) {
				// select the date
				WebElement datewb = driver.findElement(By.xpath("//a[text()='7']"));
				datewb.click();
				// break the while loop
				break;
			} else {
				// click on next button
				WebElement nextwb = driver.findElement(
						By.xpath("//span[@class = 'ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-10']"));
				nextwb.click();
			}

		}


	}

}
