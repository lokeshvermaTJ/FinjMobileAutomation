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




    public void clickprofile()
    {

    }
//
//
//
//
//    public void enterMobileNo() {
//        Random random = new Random();
//        String mobile = "9" + (100000000 + random.nextInt(899999999));
//        enterMobileField.sendKeys(mobile);
//        System.out.println("User Entered the Mobile No." + mobile);
//    }
//
//
//    public void enterLoginMobileNo() {
//        String mobile = "9643475316";
//        enterMobileField.sendKeys(mobile);
//        System.out.println("User Entered the Mobile No." + mobile);
//        enterMobileField.sendKeys(mobile);
//    }
//
//    public void enterOtp() throws InterruptedException {
//        getOtpButton.click();
//        System.out.println("User Click on the OTP Button");
//        //Verify Toast Messgae
//
//        Thread.sleep(1000);
//        String otp = "123456";
//        // Click only the first box to focus
//        WebElement firstOtpBox = driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]"));
//        firstOtpBox.click();
//        // Loop through digits and send them as key events
//        AndroidDriver androidDriver = (AndroidDriver) driver;
//        for (char digit : otp.toCharArray()) {
//            AndroidKey key = AndroidKey.valueOf("DIGIT_" + digit);
//            androidDriver.pressKey(new KeyEvent(key));
//        }
//        System.out.println("User Entered the OTP");
//    }
//
//
//
//    public void clickNext() throws InterruptedException {
//        nextClick.click();
//        System.out.println("➡️ Clicked on Next button");
//        Thread.sleep(1000);
//
//    }
//
//    // Enter Name
//    public void enterName(String name) {
//        nameElement.sendKeys(name);
//        System.out.println("👤 Entered Name: " + name);
//    }
//
//    // Enter Email
//    public void enterEmail(String email) {
//        emailElement.sendKeys(email);
//        System.out.println("📧 Entered Email: " + email);
//    }
//
//    // Select Date of Birth
//    public void selectDob(String dob) throws InterruptedException {
//        dobElement.click();
//        Thread.sleep(1000);
//        // Use dynamic XPath
//        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='" + dob + "']")).click();
//        okCalender.click();
//        Thread.sleep(1000);
//        System.out.println("🎂 Date of Birth selected");
//    }
//
//    // Enter Address
//    public void enterAddress(String address) {
//        addressElement.sendKeys(address);
//        System.out.println("🏠 Entered Address: " + address);
//    }
//
//    public void selectState(String state) {
//       stateElement.click();
//        scrollToText(state);
//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + state + "']")).click();
//    }
//
//    public void selectDistrict(String district) {
//        districtElement.click();
//        scrollToText(district);
//        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='" + district + "']")).click();
//    }
//
//    // Submit Form
//    public void clickSubmit() {
//        sumitButton.click();
//        System.out.println("✅ Clicked Submit button");
//    }


}

