package demoWebDriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DemoNavigation {
	
	WebDriver driver;
	
	@Test
	public void f() {
		driver.get("https://www.google.com/");
		
		Assert.assertEquals(driver.getTitle(), "Google");
		
//		To navigate to other site
		driver.navigate().to("https://www.seleniumhq.org/");
		
		Assert.assertEquals(driver.getTitle(), "Selenium - Web Browser Automation");
		
//		To navigate back 
		driver.navigate().back();
		
//		To navigate forward
		driver.navigate().forward();
		
//		To refresh page
		driver.navigate().refresh();
		
		System.out.println("Page Refreshed");
		
	}
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		Dynamic Wait - Implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
