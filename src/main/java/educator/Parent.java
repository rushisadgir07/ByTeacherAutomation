package educator;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class Parent {
	String parentFN;
	String parentLN;
	String parentEmail;
	String parentMobile;
	String parentGender;

	@FindBy(xpath = "//div[text()='Educator']")
	private WebElement educator;
	@FindBy(xpath = "//a[text()='Parents']")
	private WebElement parent;
	@FindBy(xpath = "(//span[text()='Quick Add'])[3]")
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
	@FindBy(xpath = "//input[@id='radio0']")
	private WebElement maleGender;
	@FindBy(xpath = "//input[@id='radio1']")
	private WebElement femaleGender;
	@FindBy(xpath = "//button[@class='closePopup']")
	private WebElement close;
	private JSONParser jsonParser = new JSONParser();

	public Parent(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void parentJsonRead() throws IOException, ParseException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\\\main\\\\resources\\\\jesonFile\\\\Teacher.json");
			Object object = jsonParser.parse(reader);
			JSONObject jsonObject = (JSONObject) object;
			JSONArray teacherArray = (JSONArray) jsonObject.get("Parent");
			JSONObject teacher = (JSONObject) teacherArray.get(0);
			parentFN = (String) teacher.get("ParentFirstName");
			parentLN = (String) teacher.get("ParentLastName");
			parentEmail = (String) teacher.get("ParentEmail");
			parentMobile = (String) teacher.get("ParentMobile");
			parentGender = (String) teacher.get("Parentgender");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void parentAdd() throws InterruptedException {
		//educator.click();
		Thread.sleep(2000);
		parent.click();
		Thread.sleep(2000);
		quick.click();
		firstname.sendKeys(parentFN);
		lastname.sendKeys(parentLN);
		email.sendKeys(parentEmail);
		mobile.sendKeys(parentMobile);
		if(parentGender.equals("male"))
		{
			maleGender.click();
		}
		else
		{
			femaleGender.click();
		}
		save.click();
		close.click();
		Thread.sleep(5000);
	}

}
