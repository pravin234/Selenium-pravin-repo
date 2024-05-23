package JavaPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NonStaticGuru {

	//	First Name:	
	//		Last Name:	
	//		Phone:	
	//		Email:	
	//		Mailing Information
	//		Address:	
	//		City:	
	//		State/Province:	
	//		Postal Code:	
	//		Country:	
	//		ALBANIA
	//		User Information
	//		User Name:	
	//		Password:	
	//		Confirm Password:



	public void registerForm(String firstName, String lastName,String mobile,String userName,String address ,String city,String state,String postalCode ,
			String country,String email,String password,String confirmPassword,String fileName) throws IOException {

		// upcasting
		WebDriver driver = new ChromeDriver();

		// open url

		driver.get("https://demo.guru99.com/test/newtours/register.php");

		// find element - all input

		WebElement first_name = driver.findElement(By.name("firstName"));

		first_name.sendKeys(firstName);

		WebElement last_name= driver.findElement(By.name("lastName"));
		last_name.sendKeys(lastName);


		WebElement contact_number = driver.findElement(By.name("phone"));
		contact_number.sendKeys(mobile);

		WebElement user_email1 = driver.findElement(By.name("userName"));
		user_email1.sendKeys(email);


		WebElement address_details = driver.findElement(By.name("address1"));
		address_details.sendKeys(address);

		WebElement city_name = driver.findElement(By.name("city"));
		city_name.sendKeys(address);


		WebElement state_name = driver.findElement(By.name("state"));
		state_name.sendKeys(state);

		WebElement postal_code = driver.findElement(By.name("postalCode"));
		postal_code.sendKeys(postalCode);


		WebElement country_name = driver.findElement(By.name("country"));

		Select sel = new Select(country_name);
		sel.selectByVisibleText(country);


		WebElement user_email = driver.findElement(By.name("email"));
		user_email.sendKeys(email);


		WebElement user_password = driver.findElement(By.name("password"));
		user_password.sendKeys(password);


		WebElement user_confpass = driver.findElement(By.name("confirmPassword"));
		user_confpass.sendKeys(confirmPassword);

		//
		TakesScreenshot shot = (TakesScreenshot)driver;
		//src ,dest, copy file
		File src = shot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir")+"\\guru99\\"+ fileName );
		
		FileUtils.copyFile(src, dest);
		
		
		WebElement submit_button = driver.findElement(By.name("submit"));

		submit_button.click();
		
		

	}
	public static void main(String[] args) throws IOException {

		// create an obj clas
		NonStaticGuru obj = new NonStaticGuru();

		obj.registerForm("rajdhani","Kadam","9876543210","rajdhanu234@gmail.com","Baner pancard" ,"Pune","Maharashtra","411045","INDIA","rajdhanu234@gmail.com","pravin@234","pravin@234","regscreen.jpg");


	}

}
