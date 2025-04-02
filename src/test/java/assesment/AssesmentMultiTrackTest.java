package assesment;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.io.IOException;
import org.testng.Reporter;

import assesment.Exam;
import assesment.MultipleTrackExam;
import baseStudy.Homepage;
import baseStudy.BaseClass;
import listener.ListenerNew;
import net.minidev.json.parser.ParseException;

@Listeners(ListenerNew.class)
public class AssesmentMultiTrackTest extends BaseClass {

	Homepage ho;

	MultipleTrackExam mte;
	private String browser;

	@BeforeClass
// @Parameters("browser")
	public void launch() throws InterruptedException, ParseException, IOException {
		// this.browser = browser;
		launchB();
		ho = new Homepage(driver);
		mte = new MultipleTrackExam(driver);
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
		mte.creatThreeTrack();
		Reporter.log("Track Created successfully");
	}

	@Test(priority = 3)
	public void fillTrack() throws IOException, ParseException, InterruptedException {
		mte.examjsonRead();
		mte.filltrack();
		Reporter.log("Track filled successfully");
	}

	@Test(priority = 4)
	public void examPublish() throws IOException, ParseException, InterruptedException {
		mte.examjsonRead();
		mte.publishExam(driver);
		Reporter.log("Track filled successfully");
	}
//	@Test(enabled = true)
//	public void examResultGeneration() throws IOException, ParseException, InterruptedException {
//		// e.examjsonRead();
//		e.resultGeneration();
//		Reporter.log("Track filled successfully");
//	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		driver.close();

	}
}
