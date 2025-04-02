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
import academics.Course;
import academics.EditClassRoom;
import academics.Grade;
import academics.Subject;
import baseStudy.Homepage;
import baseStudy.BaseClass;
import listener.ListenerNew;
import net.minidev.json.parser.ParseException;

//@Listeners(ListenerNew.class)
public class AcademicDeleteTest extends BaseClass {
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
	public void deleteSession() throws InterruptedException {
		Thread.sleep(2000);
		as.deleteAcademicSess();
	}

	@Test(priority = 2)
	public void deleteCourse() throws InterruptedException {
		Thread.sleep(2000);
		c.deleteCourse();
	}

	@Test(priority = 3)
	public void deleteClassroom() throws InterruptedException {
		Thread.sleep(2000);
		cr.deleteClass();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
