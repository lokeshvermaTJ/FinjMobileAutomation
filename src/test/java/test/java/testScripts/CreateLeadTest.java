package test.java.testScripts;

import Generics.BaseAndroidClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Android.CreateLeadPage;
import pageObjects.Android.HomePagePage;
import pageObjects.Android.LogIn;


public class CreateLeadTest extends BaseAndroidClass {

    static CreateLeadPage createLeadPage;
    static LogIn logIn;
    static HomePagePage homePagePage;

//
    @BeforeMethod
    public void setUp() throws InterruptedException {
        // Initialize page objects
        logIn = new LogIn(driver);
        createLeadPage = new CreateLeadPage(driver);
        homePagePage = new HomePagePage(driver);

        // Perform login steps
        logIn.permissionValidation();
        logIn.enterLoginMobileNo();
        logIn.enterOtp();
      //  homePagePage.verifytutorialScreen();
    }
    @Test
    public static void tc_VerifyCreateLeadPage() throws InterruptedException {
        createLeadPage = new CreateLeadPage(driver);
        logIn = new LogIn(driver);
        logIn.permissionValidation();
        logIn.enterLoginMobileNo();
        logIn.enterOtp();
        HomePagePage homePagePage = new HomePagePage(driver);
        homePagePage.verifytutorialScreen();
        createLeadPage.leadIcon();

    }

    @Test(description = "Verify that the user can enter a valid name in the Name field")
    public void testEnterValidName() {
        createLeadPage.enterName("John Doe");
        Assert.assertTrue(driver.getPageSource().contains("John Doe"), "Name not entered correctly");

    }

    @Test(description = "Verify that the user can enter a valid 10-digit mobile number")
    public void testEnterValidMobileNumber() {
        createLeadPage.enterMobileField("9876543210");
        Assert.assertTrue(driver.getPageSource().contains("9876543210"), "Mobile not entered correctly");
    }

    @Test(description = "Verify that Loan Amount field accepts valid numbers greater than 0")
    public void testEnterValidLoanAmount() throws InterruptedException {
        createLeadPage.enterloanAmountField("500000");
        Assert.assertTrue(driver.getPageSource().contains("500000"), "Loan amount not entered correctly");
    }

    @Test(description = "Verify that user can enter a valid vehicle registration number")
    public void testEnterValidRegistrationNumber() {
        createLeadPage.enterRegistration("MH12AB1234");
        Assert.assertTrue(driver.getPageSource().contains("MH12AB1234"), "Registration not entered correctly");
    }

    @Test(description = "Verify that Manufacturing Year can be selected from dropdown")
    public void testSelectManufacturingYear() {
        createLeadPage.selectManufacturingYear("2014");
        Assert.assertTrue(driver.getPageSource().contains("2014"), "Year not selected");
    }

    @Test(description = "Verify that Vehicle Type can be selected")
    public void testSelectVehicleType() {
        createLeadPage.selectVehicleType("Tractor");
        Assert.assertTrue(driver.getPageSource().contains("Tractor"), "Vehicle Type not selected");
    }

    @Test(description = "Verify that Brand can be selected from dropdown")
    public void testSelectBrand() {
        createLeadPage.selectBrand("Mahindra");
        Assert.assertTrue(driver.getPageSource().contains("Mahindra"), "Brand not selected");
    }

    @Test(description = "Verify that Model can be selected based on Brand")
    public void testSelectModel() {
        createLeadPage.selectModel("Arjun Novo");
        Assert.assertTrue(driver.getPageSource().contains("Arjun Novo"), "Model not selected");
    }

    @Test(description = "Verify that State, District, and Tehsil can be selected from dropdowns")
    public void testSelectLocationFields() {
        createLeadPage.selectState("Maharashtra");
        createLeadPage.selectDistrict("Pune");
        createLeadPage.selectTehsil("Haveli");
        Assert.assertTrue(driver.getPageSource().contains("Maharashtra"), "State not selected");
        Assert.assertTrue(driver.getPageSource().contains("Pune"), "District not selected");
        Assert.assertTrue(driver.getPageSource().contains("Haveli"), "Tehsil not selected");
    }

    @Test(description = "Verify that form can be submitted with all valid details")
    public void testSubmitFormSuccessfully() throws InterruptedException {
        createLeadPage = new CreateLeadPage(driver);
        logIn = new LogIn(driver);
//        logIn.permissionValidation();
//        //logIn.enterMobileNo();
//        logIn.enterLoginMobileNo();
//        logIn.enterOtp();
//

        HomePagePage homePagePage = new HomePagePage(driver);
        homePagePage.verifytutorialScreen();
       // Thread.sleep(5000);

        createLeadPage.leadIcon();
        createLeadPage.enterName("John Doe");
        createLeadPage.enterMobileField("9876543210");
        createLeadPage.enterloanAmountField("500000");
        createLeadPage.enterRegistration("MH12AB1234");
        createLeadPage.selectManufacturingYear("2014");
        createLeadPage.selectVehicleType("Tractor");
        createLeadPage.selectBrand("Eicher");
        createLeadPage.selectModel("242 Super Star");
        createLeadPage.selectState("Rajasthan");
        createLeadPage.selectDistrict("Bundi");
        createLeadPage.selectTehsil("Nainwa");
       // createLeadPage.remarksAdd("This is a good tractor");
        createLeadPage.clickSubmit();
        Thread.sleep(5000);
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

    }

}

