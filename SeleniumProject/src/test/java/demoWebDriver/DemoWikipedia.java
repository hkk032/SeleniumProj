package demoWebDriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DemoWikipedia {
	
	WebDriver driver;
	
	@Test
	public void f() {
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		Assert.assertEquals(driver.getTitle(), "Wikipedia, the free encyclopedia");
		
		driver.findElement(By.linkText("History")).click();
		
		Assert.assertEquals(driver.getTitle(), "Portal:History - Wikipedia");
		
//		To print current page URL
		String url = driver.getCurrentUrl();
		System.out.println("Current page URL is: " + url);
		
//		To print current page HTML code
		System.out.println(driver.getPageSource());
	}
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		Dynamic Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
