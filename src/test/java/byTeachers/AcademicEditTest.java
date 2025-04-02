package byTeachers;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import academics.Academic;
import academics.AcademicSession;
import academics.Batch;
import academics.ClassRoom;
import academics.Course;
import academics.EditClassRoom;
import academics.Grade;
import academics.Subject;
import baseStudy.Homepage;
import baseStudy.BaseClass;
import listener.ListenerNew;
import net.minidev.json.parser.ParseException;
//@Listeners(ListenerNew.class)
public class AcademicEditTest extends BaseClass {
	Homepage ho;
	Academic a;
	AcademicSession as;
	Grade g;
	Course c;
	Subject s;
	Batch b;
	EditClassRoom cr;

	@BeforeClass
	public void beforeClass() throws ParseException, IOException, InterruptedException {
		launchB();
		ho = new Homepage(driver);
		a = new Academic(driver);
		as = new AcademicSession(driver);
		g = new Grade(driver);
		s = new Subject(driver);
		b = new Batch(driver);
		cr = new EditClassRoom(driver);
		ho.jsonRead();
		ho.login();
		c = new Course(driver);
		a.onAcademic();
		Reporter.log("Login successfully");
	}

	@Test(priority = 1)
	public void editSession() throws ParseException, IOException, InterruptedException {
		as.sessionjsonRead();
		as.editAcademicsession();

	}

	@Test(priority = 2)
	public void editCourse() throws ParseException, IOException, InterruptedException {
		c.sessionjsonRead();
		c.editCourse();

	}

	@Test(priority = 3)
	public void editClassRoom() throws ParseException, IOException, InterruptedException {
		cr.classjsonRead();
		cr.addnormlVClassroom();

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
