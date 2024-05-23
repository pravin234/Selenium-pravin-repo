package Tutorial1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementTextDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//		Scenario 1 :
		//			- open a facebook register page application							get() method						void
		//			- find the first name text box											findElement() method				WebElement
		//			- check first name text box displayed status							isDisplayed()						boolean
		//			- check first name text box enabled status								isEnabled()						boolean
		//			- enter the values in text box											sendKeys()							void
		//			- capture the entered value												getAttribute("value")				String							
		//			- clear the values														clear()								void


		// 1 connect actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// 2 upcasting obhect
		WebDriver driver = new ChromeDriver();

		// 3 open url 
		driver.get("https://www.facebook.com/reg");
        
	    //3 find the first name text box	 
		WebElement wb = driver.findElement(By.name("firstname"));
        
		// 4 check textbox firstname  is  display or not  status
		
		Boolean b = wb.isDisplayed();
		System.out.println("display status is  " +b);

		//5 check first name text box enabled status
		Boolean c = wb.isEnabled();
		System.out.println("textbox is enable or not status " + c);
       
		// set textbox value //enter the values in text box
		wb.sendKeys("Pravin");
		
	
		// capture the input value

		String input = wb.getAttribute("value");

		System.out.println(input);

		Thread.sleep(5000);

		wb.clear();
		driver.quit();


	}

}
