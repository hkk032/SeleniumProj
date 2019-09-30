package demoActions;

import org.testng.annotations.Test;

import junit.framework.Assert;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DemoHandBag {
	WebDriver driver;
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		
		WebElement about = driver.findElement(By.xpath("//span[contains(.,'AboutUs')]"));
		
		Actions act1 = new Actions(driver);
		
		act1.moveToElement(about).click().build().perform();
		act1.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Our\n" + 
				"												Offices')]"))).click().build().perform();
//		act1.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Bangalore')]"))).click().build().perform();
//		
//		Set<String> set = driver.getWindowHandles();
//		for(String string : set) {
//			driver.switchTo().window(string);
//		}
//		
//		driver.switchTo().frame(driver.findElement(By.name("main_page")));
		
//		For Bangalore
//		String add = driver.findElement(By.tagName("address")).getText();
//		System.out.println(add);
		
//		Verify contact details of chennai is displayed
		act1.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Chennai')]"))).click().build().perform();
		
		Set<String> set = driver.getWindowHandles();
		for(String string : set) {
			driver.switchTo().window(string);
		}
		
		driver.switchTo().frame(driver.findElement(By.name("main_page")));
		
		String add = driver.findElement(By.tagName("address")).getText();
		Assert.assertTrue(add.contains("Chennai"));;
  }
}
