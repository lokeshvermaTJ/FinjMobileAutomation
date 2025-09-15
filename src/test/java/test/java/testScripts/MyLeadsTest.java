package test.java.testScripts;

import Generics.BaseAndroidClass;
import org.testng.annotations.Test;
import pageObjects.Android.HomePagePage;
import pageObjects.Android.MyLeadsPage;


public class MyLeadsTest extends BaseAndroidClass {

    static MyLeadsPage MyLeadsPage;

    @Test
    public static void tc_VerifyHomepageTutorialScreens() throws InterruptedException {
         MyLeadsPage  = new MyLeadsPage(driver);

          LoginTest log = new LoginTest();
          log.tc_ValidDirect_Login();
         HomePageTest.tc_verifySellTractorScreen();
         MyLeadsPage.verifyAllApplicationScreenTest();
    }

}

