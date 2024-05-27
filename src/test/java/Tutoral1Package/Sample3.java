package Tutoral1Package;

import org.testng.annotations.Test;

public class Sample3 {

	@Test(priority = -2)
	public void abc() {
		System.out.println("ABC Test Cases");
	}

	@Test(priority = 1)
	public void lmn() {
		System.out.println("LMN Test Cases");
	}

	@Test(priority = -1)
	public void pqr() {
		System.out.println("PQR Test Cases");
	}

	@Test(priority = 1)
	public void xyz() {
		System.out.println("XYZ Test Cases");
	}
}