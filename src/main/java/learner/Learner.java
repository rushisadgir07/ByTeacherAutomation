package learner;

import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import java.io.FileNotFoundException;

public class Learner {
	String first;
	String last;
	String mailId;
	String moNo;
	String Gender;

	@FindBy(xpath = "//div[text()='Learner']")
	private WebElement learnerWebelement;
	@FindBy(xpath = "//span[text()='Quick Add']")
	private WebElement quickWebelement;
	@FindBy(id = "firstName")
	private WebElement firstnameWebelement;
	@FindBy(id = "lastName")
	private WebElement lastnameWebelement;
	@FindBy(id = "emailId")
	private WebElement emailWebelement;
	@FindBy(id = "phoneNumber")
	private WebElement mobileWebelement;
	@FindBy(id = "radio0")
	private WebElement maleGenderWebElement;
	@FindBy(id = "radio1")
	private WebElement  feMaleGenderWebElement;
	@FindBy(id = "radio2")
	private WebElement otherGnderWebElement;
	@FindBy(id = "saveUser")
	private WebElement saveWebelement;
	@FindBy(id = "closePopup")
	private WebElement close;

	JSONParser jsonParser = new JSONParser();

	// FileReader reader1 = new
	// FileReader("src\\main\\resources\\jesonFile\\learner.json");
	FileReader reader = new FileReader("src\\main\\resources\\jesonFile\\learner.json");

	public Learner(WebDriver driver) throws FileNotFoundException, ParseException {
		PageFactory.initElements(driver, this);
	}

	public void jsonRead() throws ParseException {

		Object object1 = jsonParser.parse(reader);
		JSONObject userloginJsonobj1 = (JSONObject) object1;
		JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("Learner");
		JSONObject user1 = (JSONObject) userLoginsArray1.get(0);
		first = (String) user1.get("FirstName");
		last = (String) user1.get("LastName");
		mailId = (String) user1.get("email");
		moNo = (String) user1.get("mobile");
		Gender = (String) user1.get("Gender");
		// String arr[] = new String[userLoginsArray.size()];
	}

	public void NewLear() throws InterruptedException {
		learnerWebelement.click();
		Thread.sleep(1000);
		quickWebelement.click();
		firstnameWebelement.sendKeys(first);
		lastnameWebelement.sendKeys(last);
		emailWebelement.sendKeys(mailId);
		mobileWebelement.sendKeys(moNo);
		Thread.sleep(1000);
		if(Gender.equalsIgnoreCase("Male"))
		{
			maleGenderWebElement.click();
		}else if (Gender.equalsIgnoreCase("feMale")) {
			feMaleGenderWebElement.click();
		}else {
			otherGnderWebElement.click();
		}
		Thread.sleep(1000);
		saveWebelement.click();
		close.click();
		Thread.sleep(5000);
	}
}
