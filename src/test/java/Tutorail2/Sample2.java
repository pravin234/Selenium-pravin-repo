package Tutorail2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample2 {
	
	@BeforeClass
	public void a1() {
		System.out.println("BeforeClass");
	}

	@Test
	public void testCases1() {
		System.out.println("Test cases 1");
	}

	@Test
	public void testCases2() {
		System.out.println("Test cases 2");
	}

	@Test
	public void testCases3() {
		System.out.println("Test cases 3");
	}

	@AfterClass
	public void b2() {
		System.out.println("After Class");
	}

}


//[RemoteTestNG] detected TestNG version 7.4.0
//BeforeClass
//Test cases 1
//Test cases 2
//Test cases 3
//After Class
//PASSED: testCases1
//PASSED: testCases2
//PASSED: testCases3
//
//===============================================
//    Default test
//    Tests run: 3, Failures: 0, Skips: 0
//===============================================
//
//
//===============================================
//Default suite
//Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
