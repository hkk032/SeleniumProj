//package demoDDT;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class abcd {	
//	WebDriver driver;
//
//	@Test(dataProvider = "getData")
//	public void f(String uname, String pass) throws InterruptedException {
//		driver.get("http://newtours.demoaut.com/");
//		driver.findElement(By.linkText("Home")).click();
//		driver.findElement(By.name("userName")).sendKeys(uname);
//		driver.findElement(By.name("password")).sendKeys(pass);
//		driver.findElement(By.name("login")).click();
//	}
//	
//	@BeforeTest
//	public void beforeTest() {
//		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//	}
//
//	@AfterTest
//	public void afterTest() {
//		driver.close();
//	}
//	
//	@DataProvider
//	public Object[][] getData() throws IOException {
//		return ImportUserData.ReadData();
//	}
//}
