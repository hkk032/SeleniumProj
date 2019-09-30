package demoWebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class DemoAlert {
	
	WebDriver driver;
	
	@Test
	public void f() {
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		driver.findElement(By.xpath("//a[contains(.,'Alert with Textbox')]")).click();
		
//		Dynamic Wait - Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Alert with Textbox')]")));
		
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		
//		SwitchTo WebDriver Method
		Alert alertBox = driver.switchTo().alert();
		
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		
		alertBox.sendKeys("Hemant");
		alertBox.accept();
	}
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
