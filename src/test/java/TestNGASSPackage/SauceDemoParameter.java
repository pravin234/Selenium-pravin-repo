package TestNGASSPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoParameter {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Parameters({"uname", "pass"})
    @Test(priority = 1)
    public void loginFunction(String uname, String pass) {
        driver.findElement(By.id("user-name")).sendKeys(uname);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
    }

    @Parameters({"product1", "product2", "product3"})
    @Test(priority = 3)
    public void addToCart(String product1, String product2, String product3) {
        addProductToCart(product1);
        addProductToCart(product2);
        addProductToCart(product3);
    }

    private void addProductToCart(String productName) {
        try {
            // Construct the dynamic ID attribute for the button
            String productNameInLowerCase = productName.toLowerCase().replace(" ", "-");
            String addToCartButtonId = "add-to-cart-" + productNameInLowerCase;
            WebElement addToCartButton = driver.findElement(By.id(addToCartButtonId));
            addToCartButton.click();
        } catch (Exception e) {
            System.err.println("Product not found or could not be added to the cart: " + productName);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 



//











