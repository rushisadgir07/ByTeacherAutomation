package listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilityStudy.NewUtilityStudy;

public class ListenerNew implements ITestListener {

	private WebDriver driver;

	// Default constructor
	public ListenerNew() {

	}

	public ListenerNew(WebDriver driver) {
		this.driver = driver;
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("TC is Failed Please Check", true);

		try {
			if (driver != null) {
				NewUtilityStudy.screenshot(driver, "TestFail");
			} else {
				Reporter.log("WebDriver instance is null. Cannot capture screenshot.", true);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Case Success...", true);
		try {
			if (driver != null) {
				NewUtilityStudy.screenshot(driver, "TestPass");
			} else {
				Reporter.log("WebDriver instance is null. Cannot capture screenshot.", true);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test case Skipped Please check", true);
		try {
			if (driver != null) {
				NewUtilityStudy.screenshot(driver, "TestSkipped");
			} else {
				Reporter.log("WebDriver instance is null. Cannot capture screenshot.", true);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
