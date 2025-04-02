package byTeachers;

import org.testng.annotations.Test;

import baseStudy.Homepage;
import baseStudy.NewBase;
import baseStudy.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters; // Import Parameters annotation

import java.io.IOException;

import org.testng.Reporter;

import educator.Parent;
import educator.Staff;
import educator.Teacher;
import net.minidev.json.parser.ParseException;

public class EducatorTest extends BaseClass {

	Homepage ho;
	Staff st;
	Teacher t;
	Parent p;

	@BeforeClass
	
	public void launch() throws InterruptedException, ParseException, IOException {
		launchB();
		ho = new Homepage(driver);
		st = new Staff(driver);
		t = new Teacher(driver);
		p = new Parent(driver);
		ho.jsonRead();
		ho.login();
		Reporter.log("Login successfully");

	}

	@Test
	public void addStaff() throws IOException, ParseException, InterruptedException {
		st.jsonRead();
		st.Newedu(driver);
		Reporter.log("Staff added successfully");
	}

	@Test
	public void addTeacher() throws IOException, ParseException, InterruptedException {
		Thread.sleep(2000);
		t.teacherJsonRead();
		t.newTeacher();
		Reporter.log("Teacher added successfully");
	}

	@Test
	public void addparent() throws IOException, ParseException, InterruptedException {
		Thread.sleep(2000);
		p.parentJsonRead();
		p.parentAdd();
		Reporter.log("Parent added successfully");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		driver.close();

	}
}
