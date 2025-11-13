package test.java.testScripts;

import Generics.BaseAndroidClass;
import Generics.BaseAndroidClass2;
import com.aventstack.extentreports.Status;
import listeners.ListenerNew;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Android.LogIn;



public class LoginTest extends BaseAndroidClass2 {

    static LogIn logIn;

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
        System.out.println("User Click on the Checkbox Button");
        Thread.sleep(1000);
        logIn.enterMobileNo();
        logIn.enterOtp();

    }

    @Test
    public void tc_ValidDirect_Login() throws InterruptedException {
//        logIn = new LogIn(driver);
//        logIn.permissionValidation();
//        logIn.enterLoginMobileNo();
//        logIn.enterOtp();
        logIn = new LogIn(driver);
        ListenerNew.logStep(Status.INFO, "Starting Full SignUp Flow");


        logIn.locationPermission();

        // Allow permission
        logIn.permissionValidation();
        ListenerNew.logStep(Status.PASS, "Permissions allowed");

        // Enter mobile and OTP
        logIn.enterLoginMobileNo();
        ListenerNew.logStep(Status.PASS, "Entered mobile number");

        logIn.enterOtp();
        ListenerNew.logStep(Status.PASS, "Entered OTP");

//        logIn.clickNext();
//        ListenerNew.logStep(Status.PASS, "Clicked Next button on Basic Details Tutorial");

//        Thread.sleep(4000);

    }

    @Test(description = "Verify user can allow permission")
    public void testAllowPermission() throws InterruptedException {
        logIn.permissionValidation();
    }

    @Test(description = "Verify Signup with random mobile and OTP")
    public void testSignUPLogin() throws InterruptedException {
        logIn.enterMobileNo();
        logIn.enterOtp();
    }

    @Test(description = "Verify login with fixed mobile and OTP")
    public void testFixedMobileLogin() throws InterruptedException {
        logIn.enterLoginMobileNo();
        logIn.enterOtp();
    }

    @Test(description = "Verify that the user can enter a valid name in the Name field")
    public void testEnterValidName() {
        logIn.enterName("John Doe");
        Assert.assertTrue(driver.getPageSource().contains("John Doe"), "Name not entered correctly");
    }

    @Test(description = "Verify that the user can click Next button")
    public void testClickNext() throws InterruptedException {
        logIn.clickNext();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getPageSource().contains("Basic Detail")
                || driver.getPageSource().contains("Welcome"), "Next button not clicked or page not loaded");
    }

    @Test(description = "Verify that the user can enter a valid email in the Email field")
    public void testEnterValidEmail() {
        logIn.enterEmail("john.doe@test.com");
        Assert.assertTrue(driver.getPageSource().contains("john.doe@test.com"), "Email not entered correctly");
    }

    @Test(description = "Verify that the user can select Date of Birth")
    public void testSelectDob() throws InterruptedException {
        logIn.selectDob("01 September 2007");
        Assert.assertTrue(driver.getPageSource().contains("01 September 2007"), "DOB not selected correctly");
    }

    @Test(description = "Verify that the user can enter a valid address")
    public void testEnterAddress() {
        logIn.enterAddress("Tractor Junction Sector-9 Noida (U.P.)");
        Assert.assertTrue(driver.getPageSource().contains("Tractor Junction Sector-9 Noida (U.P.)"), "Address not entered correctly");
    }

    @Test(description = "Verify that the user can select a valid state")
    public void testSelectState() throws InterruptedException {
        logIn.selectState("Uttar Pradesh");
        Assert.assertTrue(driver.getPageSource().contains("Uttar Pradesh"), "State not selected correctly");
    }

    @Test(description = "Verify that the user can select a valid district")
    public void testSelectDistrict() throws InterruptedException {
        logIn.selectDistrict("Bulandshahr");
        Assert.assertTrue(driver.getPageSource().contains("Bulandshahr"), "District not selected correctly");
    }

    @Test(description = "Verify that the user can click the Submit button")
    public void testClickSubmit() {
        logIn.clickSubmit();
        Assert.assertTrue(driver.getPageSource().contains("User Updated Successfully")
                || driver.getPageSource().contains("success"), "Submit button did not work correctly");
    }

    @Test
    public void tc_verifySignUp() throws InterruptedException {
        logIn = new LogIn(driver);
        ListenerNew.logStep(Status.INFO, "Starting Full SignUp Flow");

        logIn.locationPermission();

        // Allow permission
        logIn.permissionValidation();
        ListenerNew.logStep(Status.PASS, "Permissions allowed");

        // Enter mobile and OTP
        logIn.enterMobileNo();
        ListenerNew.logStep(Status.PASS, "Entered mobile number");

        logIn.enterOtp();
        ListenerNew.logStep(Status.PASS, "Entered OTP");

        logIn.clickNext();
        ListenerNew.logStep(Status.PASS, "Clicked Next button on Basic Details Tutorial");

        Thread.sleep(4000);

        // Enter details
        logIn.enterName("Lokesh");
        ListenerNew.logStep(Status.PASS, "Entered Name: Lokesh");

        Thread.sleep(1000);
        logIn.selectState("Uttar Pradesh");
        ListenerNew.logStep(Status.PASS, "Selected State: Uttar Pradesh");

        Thread.sleep(1000);
        logIn.selectDistrict("Bulandshahr");
        ListenerNew.logStep(Status.PASS, "Selected District: Bulandshahr");
        Thread.sleep(1000);
        logIn.selectTehsil("Khurja");
        ListenerNew.logStep(Status.PASS, "Selected Tehsil: Khurja");

        logIn.clickSubmit();
        ListenerNew.logStep(Status.PASS, "Submitted Signup Form Successfully");

        ListenerNew.logStep(Status.INFO, "SignUp Flow Completed");
    }

}




