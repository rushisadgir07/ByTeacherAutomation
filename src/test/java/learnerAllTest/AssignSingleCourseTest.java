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
import learner.Learner;
import listener.ListenerNew;
import net.minidev.json.parser.ParseException;
import utilityStudy.NewUtilityStudy;

@Listeners(ListenerNew.class)
public class AssignSingleCourseTest extends BaseClass {
	Homepage ho;
	Learner le;
	Teacher t;
	AssignAcademicDetails ad;
	ActiveStudent as;
	//private String browser;

	@BeforeClass
//	@Parameters("browser")
	public void launch() throws InterruptedException, ParseException, IOException {
	//	this.browser = browser;
		launchB();
		ho = new Homepage(driver);
		le = new Learner(driver);
		ad=new AssignAcademicDetails(driver);
		t = new Teacher(driver);
		as=new ActiveStudent(driver);
		ho.jsonRead();
		ho.login();
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException, ParseException {

	}

	@Test(priority = 1)
	public void addLearner() throws IOException, ParseException, InterruptedException {
		le.jsonRead();
		le.NewLear();
		Thread.sleep(2000);
		Reporter.log("Learner added successfully");
		NewUtilityStudy.screenshot(driver, "learnerAdded");
	}
	@Test(priority = 2)
	public void assigAcademicDetails() throws IOException, ParseException, InterruptedException {
		ad.jsonRead();
		ad.addAcademicdetails();
		Reporter.log("Learner added successfully");
		NewUtilityStudy.screenshot(driver, "learnerAdded");
	}
	@Test(priority = 3)
	public void activeStudent() throws IOException, ParseException, InterruptedException {
		as.activeStudent();
		Reporter.log("Learner activated successfully");
		NewUtilityStudy.screenshot(driver, "learnerAdded");
		ad.secondCourse();
	}
	
	

	@AfterMethod
	public void loggingOut() throws InterruptedException {
		driver.close();
	}



}
