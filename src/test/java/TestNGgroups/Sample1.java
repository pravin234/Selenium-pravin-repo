package TestNGgroups;

import org.testng.annotations.Test;

public class Sample1 {

	@Test(groups = { "SanityTesting","End2EndTesting" })

	public void s1() {
		System.out.println("S1 Test cases ::: SanityTesting group");
	}

	@Test(groups = { "RegressionTesting","End2EndTesting" }, dependsOnGroups= {"SanityTesting"})
	public void s2() {
		System.out.println("S2 Test Cases ::: RegressionTesting Group");
	}

	@Test(groups = { "SystemTesting","End2EndTesting" })
	public void s3() {
		System.out.println("S3 Test Cases ::: SystemTesting Group");
	}

}
