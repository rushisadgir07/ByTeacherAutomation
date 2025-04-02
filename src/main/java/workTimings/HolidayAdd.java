package workTimings;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class HolidayAdd {
	@FindBy(xpath = "//div[text()='Work Timings']")
	private WebElement workTimingWebElement;
	@FindBy(xpath = "//a[text()='Holiday']")
	private WebElement holidaywebElement;
	@FindBy(xpath = "//div[text()='Add Holiday ']")
	private WebElement addHolidayWebElement;
	@FindBy(xpath = "//input[@placeholder='Enter Holiday Occasion']")
	private WebElement holidayNameWebElement;
	@FindBy(xpath = "//input[@formcontrolname='startDate']")
	private WebElement holidayDateWebElement;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[4]")
	private WebElement branchClickWebElement;
	@FindBy(xpath = "(//div[@role='option'])[1]")
	private WebElement selectBranchWebElement;
	@FindBy(xpath = "(//div[@class='ng-value-container'])[5]")
	private WebElement clickUserWebElement;
	@FindBy(xpath = "//span[text()='Staff']")
	private WebElement selectStaffUserWebElement;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveButtonWebElement;
	@FindBy(xpath = "(//img[@class='pointer'])[1]")
	private WebElement editClickWebElement;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[4]")
	private WebElement courseClickWebElement;
	@FindBy(xpath = "//span[text()='Update']")
	private WebElement updateButtonWebElement;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[4]")
	private WebElement batchClickWebElement;
	private JSONParser jsonParser = new JSONParser();
	Actions act;
	String holidayName;
	String holidayDate;

	public HolidayAdd(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	public void holidayJsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\Holiday.json");

			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("Holiday");

			JSONObject Csession = (JSONObject) userLoginsArray1.get(0);
			holidayName = (String) Csession.get("HolidayName");
			holidayDate = (String) Csession.get("Holidaydate");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void addHoliday() throws InterruptedException {
		workTimingWebElement.click();
		Thread.sleep(1000);
		holidaywebElement.click();
		addHolidayWebElement.click();
		Thread.sleep(500);
		holidayNameWebElement.sendKeys(holidayName);
		Thread.sleep(1000);
		holidayDateWebElement.sendKeys(holidayDate);
		branchClickWebElement.click();
		Thread.sleep(1500);
		selectBranchWebElement.click();
		clickUserWebElement.click();
		selectStaffUserWebElement.click();
		saveButtonWebElement.click();
		Thread.sleep(1000);

	}

	public void editHoliday() throws InterruptedException {
		workTimingWebElement.click();
		Thread.sleep(1000);
		holidaywebElement.click();
		Thread.sleep(1000);
		editClickWebElement.click();
		Thread.sleep(500);
		holidayDateWebElement.clear();
		Thread.sleep(500);
		holidayDateWebElement.sendKeys(holidayDate);
		branchClickWebElement.click();
		Thread.sleep(1500);
		selectBranchWebElement.click();
		clickUserWebElement.click();
		selectStaffUserWebElement.click();
		Thread.sleep(1000);
		courseClickWebElement.click();
		selectBranchWebElement.click();
		Thread.sleep(500);
		batchClickWebElement.click();
		selectBranchWebElement.click();
		Thread.sleep(500);
		updateButtonWebElement.click();

	}
}
