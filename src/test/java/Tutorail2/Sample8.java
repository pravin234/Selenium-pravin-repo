package Tutorail2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample8 {

	@BeforeMethod
	public void a1() {
		System.out.println("Before Method");
	}

	@Test
	public void s1() {
		System.out.println("S1 Test cases");
	}

	@Test
	public void s2() {
		System.out.println("S2 Test cases");
	}

	@AfterMethod
	public void a2() {
		System.out.println("After Method");
	}
}
