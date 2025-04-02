package learnerAllTest;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseStudy.BaseClass;
import baseStudy.Homepage;
import baseStudy.NewBase;
import educator.Teacher;
import learner.ActiveStudent;
import learner.AssignAcademicDetails;
import learner.BatchChange;
import learner.Learner;
import learner.TransferCourse;
import listener.ListenerNew;
import net.minidev.json.parser.ParseException;
import utilityStudy.NewUtilityStudy;

@Listeners(ListenerNew.class)
public class RemoveCourseTest extends BaseClass {
	Homepage ho;
	BatchChange bc;
	//private String browser;

	@BeforeClass
//	@Parameters("browser")
	public void launch() throws InterruptedException, ParseException, IOException {
	//	this.browser = browser;
		launchB();
		ho = new Homepage(driver);
		bc=new BatchChange(driver);
		ho.jsonRead();
		ho.login();
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException, ParseException {

	}

	@Test(priority = 1)
	public void RemovingCourse() throws IOException, ParseException, InterruptedException {
		bc.jsonRead();
		bc.RemoveCourse();
		Thread.sleep(2000);
		Reporter.log("Course Removed successfully");
		NewUtilityStudy.screenshot(driver, "learnerAdded");
	}
	
	

	@AfterMethod
	public void loggingOut() throws InterruptedException {
		driver.quit();
	}

	public void closeBrowser() throws InterruptedException {

	}

}
