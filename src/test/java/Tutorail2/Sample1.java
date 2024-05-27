package Tutorail2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample1 {

	@BeforeMethod
	public void setUp() {
		System.out.println("Before Method");
	}

	@Test
	public void testCases1() {
		System.out.println("Test Cases 1");
	}

	@Test
	public void testCases2() {
		System.out.println("Test Cases 2");
	}

	@Test
	public void testCases3() {
		System.out.println("Test cases 3");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("After Method");
		System.out.println("-----------------------------");
	}

}


//[RemoteTestNG] detected TestNG version 7.4.0
//Before Method
//Test Cases 1
//After Method
//-----------------------------
//Before Method
//Test Cases 2
//After Method
//-----------------------------
//Before Method
//Test cases 3
//After Method
//-----------------------------
//PASSED: testCases2
//PASSED: testCases3
//PASSED: testCases1
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