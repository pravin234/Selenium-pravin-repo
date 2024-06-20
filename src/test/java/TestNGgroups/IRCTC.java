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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTC {
    public static void main(String[] args) throws IOException {
        
        File f = new File("C:\\Users\\ABC\\Desktop\\Automationn\\TestNG\\inputdata.xlsx");
        if (!f.exists()) {
            System.out.println("File not found: " + f.getPath());
            return;
        }
        
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        XSSFSheet sheet = workbook.getSheetAt(2);
        String url = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println("Navigating to URL: " + url);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        try {
        	 String uname = sheet.getRow(0).getCell(1).getStringCellValue();
             
             
             WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")));
             usernameField.sendKeys(uname);

             String upassword = sheet.getRow(0).getCell(2).getStringCellValue();
             WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usrPwd")));
             passwordField.sendKeys(upassword);
             
             
            System.out.println("Form submitted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
