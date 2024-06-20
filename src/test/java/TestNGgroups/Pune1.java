package TestNGgroups;

import org.testng.annotations.Test;

public class Pune1 {
	@Test(groups = { "SanityTesting","End2EndTesting" })
	public void p1() {
		System.out.println("P1 Test cases ::: SanityTesting group");
	}

	@Test(groups = { "RegressionTesting","End2EndTesting" },dependsOnGroups= {"SanityTesting"})
	public void p2() {
		System.out.println("P2 Test Cases ::: RegressionTesting Group");
	}

	@Test(groups = { "SystemTesting","End2EndTesting" })
	public void p3() {
		System.out.println("P3 Test Cases ::: SystemTesting Group");
	}

}
