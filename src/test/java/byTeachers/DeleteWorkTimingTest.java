package byTeachers;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseStudy.Homepage;
import baseStudy.BaseClass;
import net.minidev.json.parser.ParseException;
import workTimings.HolidayAdd;
import workTimings.PeriodAdd;
import workTimings.ShiftAdd;

public class DeleteWorkTimingTest extends BaseClass {
	Homepage ho;
	PeriodAdd pa;
	ShiftAdd sa;
	HolidayAdd ha;
	

	@BeforeClass
// @Parameters("browser")
	public void launch() throws InterruptedException, ParseException, IOException {
		// this.browser = browser;
		launchB();
		ho = new Homepage(driver);
		sa=new ShiftAdd(driver);
		pa = new PeriodAdd(driver);
		ha=new HolidayAdd(driver);
		ho.jsonRead();
		ho.login();
		Reporter.log("Login successfully");
	}
	@Test(priority = 1)
	public void deleteshift() throws InterruptedException, ParseException, IOException {
		sa.shiftJsonRead();
		sa.deleteShift();
		Reporter.log("Shift Created successfully");
	}
	@Test(priority = 2)
	public void deletePeriod() throws InterruptedException, ParseException, IOException {
		pa.periodJsonRead();
		pa.deletePeriod();
		Reporter.log("Shift Created successfully");
	}
	
	@AfterClass
	public void closebrowser() {
	 driver.close();
	}
}
