package demodrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		
//		Web driver instance to connect to web browser
		WebDriver driver;
		
//		Communicate with web browser
//		key: name of driver, value: path of driver
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		
//		import chrome driver into instance
//		open chrome browser
		driver = new ChromeDriver();
		
//		open website
		driver.get("https://www.gmail.com");
		
//		open browser in maximized form
		driver.manage().window().maximize();
		
//		wait for 3 sec before closing
		Thread.sleep(3000);
		
//		closing the browser
		driver.close();
		
	}

}
