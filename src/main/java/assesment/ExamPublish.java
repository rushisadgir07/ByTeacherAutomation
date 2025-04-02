//package assesment;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//import utilityStudy.NewUtilityStudy;
//
//public class ExamPublish {
//	@FindBy(id = "Assessment")
//	private WebElement assessmentWebelement;
//	@FindBy(xpath = "(//img[@id='dropdownBasic1'])[1]")
//	private WebElement actionButtonWebelement;
//	@FindBy(id = "openPublish")
//	private WebElement publishclickWebelement;
//	@FindBy(id = "checkboxSetting2")
//	private WebElement showSolutionWebelement;
//	@FindBy(xpath = "(//input[@name='paperSetCount'])[2]")
//	private WebElement set2Webelement;
//	@FindBy(xpath = "//span[text()='Publish']")
//	private WebElement publishExamWebelement; // exam publish successfully
//
//	
//	
//	public void publishExam(WebDriver driver) throws InterruptedException {
//		assessmentWebelement.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
//		actionButtonWebelement.click();
//		publishclickWebelement.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));
//		NewUtilityStudy.scroll(driver, set2Webelement);
//		Thread.sleep(2000);
//		if ("Assignment".equalsIgnoreCase(assesmentT)) {
//			System.out.println("creating assignment");
//		} else {
//			showSolutionWebelement.click();
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
//		act.click(set2Webelement).build().perform();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
//		act.click(publishExamWebelement).build().perform();
//		Thread.sleep(3000);
//		System.out.println(assesmentT + "published successfully");
//	}
//}
