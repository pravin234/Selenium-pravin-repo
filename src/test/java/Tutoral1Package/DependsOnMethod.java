package Tutoral1Package;

import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test(dependsOnMethods={"pqr"})
	public void abc() 
	{
		System.out.println("ABC Test Cases");
	}

	@Test
	public void pqr() 
	{
		System.out.println("PQR Test Cases");
	}

	@Test(dependsOnMethods={"abc"})
	public void xyz() 
	{
		System.out.println("xyz Test Cases");
	}

}