package TestNGPackage;

import org.testng.annotations.Test;

public class Demo1 {
	@Test(priority =1)
	
	public  void registerFunction() {
		System.out.println("registerFunction");
	}
	@Test
	public  void loginfunction() {
		System.out.println("login");
	}
	@Test
	public  void pqr() {
		System.out.println("Pqr");
	}
	

}
