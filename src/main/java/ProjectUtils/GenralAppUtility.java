//package A.utils;
//
//import com.google.common.collect.ImmutableMap;
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class GenralAppUtility extends AppiumUtils{
//    AndroidDriver driver;
//    public GenralAppUtility(AndroidDriver driver)
//    {
//        super(driver);
//        this.driver = driver;
//    }
//
//    public void verifyToastMessage(String expectedToastText, int timeoutInSeconds) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//
//            // Capture the toast message using XPath
//            MobileElement toastElement = (MobileElement) wait.until(
//                    ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[1]"))
//            );
//
//            String actualToastText = toastElement.getText();
//
//            if (!actualToastText.contains(expectedToastText)) {
//                throw new AssertionError("Toast text mismatch. Expected: '" + expectedToastText +
//                        "' but found: '" + actualToastText + "'");
//            }
//
//            System.out.println("✅ Toast message verified: " + actualToastText);
//
//        } catch (Exception e) {
//            throw new AssertionError(" Toast message with text '" + expectedToastText +
//                    "' was not found within " + timeoutInSeconds + " seconds.", e);
//        }
//    }
//
//}
//}
