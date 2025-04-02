package baseStudy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class Homepage {
	String code;
	String Email;
	String pass;
	String FN;
	@FindBy(id = "orgCode")
	private WebElement orgcode;
	@FindBy(id = "signInWith")
	private WebElement signInWithMail;
	@FindBy(xpath = "//span[text()='Email?']")
	private WebElement emailclick;
	@FindBy(id = "emailId")
	private WebElement enteremail;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "mobile")
	private WebElement mobileno;
	
	@FindBy(id = "login")
	private WebElement login;
	private JSONParser jsonParser = new JSONParser();
	

	public Homepage(WebDriver driver) throws FileNotFoundException, ParseException {
		PageFactory.initElements(driver, this);

	}

	public void jsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\\\main\\\\resources\\\\jesonFile\\\\login.json");
			Object object = jsonParser.parse(reader);
			JSONObject userloginJsonobj = (JSONObject) object;
			JSONArray userLoginsArray = (JSONArray) userloginJsonobj.get("userLogin");
			JSONObject user = (JSONObject) userLoginsArray.get(0);
			code = (String) user.get("orgCode");
			Email = (String) user.get("Email");
			pass = (String) user.get("Pass");
			FN = (String) user.get("firstName");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void login() throws EncryptedDocumentException, IOException, InterruptedException, ParseException {
		orgcode.sendKeys(code);
		signInWithMail.click();
		enteremail.sendKeys(Email);
		login.click();
		Thread.sleep(2000);
		password.sendKeys(pass);
		Thread.sleep(2000);
		login.click();
		Thread.sleep(2000);
	}
}
