package test.java.testScripts;

import Generics.BaseAndroidClass;
import com.aventstack.extentreports.Status;
import listeners.ListenerNew;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Android.CreateLeadPage;
import pageObjects.Android.HomePagePage;
import pageObjects.Android.LogIn;
import pageObjects.Android.ProfilePages;


public class ProfilePagesTest extends BaseAndroidClass {

    static LogIn logIn;
    static ProfilePages profilePages;

    //
    @BeforeMethod
    public void setUp() throws InterruptedException {
        // Initialize page objects
        logIn = new LogIn(driver);
        // Perform login steps
        logIn.locationPermission();
        logIn.permissionValidation();
        logIn.enterLoginMobileNo();
        logIn.enterOtp();
        //  homePagePage.verifytutorialScreen();
    }

    @Test
    public void tc_VerifyPermission() throws InterruptedException {
        logIn = new LogIn(driver);
        logIn.permissionValidation();
        System.out.println("Click on the Allow Button");
        Thread.sleep(1000);

        logIn.enterMobileNo();
        logIn.enterOtp();
        Thread.sleep(2000);
    }

    @Test
    public void verifyOtpToastMessage() throws InterruptedException {
        LogIn logIn = new LogIn(driver);
        logIn.permissionValidation();
        System.out.println("Click on the Allow Button");
        Thread.sleep(1000);
        logIn.enterMobileNo();
        logIn.enterOtp();

    }

    @Test
    public void tc_ValidDirect_Login() throws InterruptedException {
        logIn = new LogIn(driver);
        logIn.locationPermission();
        logIn.permissionValidation();
        logIn.enterLoginMobileNo();
        logIn.enterOtp();

    }




    @Test(description = "Verify that the user can click the Submit button")
    public void profileTest() throws InterruptedException {
        profilePages = new ProfilePages(driver);
        logIn = new LogIn(driver);
        HomePagePage homePagePage = new HomePagePage(driver);
        homePagePage.verifytutorialScreen();
        profilePages.clickprofile();


    }

}




