package Tutoral1Package;

import org.testng.annotations.Test;

public class Sample5 {
	
	@Test(timeOut = 5000)
	public void abc() throws InterruptedException {
		Thread.sleep(8000);
		System.out.println("ABC Test Cases");
	}

	@Test
	public void pqr() {
		System.out.println("PQR Test Cases");
	}

}
