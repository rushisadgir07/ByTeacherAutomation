package assesment;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import assesment.Exam;
import baseStudy.Homepage;
import baseStudy.BaseClass;
import listener.ListenerNew;
import net.minidev.json.parser.ParseException;

@Listeners(ListenerNew.class)
public class MultiSubjectTrackAssesmentTest extends BaseClass {

	Homepage ho;
	MultiSubjectExam mse;
	MultiSubjectMultiTrackExamCreation mte;
	private String browser;

	@BeforeClass
// @Parameters("browser")
	public void launch() throws InterruptedException, ParseException, IOException {
		// this.browser = browser;
		launchB();
		ho = new Homepage(driver);
		mse = new MultiSubjectExam(driver);
		mte = new MultiSubjectMultiTrackExamCreation(driver);
		ho.jsonRead();
		ho.login();
		Reporter.log("Login successfully");
	}

	@Test(priority = 1)
	public void createAssesment() throws IOException, ParseException, InterruptedException {
		mte.examjsonRead();
		mte.createAssessment();
		Reporter.log("Assesment Created successfully");

	}

	@Test(priority = 2)
	public void createTrack() throws IOException, ParseException, InterruptedException {
		mte.examjsonRead();
		mte.creatPhysicsTrack();
		mte.creatChemistryTrack();
		Reporter.log("Track Created successfully");
	}

	@Test(priority = 3)
	public void fillTrack() throws IOException, ParseException, InterruptedException {
		mse.examjsonRead();
		// mse.filltrack();

		Reporter.log("Track filled successfully");
	}

//	@Test(priority = 4)
//	public void examPublish() throws IOException, ParseException, InterruptedException {
// e.examjsonRead();
//		e.publishExam(driver);
//	Reporter.log("Track filled successfully");
//	}
//	@Test(enabled = true)
//	public void examResultGeneration() throws IOException, ParseException, InterruptedException {
//		// e.examjsonRead();
//		e.resultGeneration();
//		Reporter.log("Track filled successfully");
//	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		// driver.close();

	}
}
