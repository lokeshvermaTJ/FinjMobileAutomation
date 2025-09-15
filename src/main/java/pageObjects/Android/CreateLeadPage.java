package pageObjects.Android;

import ProjectUtils.AndroidActions;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateLeadPage extends AndroidActions {

    AndroidDriver driver;

    public CreateLeadPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

//    // Locators For Notification Pages
//    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.View[2]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
//    private WebElement leadIcon;
//    @AndroidFindBy(uiAutomator = "new UiSelector().className('com.horcrux.svg.PathView').instance(33)")
//    private WebElement leadIcon;

//    @AndroidFindBy(xpath = "//android.view.ViewGroup//com.horcrux.svg.PathView[2]")
//    private WebElement leadIcon;

//    @AndroidFindBy(xpath = "//android.view.View[@text='Create Lead']")
//    private WebElement leadIcon;

    final static String expDetailsText = "Details";

    @AndroidFindBy(xpath = "//android.view.View/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement leadIcon;

    //@AndroidFindBy(xpath = "//android.view.View[@content-desc='Dashboard']/following::com.horcrux.svg.PathView[1]")
    //@AndroidFindBy(xpath = "//android.view.ViewGroup//com.horcrux.svg.PathView")
    @AndroidFindBy(xpath = "//com.horcrux.svg.SvgView//com.horcrux.svg.PathView")
//   // @AndroidFindBy(xpath = "//com.horcrux.svg.PathView")
//    private WebElement leadIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Details']")
    private WebElement detailsText;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='text-input-outlined'])[1]")
    private WebElement nameField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='text-input-outlined'])[2]")
    private WebElement mobileField;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='text-input-outline'])[3]")
//private AndroidElement loanAmountField;
    private WebElement loanAmountField;

    //@AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='text-input-outline'])[3]//android.widget.EditText")
   // @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-input-outline' and (@text='0' or .='0')]")
//    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-input-outline' and @text='0']")
//    private WebElement loanAmountField;
//    //private WebElement loanAmountField;


    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='text-input-outlined'])[4]")
    private WebElement registrationField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Manufacturing Year *']")
    private WebElement manufacturingYearDropdown;

    @AndroidFindBy(accessibility = "Vehicle Type *")
    private WebElement vehicleTypeDropDown;

    @AndroidFindBy(accessibility = "Brand *")
    private WebElement brandDropDown;

    @AndroidFindBy(accessibility = "Model *")
    private WebElement modelDropDown;

    @AndroidFindBy(accessibility = "State *")
    private WebElement stateDropDown;

    @AndroidFindBy(accessibility = "District *")
    private WebElement districtDropDown;

    @AndroidFindBy(accessibility = "Tehsil *")
    private WebElement tehsilDropDown;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='text-input-outlined'])[3]")
    private WebElement remarkButton;

    @AndroidFindBy(id = "button")
    private WebElement submitButton;





    public void leadIcon() throws InterruptedException {
      leadIcon.click();
    }

    public void enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }


    public void enterMobileField(String mobile){
        mobileField.clear();
        mobileField.sendKeys(mobile);
    }

    public void enterloanAmountField(String amount) throws InterruptedException {
        //loanAmountField.clear();
        loanAmountField.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: replaceElementValue", ImmutableMap.of(
                "elementId", ((RemoteWebElement) loanAmountField).getId(),
                "text", "500000"   // ✅ use "text" instead of "value"
        ));
       // loanAmountField.sendKeys(amount);
        Thread.sleep(5000);
    }

    public void enterRegistration(String regNo) {
        registrationField.clear();
        registrationField.sendKeys(regNo);
    }

    public void selectManufacturingYear(String year) {
        manufacturingYearDropdown.click();
        scrollToText(year);
        //android.widget.TextView[@text="2016"]
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + year + "']")).click();
    }

    public void selectVehicleType(String type) {
        vehicleTypeDropDown.click();
        scrollToText(type);
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='" + type + "']")).click();
    }

    public void selectBrand(String brand) {
        brandDropDown.click();
       // scrollToText();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + brand + "']")).click();
    }

    public void selectModel(String model) {
        modelDropDown.click();
        //scrollToText();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + model + "']")).click();
    }

    public void selectState(String state) {
        stateDropDown.click();
        //scrollToText();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + state + "']")).click();
    }

    public void selectDistrict(String district) {
        districtDropDown.click();
        //scrollToText();
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='" + district + "']")).click();
    }

    public void selectTehsil(String tehsil) {
        tehsilDropDown.click();
        scrollDown(0.8);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + tehsil + "']")).click();
    }

    public void remarksAdd(String remark)
    {
        remarkButton.sendKeys(remark);
    }
    public void clickSubmit() throws InterruptedException {
        submitButton.click();
    }









    public void scrollToText(String text) {
        super.scrollToText(text);
    }

    }
