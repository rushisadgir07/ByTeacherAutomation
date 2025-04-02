package academics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Grade {
	
	@FindBy(xpath = "//div[text()=' Academics ']")
	private WebElement academic;
	@FindBy(xpath = "//a[text()='Grade']")
	private WebElement grade;
	@FindBy(xpath = "//span[text()='Add Grade']")
	private WebElement addGreads;
	@FindBy(xpath = "(//div[@class='ng-input'])[5]")
	private WebElement selectGread;
	@FindBy(xpath = "//span[text()='8']")
	private WebElement gre;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savebutton;

	public Grade(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectgread() throws InterruptedException {
		//academic.click();
		Thread.sleep(2000);
		grade.click();
		addGreads.click();
		Thread.sleep(1000);
		selectGread.click();
		if (gre.isSelected()) {
			System.out.println("given gread is selected");
		} else {
			gre.click();
		}
		savebutton.click();
	}

}
