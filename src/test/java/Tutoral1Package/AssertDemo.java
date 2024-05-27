package Tutoral1Package;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDemo {
	@Test
	public void pqr() {
		Assert.assertEquals(12, 3455);
		System.out.println("PQR Test cases");
	}

	//Soft dependsOnMethods
	@Test(dependsOnMethods= {"pqr"},alwaysRun=true)
	public void home() {
		System.out.println("Home Test Cases");//2
	}

	//hard dependsOnMethods
	@Test(dependsOnMethods= {"home"})
	public void login() {
		System.out.println("login Test Cases");//3
	}


}
