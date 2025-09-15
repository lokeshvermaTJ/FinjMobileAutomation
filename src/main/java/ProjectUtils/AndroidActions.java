package ProjectUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtils{
    AndroidDriver driver;
    public AndroidActions(AndroidDriver driver)
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
//    public void scrollToEndAction() {
//        boolean canScrollMore;
//        do {
//
//            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
//                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 0.75));
//        }
//        while(canScrollMore);
//    }
//    public void scrollToEndAction() {
//        Dimension size = driver.manage().window().getSize();
//        int screenWidth = size.width;
//        int screenHeight = size.height;
//
//        boolean canScrollMore;
//        do {
//            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript(
//                    "mobile: scrollGesture",
//                    ImmutableMap.of(
//                            "left", 0,
//                            "top", 0,
//                            "width", screenWidth,
//                            "height", screenHeight,
//                            "direction", "down",
//                            "percent", 0.75
//                    )
//            );
//        } while (canScrollMore);
//    }
//
//    public void scrollDownByPoints(double percent) {
//        Dimension size = driver.manage().window().getSize();
//        int screenWidth = size.width;
//        int screenHeight = size.height;
//
//        ((JavascriptExecutor) driver).executeScript(
//                "mobile: scrollGesture",
//                ImmutableMap.of(
//                        "left", 0,
//                        "top", 0,
//                        "width", screenWidth,
//                        "height", screenHeight,
//                        "direction", "down",
//                        "percent", percent   // e.g., 0.3 → scroll 30% of screen
//                )
//        );
//    }
    public void scrollDown(double percent) {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.7); // start swipe lower on screen
        int endY   = (int) (size.height * 0.3); // end swipe higher

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 0,
                "top", 0,
                "width", size.width,
                "height", size.height,
                "direction", "up",
                "percent", percent
        ));
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
