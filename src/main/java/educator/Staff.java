package educator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class Staff {

	String StFirst;
	String StaffLast;
	String Staffmail;
	String StaffMo;

	@FindBy(xpath = "//div[text()='Educator']")
	private WebElement educator;
	@FindBy(xpath = "//span[text()='Quick Add']")
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
	@FindBy(id = "closeQuickForm")
	private WebElement close;

	JSONParser jsonParser = new JSONParser();

	public Staff(WebDriver driver) throws FileNotFoundException, ParseException {
		PageFactory.initElements(driver, this);
	}

	public void jsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\Teacher.json");
			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("Staff");

			JSONObject staffuser = (JSONObject) userLoginsArray1.get(0);

			StFirst = (String) staffuser.get("StaffFirstName");
			StaffLast = (String) staffuser.get("StaffLastName");
			Staffmail = (String) staffuser.get("StaffEmail");
			StaffMo = (String) staffuser.get("StaffMobile");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void Newedu(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		Actions act = new Actions(driver);
		act.moveToElement(educator).doubleClick().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(quick)).click();
		firstname.sendKeys(StFirst);
		lastname.sendKeys(StaffLast);
		email.sendKeys(Staffmail);
		mobile.sendKeys(StaffMo);
		save.click();
		close.click();
	}
}
