package screenShotPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class DemoFullScr {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Step 1: connect to actual browser
			//	System.setProperty("webdriver.chrome.driver", "D:\\SofttechClass_2024\\chromedriver-win64\\chromedriver.exe");

						// step 2: up casting
						WebDriver driver = new ChromeDriver();

						// step 3: open a url
						driver.get("https://github.com/rest-assured/rest-assured/wiki/Usage");

						// step 4: create object of AShot class

						AShot a = new AShot();

						// step 5: use shootingStrategy() method to capture the visible part of the web
						// page screenshot and use viewPortPasting() method from ShootingStrategies
						// class to capture
						// screenshot of remaining web page by scrolling web page and by mentioning
						// scrolling to wait

						a.shootingStrategy(ShootingStrategies.viewportPasting(3000));

						// step 6: use takeScreenshot by passing WebDriver instance
						Screenshot sc = a.takeScreenshot(driver);

						// step 7: get the captured screenshot using getImage() method

						BufferedImage scr = sc.getImage();

						// step 8: store screenshot in destination location by creating object of File
						// class
						File dest = new File("C:\\Users\\ABC\\git\\repository\\SalenuimTutorail\\assignment\\file1.png");
						// step 8: copy the screenshot from source to destination location using write()
						// method and
						// by passing source location and image type and destination location.

						ImageIO.write(scr, "PNG",dest);




	}

}
