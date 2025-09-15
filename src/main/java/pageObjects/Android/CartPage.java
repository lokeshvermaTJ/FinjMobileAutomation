package pageObjects.Android;

import ProjectUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions {

    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productList;

    //String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement terms;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement acceptButtons;

   // driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceed;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;


//    List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));

//    String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//    Double displayFormattedSum = getFormattedAmount(displaySum);
//        Assert.assertEquals(totalSum,displayFormattedSum);
//
//    WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//    longPressAction(ele);
//        Thread.sleep(2000);
//        driver.findElement(By.id("android:id/button1")).click();
//        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

    public List<WebElement> getProductList() {
        return productList;
    }

   // int count = productPrice.size();
//    double totalSum = 0;
//        for (int i = 0; i<count; i++)
//    {
//        String amountString = productPrice.get(i).getText();
//        // Double price = Double.parseDouble(amountString.substring(1));
//        Double price = getFormattedAmount(amountString);
//        totalSum = totalSum + price;
//    }

    public double getProductSum() {
        int count = productList.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++) {
            String amountString = productList.get(i).getText();
            // Double price = Double.parseDouble(amountString.substring(1));
            Double price = getFormattedAmount(amountString);
            totalSum = totalSum + price;
        }
        return totalSum;
    }
    //

    public Double getTotalAmountDisplayed(){
        return getFormattedAmount(totalAmount.getText());
    }
    public void acceptTermsAndCondition() throws InterruptedException {
        longPressAction(terms);
        acceptButtons.click();
    }

    public Double getFormattedAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    public void submitOrder(){
        checkBox.click();
        proceed.click();
    }
    }


