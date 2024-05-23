package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class switchframeass {

	public static void main(String[] args) throws InterruptedException {
		// open a url https://chercher.tech/practice/frames-example-selenium-webdriver
		// 1 enter the topic name
		// 2 select the avatar
		// 3 select the  checkbox
		// 4 select the cat 
		// 5 capture the entered text and enter new text
		// 6 unselect the checkbox

		// step 1 upcasting
		WebDriver driver =new ChromeDriver();

		//step 2 open url
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		//step 3 enter the topic name
		driver.switchTo().frame("frame1");
		WebElement wb=	driver.findElement(By.xpath("//input[@type='text']"));
		wb.sendKeys("Selenium Automation");

		//select the avatar
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		WebElement wb1=	driver.findElement(By.xpath("//select[@id='animals']"));
		Select sel=new Select(wb1);
		sel.selectByVisibleText("Avatar");

		Thread.sleep(5000);

		//	select the  checkbox
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame("frame3");
		WebElement wb2=	driver.findElement(By.xpath("//input[@type='checkbox']"));
		wb2.click();

		//select the cat
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		sel.selectByVisibleText("Cat");

		//	capture the entered text and enter new text
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		String a= wb.getAttribute("value");
		
		wb.clear();
		wb.sendKeys("Selenium xpath topic");

		Thread.sleep(4000);

		//	unselect the checkbox
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame("frame3");
		wb2.click();
	

	}

}
