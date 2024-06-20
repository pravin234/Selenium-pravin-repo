package AmazonWeb;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AmazonWebsiteAddressAutoSubmit {
    private static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        try {
            driver.get("https://www.amazon.in/a/addresses/add?ref=ya_address_book_add_post");

            LoginPage loginPage = new LoginPage();
            loginPage.login("9403739410", "Pravin@234");

            NewAddressDetails addressDetails = new NewAddressDetails();
            addressDetails.fillAddressDetails("Pravin Kadam", "9403739410", "411045", "Paacard club road", "Baner", "Pune", "Maharashtra");

            addressDetails.clickSubmitButton(wait);

            // Edit address part
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-new-address-popover-link")));

            // Check whether address got added successfully
            driver.get("https://www.amazon.in/a/addresses");
            // Additional verification steps can be added here

            System.out.println("Successfully performed the operation of adding address");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    static class LoginPage {
        @FindBy(id = "ap_email")
        private WebElement username;
        @FindBy(id = "ap_password")
        private WebElement password;
        @FindBy(id = "signInSubmit")
        private WebElement signInButton;
        @FindBy(id = "continue")
        private WebElement continueButton;

        public LoginPage() {
            PageFactory.initElements(driver, this);
        }

        public void login(String email, String password) {
            username.sendKeys(email);
            continueButton.click();
            this.password.sendKeys(password);
            signInButton.click();
        }
    }

    static class NewAddressDetails {
        @FindBy(id = "address-ui-widgets-enterAddressFullName")
        private WebElement fullName;
        @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
        private WebElement phoneNumber;
        @FindBy(id = "address-ui-widgets-enterAddressPostalCode")
        private WebElement postalCode;
        @FindBy(id = "address-ui-widgets-enterAddressCity")
        private WebElement city;
        @FindBy(id = "address-ui-widgets-enterAddressLine1")
        private WebElement addressLine1;
        @FindBy(id = "address-ui-widgets-enterAddressLine2")
        private WebElement addressLine2;
        @FindBy(id = "address-ui-widgets-enterAddressStateOrRegion")
        private WebElement stateOrRegion;
        @FindBy(className = "a-button-input")
        private WebElement submitButton;

        public NewAddressDetails() {
            PageFactory.initElements(driver, this);
        }

        public void fillAddressDetails(String fullNameText, String phoneNumberText, String postalCodeText,
                                       String addressLine1Text, String addressLine2Text, String cityText, String stateText) throws IOException {
            fullName.sendKeys(fullNameText);
            phoneNumber.sendKeys(phoneNumberText);
            postalCode.sendKeys(postalCodeText);
            addressLine1.sendKeys(addressLine1Text);
            addressLine2.sendKeys(addressLine2Text);
            city.sendKeys(cityText);
            stateOrRegion.sendKeys(stateText);

            takeScreenshot("amazonAddress");
        }

        public void clickSubmitButton(WebDriverWait wait) {
            submitButton.click();
            wait.until(ExpectedConditions.invisibilityOf(submitButton));
        }

        public void takeScreenshot(String fileName) throws IOException {
            AShot ashot = new AShot();
            ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000));
            Screenshot sc = ashot.takeScreenshot(driver);
            SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy_HHmmss");
            String date1 = simple.format(new Date());

            BufferedImage src = sc.getImage();
            File destDir = new File(System.getProperty("user.dir") + "\\amazon");
            if (!destDir.exists()) {
                destDir.mkdir(); // create the directory if it doesn't exist
            }
            File dest = new File(destDir.getPath() + "\\" + fileName + date1 + ".png");
            ImageIO.write(src, "PNG", dest);
        }
    }
}
