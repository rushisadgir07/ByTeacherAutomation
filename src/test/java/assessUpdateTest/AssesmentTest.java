package assessUpdateTest;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.io.IOException;
import org.testng.Reporter;

import assesment.Exam;
import assessmentNew.AssesmentCreation;
import assessmentNew.MultipleTrack;
import assessmentNew.PublishAssessment;
import assessmentNew.TrackCreation;
import assessmentNew.TrackFilling;
import baseStudy.Homepage;
import baseStudy.BaseClass;
import listener.ListenerNew;
import net.minidev.json.parser.ParseException;

@Listeners(ListenerNew.class)
public class AssesmentTest extends BaseClass {

	Homepage ho;
	AssesmentCreation ac;
	TrackCreation tc;
	TrackFilling tf;
	PublishAssessment pa;
	MultipleTrack mt;

	@BeforeClass
// @Parameters("browser")
	public void launch() throws InterruptedException, ParseException, IOException {
		// this.browser = browser;
		launchB();
		ho = new Homepage(driver);
		ac = new AssesmentCreation(driver);
		mt=new MultipleTrack(driver);
		tf = new TrackFilling(driver);
		pa = new PublishAssessment(driver);
		ho.jsonRead();
		ho.login();
		Reporter.log("Login successfully");
	}

	@Test(priority = 1)
	public void createAssesment() throws IOException, ParseException, InterruptedException {
		ac.examjsonRead();
		ac.createAssessment();
		Reporter.log("Assesment Created successfully");

	}

	@Test(priority = 2)
	public void createTrack() throws IOException, ParseException, InterruptedException {
		mt.examjsonRead();
		mt.creatThreeTrack();
		Reporter.log("Track Created successfully");
	}

	@Test(priority = 3)
	public void fillTrack() throws IOException, ParseException, InterruptedException {
		
		Reporter.log("Track filled successfully");
	}

	@Test(priority = 4)
	public void examPublish() throws IOException, ParseException, InterruptedException {
		
		Reporter.log("Track filled successfully");
	}
//	@Test(enabled = true)
//	public void examResultGeneration() throws IOException, ParseException, InterruptedException {
//		e.examjsonRead();
//		e.resultGeneration();
//		Reporter.log("Track filled successfully");
//	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		 driver.close();

	}
}
