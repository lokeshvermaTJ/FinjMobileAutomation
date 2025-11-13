package Generics;

import ProjectUtils.configLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 *
 * @author Lokesh Verma
 * @description Mobile launch is controlled by this class.
 */

public class BaseAndroidClass2 {
    /*
     * Platform can be android,ios,webandroid and webios.
     * Need to set this for each test case in the PropertyFile  (FileName = config.android.properties)
     */

    public static AndroidDriver driver;
    //@BeforeClass(alwaysRun = true)
    @BeforeClass
    @Parameters({"env"})
    public void configureAppium(String env) throws MalformedURLException {
        configLoader.loadConfig(env);
        DesiredCapabilities caps = new DesiredCapabilities();
        String platform = configLoader.get("platformName");
        if (platform.equalsIgnoreCase("Android")) {
            // ✅ Read all values from property file
            //caps.setCapability("platformName", configLoader.get("platformName"));
            caps.setCapability("appium:platformVersion", configLoader.get("platformVersion"));
            caps.setCapability("appium:deviceName", configLoader.get("deviceName"));
            caps.setCapability("appium:udid", configLoader.get("udid"));
            caps.setCapability("appium:appPackage", configLoader.get("appPackage"));
            caps.setCapability("appium:appActivity", configLoader.get("appActivity"));
            caps.setCapability("appium:automationName", configLoader.get("automationName"));

            URL url = new URL("http://127.0.0.1:4723/");
            driver = new AndroidDriver(url, caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("✅ App launched on device: " + configLoader.get("deviceName"));
        }
        else if (platform.equalsIgnoreCase("iOS")) {
            caps.setCapability("appium:platformVersion", configLoader.get("platformVersion"));
            caps.setCapability("bundleId", configLoader.get("bundleId"));  // iOS bundle id
            caps.setCapability("xcodeOrgId", configLoader.get("xcodeOrgId"));
            caps.setCapability("xcodeSigningId", configLoader.get("xcodeSigningId"));
            caps.setCapability("wdaLaunchTimeout", 80000);
            System.out.println("✅ iOS app launched on device: " + configLoader.get("deviceName"));
        }
        else if (platform.equalsIgnoreCase("webandroid")) {
            // 🌐 Android Web (Chrome)
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", configLoader.get("deviceName"));
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("udid", configLoader.get("udid"));
            caps.setCapability("platformVersion", configLoader.get("platformVersion"));
            caps.setCapability("browserName", "Chrome");
            URL url = new URL("http://127.0.0.1:4723/");
            driver = new AndroidDriver(url, caps);

        } else if (platform.equalsIgnoreCase("webios")) {
            // 🌐 iOS Web (Safari)
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", configLoader.get("deviceName"));
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("UDID", configLoader.get("udid"));
            caps.setCapability("platformVersion", configLoader.get("platformVersion"));
            caps.setCapability("browserName", "Safari");
            URL url = new URL("http://127.0.0.1:4723/");
            driver = new AndroidDriver(url, caps);
        }
        else {
            throw new RuntimeException("❌ Invalid platform: " + platform);
        }
    }



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


