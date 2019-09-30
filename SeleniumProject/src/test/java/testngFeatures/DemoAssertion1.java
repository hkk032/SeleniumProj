package testngFeatures;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAssertion1 {
	@Test
	public void test1() {
		Assert.assertEquals("Bye", "GoodBye");
	}
	
	@Test
	public void test2() {
		Assert.assertNotEquals("Bye", "GoodBye");
	}
	
	@Test
	public void test3() {
		Assert.assertTrue("Selenium".contains("Sel"), "Not contains");
	}
	
	@Test
	public void test4() {
		Assert.assertFalse(20<10, "10 is less than 20");
	}
	
	@Test
	public void Test5() {
		Object obj = null;
		Assert.assertNull(obj, "Object is null");
	}
	
	@Test
	public void Test6() {
		Assert.fail("Failing");
	}
}
