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

public class ProfilePages extends AndroidActions {

    AndroidDriver driver;

    public ProfilePages(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.ImageView")
    private WebElement profileIcon;


    // Locators For Profile click
    @AndroidFindBy(xpath = "//android.view.View[@text='Profile Detail']")
    private WebElement profileDetailText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit']")
    private WebElement editButton;

    //Locators for Inside Edit Button

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BASIC DETAIL']")
    private WebElement basicDetailText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='KYC DOCUMENT']")
    private WebElement kycDetailText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BANK DETAIL']")
    private WebElement bankDetailText;



    @AndroidFindBy(accessibility = "Update")
    private WebElement updateButton;

    //Locators For KYC Document
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-input-outlined']")
    private WebElement panNumberButton;

    @AndroidFindBy(accessibility = "Get OTP")
    private WebElement getOtpButton;




    //Locators For Bank Details
    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='text-input-outlined'])[1]")
    private WebElement accountNoButton;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='text-input-outlined'])[2]")
    private WebElement ifscCodeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify Account']")
    private WebElement verifyAccountButton;

    @AndroidFindBy(accessibility = "Bank Info*")
    private WebElement bankInfoButton;

    @AndroidFindBy(accessibility = "Signature Image*")
    private WebElement signatureImageButton;


    //Locators For GST Details

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GST Detail']")
    private WebElement gstDetailButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GST DETAIL']")
    private WebElement gstDetailBack;

    //Locators For Profile Details Screen

    @AndroidFindBy(accessibility = "My leads")
    private WebElement myLeadsButton;
    //Lead List Screen Open


    //Locator For My Contact
    @AndroidFindBy(accessibility = "My Contacts")
    private WebElement myContactButton;

    //Locators For FollowUP
    @AndroidFindBy(accessibility = "Follow Up")
    private WebElement followUpButton;

    @AndroidFindBy(xpath = "//android.view.View[@text='Today’s Follow Up']")
    private WebElement todayFollowUpHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No Follow Ups For Today']")
    private WebElement noFollowUpText;

    @AndroidFindBy(xpath = "//com.horcrux.svg.SvgView")
    private WebElement backButtonFollowUp;

    //Locators For Documents Pending

    @AndroidFindBy(accessibility = "Documents Pending")
    private WebElement documentsPendingButton;

    @AndroidFindBy(xpath = "//android.view.View[@text='Document Pending']")
    private WebElement documentPendingHeader;

    @AndroidFindBy(xpath = "//com.horcrux.svg.PathView")
    private WebElement backButtonDocument;

    //Locators For My TOOLS
    //EMi Calculator
    @AndroidFindBy(accessibility = "EMI Calculator")
    private WebElement emiCalculatorBUtton;

    @AndroidFindBy(accessibility = "//android.view.View[@text='EMI Calculator']")
    private WebElement emiCalculatorHeader;


    //PayOut Locators

    @AndroidFindBy(accessibility = "Payout Calculator")
    private WebElement payoutCalculator;

    @AndroidFindBy(xpath = "//android.view.View[@text='Payout Calculator']")
    private WebElement payoutCalculatorHeader;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='text-input-outlined'])[1]")
    private WebElement loanAmountButton;

    //Here Scrolling to vehicle
    @AndroidFindBy(accessibility = "Vehicle Type*")
    private WebElement vehicleTypeButton;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='text-input-outlined'])[2]")
    private WebElement fileDisbursedButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset']")
    private WebElement resetButton;

    @AndroidFindBy(accessibility = "Calculate")
    private WebElement calculateNowButton;

    //My Card Locators

    @AndroidFindBy(accessibility = "My Card")
    private WebElement myCardButton;


    @AndroidFindBy(xpath = " //android.widget.Button[@content-desc='Download']/android.view.ViewGroup[1]")
    private WebElement downloadButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Share with Customer']/android.view.ViewGroup[1]")
    private WebElement shareWithCustomerButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement backButtonMyCard;

    //Partner Scheme Locators

    @AndroidFindBy(accessibility = "Partner Scheme")
    private WebElement partnerSchemeButton;

    //Loactors For Others
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Others']")
    private WebElement otherText;

    //MyPayouts Locators
    @AndroidFindBy(accessibility = "My Payouts")
    private WebElement myPayoutsButton;

    @AndroidFindBy(xpath = "//android.view.View[@text='My Payouts']")
    private WebElement myPaoutsHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Data Not Found']")
    private WebElement dataNotFoundText;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Payout Received']")
    private WebElement payoutReceivedText;


    //MyReferrals

    @AndroidFindBy(accessibility = "My Referrals")
    private WebElement myReferralsButton;

    @AndroidFindBy(xpath = "//android.view.View[@text='My Referrals']]")
    private WebElement myReferralsText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Data Not Found']")
    private WebElement dataNotFoundText2;

    //Help & Support Section
    @AndroidFindBy(accessibility = "Help & Support")
    private WebElement helpandSupport;

    @AndroidFindBy(xpath = "//android.view.View[@text='Help & Support']")
    private WebElement helpandsupporttext;

    @AndroidFindBy(accessibility = "Select Issue *")
    private WebElement selectIssueDropdown;

    @AndroidFindBy(id = "text-input-outlined")
    private WebElement explainBox;

    @AndroidFindBy(accessibility = "Submit")
    private WebElement submitButton;

    //ChangeTheme

    @AndroidFindBy(accessibility = "Change Theme")
    private WebElement changeThemeButton;

    @AndroidFindBy(accessibility = "Light")
    private WebElement lightButton;

    @AndroidFindBy(accessibility = "Dark")
    private WebElement darkButton;

    @AndroidFindBy(accessibility = "System")
    private WebElement systemButton;

    //Cards Dedicated Cards

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dedicated Relationship Manager']")
    private WebElement drmText;

    @AndroidFindBy(xpath = "    //android.widget.TextView[@text='SPOC yet to be assigned']")
    private WebElement spocText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer Support']")
    private WebElement customeSupportText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='admin@finj.in']")
    private WebElement adminFinjText;

    // LOGOUT

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Logout']")
    private WebElement logoutButton;


































    public void clickprofile()
    {
        profileIcon.click();
        System.out.println("User Click on the Profile Icon");
    }

    public void clickEdit()
    {
        editButton.click();
        System.out.println("User Click on the Edit Button");
    }

    



}

