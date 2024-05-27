package Tutorail2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mumbai8 {
	
	@BeforeTest
	public void c1() {
		System.out.println("Before test");
	}

	@Test
	public void m1() {
		System.out.println("M1 Test Cases");
	}

	@Test
	public void m2() {
		System.out.println("M2 Test Cases");
	}

	@AfterTest
	public void c2() {
		System.out.println("After test ");
	}


}


//Before test
//M1 Test Cases
//M2 Test Cases
//After test 
//PASSED: m1
//PASSED: m2




// after run pune8 sampe8 mumbai 8

//Before test
//
//Before Class
//P1 Test cases
//P2 Test cases
//After class
//
//Before Method
//S1 Test cases
//After Method
//Before Method
//S2 Test cases
//After Method
//
//M1 Test Cases
//M2 Test Cases
//
//After test