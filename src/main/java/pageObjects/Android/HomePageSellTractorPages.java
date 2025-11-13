package pageObjects.Android;

import ProjectUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePageSellTractorPages extends AndroidActions {

    AndroidDriver driver;

    public HomePageSellTractorPages(AndroidDriver driver) {
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


    // Locators For SellTractor Screen
    @AndroidFindBy(accessibility = "Sell Tractor")
    private WebElement sellTractorButton;


    //Locators For Filter Section
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset']")
    private WebElement resetButton;


    // ---------- Locators () ----------

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/tv_inventory_title")
    private WebElement inventoryTitle;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/tv_inventory_count")
    private WebElement inventoryCount;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,'tractor_card')]")
    private List<WebElement> tractorCards;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/iv_tractor_image")
    private List<WebElement> tractorImages;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/tv_model_name")
    private List<WebElement> modelNames;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/tv_price")
    private List<WebElement> prices;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/btn_sell_with_us")
    private List<WebElement> sellWithUsButtons;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/iv_wishlist")
    private List<WebElement> wishlistIcons;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/tv_location")
    private List<WebElement> locations;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/tv_year")
    private List<WebElement> years;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/tv_condition")
    private List<WebElement> conditions;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/btn_filter")
    private WebElement filterButton;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/progress_loading")
    private WebElement loadingIndicator;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/tv_empty_state")
    private WebElement emptyStateMessage;


    //-----------------------FILETER PAGES LOCATOR-----------------------------------------//

    // ---------- Locators ----------
    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/dropdown_vehicle_type")
    private WebElement vehicleTypeDropdown;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/dropdown_state")
    private WebElement stateDropdown;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/dropdown_brand")
    private WebElement brandDropdown;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/dropdown_model")
    private WebElement modelDropdown;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/dropdown_price_range")
    private WebElement priceRangeDropdown;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='All']")
    private WebElement allRadioBtn;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Wishlisted']")
    private WebElement wishlistedRadioBtn;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/btn_submit")
    private WebElement submitButton;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/btn_reset")
    private WebElement resetButton2;

    @AndroidFindBy(id = "com.yourcompany.finjpartner:id/btn_close")
    private WebElement closeButton;


    //Action Method For Home PAge " ////
    public boolean isInventoryPageLoaded() {
        return (inventoryTitle.isDisplayed() || !tractorCards.isEmpty());
    }

    public int getVisibleCardsCount() {
        return tractorCards.size();
    }

    public boolean isImageVisibleOnCard(int index) {
        return tractorImages.size() > index && tractorImages.get(index).isDisplayed();
    }

    public String getPriceOnCard(int index) {
        return prices.size() > index ? prices.get(index).getText() : "";
    }

    public void tapSellWithUsOnCard(int index) {
        if (sellWithUsButtons.size() > index) sellWithUsButtons.get(index).click();
    }

    public void toggleWishlistOnCard(int index) {
        if (wishlistIcons.size() > index) wishlistIcons.get(index).click();
    }

    public boolean isFilterButtonVisible() {
        return filterButton.isDisplayed();
    }

    public void tapFilterButton() {
        filterButton.click();
    }

    public boolean isLoadingIndicatorVisible() {
        try {
            return loadingIndicator.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmptyStateVisible() {
        try {
            return emptyStateMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // helper to validate price format
    public boolean isPriceFormatValid(String priceText) {
        if (priceText == null || priceText.trim().isEmpty()) return false;
        priceText = priceText.replaceAll("\\s", "");
        return priceText.matches("₹\\d{1,3}(,\\d{2,3})*");
    }


// ---------- Actions / Methods HOMEPAGE Filter TRACTOR ----------
// ---------- Actions ----------
public void openVehicleTypeDropdown() {
    vehicleTypeDropdown.click();
}

public void openStateDropdown() {
    stateDropdown.click();
}

public void openBrandDropdown() {
    brandDropdown.click();
}

public void openModelDropdown() {
    modelDropdown.click();
}

public void openPriceRangeDropdown() {
    priceRangeDropdown.click();
}

public void selectAllWishlist() {
    allRadioBtn.click();
}

public void selectWishlisted() {
    wishlistedRadioBtn.click();
}

public void tapSubmit() {
    submitButton.click();
}

public void tapReset() {
    resetButton.click();
}

public void tapClose() {
    closeButton.click();
}

// ---------- Validations ----------
public boolean isVehicleTypeVisible() {
    return vehicleTypeDropdown.isDisplayed();
}

public boolean isStateVisible() {
    return stateDropdown.isDisplayed();
}

public boolean isBrandEnabled() {
    return brandDropdown.isEnabled();
}

public boolean isModelEnabled() {
    return modelDropdown.isEnabled();
}

public boolean isAllSelected() {
    return allRadioBtn.getAttribute("checked").equals("true");
}

public boolean isWishlistedSelected() {
    return wishlistedRadioBtn.getAttribute("checked").equals("true");
}
}





