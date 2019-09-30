package testngFeatures;

import org.testng.annotations.Test;

public class MercuryApplication {
	
//	Creating multiple test annotations
	
	@Test(priority=1)
	public void openBrowser() {
		System.out.println("openBrowser");
	}
	
	@Test(priority=2)
	public void openURL() {
		System.out.println("openURL");
	}
	
	@Test(priority=3)
	public void Login() {
		System.out.println("login");
	}
	
	@Test(priority=4)
	public void searchFlight() {
		System.out.println("searchFlight");
	}
	
	@Test(priority=5, enabled=false)
	public void bookFlight() {
		System.out.println("bookFlight");
	}
	
	@Test(priority=6)
	public void logout() {
		System.out.println("logout");
	}
	
	@Test(priority=7)
	public void closeBrowser() {
		System.out.println("closeBrowser");
	}
}
