package demodrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenIE {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;

		System.setProperty("webdriver.ie.driver", "resources\\IEDriverServer.exe");

		driver = new InternetExplorerDriver();

		driver.get("https://www.gmail.com");

		driver.manage().window().maximize();

		Thread.sleep(3000);

		driver.close();

	}

}
