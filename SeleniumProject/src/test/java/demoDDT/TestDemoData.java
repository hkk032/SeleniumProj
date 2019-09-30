package demoDDT;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestDemoData {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	@Test(dataProvider = "login")
	public void first(String fname, String lname, String city, String uname, String pass, String cpass) throws Exception  {
		driver.get("http://www.newtours.demoaut.com/");
		driver.findElement(By.xpath("//a[contains(.,'REGISTER')]")).click();
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("confirmPassword")).sendKeys(cpass);
		driver.findElement(By.name("register")).click();
		Thread.sleep(2000);
	}

	@DataProvider(name="login")
	public Object[][] dp() throws Exception {
		return ImportUserData.ReadData();
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}