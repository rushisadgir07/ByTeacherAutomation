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
public class LearnerTest extends NewBase {
	Homepage ho;
	Learner le;
	Teacher t;
	AssignAcademicDetails ad;
	ActiveStudent as;
	private String browser;

	@BeforeClass
	@Parameters("browser")
	public void launch(String browser) throws InterruptedException, ParseException, IOException {
		this.browser = browser;
		launchingbrowser(browser);
		ho = new Homepage(driver);
		le = new Learner(driver);
		ad = new AssignAcademicDetails(driver);
		t = new Teacher(driver);
		as = new ActiveStudent(driver);

	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException, ParseException {
		ho.jsonRead();
		ho.login();
	}

	@Test(priority = 1)
	public void addLearner() throws IOException, ParseException, InterruptedException {
		le.jsonRead();
		le.NewLear();
		Thread.sleep(2000);
		Reporter.log("Learner added successfully");
		NewUtilityStudy.screenshot(driver, "learnerAdded");
	}

	@AfterMethod
	public void loggingOut() throws InterruptedException {
		driver.close();
	}

}
