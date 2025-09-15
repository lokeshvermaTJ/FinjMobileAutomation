package pageObjects.Android;

import ProjectUtils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidActions {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Lokesh");
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    // Select gender
    // driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
    private WebElement femaleoption;

    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
    private WebElement maleoption;

    //Select Country
    @AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countrySelection;

    //driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click()
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    //Actions Methods
    public void setNameField(String name){

        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender)
    {
        if(gender.contains("female"))
            femaleoption.click();
        else
            maleoption.click();
    }

    ////     driver.findriver.findElement(AppiumBy.androidUIAutomator(
    ////                "new UiScrollable(new UiSelector().scrollable(true))" +
    ////                ".scrollIntoView(new UiSelector().text(\"Argentina\"))"));
    ////        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
    public void setCountrySelection(String countyName){
        countrySelection.click();
        scrollToText(countyName);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+countyName+"']")).click();
    }

    public ProductCataloguePage submitForm() throws InterruptedException {
        shopButton.click();
        Thread.sleep(2000);
        return new ProductCataloguePage(driver);

    }
}
