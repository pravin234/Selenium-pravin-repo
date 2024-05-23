package JSExcuterPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSEXAssign1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		//		incognito mode
		//		open a https://www.saucedemo.com/ using JavascriptExecutor
		//		maximize
		//		implicitly wait
		//						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//		explicit wait
		//		take screenshot
		//		enter firstname and last name using JavascriptExecutor
		//		click on login using JavascriptExecutor
		//		click 3 add to cart button using JavascriptExecutor
		//		click on container using JavascriptExecutor
		//		click on checkout button JavascriptExecutor
		//		enter first name, last name and pin code using JavascriptExecutor
		//		click on continue button JavascriptExecutor
		//		click on finish using JavascriptExecutor
		//		click on back using JavascriptExecutor
		//		click on menu JavascriptExecutor
		//		take full screenshot using AShot maven dependency
		//		click on logout

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--Incognito");

		WebDriver driver=  new ChromeDriver();

		driver.get("https://pravin234.github.io/ecom_pravin/pages/login.html");
		//maximize window
		driver.manage().window().maximize();

		// implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//		


		// take Screen Shot - create downcasting
		TakesScreenshot ts = (TakesScreenshot)driver;

		File src  = ts.getScreenshotAs(OutputType.FILE);

		// destination of path screen shot

		File dest = new File(System.getProperty("user.dir")+"\\JSExcuterScreenShot\\arrayss1.png");
		FileUtils.copyFile(src, dest);

		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		// use until() method from WebDriverWait class by passing ExpectedConditions as
		// visibilityOfElementLocated

		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		js.executeScript("document.getElementById('useremail').value='admin@gmail.com';");

		js.executeScript("document.getElementById('userpassword').value='admin@1234'");

		js.executeScript("document.getElementById('signup').click()");

	
		Thread.sleep(5000);


	}

}
