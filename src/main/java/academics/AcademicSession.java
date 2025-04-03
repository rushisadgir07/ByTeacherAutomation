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

public class AcademicSession {
	String sessionName;
	String StartDate;
	String EndDate;
	@FindBy(xpath = "//span[contains(text(),'Academic Session')]")
	private WebElement academicsess;
	@FindBy(xpath = "//input[@formcontrolname='name']")
	private WebElement entername;
	@FindBy(xpath = "//input[@formcontrolname='startDate']")
	private WebElement startDate;
	@FindBy(xpath = "//input[@formcontrolname='endDate']")
	private WebElement enddate;
	@FindBy(xpath = "//div[text()=' Save ']")
	private WebElement savebutton;
	@FindBy(xpath = "(//button[@class='closePopup'])[1]")
	private WebElement closeA;
	@FindBy(xpath = "(//img[@src='../../../../../assets/Icons/Icon edit.svg'])[1]")
	private WebElement editSession;
	@FindBy(xpath = "//div[text()=' Update ']")
	private WebElement updatebutton;
	@FindBy(xpath = "//span[@class='deletIcon ng-star-inserted']")
	private WebElement delete;
	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement remove;
	@FindBy(xpath = "(//button[@class='closePopup'])[1]")
	private WebElement closeButton;
	Actions act;

	
	private JSONParser jsonParser = new JSONParser();

	public AcademicSession(WebDriver driver) throws FileNotFoundException, ParseException {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	public void sessionjsonRead() throws ParseException, IOException {

		FileReader reader = null;
		try {

			reader = new FileReader("src\\main\\resources\\jesonFile\\AcaSession.json");

			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("AcademicS");

			JSONObject session = (JSONObject) userLoginsArray1.get(0);
			sessionName = (String) session.get("SessionName");
			StartDate = (String) session.get("startDate");
			EndDate = (String) session.get("endDate");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

	public void academicsession() throws InterruptedException {

		Thread.sleep(1000);
		academicsess.click();
		entername.sendKeys(sessionName);
		startDate.sendKeys(StartDate);
		enddate.sendKeys(EndDate);
		savebutton.click();
		closeA.click();

	}

	public void editAcademicsession() throws InterruptedException {

		Thread.sleep(1000);
		editSession.click();
		entername.clear();
		entername.sendKeys(sessionName);
		startDate.clear();
		startDate.sendKeys(StartDate);
		enddate.clear();
		enddate.sendKeys(EndDate);
		updatebutton.click();
		Thread.sleep(1000);
		closeButton.click();

	}

	public void deleteAcademicSess() throws InterruptedException {

		editSession.click();
		Thread.sleep(1000);
		act.click(delete).build().perform();
		remove.click();
		Thread.sleep(1000);
		closeButton.click();

	}

}
