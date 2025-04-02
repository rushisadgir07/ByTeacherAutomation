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

public class Batch {
	Actions act;

	String batchName;
	@FindBy(xpath = "//div[text()=' Academics ']")
	private WebElement academic;
	@FindBy(xpath = "//a[text()='Batch']")
	private WebElement batch;
	@FindBy(xpath = "//span[text()='Add Batch']")
	private WebElement addBatch;
	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[8]")
	private WebElement selectC;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement selectCourse;
	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[9]")
	private WebElement selectB;
	@FindBy(xpath = "(//span[@class='ng-option-label ng-star-inserted'])[1]")
	private WebElement selectBranch;
	@FindBy(xpath = "//input[@placeholder='Enter batch']")
	private WebElement enterName;
	@FindBy(xpath = "(//button[text()='Save'])[2]")
	private WebElement savebutton;
	@FindBy(xpath = "(//img[@src='../../../../../assets/Icons/Icon edit.svg'])[20]")
	private WebElement editbutton;

	private JSONParser jsonParser = new JSONParser();

	public Batch(WebDriver driver) throws FileNotFoundException, ParseException {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	public void batchjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\AcaSession.json");

			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("Batch");

			JSONObject Csession = (JSONObject) userLoginsArray1.get(0);
			batchName = (String) Csession.get("BatchName");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void addBatch() throws InterruptedException {
		//academic.click();
		Thread.sleep(1000);
		batch.click();
		addBatch.click();
		Thread.sleep(1000);
		act.click(selectC).build().perform();
		//selectC.click();
		selectCourse.click();
		selectB.click();
		selectBranch.click();
		enterName.sendKeys(batchName);
		savebutton.click();
	}

	public void editBatch() throws InterruptedException {
		academic.click();
		Thread.sleep(1000);
		batch.click();
		Thread.sleep(3000);
		act.moveToElement(editbutton).click().build().perform();

	}
}
