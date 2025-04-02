package baseStudy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class NewBase {
	public static WebDriver driver;

	public static void launchingbrowser(String browser) throws InterruptedException {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			opt.addArguments("--disable-popup-blocking"); 
			driver = new ChromeDriver(opt); 
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win32\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-popup-blocking");

			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
		driver.get("https://eks-staging.byteachers.in/");
		Thread.sleep(1000);
		Reporter.log("launching the browser", true);
	}

	public static void firefoxdriver() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");

		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--disable-popup-blocking");

		driver = new FirefoxDriver(options);

		driver.manage().window().maximize();
		driver.get("https://eip-qa1.byteachers.in/");
		Thread.sleep(1000);
		Reporter.log("Launching the Firefox browser", true);
	}

}
