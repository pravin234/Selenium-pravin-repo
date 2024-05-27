package TestNGPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample1 {
	@Parameters({"username"})
	@Test
	public void loginFunctionality(String abc)
	{
		System.out.println(abc);
	}

}
