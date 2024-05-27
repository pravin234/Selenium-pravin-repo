package Tutoral1Package;

import org.testng.annotations.Test;

public class IngnoreTestCase2 {

	@Test
	public void testCases1() {
		System.out.println("Test cases 1");
	}

	@Test
	public void testCases2() {
		System.out.println("Test cases 2");
	}

	@Test(enabled = false)
	public void testCases3() {
		System.out.println("Test cases 3");
	}
}

//[RemoteTestNG] detected TestNG version 7.4.0
//Test cases 1
//Test cases 2
//PASSED: testCases1
//PASSED: testCases2
//
//===============================================
//    Default test
//    Tests run: 2, Failures: 0, Skips: 0