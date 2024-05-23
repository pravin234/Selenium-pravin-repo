package windowHandle;

import java.util.ArrayList;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleArrDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//		open a https://prafpawar11.github.io/multiplewindows.html
		//		capture title
		//		click on facebook link
		//		capture all window id
		//		convert Set<String> into ArrayList<String> because  by using ArrayList object we can capture window id as per the index position.
		//		capture fb window id
		//		switch focus to facebook window
		//		capture the title
		//		capture the main window id
		//		switch focus to main window
		//		capture url
		//		click on  cogmento CRM link
		//		capture all window id 
		//		convert Set<String> into ArrayList<String> because  by using ArrayList object we can capture window id as per the index position.
		//		capture the cogmento CRM window id number
		//		switch focus to cogmento CRM window
		//		capture title
		//		switch focus to fb window 
		//		capture url
		//		switch focus to main window
		//		capture url
		//		switch focus to cogmento CRM window 
		//		capture url
		//

		WebDriver driver = new ChromeDriver();
		//open a https://prafpawar11.github.io/multiplewindows.html

		driver.get("https://prafpawar11.github.io/multiplewindows.html");

		//capture title

		String title=   driver.getTitle();

		System.out.println(title);

		//		click on facebook link
		driver.findElement(By.linkText("Visit Facebook")).click();

		//capture all window id
		Set<String> AllWIndowId = driver.getWindowHandles();


		//		convert Set<String> into ArrayList<String> because  by using ArrayList object we can capture window id as per the index position.
		ArrayList<String> arr = new ArrayList<String>(AllWIndowId);
		//switch focus to facebook window
		driver.switchTo().window(arr.get(1));


		//capture the title
		System.out.println("facebook page  title " + driver.getTitle());
		Thread.sleep(5000);

		//capture the main window id
		String parentWIndowId = arr.get(0);
		System.out.println(parentWIndowId);

		//		switch focus to main window
		driver.switchTo().window(parentWIndowId);

		//capture url
		System.out.println("Current Url is "+ driver.getCurrentUrl());
		Thread.sleep(5000);
		//click on  cogmento CRM link

		driver.findElement(By.linkText("cogmento CRM Link")).click();

		//capture all window id

		AllWIndowId = driver.getWindowHandles();

		//convert Set<String> into ArrayList<String> because  by using ArrayList object we can capture window id as per the index position.
		arr = new ArrayList<String>(AllWIndowId);

		//capture the cogmento CRM window id number
		//String cogmentoWindowId = arr.get(2);
		Thread.sleep(5000);

		//switch focus to cogmento CRM window
		driver.switchTo().window(arr.get(2));

		//capture title
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);

		//switch focus to fb window 
		driver.switchTo().window(arr.get(1));

		//capture url
		System.out.println(driver.getCurrentUrl());
		//switch focus to main window
		driver.switchTo().window(arr.get(0));
		//capture url
		System.out.println(driver.getCurrentUrl());

		//switch focus to cogmento CRM window 

		driver.switchTo().window(arr.get(2));

		//capture url
		System.out.println(driver.getCurrentUrl());


	}

}
