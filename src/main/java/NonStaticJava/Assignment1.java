package NonStaticJava;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public String registerForm( String FirstName, String LastName, String ContactNumber, String Email, String Address, String City,
			String State, String PostalCode, String Contry, String Username, String Password,
			String ConfirmPassword) throws	 IOException, InterruptedException

	{	

		//up casting 
		WebDriver driver = new ChromeDriver();

		//open a url
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		Thread.sleep(5000);

		//find the firstname textbox
		WebElement firstname = driver.findElement(By.name("firstName"));
		firstname.sendKeys(FirstName);

		//find the lastname textbox
		WebElement lname1 = driver.findElement(By.name("lastName"));
		lname1.sendKeys(LastName);

		//find the phone textbox
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys(ContactNumber);


		//find the username textbox
		WebElement username = driver.findElement(By.name("userName"));
		username.sendKeys(Email);	

		//find the address textbox
		WebElement address = driver.findElement(By.name("address1"));
		address.sendKeys(Address);

		//find the city textbox
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys(City);

		//find the state textbox
		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys(State);

		//find the postalcode textbox
		WebElement postalcode = driver.findElement(By.name("postalCode"));
		postalcode.sendKeys(PostalCode);

		//find the contry dropdown
		WebElement contry = driver.findElement(By.name("country"));
		Select sel = new Select(contry);
		sel.selectByVisibleText(Contry);

		//find the username textbox
		WebElement username1 = driver.findElement(By.name("email"));
		username1.sendKeys(Username);

		//find the password textbox
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(Password);

		//find the confirmpassword textbox
		WebElement confirmpassword = driver.findElement(By.name("confirmPassword"));
		confirmpassword.sendKeys(ConfirmPassword);

		Thread.sleep(3000);
		// click on submit button 
		driver.findElement(By.name("submit")).click();

		// find the myname and capture
		WebElement registerUserName = driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']/child::b[contains(text(),'Dear')]"));
		String name = registerUserName.getText();
		String wordToRemove = "Dear";
		String regUserName	= name.replace(wordToRemove, "").trim();
		return regUserName;


	}

	public static void main(String[ ]args) throws IOException, InterruptedException {

		//create an obj of class

		Assignment1 obj = new Assignment1();

		// pass  parameter to function
		String regUserName = obj.registerForm("pravin", "Kadam", "9988776655", "pravinkadam@gmail.com", "Baner", "Pune", "Maharashtra", "12345", "INDIA", "pravinkadam@gmail.com", "rajdhani@234", "rajdhani@234");

		System.out.println(regUserName);

	}




}
