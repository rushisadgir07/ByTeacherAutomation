package learner;

import java.awt.RenderingHints.Key;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class AssignAcademicDetails {

	String mailId;
	String moNo;

	Actions act;
	FileReader reader;
	@FindBy(xpath = "//div[text()='Learner']")
	private WebElement learnerWebelement;
	@FindBy(id = "searchTerm")
	private WebElement searchBarWebElement;
	@FindBy(id = "rowClick0")
	private WebElement openStudentDetailsWebElement;
	@FindBy(xpath = "//a[text()='Academic Details']")
	private WebElement academicWebElement;
	@FindBy(xpath = "//span[text()='Add course']")
	private WebElement addCourseWebElement;
	@FindBy(xpath = "//div[text()='Select Course']")
	private WebElement openselectCourseDD;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement selectCourseWebElement;
	@FindBy(xpath = "//div[text()='Select Batch']")
	private WebElement openBatchDDWebElement;
	@FindBy(xpath = "//div[text()='Select Grade']")
	private WebElement selectGradeWebElement;
	@FindBy(id = "radio2")
	private WebElement selectLearningModeWebElement;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButtonWebElement;
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addButtonWebElement;
	@FindBy(id = "saveStudentAcademicInfo")
	private WebElement savestudentInfoWebElement;
	

	JSONParser jsonParser = new JSONParser();

	// FileReader reader1 = new
	// FileReader("src\\main\\resources\\jesonFile\\learner.json");

	public AssignAcademicDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	public void jsonRead() throws ParseException, FileNotFoundException {
		reader = new FileReader("src\\main\\resources\\jesonFile\\learner.json");
		Object object1 = jsonParser.parse(reader);
		JSONObject userloginJsonobj1 = (JSONObject) object1;
		JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("Learner");
		JSONObject user1 = (JSONObject) userLoginsArray1.get(0);
		;
		mailId = (String) user1.get("email");
		moNo = (String) user1.get("mobile");
	}

	public void addAcademicdetails() throws InterruptedException {
		//learnerWebelement.click();
		searchBarWebElement.sendKeys(moNo);
		Thread.sleep(1500);
		act.moveToElement(searchBarWebElement).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1500);
		act.click(openStudentDetailsWebElement).build().perform();
		academicWebElement.click();
		Thread.sleep(1500);
		addCourseWebElement.click();
		Thread.sleep(1500);
		act.click(openselectCourseDD).build().perform();
		Thread.sleep(1500);
		selectCourseWebElement.click();
		Thread.sleep(1500);
		act.click(openBatchDDWebElement).build().perform();
		Thread.sleep(1500);
		selectCourseWebElement.click();
		Thread.sleep(1500);
		act.click(selectGradeWebElement).build().perform();
		Thread.sleep(1500);
		selectCourseWebElement.click();
		selectLearningModeWebElement.click();
		Thread.sleep(1000);
		saveButtonWebElement.click();
		Thread.sleep(1000);
		addButtonWebElement.click();
		Thread.sleep(2000);
		savestudentInfoWebElement.click();
		
		Thread.sleep(5000);
	}
	
	public void secondCourse() throws InterruptedException {
		//learnerWebelement.click();
		Thread.sleep(1500);
		addCourseWebElement.click();
		Thread.sleep(1500);
		act.click(openselectCourseDD).build().perform();
		Thread.sleep(1500);
		selectCourseWebElement.click();
		Thread.sleep(1500);
		act.click(openBatchDDWebElement).build().perform();
		Thread.sleep(1500);
		selectCourseWebElement.click();
		Thread.sleep(1500);
		act.click(selectGradeWebElement).build().perform();
		Thread.sleep(1500);
		selectCourseWebElement.click();
		selectLearningModeWebElement.click();
		Thread.sleep(1000);
		saveButtonWebElement.click();
		Thread.sleep(1000);
		addButtonWebElement.click();
		Thread.sleep(2000);
		savestudentInfoWebElement.click();
		Thread.sleep(2000);
	}

}
