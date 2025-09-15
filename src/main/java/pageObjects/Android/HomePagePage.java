package pageObjects.Android;

import ProjectUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePagePage extends AndroidActions {

    AndroidDriver driver;

    public HomePagePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Text For Ist Tutorial Screen
    final static String expfinjPartnerText = "FinJ Partner";
    final static String expsendManageText = "Send and manage vehicle financing leads to us and earn for every successful loan.";
    final static String expsellTractorText = "Sell Tractor";
    final static String expsendManageTractorText = "Send and manage used vehicle sale leads to us and earn for every successful sale.";
    final static String expcreateLeadText = "Create your Lead";
    // Text here for input field
    final static String expquicklyCreateLeadText = "Quickly create leads from here.";
    final static String expmyLeadsText = "My Leads";
    final static String expviewManageText = "View and manage all your leads from Open to Disbursed";
    final static String expkycPendingText = "KYC Pending";
    final static String expfinishKycText = "Finish your KYC to receive payouts on time.";
    final static String expbankPendingText = "Bank Details Pending";
    final static String expaddBankText = "Add bank account details for direct disbursal.";
    final static String expgstPendingText = "GST Pending";
    final static String expaddGSTText = "Add GST for smooth invoicing.";


    // Locators For Tutorial Screen
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FinJ Partner']")
    private WebElement headerfinjPartnerText;

    @AndroidFindBy(xpath = " //android.widget.TextView[@text='Send and manage vehicle financing leads to us and earn for every successful loan.']")
    private WebElement sendManageText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Next']")
    private WebElement nextClick;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sell Tractor']")
    private WebElement sellTractorText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send and manage used vehicle sale leads to us and earn for every successful sale.']")
    private WebElement sendManageTractorText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Back']']")
    private WebElement backClick;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create your Lead']")
    private WebElement createLeadText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quickly create leads from here.']")
    private WebElement quicklyCreateLeadText;

    //android.widget.TextView[@text='My Leads']

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Leads']")
    private WebElement myLeadsText;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View and manage all your leads from Open to Disbursed']")
    private WebElement viewManageText;

    //android.widget.TextView[@text='KYC Pending']

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='KYC Pending']")
    private WebElement kycPendingText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Finish your KYC to receive payouts on time.']")
    private WebElement finishKycText;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bank Details Pending']")
    private WebElement bankPendingText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add bank account details for direct disbursal.']")
    private WebElement addBankText;

    //android.widget.TextView[@text='GST Pending']

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GST Pending']")
    private WebElement gstPendingText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add GST for smooth invoicing.']")
    private WebElement addGSTText;

    //android.view.ViewGroup[@content-desc='Done']

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Done']")
    private WebElement doneClick;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[android.widget.ImageView])[last()]")
    private WebElement profileClick;


    //Sell Tractor Module
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Sell Tractor']")
    private WebElement sellTractormain;


//-----------------------------//Scrpit generation test cases--------------------------------------------//


    // My Leads Section
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'My Leads')]")
    private WebElement myLeadsSection;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='View All']")
    private WebElement viewAllLeads;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Open Lead']")
    private WebElement openLeadCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Disbursed Lead']")
    private WebElement disbursedLeadCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View All']")
    private WebElement viewAllLeads;

    // My Tools
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EMI Calculator']")
    private WebElement emiCalculator;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Payout Calculator']")
    private WebElement payoutCalculator;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Partner Scheme']")
    private WebElement partnerScheme;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Payout']")
    private WebElement myPayout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Follow-up']")
    private WebElement followUp;

    // Document Upload Banner
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Document submission')]")
    private WebElement documentSubmissionBanner;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Upload Doc']")
    private WebElement uploadDocButton;

    // Refer Friends
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Refer Your Friends')]")
    private WebElement referFriendsBanner;

    // Bottom Navigation
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dashboard']")
    private WebElement dashboardTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Leads']")
    private WebElement myLeadsTab;

    // Floating Action Button
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Add']")
    private WebElement floatingActionButton;

