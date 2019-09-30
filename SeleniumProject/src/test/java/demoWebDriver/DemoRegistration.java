package demoWebDriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DemoRegistration {
	
	WebDriver driver;
	
	@Test
	public void f() throws InterruptedException {
		driver.get("http://newtours.demoaut.com/");
		
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
		
		driver.findElement(By.linkText("REGISTER")).click();
		
		Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("hemant");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8056745678");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("hk@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("hadapsar");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("pune");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("maharashtra");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("412307");
		
		Select cName = new Select(driver.findElement(By.name("country")));
		cName.selectByValue("50");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hemu");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@name='register']")).submit();
		
		
		Thread.sleep(3000);
	}
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
