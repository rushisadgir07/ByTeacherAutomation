package byTeachers;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseStudy.BaseClass;
import baseStudy.Homepage;
import coursePlanner.ImportCP;
import net.minidev.json.parser.ParseException;

public class ImportCPTest extends BaseClass {

	Homepage ho;
	ImportCP cp;
	
	@BeforeClass

	public void launch12() throws InterruptedException, ParseException, IOException {
		launchB();
		ho = new Homepage(driver);
		cp = new ImportCP(driver);
		ho.jsonRead();
		ho.login();
		Reporter.log("Login successfully");
	}

	@Test(priority = 1)
	public void creationofplanner() throws IOException, ParseException, InterruptedException {
		cp.cpjsonRead();
		cp.importplannercreation();
		Thread.sleep(5000);
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		driver.close();

	}
}