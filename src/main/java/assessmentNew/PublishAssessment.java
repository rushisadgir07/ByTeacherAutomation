package assessmentNew;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.byteacher.automation.dto.ExamDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import utilityStudy.NewUtilityStudy;

public class PublishAssessment {
	String assesmentT;
	WebDriver driver;
	Actions act;
	
	ExamDetailsDto examDetailDto;
	@FindBy(id = "openPublish")
	private WebElement publishclickWebelement;
	@FindBy(id = "checkboxSetting2")
	private WebElement showSolutionWebelement;
	@FindBy(xpath = "(//input[@name='paperSetCount'])[2]")
	private WebElement set2Webelement;
	@FindBy(xpath = "//span[text()='Publish']")
	private WebElement publishExamWebelement;
	@FindBy(id = "Assessment")
	private WebElement assessmentWebelement;
	@FindBy(xpath = "(//img[@id='dropdownBasic1'])[1]")
	private WebElement actionButtonWebelement;
	
	private JSONParser jsonParser = new JSONParser();
	
	public PublishAssessment(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 act=new Actions(driver);
	}
	public void examjsonRead() throws ParseException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\jesonFile\\Exam.json");
			Object object1 = jsonParser.parse(reader);
			JSONObject userloginJsonobj1 = (JSONObject) object1;
			JSONArray userLoginsArray1 = (JSONArray) userloginJsonobj1.get("ExamDetails");

			JSONObject session = (JSONObject) userLoginsArray1.get(0);
			ObjectMapper objectMapper = new ObjectMapper();
			examDetailDto = objectMapper.readValue(session.toJSONString(), ExamDetailsDto.class);
			
			assesmentT = (String) session.get("assesmentType");
			
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}
	public void publishExam(WebDriver driver) throws InterruptedException {
		assessmentWebelement.click();
		Thread.sleep(1000);
		actionButtonWebelement.click();
		publishclickWebelement.click();
		Thread.sleep(2000);
		NewUtilityStudy.scroll(driver, set2Webelement);
		Thread.sleep(2000);
		if ("Assignment".equalsIgnoreCase(assesmentT)) {
			System.out.println("creating assignment");
		} else {
			showSolutionWebelement.click();
		}
		Thread.sleep(2000);
		act.click(set2Webelement).build().perform();
		Thread.sleep(1000);
		act.click(publishExamWebelement).build().perform();
		Thread.sleep(3000);
		System.out.println(assesmentT + "published successfully");
	}

}
