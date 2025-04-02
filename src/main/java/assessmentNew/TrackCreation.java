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

public class TrackCreation {
	String tMarks;
	String passMarks;
	String startda;
	String question;
	String positiveMarks;
	String enterInstru;
	String numberques1;
	String numberques2;
	String numberques3;
	String endda;
	String questionT;
	String examDeadline;
	Actions act;
	WebDriver driver;
	
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
	@FindBy(xpath = "//span[text()=' NUMERICAL ']")
	private WebElement numericQuestionWebelement;
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
	private WebElement saveQBWebelement; 
	private JSONParser jsonParser = new JSONParser();
	public TrackCreation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
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
			question = (String) session.get("EnterQuestion");
			positiveMarks = (String) session.get("Positivemark");
			enterInstru = (String) session.get("Instruction");

			numberques1 = (String) session.get("numberquestion1");
			numberques2 = (String) session.get("numberquestion2");
			numberques3 = (String) session.get("numberquestion3");
			questionT = (String) session.get("QuestionType");
			examDeadline = (String)session.get("ExamdeadLine");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}
	
	public void creatTrack() throws InterruptedException {
		Thread.sleep(3000);
		act.moveToElement(clickteacherWebelement).click().build().perform();
		selectTeacherWebelement.click();
		enterQuestionWebelement.sendKeys(question);
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

	//	act.click(deadlineWebelement).sendKeys(examDetailDto.getStartDate()).build().perform();
		act.sendKeys(deadlineWebelement, examDeadline).build().perform();
		//deadlineWebelement.sendKeys(startda);
		Thread.sleep(500);
		saveQBWebelement.click();
		System.out.println("Track Created successfully");

	}

}
