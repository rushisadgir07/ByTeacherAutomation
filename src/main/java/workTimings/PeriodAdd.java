package workTimings;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class PeriodAdd {
	@FindBy(xpath = "//div[text()='Work Timings']")
	private WebElement workTimingWebElement;
	@FindBy(xpath = "//a[text()='Period']")
	private WebElement periodWebElement;
	@FindBy(xpath = "//div[text()='Add Period ']")
	private WebElement addPeriodWebElement;
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement periodNameWebElement;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[4]")
	private WebElement clickShiftWebElement;
	@FindBy(xpath = "(//div[@class='ng-option ng-star-inserted'])[1]")
	private WebElement selectShiftWebElement;
	@FindBy(xpath = "//input[@placeholder='Start Time']")
	private WebElement startTimeWebElement;
	@FindBy(xpath = "//span[text()=' 12 ']")
	private WebElement selectStartTimeWebElement;
	@FindBy(xpath = "(//button[@class='timepicker-button'])[2]")
	private WebElement okWebelement;
	@FindBy(xpath = "//input[@placeholder='End Time']")
	private WebElement endTimeWebElement;
	@FindBy(xpath = "//span[text()=' 1 ']")
	private WebElement selectEndTimeWebelement;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savebuttonWebElement;
	@FindBy(xpath = "(//div[@class='row mx-0 shift-box'])[1]")
	private WebElement clickPeriodCardWebElement;
	@FindBy(xpath = "//img[@class='pointer']")
	private WebElement editClickWebElement;
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateButtonWebElement;
	@FindBy(xpath = "//span[@class='delete float-right']")
	private WebElement deleteButtonWebElement;
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteWebElement;
	@FindBy(xpath = "//button[@class='closePopup']")
	private WebElement closeButtonWebElement;
	private JSONParser jsonParser = new JSONParser();
	String PeriodName;

	public PeriodAdd(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void periodJsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\Period.json");

			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("Period");

			JSONObject Csession = (JSONObject) userLoginsArray1.get(0);
			PeriodName = (String) Csession.get("PeriodName");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void addPeriod() throws InterruptedException {
		//workTimingWebElement.click();
		Thread.sleep(1000);
		periodWebElement.click();
		Thread.sleep(1000);
		addPeriodWebElement.click();
		periodNameWebElement.sendKeys(PeriodName);
		clickShiftWebElement.click();
		Thread.sleep(1000);
		selectShiftWebElement.click();
		startTimeWebElement.click();
		Thread.sleep(1000);
		selectStartTimeWebElement.click();
		okWebelement.click();
		Thread.sleep(1000);
		endTimeWebElement.click();
		Thread.sleep(1000);
		selectEndTimeWebelement.click();
		okWebelement.click();
		savebuttonWebElement.click();
		Thread.sleep(1000);
		closeButtonWebElement.click();
	}

	public void editPeriod() throws InterruptedException {
		workTimingWebElement.click();
		Thread.sleep(1000);
		periodWebElement.click();
		Thread.sleep(1000);
		clickPeriodCardWebElement.click();
		Thread.sleep(1000);
		editClickWebElement.click();
		Thread.sleep(1000);
		updateButtonWebElement.click();
		Thread.sleep(1000);
		closeButtonWebElement.click();
	}

	public void deletePeriod() throws InterruptedException {
		workTimingWebElement.click();
		Thread.sleep(1000);
		periodWebElement.click();
		Thread.sleep(1000);
		clickPeriodCardWebElement.click();
		Thread.sleep(1000);
		deleteButtonWebElement.click();
		deleteWebElement.click();
		Thread.sleep(1000);
		closeButtonWebElement.click();

	}
}
