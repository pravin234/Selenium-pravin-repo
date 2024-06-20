package TestNGgroups;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {

	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\ABC\\Desktop\\Automationn\\TestNG\\inputdata.xlsx");
		boolean a = f.exists();
		System.out.println(a);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String url = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(url);

		WebDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//apply pageloadTimeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(url);
		
		String firstname = sheet.getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.name("firstName")).sendKeys(firstname);

		String lastname = sheet.getRow(2).getCell(0).getStringCellValue();
		driver.findElement(By.name("lastName")).sendKeys(lastname);

		String phoneNumber = sheet.getRow(3).getCell(0).getRawValue();
		driver.findElement(By.name("phone")).sendKeys(phoneNumber);

		String email = sheet.getRow(4).getCell(0).getStringCellValue();
		driver.findElement(By.name("userName")).sendKeys(email);

		String address = sheet.getRow(5).getCell(0).getStringCellValue();
		driver.findElement(By.name("address1")).sendKeys(address);

		String city = sheet.getRow(6).getCell(0).getStringCellValue();
		driver.findElement(By.name("city")).sendKeys(city);

		String state = sheet.getRow(7).getCell(0).getStringCellValue();
		driver.findElement(By.name("state")).sendKeys(state);

		String postalcode = sheet.getRow(8).getCell(0).getRawValue();
		driver.findElement(By.name("postalCode")).sendKeys(postalcode);

		WebElement dropdown = driver.findElement(By.name("country"));

		Select sel = new Select(dropdown);
		String country = sheet.getRow(9).getCell(0).getStringCellValue();
		sel.selectByVisibleText(country);

		String mail = sheet.getRow(10).getCell(0).getStringCellValue();
		driver.findElement(By.name("email")).sendKeys(mail);

		String password = sheet.getRow(11).getCell(0).getStringCellValue();
		driver.findElement(By.name("password")).sendKeys(password);

		String confirmpassword = sheet.getRow(12).getCell(0).getStringCellValue();
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);

		driver.findElement(By.name("submit")).click();

	}


}
