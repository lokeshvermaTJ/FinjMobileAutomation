package Generics;
//import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.Android.FormPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


public class VirtualAndroidBaseTest
{
    //public static void main(String[] args) throws MalformedURLException {
    public AndroidDriver driver;
    public FormPage formPage;
    @BeforeClass
    public void configureAppium() throws IOException {
        //AndroidDriver driver = new AndroidDriver(new URL("https://127.0.0.1:4723"),null);

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/c/resources/data.properties");
        prop.load(fis);
        String ipAddress = prop.getProperty("ipAddress");
       // String port = prop.getProperty("prop");
        int port = Integer.parseInt(prop.getProperty("port"));



        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 9a API 36.0");
        options.setPlatformName("Android");
        //options.setApp("C:\\Users\\Tractor Junction\\IdeaProjects\\AppiumProject\\src\\main\\java\\NewPackage\\ApiDemos-debug.apk"); // replace with your APK path
        options.setApp("C:\\Users\\Tractor Junction\\IdeaProjects\\AppiumProject\\src\\main\\java\\NewPackage\\General-Store.apk");
        options.setCapability("noSign", true);
        options.setCapability("skipServerInstallation", true);
        options.setCapability("chromedriver_autodownload", true);

       // URL url = new URL("http://127.0.0.1:4723");
        URL url = new URL("http://" + ipAddress + ":" + port);
        driver = new AndroidDriver(url, options);

        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("App open");
        formPage = new FormPage(driver);
    }

    //LongPressActionMethod
    public void longPressAction(WebElement element) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(), "duration", 1000));
        Thread.sleep(3000);
    }

    //SwipeAction
    public void swipeAction(WebElement ele, String direction )
    {
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "direction", direction, "percent", 0.15));
    }

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
