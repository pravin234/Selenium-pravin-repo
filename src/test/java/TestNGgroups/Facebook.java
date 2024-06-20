package TestNGgroups;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facebook {

	public static void main(String[] args) throws IOException {

		// Load the Excel file
		File f = new File("C:\\Users\\ABC\\Desktop\\Automationn\\TestNG\\inputdata.xlsx");
		if (!f.exists()) {
			System.out.println("File not found: " + f.getPath());
			return;
		}

		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1); // Assuming the Facebook data is on the second sheet

		// Get the URL from the first row and cell
		String url = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(url);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Fill the registration form
		String firstName = sheet.getRow(0).getCell(1).getStringCellValue();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys(firstName);

		String lastName = sheet.getRow(0).getCell(2).getStringCellValue();
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		String email = sheet.getRow(0).getCell(3).getStringCellValue();
		driver.findElement(By.name("reg_email__")).sendKeys(email);


		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email); // Facebook may require email confirmation

		String password = sheet.getRow(0).getCell(4).getStringCellValue();
		driver.findElement(By.name("reg_passwd__")).sendKeys(password);

		// Select the birth day
		int birthDay = (int) sheet.getRow(0).getCell(5).getNumericCellValue();
		Select daySelect = new Select(driver.findElement(By.id("day")));
		daySelect.selectByVisibleText(String.valueOf(birthDay));

		// Select the birth month
		String birthMonth = sheet.getRow(0).getCell(6).getStringCellValue();
		Select monthSelect = new Select(driver.findElement(By.id("month")));
		monthSelect.selectByVisibleText(birthMonth);

		// Select the birth year
		int birthYear = (int) sheet.getRow(0).getCell(7).getNumericCellValue();
		Select yearSelect = new Select(driver.findElement(By.id("year")));
		yearSelect.selectByVisibleText(String.valueOf(birthYear));

		// Select gender
		String gender = sheet.getRow(0).getCell(8).getStringCellValue();
		driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();

		// Submit the form
		driver.findElement(By.name("websubmit")).click();


	}
}
