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

public class EditClassRoom {
	String classRoomName;
	Actions act;
	@FindBy(xpath = "//div[text()=' Academics ']")
	private WebElement academic;
	@FindBy(xpath = "//a[text()='Classroom']")
	private WebElement classroom;
	@FindBy(xpath = "//span[text()='Add Classroom']")
	private WebElement addBatch;
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement enterName;
	@FindBy(xpath = "(//div[@class='ng-select-container ng-has-value'])[4]")
	private WebElement selectCT;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement Classroomtype;
	@FindBy(xpath = "(//div[@class='ng-select-container ng-has-value'])[5]")
	private WebElement selectCC;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[2]")
	private WebElement virtualCate;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement physicalCate;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[3]")
	private WebElement hybridCate;
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement licensed;
	@FindBy(xpath = "(//ng-select[@placeholder='Select'])[3]")
	private WebElement selectBar;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement selectBranch;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement savebutton;
	@FindBy(xpath = "(//span[@class='editBox'])[8]")
	private WebElement editClassroom;
	@FindBy(xpath = "//span[text()='Update']")
	private WebElement update;
	@FindBy(xpath = "//img[@src='../assets/Icons/timetable/DeleteIcon.svg']")
	private WebElement delete;
	@FindBy(xpath = "//span[text()='Remove']")
	private WebElement removeClick;

	private JSONParser jsonParser = new JSONParser();

	public EditClassRoom(WebDriver driver) throws FileNotFoundException, ParseException {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	public void classjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\ClassRoom.json");
			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("Classroom");

			JSONObject Csession = (JSONObject) userLoginsArray1.get(0);
			classRoomName = (String) Csession.get("ClassroomName");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void addnormlVClassroom() throws InterruptedException {
		//academic.click();
		Thread.sleep(1000);
		classroom.click();
		Thread.sleep(2000);
		editClassroom.click();
		Thread.sleep(1000);
		enterName.clear();
		Thread.sleep(1000);
		enterName.sendKeys(classRoomName);
		Thread.sleep(1000);
		selectCT.click();
		Thread.sleep(1000);
		Classroomtype.click();
		selectCC.click();
		physicalCate.click();
		//act.click(selectBar).build().perform();
		update.click();
		System.out.println("normal Classroom edited");

	}

	public void deleteClass() throws InterruptedException {
		//academic.click();
		Thread.sleep(1000);
		classroom.click();
		Thread.sleep(1000);
		editClassroom.click();
		Thread.sleep(1500);
		delete.click();
		removeClick.click();
		Thread.sleep(2000);

	}
}
