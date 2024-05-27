package Tutoral1Package;

import org.testng.annotations.Test;

public class Sample4 {


	@Test(invocationCount = 10)
	public void abc() {
		System.out.println("ABC Test Cases");
	}

	@Test(priority = 1)
	public void xyz() {
		System.out.println("XYZ Test Cases");
	}
	
	@Test(priority = -1)
	public void pxyz() {
		System.out.println("PXYZ Test Cases");
	}
}

// here proporitycount 10 so Total tests run: 12, Passes: 12, Failures: 0, Skips: 0
