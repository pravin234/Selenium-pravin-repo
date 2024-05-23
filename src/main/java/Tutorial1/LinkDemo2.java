package Tutorial1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		 
		 // upcastig 
		 WebDriver driver = new ChromeDriver();
		 
		 //open url 
		 driver.get("https://ugrodms.ugrocapital.com/");
		 
		 WebElement wb = driver.findElement(By.linkText("Forgot Password?"));
		 
		 Boolean a = wb.isDisplayed();
	    System.out.println(a);
	    
	     Boolean b = wb.isEnabled();
	     System.out.println(b);
		 
	     String s = wb.getText();
	     System.out.println(s);
	     
	     Thread.sleep(2000);
		
	}

}
