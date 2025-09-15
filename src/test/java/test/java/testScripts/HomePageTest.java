package test.java.testScripts;

import Generics.BaseAndroidClass;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pageObjects.Android.HomePagePage;


public class HomePageTest extends BaseAndroidClass {

    static HomePagePage HomePagePage;

    @Test
    public static void tc_VerifyHomepageTutorialScreens() throws InterruptedException {
        HomePagePage = new HomePagePage(driver);
        LoginTest log = new LoginTest();
        log.tc_ValidDirect_Login();
        Thread.sleep(5000);
        HomePagePage.verifytutorialScreen();
        HomePagePage.verifyProfileClick();

    }

    @Test
    public static void tc_verifySellTractorScreen() throws InterruptedException {
        HomePagePage = new HomePagePage(driver);
        tc_VerifyHomepageTutorialScreens();
        HomePagePage.getSellTractor().click();
        Thread.sleep(5000);
    }
}
