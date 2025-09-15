package pageObjects.Android;

import ProjectUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyLeadsPage extends AndroidActions {

    AndroidDriver driver;

    public MyLeadsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Text For Ist Tutorial Screen
    final static String expallApplicationText = "All Application";
    final static String expallText = "All";
    final static String expTractorText = "Tractor";
    final static String expTruckText = "Truck";


    final static String expOpenAllText = "Open\nLeads";
    final static String expFiLeads = "FI Leads";


    final static String expLoginLeadText = "Login Leads";
    final static String expOpsCheckPending = "OPS Check Pending";
    final static String expApprovedLeads = "Approved Leads";

    final static String expDisbursedLeadsText= "Discbursed Leads";
    final static String expRejectedLeadsText = "Rejected Leads";
    final static String expCustomerCancellation = "Customer Cancellation";

   // Login\nLeads
    //OPS Check\nPending
    //Approved\nLeads
    //Verification\nPending
    //Disbursed\nLeads
    //Rejected\nLeads
    //Customer\nCancellation




    // Locators For Tutorial Screen
    //android.widget.TextView[@text='My Leads']

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Leads']")
    private WebElement myLeads;

    @AndroidFindBy(xpath = "//android.view.View[@text='All Application']")
    private WebElement allApplicationtext;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
    private WebElement allText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tractor']")
    private WebElement tractorText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Truck']")
    private WebElement truckText;





    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Open Leads']")
    private WebElement openLeadsText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FI Leads']")
    private WebElement fiLeadsTaxt;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login Leads']")
    private WebElement loginLeadsText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OPS Check Pending']")
    private WebElement opsCheckPendingText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Approved Leads']")
    private WebElement approvedLeadsText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verification Pending']")
    private WebElement verificationPendingText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Disbursed Leads']")
    private WebElement disbursedLeadsText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rejected Leads']")
    private WebElement rejectedLeadsText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer Cancellation']")
    private WebElement customerCancellationText;


    public WebElement getMyLeads() {
        return myLeads;
    }



    public void verifyAllApplicationScreenTest() {
        Assert.assertEquals(allApplicationtext.getText(),expallApplicationText);

    }

}