package pageObjects.Android;

import ProjectUtils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class LogIn extends AndroidActions {

    AndroidDriver driver;

    public LogIn(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    final static String expTextAllowNotification = "Allow FinjPartnerApp to send you notifications?";
    final static String expTextallowButton = "ALLOW";
    final static String expTextDeny = "DON'T ALLOW";
    final static String expTextmobileNumberText = "Enter mobile number";
    final static String expTextmobileNumberRequestText = "Enter your phone number and otp to log in";
    // Text here for input field
    final static String expTextGetOtpButton = "Get OTP";
    final static String expTextTermsText = "I agree to share my details Terms and Condition";
    //Text Here for OTp Screen
    // Text =
    final static String expTextToastSignupOTP = "Signup OTP Sent Successfully!!";
    final static String expTextVerificationCode = "Enter verification code";
    final static String expTextsentVerficationCode = "Sent verification code on +91 9643475316.";
    final static String expTextEdit = "Edit";
    final static String expTextNotReceiveOtpText = "Didn't receive OTP?";
    final static String expTextResendText = "Resend";

    //Text here for Basic details Screen
    //text = Welcome to FinJ Partner App
    final static String expWelcomeAppText = "Welcome to FinJ Partner App";
    final static String expShareDetails = "Share your details to join our trusted network and unlock leads, quick processing & support.";

    //Text Here for Basic Details
    final static String expbasicDetailText = "Basic Detail";
    final static String expWelcomeText = "Welcome to Finj";
    final static String expDetailsShare = "Share your basic details to create an account and get started !";
    //Search Details Text
    final static String expStateText = "State*";
    final static String expDistrictText = "District*";

    final static String expToastUpdateSuccessText = "User Updated Successfully!";

    // Locators For Notification Pages
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_icon")
    private WebElement permissionIconLogo;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    private WebElement permissionMessage;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement denyButton;

    // LogIn Screen Locators

    @AndroidFindBy(xpath = "//com.horcrux.svg.PathView")
    private WebElement finjLogo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter mobile number']")
    private WebElement mobileNumberText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter your phone number and otp to log in']")
    private WebElement mobileNumberRequestText;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-input-outlined']")
    private WebElement enterMobileField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Get OTP']")
    private WebElement getOtpButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='I agree to share my details Terms and Condition']")
    private WebElement termsText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement checkboxClick;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Signup OTP Sent Successfully!!']")
    private WebElement signupOtpToast;


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='button-text' and @text='OK']")
    private WebElement clickOK;
    //Text = OK

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter verification code']")
    private WebElement enterVerificationCodeText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sent verification code on +91 9643475316. ']")
    private WebElement sentVerficationCodeText;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit']")
    private WebElement editText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Didn't receive OTP? ']")
    private WebElement notReceiveOtpText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Resend']")
    private WebElement resendButton;

    //Locators For Basic Details Filling Screen

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome to FinJ Partner App']")
    private WebElement welcomeApp;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share your details to join our trusted network and unlock leads, quick processing & support.']")
    private WebElement shareDetails;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Next']")
    private WebElement nextClick;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Basic Detail']")
    private WebElement basicDetailText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome to Finj']")
    private WebElement welcomeFinjText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share your basic details to create an account and get started !']")
    private WebElement detailsShareText;

    @AndroidFindBy(xpath = "//(//android.widget.EditText[@resource-id='text-input-outlined'])[1]")
    private WebElement nameElement;

    @AndroidFindBy(xpath = "//(//android.widget.EditText[@resource-id='text-input-outlined'])[2]")
    private WebElement emailElement;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Date of Birth*']")
    private WebElement dobElement;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='01 September 2007']")
    private WebElement dobDateElement;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement okCalender;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
    private WebElement cancelCalender;


    @AndroidFindBy(xpath = "//(//android.widget.EditText[@resource-id='text-input-outlined'])[3]")
    private WebElement addressElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='State*']")
    private WebElement stateText;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='State*']")
    private WebElement stateElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Uttar Pradesh']")
    private WebElement stateSelection;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search...']")
    private WebElement stateSearch;

    @AndroidFindBy(xpath = "//com.horcrux.svg.PathView")
    private WebElement stateCross;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='District*']")
    private WebElement districtElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bulandshahr']")
    private WebElement districtSelection;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search...']")
    private WebElement districtSearch;


    @AndroidFindBy(xpath = "//com.horcrux.svg.PathView")
    private WebElement districtCross;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Submit']")
    private WebElement sumitButton;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='User Updated Successfully!']")
    private WebElement toastUpdateSuccess;


    public WebElement getAllowButton() {
        return allowButton;
    }

    public WebElement getDenyButton() {
        return denyButton;
    }

    public void permissionValidation() throws InterruptedException {
        allowButton.click();
        Thread.sleep(2000);
        System.out.println("User Click on the Allow Button");
    }



    public void enterMobileNo() {
        Random random = new Random();
        String mobile = "9" + (100000000 + random.nextInt(899999999));
        enterMobileField.sendKeys(mobile);
        System.out.println("User Entered the Mobile No." + mobile);
    }


    public void enterLoginMobileNo() {
        String mobile = "9643475316";
        enterMobileField.sendKeys(mobile);
        System.out.println("User Entered the Mobile No." + mobile);
        enterMobileField.sendKeys(mobile);
    }

    public void enterOtp() throws InterruptedException {
        getOtpButton.click();
        System.out.println("User Click on the OTP Button");
        //Verify Toast Messgae

        Thread.sleep(1000);
        String otp = "123456";
        // Click only the first box to focus
        WebElement firstOtpBox = driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]"));
        firstOtpBox.click();
        // Loop through digits and send them as key events
        AndroidDriver androidDriver = (AndroidDriver) driver;
        for (char digit : otp.toCharArray()) {
            AndroidKey key = AndroidKey.valueOf("DIGIT_" + digit);
            androidDriver.pressKey(new KeyEvent(key));
        }
        System.out.println("User Entered the OTP");
    }



    public void clickNext() throws InterruptedException {
        nextClick.click();
        System.out.println("➡️ Clicked on Next button");
        Thread.sleep(1000);

    }

    // Enter Name
    public void enterName(String name) {
        nameElement.sendKeys(name);
        System.out.println("👤 Entered Name: " + name);
    }

    // Enter Email
    public void enterEmail(String email) {
        emailElement.sendKeys(email);
        System.out.println("📧 Entered Email: " + email);
    }

    // Select Date of Birth
    public void selectDob(String dob) throws InterruptedException {
        dobElement.click();
        Thread.sleep(1000);
        // Use dynamic XPath
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='" + dob + "']")).click();
        okCalender.click();
        Thread.sleep(1000);
        System.out.println("🎂 Date of Birth selected");
    }

    // Enter Address
    public void enterAddress(String address) {
        addressElement.sendKeys(address);
        System.out.println("🏠 Entered Address: " + address);
    }

    public void selectState(String state) {
       stateElement.click();
        scrollToText(state);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + state + "']")).click();
    }

    public void selectDistrict(String district) {
        districtElement.click();
        scrollToText(district);
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='" + district + "']")).click();
    }

    // Submit Form
    public void clickSubmit() {
        sumitButton.click();
        System.out.println("✅ Clicked Submit button");
    }


}

