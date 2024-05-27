package Tutorail2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Pune8 {
	@BeforeClass
	public void b1() {
		System.out.println("Before Class");
	}

	@Test
	public void p1() {
		System.out.println("P1 Test cases");
	}

	@Test
	public void p2() {
		System.out.println("P2 Test cases");
	}

	@AfterClass
	public void b2() {
		System.out.println("After class");
	}


}
