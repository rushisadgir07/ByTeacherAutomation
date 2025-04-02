package educator;


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


public class Teacher {
	private String teacherFN;
	private String teacherLN;
	private String teacherEmail;
	private String teacherMobile;
	Actions act;

	@FindBy(xpath = "//div[text()='Educator']")
	private WebElement educator;

	@FindBy(xpath = "//a[text()='Teachers']")
	private WebElement teacher;

	@FindBy(xpath = "(//span[text()='Quick Add'])[2]")
	private WebElement quick;

	@FindBy(id = "firstName")
	private WebElement firstname;

	@FindBy(id = "lastName")
	private WebElement lastname;

	@FindBy(id = "emailId")
	private WebElement email;

	@FindBy(id = "phoneNumber")
	private WebElement mobile;

	@FindBy(id = "saveUser")
	private WebElement save;

	@FindBy(xpath = "//button[@class='closePopup']")
	private WebElement closebutton;

	private JSONParser jsonParser = new JSONParser();

	public Teacher(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	public void teacherJsonRead() throws IOException, ParseException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\\\main\\\\resources\\\\jesonFile\\\\Teacher.json");
			Object object = jsonParser.parse(reader);
			JSONObject jsonObject = (JSONObject) object;
			JSONArray teacherArray = (JSONArray) jsonObject.get("Teacher");
			JSONObject teacher = (JSONObject) teacherArray.get(0);
			teacherFN = (String) teacher.get("TeacherFirstName");
			teacherLN = (String) teacher.get("TeacherLastName");
			teacherEmail = (String) teacher.get("TeacherEmail");
			teacherMobile = (String) teacher.get("TeacherMobile");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void newTeacher() throws InterruptedException {
		educator.click(); // You can uncomment this line if needed
		Thread.sleep(1000);
		teacher.click();
		Thread.sleep(2000);
		quick.click();
		firstname.sendKeys(teacherFN);
		lastname.sendKeys(teacherLN);
		email.sendKeys(teacherEmail);
		mobile.sendKeys(teacherMobile);
		save.click();
		Thread.sleep(1000);
		act.moveToElement(closebutton).doubleClick().build().perform();

	}
}
