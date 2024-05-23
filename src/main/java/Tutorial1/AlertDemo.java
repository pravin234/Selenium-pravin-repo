package Tutorial1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// upcasting
		ChromeDriver driver  = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// find text box  web element 
		WebElement wb =driver.findElement(By.id("name"));
		
		// set values in text box
		wb.sendKeys("Pravin");
		
		WebElement wb2 =driver.findElement(By.id("alertbtn"));
		wb2.click();
		
		// find confirm button using
		Thread.sleep(5000);
		
		WebElement wb3 = driver.findElement(By.id("confirmbtn"));
		
		wb3.click();
		//create object alert interface
		Alert alt = driver.switchTo().alert();
		
		// capture the text
		
		String a = alt.getText();
		if(a.contains("Pravin")){
			System.out.println(a);		
		}
		else {
			System.out.println("pravin is not present");
		}
		Thread.sleep(5000);
		alt.accept();
		alt.dismiss();
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
