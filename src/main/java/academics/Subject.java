package academics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Subject {
	Actions act;
	@FindBy(xpath = "//div[text()=' Academics ']")
	private WebElement academic;
	@FindBy(xpath = "//a[text()='Subject']")
	private WebElement subject;
	@FindBy(xpath = "//span[text()='Add Subjects']")
	private WebElement addSub;
	@FindBy(xpath = "(//div[@class='ng-input'])[8]")
	private WebElement Course;
	@FindBy(xpath = "//div[@class='ng-option ng-option-marked ng-star-inserted']")
	private WebElement selectCourse;
	@FindBy(xpath = "//span[text()='Chemistry']")
	private WebElement chemSub;
	@FindBy(xpath = "//span[text()='Mathematics']")
	private WebElement mathSub;
	@FindBy(xpath = "//span[text()='Physics']")
	private WebElement phySub;
	@FindBy(xpath = "//span[text()='Biology']")
	private WebElement biologySubject;
	@FindBy(id = "cdk-drop-list-12")
	private WebElement dragSubject;
	@FindBy(xpath = "(//div[@formarrayname='compulsorySubjectList'])[1]")
	private WebElement compulsory;
	@FindBy(xpath = "(//div[@formarrayname='compulsorySubjectList'])[2]")
	private WebElement optional;
	@FindBy(xpath = "(//button[text()='Save'])[2]")
	private WebElement savebutton;
	@FindBy(xpath = "(//span[@class='editBox'])[10]")
	private WebElement editbutton;
	@FindBy(xpath = "//button[text()='Move']")
	private WebElement move;
	@FindBy(xpath = "(//div[@class='swal2-popup swal2-modal swal2-show'])")
	private WebElement moveelement;
	@FindBy(xpath = "(//button[@class='btn common-btn ng-star-inserted'])")
	private WebElement update;

	public Subject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.act = new Actions(driver);
	}

	public void selectSubject() throws InterruptedException {
		//academic.click();
		Thread.sleep(1000);
		subject.click();
		addSub.click();
		Course.click();
		selectCourse.click();
		Thread.sleep(1000);
		act.clickAndHold(chemSub).dragAndDrop(chemSub, compulsory).build().perform();
		Thread.sleep(500);
		act.clickAndHold(mathSub).dragAndDrop(mathSub, compulsory).build().perform();
		Thread.sleep(500);
		act.clickAndHold(phySub).dragAndDrop(phySub, compulsory).build().perform();
		Thread.sleep(500);
		act.clickAndHold(biologySubject).dragAndDrop(biologySubject, optional).build().perform();
		
		Thread.sleep(1000);
		savebutton.click();
	}

	public void editSubject() throws InterruptedException {
		academic.click();
		Thread.sleep(1000);
		subject.click();
		editbutton.click();
		Thread.sleep(1000);
		act.clickAndHold(mathSub).dragAndDrop(mathSub, optional).build().perform();
		
		if (move.isSelected()) {
			move.click();
		} else {
			System.out.println("subject drop succesfully");
		}
		// move.click();
		Thread.sleep(3000);
		update.click();

	}
}
