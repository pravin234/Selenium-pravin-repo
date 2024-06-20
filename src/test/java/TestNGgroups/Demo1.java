package TestNGgroups;

import org.testng.annotations.Test;

public class Demo1 {
	
	@Test(groups = { "SanityTesting","End2EndTesting" })
	public void d1() {
		System.out.println("D1 Test cases ::: SanityTesting group");
	}

	@Test(groups = { "RegressionTesting","End2EndTesting" }, dependsOnGroups = { "SanityTesting" })
	public void d2() {
		System.out.println("D2 Test Cases ::: RegressionTesting Group");
	}

	@Test(groups = { "SystemTesting","End2EndTesting" })
	public void d3() {
		System.out.println("D3 Test Cases ::: SystemTesting Group");
	}


}
