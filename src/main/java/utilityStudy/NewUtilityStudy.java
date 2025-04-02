package utilityStudy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class NewUtilityStudy {
	public static void screenshot(WebDriver driver, String name) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// System.out.println(src);

		File trget = new File("C:\\Users\\Rushikesh Sadgir\\Pictures\\Saved Pictures\\" + name + ".png");
		System.out.println("Target file path: " + trget.getAbsolutePath()); // Print absolute path
		FileHandler.copy(src, trget);
		Reporter.log("Taking Screenshot", true);
	}

	public static void wait(WebDriver driver, int a) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(a));

	}

	public static void scroll(WebDriver driver, WebElement Ref) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Ref);
	}

	public static String dataFromPropertiefile(String key) throws IOException {
		Properties prop = new Properties();

		FileInputStream myFile = new FileInputStream(
				"C:\\Users\\Rushikesh Sadgir\\Desktop\\My_Project\\application.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("Reading " + key + " from property File", true);
		return value;
	}

}
