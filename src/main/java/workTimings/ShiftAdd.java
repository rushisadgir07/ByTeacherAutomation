package workTimings;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class ShiftAdd {
	@FindBy(xpath = "//div[text()='Work Timings']")
	private WebElement workTiming;
	@FindBy(xpath = "//div[text()='Add Shift']")
	private WebElement addShift;
	@FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-invalid'])[1]")
	private WebElement enterName;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[1]")
	private WebElement shifttype;
	@FindBy(xpath = "//span[text()='BOTH']")
	private WebElement selectShiftType;
	@FindBy(xpath = "//input[@placeholder='Start Time']")
	private WebElement startTime;
	@FindBy(xpath = "//span[text()=' 7 ']")
	private WebElement selectStartTime;
	@FindBy(xpath = "(//button[@class='timepicker-button'])[2]")
	private WebElement okWebelement;
	@FindBy(xpath = "//input[@placeholder='End Time']")
	private WebElement endTimeWebElement;
	@FindBy(xpath = "//span[text()=' 1 ']")
	private WebElement selectEndTimeWebelement;
	@FindBy(xpath = "//button[text()='PM']")
	private WebElement pmSelectWebelement;
	@FindBy(xpath = "//div[text()='Select Day']")
	private WebElement selectDayWebElement;
	@FindBy(xpath = "(//input[@class='ng-untouched ng-pristine ng-valid'])[3]")
	private WebElement selectAllDayWebElement;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savebuttonWebElement;
	@FindBy(xpath = "(//div[@class='shiftData col-6 box ng-star-inserted'])[1]")
	private WebElement editShiftWebElement;
	@FindBy(xpath = "//img[@class='pointer']")
	private WebElement editClickWebElement;
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateButtonWebElement;
	@FindBy(xpath = "//span[@class='delete float-right']")
	private WebElement deleteButtonWebElement;
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteWebElement;
	@FindBy(xpath = "//button[text()='x']")
	private WebElement closepageWebElement;
	private JSONParser jsonParser = new JSONParser();
	String ShiftName;
	Actions act;

	public ShiftAdd(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
	}

	public void shiftJsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\WorkTiming.json");

			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("Shift");

			JSONObject Csession = (JSONObject) userLoginsArray1.get(0);
			ShiftName = (String) Csession.get("ShiftName");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void addShift() throws InterruptedException {

		workTiming.click();
		Thread.sleep(2000);
		addShift.click();
		enterName.clear();
		enterName.sendKeys(ShiftName);
		shifttype.click();
		selectShiftType.click();
		startTime.click();
		Thread.sleep(1000);
		selectStartTime.click();
		okWebelement.click();
		Thread.sleep(500);
		endTimeWebElement.click();
		selectEndTimeWebelement.click();
		pmSelectWebelement.click();
		okWebelement.click();
		Thread.sleep(1000);
		act.click(selectDayWebElement).build().perform();
		selectAllDayWebElement.click();
		savebuttonWebElement.click();
		Thread.sleep(1000);
		closepageWebElement.click();

	}

	public void editShift() throws InterruptedException {
		workTiming.click();
		Thread.sleep(1000);
		editShiftWebElement.click();
		Thread.sleep(1000);
		editClickWebElement.click();
		Thread.sleep(1000);
		updateButtonWebElement.click();
		Thread.sleep(1000);
		closepageWebElement.click();
	}

	public void deleteShift() throws InterruptedException {
		workTiming.click();
		Thread.sleep(1000);
		editShiftWebElement.click();
		Thread.sleep(1000);
		deleteButtonWebElement.click();
		deleteWebElement.click();
		Thread.sleep(1000);
		closepageWebElement.click();

	}
}
