package assessmentNew;

import java.io.FileReader;
import java.io.IOException;

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

public class TrackFilling {
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
	;
	WebDriver driver;
	Actions act;
	
	ExamDetailsDto examDetailDto;
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
	@FindBy(id = "gradeCheck0")
	private WebElement greadCheckWebElement;
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
	@FindBy(id = "lockTrack")
	private WebElement lockTrackWebelement;
	@FindBy(xpath = "//button[text()='Lock']")
	private WebElement lockWebelement;
	
	private JSONParser jsonParser = new JSONParser();
	
	public TrackFilling(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 act=new Actions(driver);
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
			numberques1 = (String) session.get("numberquestion1");
			numberques2 = (String) session.get("numberquestion2");
			numberques3 = (String) session.get("numberquestion3");
			assesmentT = (String) session.get("assesmentType");
			questionT = (String) session.get("QuestionType");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

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
		Thread.sleep(1000);
		greadCheckWebElement.click();
		clicksyllabusWebelement.click();
		Thread.sleep(1000);
		selectallWebelement.click();
		autoGenrateWebelement.click();
		Thread.sleep(1000);
		unit1questionWebelement.sendKeys(numberques1);
		unit2questionWebelement.sendKeys(numberques2);
		unit3questionWebelement.sendKeys(numberques3);
		addQuestionWebelement.click();
		Thread.sleep(3000);
		selectquestionWebelement.click();
		Thread.sleep(2000);
		approvebuttonWebelement.click();
		gotoTrackWebelement.click();
		Thread.sleep(2000);
		lockTrackWebelement.click();
		lockWebelement.click();

		System.out.println(assesmentT + "locked successfully");
	}

}
