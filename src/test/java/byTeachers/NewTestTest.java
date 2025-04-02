package byTeachers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;   
import org.testng.annotations.Test;

import baseStudy.BaseClass;
import jsonPractice.JsonData;

public class NewTestTest extends BaseClass {

    private JsonData jd;

    @BeforeClass
    public void setup() throws InterruptedException, IOException {
        launchB(); 
        jd = new JsonData(driver); 
    }

    @Test
    public void testOrgCodeValue() throws InterruptedException {
        String expectedValue = "YourOrgCode"; 
        jd.sendOrgCodeValue(expectedValue);
      
        String actualValue = jd.getOrgCodeValue();
        Assert.assertEquals(actualValue, expectedValue, "The org code value does not match the expected value.");
        
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
