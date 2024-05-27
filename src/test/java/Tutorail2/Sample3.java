package Tutorail2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample3 {

	@BeforeClass
	public void a1() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void b1() {
		System.out.println("Before Method");
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

	@AfterMethod
	public void b2() {
		System.out.println("After Method");
		System.out.println("-------------------");
	}

	@AfterClass
	public void a2() {
		System.out.println("After Class");
		System.out.println("===================================");
	}

}


//
//[RemoteTestNG] detected TestNG version 7.4.0
//Before Class
//Before Method
//Test cases 1
//After Method
//-------------------
//Before Method
//Test cases 2
//After Method
//-------------------
//Before Method
//Test cases 3
//After Method
//-------------------
//After Class
//===================================
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
//===============================================
//
