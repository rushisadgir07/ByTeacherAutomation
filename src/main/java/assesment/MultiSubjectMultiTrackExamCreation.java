package assesment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.byteacher.automation.dto.ExamDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import utilityStudy.NewUtilityStudy;

public class MultiSubjectMultiTrackExamCreation {
	String examNa;
	String tMarks;
	String passMarks;
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
	JavascriptExecutor js;
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
	@FindBy(xpath = "//button[text()='Add Student']")
	private WebElement selectStudWebelement;
	@FindBy(id = "saveMoreStudent")
	private WebElement saveStudentButtonWebelement;
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButtonWebelement;
	@FindBy(xpath = "//div[text()='Simple']")
	private WebElement simpleWebelement;
	@FindBy(xpath = "(//button[text()='Next'])[2]")
	private WebElement secondNextWebelement;
	@FindBy(xpath = "(//div[@class='ng-value-container'])[5]")
	private WebElement selectSubjectWebelement;
	@FindBy(xpath = "//span[text()='Physics']")
	private WebElement physicsWebelement;
	@FindBy(xpath = "//span[text()='Chemistry']")
	private WebElement chemistryWebelement;
	@FindBy(xpath = "//span[text()='Mathematics']")
	private WebElement mathematicsWebElement;
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
	@FindBy(id = "dotLeatter1")
	private WebElement chemDotLetterWebElement;
	@FindBy(id = "dotLeatter2")
	private WebElement mathDoitLeWebElement;
	@FindBy(xpath = "(//button[text()='Next'])[2]")
	private WebElement nextNewWebelement;
	@FindBy(xpath = "//button[text()=' Submit']")
	private WebElement submitWebelement; // Create exam
	@FindBy(xpath = "//div[text()='Select Teacher']")
	private WebElement clickteacherWebelement;
	@FindBy(xpath = "(//div[@class='ng-option ng-star-inserted'])[1]")
	private WebElement selectTeacherWebelement;
	@FindBy(xpath = "//input[@id='numebrOnly']")
	private WebElement enterQuestionWebelement;
	@FindBy(xpath = "(//div[@class='ng-input'])[2]")
	private WebElement clickExamTypeWebelement;
	@FindBy(xpath = "//span[text()=' SCQ ']")
	private WebElement scqQuestionWebelement;
	@FindBy(id = "0calculate0")
	private WebElement positiveMarkWebelement;
	@FindBy(id = "0getInstruction0")
	private WebElement instructionClickWebelement;
	@FindBy(id = "instructionType2")
	private WebElement insturctionTypeWebelement;
	@FindBy(xpath = "//div[@class='angular-editor-textarea']")
	private WebElement instructionWebelement;
	@FindBy(id = "saveIns")
	private WebElement savebWebelement;
	@FindBy(id = "bsDatepicker")
	private WebElement deadlineWebelement;
	@FindBy(xpath = "//button[text()='Save Question Buckets']")
	private WebElement saveQBWebelement; // SCQ track Created Successfully
	@FindBy(id = "0addSimpleFormControl0")
	private WebElement createMCQtrack;
	@FindBy(xpath = "(//div[text()='Select Teacher'])[2]")
	private WebElement MCQTrackTeacher;
	@FindBy(xpath = "(//input[@id='numebrOnly'])[2]")
	private WebElement enterMCQquestion;
	@FindBy(xpath = "(//div[@class='ng-input'])[4]")
	private WebElement secondTrackQuestionType;
	@FindBy(xpath = "//span[text()=' MCQ ']")
	private WebElement mcqQuestionWebelement;
	@FindBy(xpath = "//button[text()='Add Scheme ']")
	private WebElement addSchemeButtonWebElement;
	@FindBy(xpath = "(//input[@id='schemeType1'])[1]")
	private WebElement selectSchemeTypeElement;
	@FindBy(xpath = "(//div[@class='ng-input'])[5]")
	private WebElement clickOnSchemeType;
	@FindBy(xpath = "//span[text()=' New Sceme ']")
	private WebElement selectSchemeWebElement;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButtonWebElement;
	@FindBy(id = "0getInstruction1")
	private WebElement mcqInstructionClick;
	@FindBy(xpath = "(//input[@id='bsDatepicker'])[2]")
	private WebElement mcqDeadlineClick; // PhysicsMCQ track created successfully
	@FindBy(id = "0addSimpleFormControl1")
	private WebElement createNumTrackWebElement;
	@FindBy(xpath = "(//div[text()='Select Teacher'])[3]")
	private WebElement numericTrackTeacher;
	@FindBy(xpath = "(//input[@id='numebrOnly'])[3]")
	private WebElement numericQuestionCount;
	@FindBy(xpath = "(//div[@class='ng-input'])[6]")
	private WebElement numericquestionTypeWebElement;
	@FindBy(xpath = "//span[text()=' NUMERICAL ']")
	private WebElement numericQuestionWebelement;
	@FindBy(id = "0calculate2")
	private WebElement numPositiveMarkWebElement;
	@FindBy(id = "0getInstruction2")
	private WebElement numericInstructionWebElement;
	@FindBy(xpath = "(//input[@id='bsDatepicker'])[3]")
	private WebElement numericDeadlineWebElement;// Physics Numeric track created successfully
	@FindBy(xpath = "(//div[text()='Select Teacher'])[4]")
	private WebElement chemSCQTeacher;
	@FindBy(xpath = "(//input[@id='numebrOnly'])[4]")
	private WebElement chemSCQquestionElement;
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
	private WebElement createTestWebelement; // Test
	@FindBy(xpath = "(//img[@id='dropdownBasic1'])[1]")
	private WebElement actionButtonWebelement;
	@FindBy(xpath = "(//button[text()='View Question Buckets'])[1]")
	private WebElement viewquestionBucketWebelement;
	@FindBy(xpath = "//div[text()=' Select Syllabus']")
	private WebElement selectSWebelement;
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	private WebElement syllabusCheckWebelement;
	@FindBy(xpath = "//div[@class='ng-input']")
	private WebElement syllabusClickWebelement;
	@FindBy(xpath = "(//div[@class='ng-option ng-star-inserted'])[1]")
	private WebElement selectunit1Webelement;
	@FindBy(xpath = "(//div[@class='ng-option ng-star-inserted'])[2]")
	private WebElement selectunit2Webelement;
	@FindBy(id = "SaveSyllabus")
	private WebElement savesyllabusWebelement;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement newCheckButtonWebelement;
	@FindBy(xpath = "//div[@class='ng-input']")
	private WebElement clicksyllabusWebelement;
	@FindBy(xpath = "(//input[@class='form-check-input'])[2]")
	private WebElement selectallWebelement;
	@FindBy(xpath = "//button[text()='Auto Generate Questions']")
	private WebElement autoGenrateWebelement;
	@FindBy(xpath = "(//input[@type='number'])[3]")
	private WebElement unit1questionWebelement;
	@FindBy(xpath = "(//input[@type='number'])[2]")
	private WebElement unit2questionWebelement;
	@FindBy(xpath = "(//input[@type='number'])[4]")
	private WebElement unit3questionWebelement;
	@FindBy(xpath = "//button[text()='Add Questions']")
	private WebElement addQuestionWebelement;
	@FindBy(xpath = "//u[text()='Select All']")
	private WebElement selectquestionWebelement;
	@FindBy(id = "approveQuestions")
	private WebElement approvebuttonWebelement;
	@FindBy(id = "gotoTrack1")
	private WebElement gotoTrackWebelement;
	@FindBy(xpath = "(//div[text()=' Select Syllabus'])[1]")
	private WebElement secondTracksyllabusClick;
	@FindBy(id = "lockTrack")
	private WebElement lockTrackWebelement;
	@FindBy(xpath = "//button[text()='Lock']")
	private WebElement lockWebelement; // track locked successfully
	@FindBy(id = "openPublish")
	private WebElement publishclickWebelement;
	@FindBy(id = "checkboxSetting2")
	private WebElement showSolutionWebelement;
	@FindBy(xpath = "(//input[@name='paperSetCount'])[2]")
	private WebElement set2Webelement;
	@FindBy(xpath = "//span[text()='Publish']")
	private WebElement publishExamWebelement; // exam publish successfully
	@FindBy(xpath = "(//small[text()='Conducted'])[1]")
	private WebElement conductedExamWebElement;
	@FindBy(xpath = "//span[text()='Check']")
	private WebElement checkButtonWebElement;
	@FindBy(xpath = "//a[text()='Check']")
	private WebElement checkConfirmWebElement;
	@FindBy(xpath = "//button[text()='Checked']")
	private WebElement checkedButtonWebElement;
	@FindBy(xpath = "//span[text()='Generate Result']")
	private WebElement generateResultWebElement;
	@FindBy(xpath = "//a[text()='Result']")
	private WebElement resultConfirmWebElement;
	@FindBy(xpath = "//button[text()='Result']")
	private WebElement resultWebElement;
	@FindBy(xpath = "(//h4[@class='header-title float-left ml-3'])[2]")
	private WebElement chemistryWebElement2;

