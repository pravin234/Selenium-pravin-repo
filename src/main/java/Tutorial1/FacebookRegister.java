package Tutorial1;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegister {

	public static void main(String[] args) {

		// connect to actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// typecasting 
		WebDriver driver = new ChromeDriver();

		// open url of fb register
		driver.get("https://facebook.com/reg");

		// find element each register form
		WebElement firstName = driver.findElement(By.name("firstname"));

		// check firstname textbox is display 
		boolean status1 = firstName.isDisplayed();
		System.out.println("firstname textbox status " + status1);

		boolean status2 = firstName.isEnabled();
		System.out.println("firstname texbox enable status" +status2);

		// set input  for textbox
		firstName.sendKeys("Pravin");

		// check enter input value using getAttribute

		String userNameInput = firstName.getAttribute("value");
		System.out.println(userNameInput);


		WebElement lastName = driver.findElement(By.name("lastname"));

		// check firstname textbox is display 
		boolean lastNamestatus1 = lastName.isDisplayed();
		System.out.println("lastName textbox status " + lastNamestatus1);

		boolean lastNamestatus2 = lastName.isEnabled();
		System.out.println("lastName texbox enable status" +lastNamestatus2);

		// set input  for textbox
		lastName.sendKeys("Kadam");

		// check enter input value using getAttribute

		String lastNameInput = lastName.getAttribute("value");
		System.out.println(lastNameInput);

		//email/Mobilenumber textbox
		WebElement email = driver.findElement(By.name("reg_email__"));

		// check firstname textbox is display 
		boolean emailStatus1 = email.isDisplayed();
		System.out.println("email textbox status " + emailStatus1);

		boolean emailStatus2 = email.isEnabled();
		System.out.println("email or mobile texbox enable status" +emailStatus2);

		// set input  for textbox
		email.sendKeys("pravinKadam230491@gmail.com");

		// check enter input value using getAttribute

		String emailInput = email.getAttribute("value");
		System.out.println(emailInput);

		//password input filed

		WebElement password = driver.findElement(By.name("reg_passwd__"));

		// check firstname textbox is display 
		boolean passwordStatus1 = password.isDisplayed();
		System.out.println("password textbox status " + passwordStatus1);

		boolean passwordStatus2 = password.isEnabled();
		System.out.println("password texbox enable status" +passwordStatus2);

		// set input  for textbox
		password.sendKeys("pravin234");

		// check enter input value using getAttribute

		String passwordInput = password.getAttribute("value");
		System.out.println(passwordInput);
		
		// dropdown purpose
		WebElement birthDay = driver.findElement(By.name("birthday_day")); 
		Select day = new Select(birthDay);
		
		day.selectByVisibleText("23");
		
		List<WebElement> daylist = day.getOptions();
		for(WebElement ab:daylist)
		{
			String dayOption = ab.getText();
			System.out.println(dayOption);
		}
		// select month 
		WebElement birthMonth = driver.findElement(By.name("birthday_month")); 
		Select month = new Select(birthMonth);
		
		month.selectByIndex(9);
		
		List<WebElement> monthList = month.getOptions();
		for(WebElement mn : monthList) {
			String monthOption = mn.getText();
			System.out.println(monthOption);
		}
		
		// select Year 
		
		WebElement birthYear = driver.findElement(By.name("birthday_year")); 
		Select year = new Select(birthYear);
		
		year.selectByVisibleText("2000");
		
		List<WebElement> yearList = year.getOptions();
		for(WebElement year1 : yearList) {
			String yearOption = year1.getText();
			System.out.println(yearOption);
		}
		
		// select gender
		WebElement gender = driver.findElement(By.name("sex"));
		boolean selecteGender = gender.isDisplayed();
		System.out.println(selecteGender);
		
		boolean n = gender.isEnabled();
		System.out.println(n);
		
		gender.click();
		boolean genderInput = gender.isSelected();
		System.out.println(genderInput);
	
		WebElement signUpButton = driver.findElement(By.name("websubmit"));
		signUpButton.click();	
		
	}

}
 