package Tutorail9;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample {
	@BeforeMethod
	public void abc() {
		System.out.println("Before Method ABC		:::		1");
	}

	@BeforeMethod
	public void aaa() {
		System.out.println("Before Method AAA		:::		1");
	}

	@Test
	public void s1() {
		System.out.println("S1 Test cases			:::		3");
	}
	
	@Test
	public void s2() {
		System.out.println("S2 Test cases			:::		3");
	}

	@AfterMethod
	public void bbb() {
		System.out.println("After Method BBB		:::		4");
	}

	@AfterMethod
	public void ccc() {
		System.out.println("After Method CCC		:::		5");
	}

}
//[RemoteTestNG] detected TestNG version 7.4.0
//Before Method AAA		:::		1
//Before Method ABC		:::		1
//S1 Test cases			:::		3
//After Method BBB		:::		4
//After Method CCC		:::		5
//Before Method AAA		:::		1
//Before Method ABC		:::		1
//S2 Test cases			:::		3
//After Method BBB		:::		4
//After Method CCC		:::		5
//PASSED: s1
//PASSED: s2
//
//===============================================
//    Default test
//    Tests run: 2, Failures: 0, Skips: 0
//===============================================
//
//
//===============================================
//Default suite
//Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
//===============================================
//
