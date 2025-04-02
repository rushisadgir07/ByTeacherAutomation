package academics;

import java.io.FileNotFoundException;
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

public class Course {
	String courseNa;
	Actions act;

	@FindBy(xpath = "//div[text()=' Academics ']")
	private WebElement academic;
	@FindBy(xpath = "//a[text()='Course']")
	private WebElement course;
	@FindBy(xpath = "//span[text()='Add Course']")
	private WebElement addC;
	@FindBy(xpath = "//input[@placeholder='Course']")
	private WebElement courseName;
	@FindBy(xpath = "(//div[@class='input-group'])[2]")
	private WebElement startdate;
	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[9]")
	private WebElement selectDate;
	@FindBy(xpath = "//div[text()='Grade']")
	private WebElement clickGread;
	@FindBy(xpath = "//label[text()='11']")
	private WebElement firstGread;
	@FindBy(xpath = "//label[text()='12']")
	private WebElement SecondGread;
	@FindBy(xpath = "//div[text()='Link Master Course']")
	private WebElement selectMasterCourse;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement mastercourse;
	@FindBy(xpath = "(//div[@class='ng-input'])[6]")
	private WebElement selectAcademicSession;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement firstSession;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savebutton;
	@FindBy(xpath = "(//img[@src='../../../../../assets/Icons/Icon edit.svg'])[10]")
	private WebElement editcourse;
	@FindBy(xpath = "(//button[text()='Update'])[1]")
	private WebElement updateButton;
	@FindBy(xpath = "//i[@class='fas fa-trash fa-1x']")
	private WebElement delete;
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteButton;

	private JSONParser jsonParser = new JSONParser();

	public Course(WebDriver driver) throws FileNotFoundException, ParseException {
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
	}

	public void sessionjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {

			reader = new FileReader("src\\main\\resources\\jesonFile\\AcaSession.json");

			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("Course");

			JSONObject Csession = (JSONObject) userLoginsArray1.get(0);
			courseNa = (String) Csession.get("CourseName");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void addCourse() throws InterruptedException {
		//academic.click();
		Thread.sleep(1000);
		course.click();
		addC.click();
		courseName.sendKeys(courseNa);
		startdate.click();
		selectDate.click();
		Thread.sleep(2000);
		act.click(clickGread).build().perform();
		Thread.sleep(1000);
		firstGread.click();
		SecondGread.click();
		Thread.sleep(1000);
		act.click(selectMasterCourse).build().perform();
		Thread.sleep(1000);
		mastercourse.click();
		Thread.sleep(500);
		selectAcademicSession.click();
		firstSession.click();
		savebutton.click();
	}

	public void editCourse() throws InterruptedException {
		//academic.click();
		Thread.sleep(1000);
		course.click();
		Thread.sleep(1000);
		editcourse.click();
		Thread.sleep(1500);
		courseName.clear();
		courseName.sendKeys(courseNa);
		startdate.click();
		selectDate.click();
		clickGread.click();
		firstGread.click();
		Thread.sleep(500);
		SecondGread.click();
		Thread.sleep(1500);
		selectAcademicSession.click();
		firstSession.click();
		updateButton.click();
	}

	public void deleteCourse() throws InterruptedException {
		//academic.click();
		Thread.sleep(1000);
		course.click();
		Thread.sleep(1000);
		editcourse.click();
		Thread.sleep(1000);
		delete.click();
		deleteButton.click();
	}
}
