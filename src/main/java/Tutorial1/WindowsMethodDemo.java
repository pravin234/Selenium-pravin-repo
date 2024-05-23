package Tutorial1;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsMethodDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");

		// upcasting
		ChromeDriver driver  = new ChromeDriver();

		driver.get("https://www.facebook.com");

		String url = driver.getCurrentUrl();
		System.out.println(url);

		// maximize window
		driver.manage().window().maximize();

		Thread.sleep(2000);
		// minimize 
		driver.manage().window().minimize();

		Thread.sleep(2000);
		// fullscreen window after 2 second
		driver.manage().window().fullscreen();
		
		Thread.sleep(2000);
		
		driver.quit();







	}

}


