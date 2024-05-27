package Tutoral1Package;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreTestCase {

	@Test
	public void testCases1() {
		System.out.println("Test cases 1");
	}

	@Ignore
	@Test
	public void testCases2() {
		System.out.println("Test cases 2");
	}

	@Test
	public void testCases3() {
		System.out.println("Test cases 3");
	}
}

