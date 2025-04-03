package byTeachers;

import org.testng.annotations.Test;

import academics.Academic;
import academics.AcademicSession;
import academics.Batch;
import academics.ClassRoom;
import academics.Course;
import academics.Grade;
import academics.Subject;
import baseStudy.Homepage;
import baseStudy.BaseClass;
import listener.ListenerNew;
import net.minidev.json.parser.ParseException;
import utilityStudy.NewUtilityStudy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

@Listeners(ListenerNew.class)
public class AcademicAddTest extends BaseClass {
	Homepage ho;
	Academic a;
	AcademicSession as;
	Grade g;
	Course c;
	Subject s;
	Batch b;
	ClassRoom cr;

	@BeforeClass
	public void beforeClass() throws ParseException, IOException, InterruptedException {
		launchB();
		ho = new Homepage(driver);
		a = new Academic(driver);
		as = new AcademicSession(driver);
		g = new Grade(driver);
		s = new Subject(driver);
		b = new Batch(driver);
		cr = new ClassRoom(driver);
		ho.jsonRead();
		ho.login();
		c = new Course(driver);
		a.onAcademic();
		Reporter.log("Login successfully");
	}

	@Test(priority = 1)
	public void addacademicSession() throws ParseException, IOException, InterruptedException {
		as.sessionjsonRead();
		as.academicsession();
		NewUtilityStudy.screenshot(driver, "SessionAdded");

	}

	@Test(priority = 2)
	public void selectGread() throws ParseException, IOException, InterruptedException {
		g.selectgread();
		NewUtilityStudy.screenshot(driver, "GradeSelected");

	}

	@Test(priority = 3)
	public void addCourse() throws ParseException, IOException, InterruptedException {
		c.sessionjsonRead();
		c.addCourse();
		NewUtilityStudy.screenshot(driver, "CourseAdded");
	}

	@Test(priority = 4)
	public void addSubject() throws ParseException, IOException, InterruptedException {
		s.selectSubject();
		NewUtilityStudy.screenshot(driver, "SubjectSelection");
	}

	@Test(priority = 5)
	public void addBatch() throws ParseException, IOException, InterruptedException {
		b.batchjsonRead();
		b.addBatch();
		NewUtilityStudy.screenshot(driver, "BatchAdded");
	}

	@Test(priority = 6)
	public void addClassRoom() throws ParseException, IOException, InterruptedException {
		cr.classjsonRead();
		cr.addnormlVClassroom();
		NewUtilityStudy.screenshot(driver, "ClassroomAdded");
	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.close();
//	}

}
