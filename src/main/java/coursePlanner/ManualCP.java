package coursePlanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class ManualCP {

	String CPName;
	String Subject;
	String SUnit;
	String Chapter;
	String Topic;
	String Subtopic;
	String Duration;

	@FindBy(xpath = "//div[text()='Curriculum']")
	private WebElement curriculamWebElement;
	@FindBy(xpath = "//span[@class='btn common-btn-md']")
	private WebElement CreatePlanner;
	@FindBy(xpath = "//div[@class='ng-select-container']")
	private WebElement SubjectDropClick;
	@FindBy(xpath = "//span[text()='Physics']")
	private WebElement SelectPhySub;
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement CPname1;
	@FindBy(xpath = "//button[@id='nextStep']")
	private WebElement nextB;
	@FindBy(xpath = "//input[@id='comment' and @name='unitName']")
	private WebElement Unit;
	@FindBy(xpath = "//div[@class='d-flex onlyAdd ng-star-inserted']/p")
	private WebElement addChapter;
	@FindBy(xpath = "//input[@id='comment' and @name='chapterName']")
	private WebElement chaptername;
	@FindBy(xpath = "//div[@class='d-flex onlyAdd ng-star-inserted']/p")
	private WebElement addTopic;
	@FindBy(xpath = "//input[@id='comment' and @name='topicName']")
	private WebElement topicname;
	@FindBy(xpath = "//div[@class='d-flex onlyAdd ng-star-inserted']/p")
	private WebElement addSubtopic;
	@FindBy(xpath = "//input[@id='comment' and @name='subTopicName']")
	private WebElement subtopicname;
	@FindBy(xpath = "//span[@class='ng-arrow-wrapper']")
	private WebElement durationdd;
	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	private WebElement durationselect;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveB;
	JSONParser jsonParser = new JSONParser();

	public ManualCP(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void cpjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\cp.json");
			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("CoursePlanner");
			JSONObject session = (JSONObject) userLoginsArray1.get(0);
			ObjectMapper objectMapper = new ObjectMapper();
			CPName = (String) session.get("CoursePName");
			Subject = (String) session.get("subject");
			SUnit = (String) session.get("UnitName");
			Chapter = (String) session.get("ChapterName");
			Topic = (String) session.get("TopicName");
			Subtopic = (String) session.get("SubTopicName");
			Duration = (String) session.get("duration");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

	public void addCurriculam() throws InterruptedException {
		Thread.sleep(1000);
		curriculamWebElement.click();
		Thread.sleep(1000);
		CreatePlanner.click();
		Thread.sleep(3000);
		SubjectDropClick.click();
		Thread.sleep(1000);
		SelectPhySub.click();
		Thread.sleep(1000);
		CPname1.sendKeys(CPName);
		nextB.click();
		Thread.sleep(2000);
		Unit.sendKeys(SUnit);
		addChapter.click();
		chaptername.sendKeys(Chapter);
		addTopic.click();
		topicname.sendKeys(Topic);
		addSubtopic.click();
		subtopicname.sendKeys(Subtopic);
		durationdd.click();
		Thread.sleep(2000);
		durationselect.click();
		Thread.sleep(2000);
		saveB.click();
	}

}