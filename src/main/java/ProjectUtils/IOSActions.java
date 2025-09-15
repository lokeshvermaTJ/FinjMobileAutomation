package ProjectUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class IOSActions extends AppiumUtils{
    AndroidDriver driver;
    public IOSActions(AndroidDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    //LongPressActionMethod
    public void longPressAction(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 1000));
        Thread.sleep(3000);
    }

    //Scroll Into End
    public void scrollToEndAction() {
        boolean canScrollMore;
        do {

            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 0.75));
        }
        while(canScrollMore);
    }

    public void scrollToText(String text){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\""+text+"\"))"));
    }

    //SwipeAction
    public void swipeAction(WebElement ele, String direction )
    {
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "direction", direction, "percent", 0.15));
    }




}
