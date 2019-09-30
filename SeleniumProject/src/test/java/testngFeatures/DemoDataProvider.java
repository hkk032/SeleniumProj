package testngFeatures;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DemoDataProvider {
	@Test(dataProvider = "dp")
	public void f(String userName, String password) {
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { "abc", "def" },
			new Object[] { "testing", "training" },
			new Object[] { "hemant", "kumar" },
		};
	}
	
//	*****Alternate way*****
//	@Test(dataProvider = "credentials")
//	public void f(String userName, String password) {
//		System.out.println("Username: " + userName);
//		System.out.println("Password: " + password);
//	}
//
//	@DataProvider(name="credentials")
//	public Object[][] dp() {
//		return new Object[][] {
//			new Object[] { "abc", "def" },
//			new Object[] { "testing", "training" },
//			new Object[] { "hemant", "kumar" },
//		};
//	}
}
