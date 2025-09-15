package ProjectUtils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumUtils {

    AppiumDriver driver;

    public AppiumUtils(AppiumDriver driver){
        this.driver = driver;
    }


    public void waitForElementToAppear(WebElement ele){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
    }

    // Wait until element contains specific attribute value (e.g., text)
    public void waitForElementToAppearNew(WebElement ele, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(ele, attribute, value));
    }


    // Wait for element to be clickable
    public void waitForElementToBeClickable(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    // Wait until element is visible
    public void waitForVisibility(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    // Click on element after waiting
    public void waitAndClick(WebElement ele) {
        waitForVisibility(ele);
        ele.click();
    }

    // Send keys after waiting
    public void waitAndSendKeys(WebElement ele, String text) {
        waitForVisibility(ele);
        ele.clear();
        ele.sendKeys(text);
    }


    // Hide keyboard
//    public void hideKeyboard() {
//        try {
//            driver.hideKeyboard();
//        } catch (Exception e) {
//            // Ignore if not present
//        }
//    }








}
