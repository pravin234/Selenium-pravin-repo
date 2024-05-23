package Tutorial1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementRadioDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//		- open a https://copyright.gov.in/UserRegistration/frmNewUser.aspx				get() method				void
		//			- find the General User Radio button												findElement() method		WebElement
		//			- check the General User Radio button displayed status								isDisplayed()				boolean					
		//			- check the General User Radio button enabled status								isEnabled()					boolean
		//			- check the General User Radio button selected status								isSelected()					boolean
		//			- click on General User Radio button												click()						void
		//			- check the General User Radio button selected status								isSelected()					boolean
		//
		//			- find the Society User radio button												findElement()				WebElement 
		//			- click on Society User radio button												click()						void
		//			- check the General User Radio button selected status								isSelected					boolean


		// 1 connect actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// 2 upcasting 
		WebDriver driver = new ChromeDriver();
		
		// open url
		driver.get("https://copyright.gov.in/UserRegistration/frmNewUser.aspx");
		//find the General User Radio button
		WebElement wb = driver.findElement(By.name("ctl00$ContentPlaceHolder1$UserType"));
		
		//check the General User Radio button displayed status	
		Boolean b = wb.isDisplayed();
		System.out.println("General User Radio button displayed status "+b);
		
		//check the General User Radio button enable or not status	
		Boolean c = wb.isEnabled();
		System.out.println("General User Radio button enable or not status	"+ c);
		
		//7 check the General User Radio button selected status
         Boolean d = wb.isSelected();
         System.out.println("check the General User Radio button selected status" + d);
      
         Thread.sleep(4000);
      // 8 find the society radio button
 		WebElement wb1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoSociety"));

 		// 9 click on society radio button
 	  	wb1.click();

 		// 10 check the general radio button selected status.
 		boolean e = wb.isSelected();
 		System.out.println(e);// false
 		

 		System.out.println("------------------------------------");
 		/// step 11: society radio button displayed,enabled and selected status
 		System.out.println(wb1.isDisplayed());// true
 		System.out.println(wb1.isEnabled());// true
 		System.out.println(wb1.isSelected());// true
         
         Thread.sleep(4000);
          driver.quit();
	}

}
