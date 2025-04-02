package learner;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveStudent {
	Actions act;
	@FindBy(xpath = "//a[text()='Account']")
	private WebElement accountWebElement;
	@FindBy(id = "dropdownBasic")
	private WebElement dropDownWebElement;
	@FindBy(xpath = "//span[text()='Activate Account']")
	private WebElement activeAccountWebElement;
	@FindBy(xpath = "//button[text()='Activate']")
	private WebElement activateWebElement;
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButtonWebElement;
	@FindBy(xpath = "//button[@class='closePopup']")
	private WebElement closeButtonWebElement;
	@FindBy(id = "dropdownBasic")
	private WebElement checkStatusWebElement;

	public ActiveStudent(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	public void activeStudent() throws InterruptedException {
		accountWebElement.click();
		Thread.sleep(1000);
		dropDownWebElement.click();
		Thread.sleep(1000);
		activeAccountWebElement.click();
		Thread.sleep(1000);
		activateWebElement.click();
		Thread.sleep(1500);
		nextButtonWebElement.click();
		Thread.sleep(2500);
		nextButtonWebElement.click();
		Thread.sleep(2500);

	}

	public void ValidateStatus() throws InterruptedException {
		accountWebElement.click();
		Thread.sleep(1000);

		String StatusText = checkStatusWebElement.getText();
		System.out.println("Student Status: " + StatusText);

		Assert.assertTrue(StatusText.equals("ACTIVE") || StatusText.equals("ADDED"),
				"Student Status: " + StatusText);

		Reporter.log("Student Status is: " + StatusText, true);
	}

}
