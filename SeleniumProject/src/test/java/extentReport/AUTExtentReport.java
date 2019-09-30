package extentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AUTExtentReport {
	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	@Test
	public void failTestDemoWebShop() {
		logger = extent.createTest("failTest");
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("Passw")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'SignOut')]")).isDisplayed());
		driver.findElement(By.xpath("//a[contains(.,'SignOut')]")).click();
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			TakesScreenshot snapshot = ((TakesScreenshot)driver);
			File src = snapshot.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/extent-reports/snapshots/" + result.getName() + ".png";
//			FileHandler.copy(src, new File(path));
			FileUtils.copyFile(src, new File(path));
			logger.addScreenCaptureFromPath(path, result.getName());
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
	}

	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/extent-reports/" + new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date()) + ".html");
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "GFT NextGen Testing Stream");
		extent.setSystemInfo("Environment", "Automation Testing - Selenium");
		extent.setSystemInfo("User Name", "Aswani Kumar Avilala");
		
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
		htmlReporter.config().setReportName("Name of the Report Comes here");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

}
