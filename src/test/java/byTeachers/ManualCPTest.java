


package byTeachers;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseStudy.BaseClass;
import baseStudy.Homepage;
import coursePlanner.ManualCP;
import net.minidev.json.parser.ParseException;

public class ManualCPTest extends BaseClass {

	Homepage ho;
	ManualCP cp;

	@BeforeClass

	public void launch12() throws InterruptedException, ParseException, IOException {
		launchB();
		ho = new Homepage(driver);
		cp = new ManualCP(driver);
		ho.jsonRead();
		ho.login();
		Reporter.log("Login successfully");
	}

	@Test(priority = 1)
	public void creationofplanner() throws IOException, ParseException, InterruptedException {
		cp.cpjsonRead();
		cp.addCurriculam();
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		driver.close();

	}
}