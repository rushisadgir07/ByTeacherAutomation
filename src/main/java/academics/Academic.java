package academics;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.minidev.json.parser.ParseException;

public class Academic {
	@FindBy(xpath = "//div[text()=' Academics ']")
	private static WebElement academicWebElement;

	public Academic(WebDriver driver) throws FileNotFoundException, ParseException {
		PageFactory.initElements(driver, this);
	}

	public static void onAcademic() {
		academicWebElement.click();
	}
}
