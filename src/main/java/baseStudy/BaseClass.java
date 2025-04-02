package baseStudy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import utilityStudy.NewUtilityStudy;

public class BaseClass {
	public static WebDriver driver;

	public static void launchB() throws InterruptedException, IOException {
		if (driver == null) { // Ensure driver is initialized only once
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			opt.addArguments("--disable-popup-blocking");

			driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
			driver.get(NewUtilityStudy.dataFromPropertiefile("url"));
			Thread.sleep(1000);
			Reporter.log("Launching the browser", true);
		}
	}

}
