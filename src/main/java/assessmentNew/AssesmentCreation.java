package assessmentNew;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.byteacher.automation.dto.ExamDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class AssesmentCreation {
	String startda;
	String examDuration;
	String question;
	String positiveMarks;
	String enterInstru;
	String numberques1;
	String numberques2;
	String numberques3;
	String endda;
	String assesmentT;
	String questionT;
	String examDeadline;
	Actions act;
	WebDriver driver;
	
	ExamDetailsDto examDetailDto;
	@FindBy(id = "Assessment")
	private WebElement assessmentWebelement;
	@FindBy(xpath = "//span[contains(text(),'Create Exam')]")
	private WebElement createExamWebelement;
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement examNameWebelement;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[1]")
	private WebElement examCategoryWebelement;
	@FindBy(xpath = "//span[text()='Unit']")
	private WebElement unitExamWebelement;
	@FindBy(xpath = "(//div[@class='ng-value-container'])[3]")
	private WebElement courseDropWebelement;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement selectCourseWebelement;
	@FindBy(xpath = "(//div[@class='ng-placeholder'])[4]")
	private WebElement selectBatchWebelement;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement batch1Webelement;
	@FindBy(id = "readOnly")
	private WebElement selectStudWebelement;
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okButtonWebelement;
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButtonWebelement;
	@FindBy(xpath = "//div[text()='Simple']")
	private WebElement simpleWebelement;
	@FindBy(xpath = "(//button[text()='Next'])[2]")
	private WebElement secondNextWebelement;
	@FindBy(xpath = "(//div[@class='ng-input'])[5]")
	private WebElement selectSubjectWebelement;
	@FindBy(xpath = "//span[text()='Physics']")
	private WebElement physicsWebelement;
	@FindBy(xpath = "(//input[contains(@placeholder,'Type here...')])[1]")
	private WebElement marksWebelement;
	@FindBy(xpath = "(//input[contains(@placeholder,'Type here...')])[2]")
	private WebElement passingMarkWebelement;
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement thirdNextWebelement;
	@FindBy(id = "startDtae")
	private WebElement startDateWebelement;
	@FindBy(xpath = "(//div[@class='input-group'])[1]")
	private WebElement timeWebelement;
	@FindBy(xpath = "(//div[@class='clock-face__number clock-face__number--outer ng-star-inserted'])[3]")
	private WebElement startTimeWebelement;
	@FindBy(xpath = "//button[text()='PM']")
	private WebElement pmSelectWebelement;
	@FindBy(xpath = "(//button[@class='timepicker-button'])[2]")
	private WebElement okWebelement;
	@FindBy(xpath = "//input[contains(@placeholder,'Enter Minutes')]")
	private WebElement durationWebelement;
	@FindBy(xpath = "(//div[@class='ng-input'])[6]")
	private WebElement clickExtraWebelement;
	@FindBy(xpath = "//span[text()='5 Min']")
	private WebElement selectExtraWebelement;
	@FindBy(id = "dotLeatter0")
	private WebElement doItLetterWebelement;
	@FindBy(xpath = "(//button[text()='Next'])[2]")
	private WebElement nextnWebelement;
	@FindBy(xpath = "//button[text()='Add Student']")
	private WebElement addStudentWebElement;
	@FindBy(xpath = "//span[text()='Add']")
	private WebElement addWebElement;
	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitWebelement;
	@FindBy(xpath = "//a[text()='Assignment']")
	private WebElement assignmentClickWebelement;
	@FindBy(xpath = "//span[contains(text(),'Create Assignment')]")
	private WebElement createAssignmentWebelement;
	@FindBy(id = "endDate")
	private WebElement endDateWebelement;
	@FindBy(xpath = "//input[@placeholder='End Time']")
	private WebElement endTimeWebelement; // assignment
	@FindBy(xpath = "//a[contains(text(),'Test')]")
	private WebElement testClickWebelement;
	@FindBy(xpath = "//span[contains(text(),'Create Test')]")
	private WebElement createTestWebelement;
	
	private JSONParser jsonParser = new JSONParser();
	
	public AssesmentCreation(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		act = new Actions(driver);
		
	}
	public void examjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\Exam.json");
			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("ExamDetails");

			JSONObject session = (JSONObject) userLoginsArray1.get(0);
			ObjectMapper objectMapper = new ObjectMapper();
			examDetailDto = objectMapper.readValue(session.toJSONString(), ExamDetailsDto.class);
			examDuration = (String) session.get("ExamDuration");
			assesmentT = (String) session.get("assesmentType");
			questionT = (String) session.get("QuestionType");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}
	public void createAssessment() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		assessmentWebelement.click();
		Thread.sleep(1500);
		if ("Assignment".equalsIgnoreCase(assesmentT)) {
			assignmentClickWebelement.click();
			createAssignmentWebelement.click();
		} else if ("Exam".equalsIgnoreCase(assesmentT)) {
			createExamWebelement.click();
		} else {
			testClickWebelement.click();
			createTestWebelement.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));
		examNameWebelement.sendKeys(examDetailDto.getAssesmentName());
		examCategoryWebelement.click();
		Thread.sleep(1000);
		act.click(unitExamWebelement).build().perform();
		courseDropWebelement.click();
		Thread.sleep(1000);
		act.click(selectCourseWebelement).build().perform();
		Thread.sleep(2000);
		act.click(selectBatchWebelement).build().perform();
		batch1Webelement.click();
		Thread.sleep(500);
		act.click(examNameWebelement).build().perform();
		Thread.sleep(2000);
		nextButtonWebelement.click();
		simpleWebelement.click();
		secondNextWebelement.click();
		Thread.sleep(500);
		selectSubjectWebelement.click();
		physicsWebelement.click();
		Thread.sleep(500);
		marksWebelement.sendKeys(examDetailDto.getTotalMarks());
		Thread.sleep(500);
		passingMarkWebelement.sendKeys(examDetailDto.getPassingMarks());
		thirdNextWebelement.click();
		Thread.sleep(3000);
		System.out.println(examDetailDto.getStartDate());
		if ("Exam".equalsIgnoreCase(assesmentT)) {
			act.click(startDateWebelement).sendKeys(examDetailDto.getStartDate()).build().perform();
			// startDateWebelement.sendKeys("02/11/2024");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
			timeWebelement.click();
			startTimeWebelement.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
			pmSelectWebelement.click();
			okWebelement.click();
		} else {
			act.click(startDateWebelement).sendKeys(examDetailDto.getStartDate()).build().perform();
			act.click(endDateWebelement).sendKeys(examDetailDto.getEndDate()).build().perform();
			// endDateWebelement.sendKeys(endda);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
			timeWebelement.click();
			startTimeWebelement.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
			pmSelectWebelement.click();
			okWebelement.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
			endTimeWebelement.click();
			startTimeWebelement.click();
			pmSelectWebelement.click();
			okWebelement.click();
		}
		Thread.sleep(1000);
		durationWebelement.sendKeys(examDuration);
		clickExtraWebelement.click();
		selectExtraWebelement.click();
		doItLetterWebelement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		//Thread.sleep(500);
		nextnWebelement.click();
		Thread.sleep(500);
		addStudentWebElement.click();
		Thread.sleep(1500);
		addWebElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		submitWebelement.click();
		System.out.println(assesmentT + "Created successfully");

	}


}
