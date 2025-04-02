package jsonPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JsonData {
    private WebDriver driver;
    private WebElement orgcode;

    public JsonData(WebDriver driver) {
        this.driver = driver;
        loadWebElementsFromJson();
    }

    private void loadWebElementsFromJson() {
        try {
            // Load WebElement configurations from JSON
            String orgCodeId = "orgCode"; // This should come from your JSON
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            orgcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orgCodeId)));

            if (orgcode != null) {
                System.out.println("orgcode element is initialized.");
            }
        } catch (Exception e) {
            System.err.println("Error initializing orgcode element: " + e.getMessage());
        }
    }

    public void sendOrgCodeValue(String value) {
        if (orgcode != null) {
            orgcode.clear(); // Clear the field before sending new value
            orgcode.sendKeys(value);
            System.out.println("Sent value: " + value);
        } else {
            System.err.println("orgcode WebElement is null. Cannot send value.");
        }
    }

    public String getOrgCodeValue() {
        if (orgcode != null) {
            String value = orgcode.getAttribute("value");
            System.out.println("Retrieved value: " + value);
            return value;
        }
        System.err.println("orgcode WebElement is null. Cannot retrieve value.");
        return null; // Return null if orgcode is still uninitialized
    }

    // Other methods as needed...
}
