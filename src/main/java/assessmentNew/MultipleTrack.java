package assessmentNew;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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

public class MultipleTrack {

	
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
	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	
	ExamDetailsDto examDetailDto;
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
	@FindBy(xpath = "(//span[text()='×'])[6]")
	private WebElement clickOnSchemeType;
	@FindBy(xpath = "//span[text()=' New Sceme ']")
	private WebElement selectSchemeWebElement;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButtonWebElement;
	@FindBy(id = "0getInstruction1")
	private WebElement mcqInstructionClick;
	@FindBy(xpath = "(//input[@id='bsDatepicker'])[2]")
	private WebElement mcqDeadlineClick; // MCQ track created successfully
	@FindBy(id = "0addSimpleFormControl1")
	private WebElement createNumTrackWebElement;
	@FindBy(xpath = "(//div[text()='Select Teacher'])[3]")
	private WebElement numericTrackTeacher;
	@FindBy(id = "0checkTrack2")
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
	private WebElement numericDeadlineWebElement;
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
	@FindBy(id = "gradeCheck0")
	private WebElement greadCheckWebElement;
	private JSONParser jsonParser = new JSONParser();
	
	
	public MultipleTrack(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	public void examjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\multitrackExam.json");
			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("ExamDetails");

			JSONObject session = (JSONObject) userLoginsArray1.get(0);
			ObjectMapper objectMapper = new ObjectMapper();
			examDetailDto = objectMapper.readValue(session.toJSONString(), ExamDetailsDto.class);
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
	public void creatThreeTrack() throws InterruptedException {
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
		Thread.sleep(1000);
		act.click(insturctionTypeWebelement).build().perform();
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
		act.click(numericquestionTypeWebElement).build().perform();
		numericQuestionWebelement.click();
		numPositiveMarkWebElement.sendKeys(positiveMarks);
		numericInstructionWebElement.click();
		Thread.sleep(1000);
		act.click(insturctionTypeWebelement).build().perform();
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
		if (greadCheckWebElement.isDisplayed()) {
			greadCheckWebElement.click();
		}
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
		secondTracksyllabusClick.click(); // Second Track
		Thread.sleep(1000);
		act.click(newCheckButtonWebelement).build().perform();
		if (greadCheckWebElement.isDisplayed()) {
			greadCheckWebElement.click();
		}
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
		act.click(newCheckButtonWebelement).build().perform();
		if (greadCheckWebElement.isDisplayed()) {
			greadCheckWebElement.click();
		}
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


}
