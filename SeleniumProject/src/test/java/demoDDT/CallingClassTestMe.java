package demoDDT;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CallingClassTestMe {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	@Test(dataProvider = "login")
	public void f(String username, String password) throws Exception  {
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//a[contains(.,'SignIn')]")).click();
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'SignOut')]")).click();
		Thread.sleep(5000);
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