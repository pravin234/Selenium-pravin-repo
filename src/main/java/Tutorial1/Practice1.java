package Tutorial1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//		/*1) open a edge/chrome browser
		//		2) open a url https://copyright.gov.in/UserRegistration/frmNewUser.aspx
		//		3) capture the title
		//		4) and verify the "Registration" keyword is present or not if present the print title test cases is pass else fail
		//		5) open  new tab
		//		6) open a url https://demoqa.com/buttons
		//		7) capture the url
		//		8) navigate to https://ui.cogmento.com/ url
		//		9) capture the title
		//		10) navigate to url https://www.irctc.co.in/nget/train-search 
		//		11) capture url
		//		12) navigate back
		//		13) capture url
		//		14) navigate forward 
		//		15) capture title
		//		16) close all window

		//connect to browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// 1 open url https://copyright.gov.in/UserRegistration/frmNewUser.aspx
		driver.get("https://copyright.gov.in/UserRegistration/frmNewUser.aspx");

		//2 capture the current url title
		String title = driver.getTitle();
		System.out.println(title);

		//3 & 4 verify the "Registration" keyword is present or not if present the print title test cases is pass else fail
		if(title.contains("Registration")) {
			System.out.println("keyword is match inside string");	
		}
		else {
			System.out.println("no keywords fouds");
		}

		//5 open  new tab

		driver.switchTo().newWindow(WindowType.TAB);

		//6) open a url https://demoqa.com/buttons

		driver.get("https://demoqa.com/buttons");

		//7 capture the url
		String newTabTitle = driver.getTitle();

		System.out.println(newTabTitle);

		//10) navigate to url https://www.irctc.co.in/nget/train-search 

		driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		//11 capture title

		String navTitle = driver.getTitle();
		System.out.println(navTitle);

		//12) navigate back
		driver.navigate().back();

		// 13 capture the url
		String navBackUrl = driver.getCurrentUrl();
        
		System.out.println(navBackUrl);

		//14) navigate forward

		driver.navigate().forward() ;

		//15) capture title

		String forwordUrl = driver.getCurrentUrl();
		System.out.println(forwordUrl);

		//16) close all window
		driver.close();

	}

}
