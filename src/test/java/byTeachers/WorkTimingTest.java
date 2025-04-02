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

public class WorkTimingTest extends BaseClass {
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
	public void creatNewshift() throws InterruptedException, ParseException, IOException {
		sa.shiftJsonRead();
		sa.addShift();
		Reporter.log("Shift Created successfully");
	}
	@Test(priority = 2)
	public void creatNewPeriod() throws InterruptedException, ParseException, IOException {
		pa.periodJsonRead();
		pa.addPeriod();
		Reporter.log("Shift Created successfully");
	}
	@Test(priority = 3)
	public void creatNewHoliday() throws InterruptedException, ParseException, IOException {
		ha.holidayJsonRead();
		ha.addHoliday();
		Reporter.log("Shift Created successfully");
	}

	@AfterClass
	public void closebrowser() {
	 //driver.close();
	}
}
