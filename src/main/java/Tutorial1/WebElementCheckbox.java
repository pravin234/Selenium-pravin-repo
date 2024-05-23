package Tutorial1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// step 1: connect actual browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		// step 2: up casting
		WebDriver driver = new ChromeDriver();

		// step 3: open a url
		driver.get("https://demo.automationtesting.in/Register.html");

		// step 4: find the cricket checkbox
		WebElement wb = driver.findElement(By.id("checkbox1"));

		/// step 5: check the cricket check box displayed status
		boolean a = wb.isDisplayed();
		System.out.println(a);//true

		/// step 6: check the cricket check box enabled status
		boolean b = wb.isEnabled();
		System.out.println(b);//true

		//step 7: check the cricket checkbox selected status
		boolean c = wb.isSelected();
		System.out.println(c);//false

		///step 8:click on cricket checkbox
		wb.click();

		//step 9:check the cricket checkbox selected status
		boolean d =wb.isSelected();
		System.out.println(d);//true

		//step 10: find the movies checkbox
		WebElement wb1 = driver.findElement(By.id("checkbox2"));


		//step 11: click on movies checkbox
		wb1.click();

		//step 12: check cricket checkbox selected status
		boolean f = wb.isSelected();
		System.out.println(f);//true

		//step 13:movies checkbox displayes
		boolean g = wb1.isDisplayed();
		System.out.println(g);

		//step 14: movies checkbox enabled status
		boolean h = wb1.isEnabled();
		System.out.println(h);

		//step 15: movies check box selected status
		boolean i = wb1.isSelected();
		System.out.println(i);


	}

}
