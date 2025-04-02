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

public class ClassRoom {
	String classRoomName;
	Actions act;
	@FindBy(xpath = "//div[text()=' Academics ']")
	private WebElement academic;
	@FindBy(xpath = "//a[text()='Classroom']")
	private WebElement classroom;
	@FindBy(xpath = "//span[text()='Add Classroom']")
	private WebElement addclassroom;
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement enterName;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[5]")
	private WebElement selectCT;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[2]")
	private WebElement Classroomtype;
	@FindBy(xpath = "(//div[@class='ng-select-container'])[5]")
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

	private JSONParser jsonParser = new JSONParser();

	public ClassRoom(WebDriver driver) throws FileNotFoundException, ParseException {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	public void classjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\AcaSession.json");

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
		// academic.click();
		Thread.sleep(1000);
		classroom.click();
		addclassroom.click();
		enterName.sendKeys(classRoomName);
		selectCT.click();
	//	Classroomtype.click();
//		selectCC.click();
		virtualCate.click();
		savebutton.click();
		System.out.println("normal Classroom Created");

	}

	public void addlicenseVClassroom() throws InterruptedException {
		// academic.click();
		Thread.sleep(1000);
		classroom.click();
		addclassroom.click();
		Thread.sleep(1000);
		enterName.sendKeys(classRoomName);
		selectCT.click();
		Classroomtype.click();
		selectCC.click();
		virtualCate.click();
		licensed.click();
		savebutton.click();
		System.out.println("licensed Classroom Created");

	}

	public void addPhysicalClassroom() throws InterruptedException {
		// academic.click();
		Thread.sleep(1000);
		classroom.click();
		addclassroom.click();
		enterName.sendKeys(classRoomName);
		selectCT.click();
		Classroomtype.click();
		selectCC.click();
		physicalCate.click();
		Thread.sleep(1000);
		act.click(selectBar).build().perform();
		selectBranch.click();
		savebutton.click();
		System.out.println("physical Classroom Created");

	}

	public void addHybridClassroom() throws InterruptedException {
		// academic.click();
		Thread.sleep(1000);
		classroom.click();
		addclassroom.click();
		enterName.sendKeys(classRoomName);
		selectCT.click();
		Classroomtype.click();
		selectCC.click();
		hybridCate.click();
		Thread.sleep(1000);
		// selectBar.click();
		act.click(selectBar).build().perform();
		selectBranch.click();
		savebutton.click();
		System.out.println("hybrid Classroom Created");

	}
}
