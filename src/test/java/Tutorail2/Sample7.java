package Tutorail2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample7 {

	@BeforeTest
	public void a1() {
		System.out.println("Before Test");
	}

	@Test
	public void s1() {
		System.out.println("S1 Test Cases");
	}

	@Test
	public void s2() {
		System.out.println("S2 Test Cases");
	}

	@AfterTest
	public void a2() {
		System.out.println("After Test");
	}
	
}
