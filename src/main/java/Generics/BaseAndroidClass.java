package Generics;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.Android.FormPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseAndroidClass {

    public static AndroidDriver driver;
    public FormPage formPage;

    // @BeforeClass(alwaysRun = true)
    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "POCO C51");
        caps.setCapability("appium:udid", "YPCM8LMFA6XGXWHY");
        caps.setCapability("appium:appPackage", "com.finjpartnerapp");
        caps.setCapability("appium:appActivity", "com.finjpartnerapp.MainActivity");
        //caps.setCapability("appium:appActivity", "com.finjpartnerapp/com.finjpartnerapp.MainActivity");


        caps.setCapability("appium:automationName", "UiAutomator2");
        //caps.setCapability("appium:noReset", "true");
        //        caps.setCapability("appium:fullReset","false");


        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("App open");
        formPage = new FormPage(driver);
    }

//
//    public String getScreenshot(AppiumDriver driver, String testCaseName) throws IOException {
//
//        File source = driver.getScreenshotAs(OutputType.FILE);
//        File screenshotDir = new File(System.getProperty("user.dir") + "/ScreenShots/");
//        screenshotDir.mkdirs();
//        String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh-mm_a").format(new Date());
//        String destinationPath = screenshotDir.getAbsolutePath() + "/" + testCaseName + "_" + timestamp + ".png";
//        FileUtils.copyFile(source, new File(destinationPath));
//        //System.out.println("Screenshot saved at: " + destinationPath);
//        return destinationPath;
//    }
//    // @AfterClass(alwaysRun = true)


    public String getScreenshot(AppiumDriver driver, String testCaseName) throws IOException {
        // Capture screenshot
        File source = driver.getScreenshotAs(OutputType.FILE);

        // Create directory under project -> /reports/ScreenShots
        File screenshotDir = new File(System.getProperty("user.dir") + "/reports/ScreenShots/");
        screenshotDir.mkdirs();

        // Unique filename with timestamp
        String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh-mm_a").format(new Date());
        String screenshotName = testCaseName + "_" + timestamp + ".png";

        // Full path on local system
        String destinationPath = screenshotDir.getAbsolutePath() + "/" + screenshotName;

        // Copy file to destination
        FileUtils.copyFile(source, new File(destinationPath));

        // Return relative path (so ExtentReport can display it)
        return "ScreenShots/" + screenshotName;
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


