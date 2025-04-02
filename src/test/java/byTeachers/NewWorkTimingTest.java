package byTeachers;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseStudy.BaseClass;
import baseStudy.Homepage;
import net.minidev.json.parser.ParseException;
import workTimings.HolidayAdd;
import workTimings.PeriodAdd;
import workTimings.ShiftAdd;

public class NewWorkTimingTest extends BaseClass {
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
	@Test
	public void creatNewshift() throws InterruptedException, ParseException, IOException {
		sa.shiftJsonRead();
		sa.addShift();
		Reporter.log("Shift Created successfully");
	}
	@Test
	public void createNewPeriod() throws ParseException, IOException, InterruptedException
	{
		pa.periodJsonRead();
		pa.addPeriod();
		
	}
}