//---------------------------------------------------------------------------------------------------//
    public WebElement getNextClick() {
        return nextClick;
    }

    public WebElement getBackClick() {
        return backClick;
    }

    public WebElement getDoneClick() {
        return doneClick;
    }

    public void verifyTutorialFinjPartner() {
        Assert.assertEquals(finjPartnerText.getText(), expfinjPartnerText);
        Assert.assertEquals(sendManageText.getText(), expsendManageText);
    }

    public void verifyTutorialSellTractor() {
        Assert.assertEquals(sellTractorText.getText(), expsellTractorText);
        Assert.assertEquals(sendManageTractorText.getText(), expsendManageTractorText);
    }

    public void verifyTutorialCreateLead() {
        Assert.assertEquals(createLeadText.getText(), expcreateLeadText);
        Assert.assertEquals(quicklyCreateLeadText.getText(), expquicklyCreateLeadText);
    }

    public void verifyTutorialMyLead() {
        Assert.assertEquals(myLeadsText.getText(), expmyLeadsText);
        Assert.assertEquals(viewManageText.getText(), expviewManageText);
    }

    public void verifyTutorialKycPending() {
        Assert.assertEquals(kycPendingText.getText(), expkycPendingText);
        Assert.assertEquals(finishKycText.getText(), expfinishKycText);
    }

    public void verifyTutorialBankPending() {
        Assert.assertEquals(bankPendingText.getText(), expbankPendingText);
        Assert.assertEquals(addBankText.getText(), expaddBankText);
    }

    public void verifyTutorialGSTPending() {
        Assert.assertEquals(gstPendingText.getText(), expgstPendingText);
        Assert.assertEquals(addGSTText.getText(), expaddGSTText);
    }

    public void verifyTutorialHomePage() throws InterruptedException {
        Assert.assertEquals(finjPartnerText.getText(), expfinjPartnerText);
        Assert.assertEquals(sendManageText.getText(), expsendManageText);
        Thread.sleep(2000);
        nextClick.click();
        Assert.assertEquals(sellTractorText.getText(), expsellTractorText);
        Assert.assertEquals(sendManageTractorText.getText(), expsendManageTractorText);
        nextClick.click();
        Assert.assertEquals(createLeadText.getText(), expcreateLeadText);
        Assert.assertEquals(quicklyCreateLeadText.getText(), expquicklyCreateLeadText);
        nextClick.click();
        Assert.assertEquals(myLeadsText.getText(), expmyLeadsText);
        Assert.assertEquals(viewManageText.getText(), expviewManageText);
        nextClick.click();
        Assert.assertEquals(kycPendingText.getText(), expkycPendingText);
        Assert.assertEquals(finishKycText.getText(), expfinishKycText);
        nextClick.click();
        Assert.assertEquals(bankPendingText.getText(), expbankPendingText);
        Assert.assertEquals(addBankText.getText(), expaddBankText);
        nextClick.click();
        Assert.assertEquals(gstPendingText.getText(), expgstPendingText);
        Assert.assertEquals(addGSTText.getText(), expaddGSTText);
        doneClick.click();
    }

    public WebElement getSellTractor() {
        return sellTractor;
    }


    public void verifytutorialScreen() throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i <= 5; i++) {
            nextClick.click();
        }
        // doneClick.click();
    }

    public void verifyProfileClick() throws InterruptedException {
        profileClick.click();
        Thread.sleep(2000);
    }

    // --- Action Methods ---
    public void clickSellTractor() {
        sellTractor.click();
    }

    public void clickViewAllLeads() {
        viewAllLeads.click();
    }

    public void openEmiCalculator() {
        emiCalculator.click();
    }

    public void openPayoutCalculator() {
        payoutCalculator.click();
    }

    public void openPartnerScheme() {
        partnerScheme.click();
    }

    public void openMyPayout() {
        myPayout.click();
    }

    public void openFollowUp() {
        followUp.click();
    }

    public void uploadDocument() {
        uploadDocButton.click();
    }

    public void clickReferFriends() {
        referFriendsBanner.click();
    }

    public void navigateToDashboard() {
        dashboardTab.click();
    }

    public void navigateToMyLeads() {
        myLeadsTab.click();
    }

    public void openActionMenu() {
        floatingActionButton.click();
    }

}


