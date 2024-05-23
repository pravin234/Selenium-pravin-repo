package actionsPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionAssign1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Ass:
//			open a https://swisnl.github.io/jQuery-contextMenu/demo.html
//			find and right click on right click me button
//			find and click on copy button
//			switch focus to alert pop up, capture the text and click on ok button

		
		//upcasting
		
		WebDriver driver = new ChromeDriver();
		
		// open url 
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		
	}

}
