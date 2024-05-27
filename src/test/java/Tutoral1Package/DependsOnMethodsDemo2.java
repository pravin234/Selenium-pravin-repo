package Tutoral1Package;

import org.testng.annotations.Test;

public class DependsOnMethodsDemo2 {

	@Test
	public void pqr() {
		System.out.println("PQR Test Cases");//1
	}

	@Test(dependsOnMethods= {"pqr"})
	public void home() {
		System.out.println("Home Test Cases");//2
	}

	@Test(dependsOnMethods= {"pqr"})
	public void profile() {
		System.out.println("Profile Test Cases");//2
	}

	@Test(dependsOnMethods= {"pqr"})
	public void login() {
		System.out.println("login Test Cases");//3
	}

}
