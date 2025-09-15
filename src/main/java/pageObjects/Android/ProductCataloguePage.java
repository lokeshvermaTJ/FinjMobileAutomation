package pageObjects.Android;

import ProjectUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloguePage extends AndroidActions {

    AndroidDriver driver;

    public ProductCataloguePage(AndroidDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    //   driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
    //        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
    //driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

    @AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
//    private List<WebElement> addToCart;
//

    //        // Navigate to cart
    //        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;



    public void addItemToCartByIndex(int index)
    {
        addToCart.get(index).click();
    }

    public CartPage goToCartPage() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
        return new CartPage(driver);

    }
}
