package windowHandle;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//		Open a https://prafpawar11.github.io/multiplewindows.html
		//			capture current or parent window id number
		//			find and enter the firstname
		//			click on facebook link
		//			capture all window id number
		//			capture the facebook window id number
		//			switch focus to facebook window
		//			enter first name last name , username and password
		//			switch focus to parent window
		//			find and enter last name
		//			click on orange HRM link
		//			capture all window id number
		//			capture the orange hrm window id number
		//			switch focus to orange hrm window
		//			find and enter username, password and click on login button
		//			switch to parent window
		//			find and enter the address
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// step 3: open a url
		driver.get("https://prafpawar11.github.io/multiplewindows.html");

		String parentWindowID = driver.getWindowHandle();
		System.out.println(parentWindowID);

		//find and enter the firstname

		driver.findElement(By.name("fname")).sendKeys("Pravin");

		// click on fb link
		driver.findElement(By.linkText("Visit Facebook")).click();


		//capture all window id number

		Set<String> allWindowsId = driver.getWindowHandles();

		// use enhance loop  using loop find  all window id and match new window id
		String faceWIndowID = null;
		for(String abc : allWindowsId) {
			if(!abc.equals(parentWindowID)) {
				faceWIndowID = abc;
			}
		}

		// swithc to new window 

		driver.switchTo().window(faceWIndowID);

		// enter input in fb reg page
		driver.findElement(By.name("firstname")).sendKeys("Pravin");

		driver.findElement(By.name("lastname")).sendKeys("Kadam");

		driver.findElement(By.name("reg_email__")).sendKeys("pravinkadam@gmail.com");

		//		switch focus to parent window

		driver.switchTo().window(parentWindowID);

		//	find and enter last name
		driver.findElement(By.name("lname")).sendKeys("Kadam");

		//
		Thread.sleep(5000);

		driver.findElement(By.linkText("Visit Orange HRM")).click();

		//capture all window id number


		Set<String> AllWindowdId1 = driver.getWindowHandles();

		// forloop 

		String orangeHrmWindowID = null;
		for(String abc :AllWindowdId1) {

			if(!abc.equals(parentWindowID) ||! abc.equals(faceWIndowID) ){

				orangeHrmWindowID = abc;

			}
		}
		driver.switchTo().window(orangeHrmWindowID);

		// step 17: find and enter value in username, password and click on login button
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		Thread.sleep(5000);
		
		driver.switchTo().window(parentWindowID);

		// step 19:find and enter value in address

		driver.findElement(By.name("address")).sendKeys("Pune");




	}

}