	private JSONParser jsonParser = new JSONParser();

	public MultiSubjectMultiTrackExamCreation(WebDriver driver) throws FileNotFoundException, ParseException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}

	public void examjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\multiTrackExam.json");
			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("ExamDetails");

			JSONObject session = (JSONObject) userLoginsArray1.get(0);
			ObjectMapper objectMapper = new ObjectMapper();
			examDetailDto = objectMapper.readValue(session.toJSONString(), ExamDetailsDto.class);
			examDuration = (String) session.get("ExamDuration");
			question = (String) session.get("EnterQuestion");
			positiveMarks = (String) session.get("Positivemark");
			enterInstru = (String) session.get("Instruction");
			numberques1 = (String) session.get("scqquestion");
			numberques2 = (String) session.get("mcqquestion");
			numberques3 = (String) session.get("numericquestion");
			assesmentT = (String) session.get("assesmentType");
			questionT = (String) session.get("QuestionType");
			examDeadline = (String) session.get("ExamdeadLine");
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
		chemistryWebelement.click();
		//mathematicsWebElement.click();
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
		chemDotLetterWebElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		//mathDoitLeWebElement.click();
		Thread.sleep(500);
		nextNewWebelement.click();
		Thread.sleep(500);
		selectStudWebelement.click();
		Thread.sleep(1500);
		saveStudentButtonWebelement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		submitWebelement.click();
		System.out.println(assesmentT + "Created successfully");

	}
	public void creatPhysicsTrack() throws InterruptedException {
		Thread.sleep(3000);
		act.moveToElement(clickteacherWebelement).click().build().perform();
		selectTeacherWebelement.click();
		enterQuestionWebelement.sendKeys(numberques1);
		act.click(clickExamTypeWebelement).build().perform();
		if ("scq".equalsIgnoreCase(questionT)) {
			scqQuestionWebelement.click();
		} else {
			numericQuestionWebelement.click();
		}
		positiveMarkWebelement.sendKeys(positiveMarks);
		instructionClickWebelement.click();
		insturctionTypeWebelement.click();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1500);
		System.out.println(examDeadline);
		act.sendKeys(deadlineWebelement, examDeadline).build().perform();
		Thread.sleep(1000);
		createMCQtrack.click(); // MCQ Track
		Thread.sleep(1000);
		act.click(MCQTrackTeacher).build().perform();
		selectTeacherWebelement.click();
		enterMCQquestion.sendKeys(numberques2);
		act.click(secondTrackQuestionType).build().perform();
		mcqQuestionWebelement.click();
		act.click(addSchemeButtonWebElement).build().perform();
		Thread.sleep(1500);
		act.click(selectSchemeTypeElement).build().perform();
		saveButtonWebElement.click();
		mcqInstructionClick.click();
		Thread.sleep(1000);
		act.click(insturctionTypeWebelement).build().perform();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(mcqDeadlineClick, examDeadline).build().perform();
		Thread.sleep(1000);
		createNumTrackWebElement.click(); // Numeric Track
		act.click(numericTrackTeacher).build().perform();
		selectTeacherWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(numericQuestionCount, numberques3).build().perform();
		// numericQuestionCount.sendKeys("5");
		act.click(numericquestionTypeWebElement).build().perform();
		numericQuestionWebelement.click();
		numPositiveMarkWebElement.sendKeys(positiveMarks);
		numericInstructionWebElement.click();
		Thread.sleep(1000);
		act.click(insturctionTypeWebelement).build().perform();
		// insturctionTypeWebelement.click();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(numericDeadlineWebElement, examDeadline).build().perform();
		Thread.sleep(1000);
		// createMCQtrack.click(); // MCQ Track
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", MCQTrackTeacher);
		act.click(MCQTrackTeacher).build().perform();
		selectTeacherWebelement.click();
		enterMCQquestion.sendKeys(numberques2);
		act.click(secondTrackQuestionType).build().perform();
		mcqQuestionWebelement.click();
		act.click(addSchemeButtonWebElement).build().perform();
		Thread.sleep(1000);
		selectSchemeTypeElement.click();
		Thread.sleep(1500);
		// clickOnSchemeType.click();
		// selectSchemeWebElement.click();
		saveButtonWebElement.click();
		mcqInstructionClick.click();
		insturctionTypeWebelement.click();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(mcqDeadlineClick, examDeadline).build().perform();
		Thread.sleep(2000);
		// createNumTrackWebElement.click(); // Numeric Track
		js.executeScript("arguments[0].scrollIntoView(true);", numericTrackTeacher);
		Thread.sleep(1000);
		act.click(numericTrackTeacher).build().perform();
		selectTeacherWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(numericQuestionCount, numberques3).build().perform();
		// numericQuestionCount.sendKeys("5");
		js.executeScript("arguments[0].scrollIntoView(true);", chemistryWebElement2);
		act.click(numericquestionTypeWebElement).build().perform();
		numericQuestionWebelement.click();
		numPositiveMarkWebElement.sendKeys(positiveMarks);
		numericInstructionWebElement.click();
		Thread.sleep(1000);
		act.click(insturctionTypeWebelement).build().perform();
		// insturctionTypeWebelement.click();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(numericDeadlineWebElement, examDeadline).build().perform();
		System.out.println("Track Created successfully");
		Thread.sleep(3000);	
	}
	public void creatChemistryTrack() throws InterruptedException {
		//js.executeScript("arguments[0].scrollIntoView(true);", chemistryWebElement2);
		Thread.sleep(3000);
		act.moveToElement(chemSCQTeacher).click().build().perform();
		selectTeacherWebelement.click();
		chemSCQquestionElement.sendKeys(numberques1);
		act.click(clickExamTypeWebelement).build().perform();
		if ("scq".equalsIgnoreCase(questionT)) {
			scqQuestionWebelement.click();
		} else {
			numericQuestionWebelement.click();
		}
		positiveMarkWebelement.sendKeys(positiveMarks);
		instructionClickWebelement.click();
		insturctionTypeWebelement.click();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1500);
		System.out.println(examDeadline);
		act.sendKeys(deadlineWebelement, examDeadline).build().perform();
		Thread.sleep(1000);
		createMCQtrack.click(); // MCQ Track
		Thread.sleep(1000);
		act.click(MCQTrackTeacher).build().perform();
		selectTeacherWebelement.click();
		enterMCQquestion.sendKeys(numberques2);
		act.click(secondTrackQuestionType).build().perform();
		mcqQuestionWebelement.click();
		act.click(addSchemeButtonWebElement).build().perform();
		Thread.sleep(1500);
		act.click(selectSchemeTypeElement).build().perform();
		saveButtonWebElement.click();
		mcqInstructionClick.click();
		Thread.sleep(1000);
		act.click(insturctionTypeWebelement).build().perform();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(mcqDeadlineClick, examDeadline).build().perform();
		Thread.sleep(1000);
		createNumTrackWebElement.click(); // Numeric Track
		act.click(numericTrackTeacher).build().perform();
		selectTeacherWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(numericQuestionCount, numberques3).build().perform();
		// numericQuestionCount.sendKeys("5");
		act.click(numericquestionTypeWebElement).build().perform();
		numericQuestionWebelement.click();
		numPositiveMarkWebElement.sendKeys(positiveMarks);
		numericInstructionWebElement.click();
		Thread.sleep(1000);
		act.click(insturctionTypeWebelement).build().perform();
		// insturctionTypeWebelement.click();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(numericDeadlineWebElement, examDeadline).build().perform();
		Thread.sleep(1000);
		// createMCQtrack.click(); // MCQ Track
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", MCQTrackTeacher);
		act.click(MCQTrackTeacher).build().perform();
		selectTeacherWebelement.click();
		enterMCQquestion.sendKeys(numberques2);
		act.click(secondTrackQuestionType).build().perform();
		mcqQuestionWebelement.click();
		act.click(addSchemeButtonWebElement).build().perform();
		Thread.sleep(1000);
		selectSchemeTypeElement.click();
		Thread.sleep(1500);
		// clickOnSchemeType.click();
		// selectSchemeWebElement.click();
		saveButtonWebElement.click();
		mcqInstructionClick.click();
		insturctionTypeWebelement.click();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(mcqDeadlineClick, examDeadline).build().perform();
		Thread.sleep(1000);
		// createNumTrackWebElement.click(); // Numeric Track
		js.executeScript("arguments[0].scrollIntoView(true);", numericTrackTeacher);
		Thread.sleep(1000);
		act.click(numericTrackTeacher).build().perform();
		selectTeacherWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(numericQuestionCount, numberques3).build().perform();
		// numericQuestionCount.sendKeys("5");
		act.click(numericquestionTypeWebElement).build().perform();
		numericQuestionWebelement.click();
		numPositiveMarkWebElement.sendKeys(positiveMarks);
		numericInstructionWebElement.click();
		Thread.sleep(1000);
		act.click(insturctionTypeWebelement).build().perform();
		// insturctionTypeWebelement.click();
		act.click(instructionWebelement).sendKeys(enterInstru).build().perform();
		savebWebelement.click();
		Thread.sleep(1000);
		act.sendKeys(numericDeadlineWebElement, examDeadline).build().perform();
		Thread.sleep(1000);
		saveQBWebelement.click();
		Thread.sleep(3000);
		System.out.println("Track Created successfully");

	}
	

	public void filltrack() throws InterruptedException {
		Thread.sleep(1000);
		actionButtonWebelement.click();
		viewquestionBucketWebelement.click();
		Thread.sleep(1000);
		selectSWebelement.click();
		Thread.sleep(1000);
		syllabusCheckWebelement.click();
		Thread.sleep(2000);
		syllabusClickWebelement.click();
		selectunit1Webelement.click();
		selectunit2Webelement.click();
		savesyllabusWebelement.click();
		Thread.sleep(1000);
		selectSWebelement.click();
		Thread.sleep(1000);
		act.click(newCheckButtonWebelement).build().perform();
		clicksyllabusWebelement.click();
		Thread.sleep(1000);
		selectallWebelement.click();
		autoGenrateWebelement.click();
		Thread.sleep(1000);
		unit1questionWebelement.sendKeys(numberques1);
		// unit2questionWebelement.sendKeys(numberques2);
		// unit3questionWebelement.sendKeys(numberques3);
		addQuestionWebelement.click();
		Thread.sleep(2500);
		selectquestionWebelement.click();
		Thread.sleep(1500);
		approvebuttonWebelement.click();
		gotoTrackWebelement.click();
		Thread.sleep(2500);
		js.executeScript("arguments[0].scrollIntoView(true);", secondTracksyllabusClick);
		Thread.sleep(1000);
		secondTracksyllabusClick.click();
		Thread.sleep(1000);
		syllabusCheckWebelement.click();
		Thread.sleep(2000);
		syllabusClickWebelement.click();
		selectunit1Webelement.click();
		selectunit2Webelement.click();
		savesyllabusWebelement.click();
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", secondTracksyllabusClick);
		secondTracksyllabusClick.click(); // Second Track
		Thread.sleep(1000);
		act.click(newCheckButtonWebelement).build().perform();
		clicksyllabusWebelement.click();
		Thread.sleep(1000);
		selectallWebelement.click();
		autoGenrateWebelement.click();
		Thread.sleep(1000);
		// unit1questionWebelement.sendKeys(numberques1);
		unit2questionWebelement.sendKeys(numberques2);
		// unit3questionWebelement.sendKeys(numberques3);
		addQuestionWebelement.click();
		Thread.sleep(2500);
		selectquestionWebelement.click();
		Thread.sleep(1500);
		approvebuttonWebelement.click();
		gotoTrackWebelement.click();
		Thread.sleep(2500);
		js.executeScript("arguments[0].scrollIntoView(true);", selectSWebelement);
		selectSWebelement.click(); // Third Track
		Thread.sleep(1000);
		Thread.sleep(1000);
		syllabusCheckWebelement.click();
		Thread.sleep(2000);
		syllabusClickWebelement.click();
		selectunit1Webelement.click();
		selectunit2Webelement.click();
		savesyllabusWebelement.click();
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", selectSWebelement);
		selectSWebelement.click();
		act.click(newCheckButtonWebelement).build().perform();
		clicksyllabusWebelement.click();
		Thread.sleep(1000);
		selectallWebelement.click();
		autoGenrateWebelement.click();
		Thread.sleep(1000);
		// unit1questionWebelement.sendKeys(numberques1);
		// unit2questionWebelement.sendKeys(numberques2);
		unit3questionWebelement.sendKeys(numberques3);
		addQuestionWebelement.click();
		Thread.sleep(1500);
		selectquestionWebelement.click();
		Thread.sleep(1500);
		approvebuttonWebelement.click();
		gotoTrackWebelement.click();
		Thread.sleep(1500);
		lockTrackWebelement.click();
		lockWebelement.click();

		System.out.println(assesmentT + "locked successfully");
	}

	public void publishExam(WebDriver driver) throws InterruptedException {
		assessmentWebelement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		actionButtonWebelement.click();
		publishclickWebelement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));
		NewUtilityStudy.scroll(driver, set2Webelement);
		Thread.sleep(2000);
		if ("Assignment".equalsIgnoreCase(assesmentT)) {
			System.out.println("creating assignment");
		} else {
			showSolutionWebelement.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		act.click(set2Webelement).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		act.click(publishExamWebelement).build().perform();
		Thread.sleep(3000);
		System.out.println(assesmentT + "published successfully");
	}

	public void resultGeneration() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		assessmentWebelement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		if ("Assignment".equalsIgnoreCase(assesmentT)) {
			assignmentClickWebelement.click();
			createAssignmentWebelement.click();
		} else if ("Exam".equalsIgnoreCase(assesmentT)) {
			createExamWebelement.click();
		} else {
			testClickWebelement.click();
			createTestWebelement.click();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		act.click(conductedExamWebElement).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		checkButtonWebElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		checkConfirmWebElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		checkedButtonWebElement.click();
		Thread.sleep(2000);
		generateResultWebElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		resultConfirmWebElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		resultWebElement.click();
		System.out.println("Result generated Successfully");

	}
}
