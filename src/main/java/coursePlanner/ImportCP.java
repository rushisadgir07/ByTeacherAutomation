package coursePlanner;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class ImportCP {

	String CPName;
	@FindBy(xpath = "//div[text()='Curriculum']")
	private WebElement curriculamWebElement;
	@FindBy(xpath = "//i[@id='dropdownBasic']")
	private WebElement importcpdd;
	@FindBy(xpath = "//span[@id='importplanner']")
	private WebElement userexportplanner;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[1]")
	private WebElement selectcourseBox;
	@FindBy(xpath = "//div[@class='ng-option ng-option-marked ng-star-inserted']")
	private WebElement selectCourse;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[1]")
	private WebElement selectSubjectBox;
	@FindBy(xpath = "//div[@class='ng-option ng-option-marked ng-star-inserted']")
	private WebElement selectSub;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[1]")
	private WebElement selectGreadBox;
	@FindBy(xpath = "//div[@class='ng-option ng-option-marked ng-star-inserted']")
	private WebElement selectGread;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[1]")
	private WebElement selectPlannerBox;
	@FindBy(xpath = "//div[@class='ng-option ng-option-marked ng-star-inserted']")
	private WebElement selectPlanner;
	@FindBy(id = "coursePlannerName")
	private WebElement CourseName;
	@FindBy(id = "createCoursePalnnerWithImport")
	private WebElement createPlanner;
	@FindBy(id = "saveCoursePalnner")
	private WebElement saveCP;
	JSONParser jsonParser = new JSONParser();
	

	public ImportCP(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void cpjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\cp.json");
			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("ImportCoursePlanner");
			JSONObject session = (JSONObject) userLoginsArray1.get(0);
			ObjectMapper objectMapper = new ObjectMapper();
			CPName = (String) session.get("CoursePName");

		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void importplannercreation() throws InterruptedException {
		Thread.sleep(1000);
		curriculamWebElement.click();
		Thread.sleep(1000);
		importcpdd.click();
		userexportplanner.click();
		Thread.sleep(1000);
		selectcourseBox.click();
		selectCourse.click();
		Thread.sleep(1000);
		selectSubjectBox.click();
		selectSub.click();
		Thread.sleep(1000);
		selectGreadBox.click();
		selectGread.click();
		Thread.sleep(1000);
		selectPlannerBox.click();
		selectPlanner.click();
		Thread.sleep(1000);
		CourseName.sendKeys(CPName);
		createPlanner.click();
		Thread.sleep(1000);
		saveCP.click();
	}
}
