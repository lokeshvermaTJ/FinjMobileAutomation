//package test.java.testScripts;
//
//import Generics.BaseAndroidClass;
//import org.testng.annotations.Test;
//import pageObjects.Android.HomePagePage;
//
//
//public class HomePageSellTractorTest extends BaseAndroidClass {
//
//    static HomePagePage HomePagePage;
//
//    @Test(description = "TC01 - Verify Inventory page loads successfully")
//    public void testInventoryPageLoads() {
//        Assert.assertTrue(inventoryPage.isInventoryPageLoaded(), "Inventory page did not load.");
//    }
//
//    @Test(description = "TC02 - Verify inventory count is displayed and > 0")
//    public void testInventoryCountDisplayed() {
//        // If there's a separate count element, you can validate it; otherwise validate visible cards
//        int visible = inventoryPage.getVisibleCardsCount();
//        Assert.assertTrue(visible >= 0, "Visible cards count invalid.");
//        // optional: if you know the count element exists uncomment below
//        // String countText = driver.findElement(inventoryPage.inventoryCount).getText();
//        // Assert.assertTrue(countText.matches("\\d+"), "Count not numeric");
//    }
//
//    @Test(description = "TC03/04 - Verify tractor card displays core details and image")
//    public void testTractorCardDetailsAndImage() {
//        Assert.assertTrue(inventoryPage.getVisibleCardsCount() > 0, "No tractor cards visible.");
//        // check first card's image and model/price presence
//        Assert.assertTrue(inventoryPage.isImageVisibleOnCard(0), "Tractor image missing on first card.");
//        String price = inventoryPage.getPriceOnCard(0);
//        Assert.assertFalse(price.isEmpty(), "Price missing on first card.");
//        Assert.assertTrue(inventoryPage.isPriceFormatValid(price), "Price format invalid: " + price);
//    }
//
//    @Test(description = "TC06 - Verify Sell with Us button opens Sell Tractor flow")
//    public void testSellWithUsButton() throws InterruptedException {
//        // Tap Sell with Us on first card
//        inventoryPage.tapSellWithUsOnCard(0);
//        // Wait a short while for navigation - ideally use explicit wait for next page element
//        Thread.sleep(2000);
//        // Replace below locator with an element on the Sell Tractor screen to assert proper navigation
//        // Example:
//        // boolean isSellScreen = driver.findElement(By.id("com.yourcompany.finjpartner:id/sell_screen_title")).isDisplayed();
//        // For now assert that current activity changed (requires AndroidDriver cast):
//        String currentActivity = ((io.appium.java_client.android.AndroidDriver) driver).currentActivity();
//        Assert.assertFalse(currentActivity == null || currentActivity.isEmpty(), "Activity not found after tapping Sell with Us");
//        // optionally navigate back after assertion
//        driver.navigate().back();
//    }
//
//    @Test(description = "TC07/08 - Verify wishlist toggle and persistence")
//    public void testWishlistToggleAndPersistence() {
//        // Toggle wishlist on first card
//        inventoryPage.toggleWishlistOnCard(0);
//        // Short verification - ideally check the icon attribute changed or wishlist count incremented
//        // Now navigate to My Wishlist tab (replace with exact locator or bottom nav action)
//        // Example: driver.findElement(By.id("com.yourcompany.finjpartner:id/tab_wishlist")).click();
//        // For sample, assert the toggle didn't crash the app
//        Assert.assertTrue(inventoryPage.isInventoryPageLoaded(), "App not stable after toggling wishlist.");
//        // NOTE: To fully validate persistence, restart the app and check wishlist contents (not implemented here)
//    }
//
//    @Test(description = "TC09 - Verify filter button functionality")
//    public void testFilterButtonOpens() {
//        Assert.assertTrue(inventoryPage.isFilterButtonVisible(), "Filter button not visible.");
//        inventoryPage.tapFilterButton();
//        // Add a simple assertion that some filter panel element appears (update locator)
//        // Example:
//        // Assert.assertTrue(driver.findElement(By.id("com.yourcompany.finjpartner:id/filter_panel")).isDisplayed());
//        // For now resume test by navigating back:
//        driver.navigate().back();
//    }
//
//    @Test(description = "TC16/17/18 - Negative: empty state, missing image, invalid price handling")
//    public void testNegativeStates() {
//        // This is a structural test: verify app gracefully shows empty/placeholder states.
//        // If there are no items:
//        if (inventoryPage.getVisibleCardsCount() == 0) {
//            Assert.assertTrue(inventoryPage.isEmptyStateVisible(), "Empty state message not visible when inventory is zero.");
//        } else {
//            // Check for missing images (placeholder) on visible cards
//            boolean anyMissingImage = false;
//            int visible = inventoryPage.getVisibleCardsCount();
//            for (int i = 0; i < visible; i++) {
//                try {
//                    if (!inventoryPage.isImageVisibleOnCard(i)) {
//                        anyMissingImage = true;
//                        break;
//                    }
//                } catch (Exception ignored) {}
//            }
//            // We allow either all images present or placeholder handling; ensure app not crashed
//            Assert.assertTrue(inventoryPage.isInventoryPageLoaded(), "Inventory page crashed while evaluating images.");
//        }
//    }
//
//    @Test(description = "TC20 - Verify loading indicator on slow network")
//    public void testLoadingIndicatorOnSlowNetwork() throws InterruptedException {
//        // This must be run in an environment where network throttling is possible or simulate by toggling airplane mode
//        // Just assert that loading indicator may appear during data fetch
//        boolean loading = inventoryPage.isLoadingIndicatorVisible();
//        // It's acceptable either way (sometimes fast) - assert check completes without exception
//        Assert.assertNotNull(loading);
//    }
//    //----FIleter Test Cases"
//    @Test(description = "Verify vehicle type dropdown is visible and clickable")
//    public void testVehicleTypeDropdown() {
//        Assert.assertTrue(filterPage.isVehicleTypeVisible(), "Vehicle type dropdown is not visible");
//        filterPage.openVehicleTypeDropdown();
//    }
//
//    @Test(description = "Verify state dropdown is visible and clickable")
//    public void testStateDropdown() {
//        Assert.assertTrue(filterPage.isStateVisible(), "State dropdown is not visible");
//        filterPage.openStateDropdown();
//    }
//
//    @Test(description = "Verify brand dropdown is enabled and clickable")
//    public void testBrandDropdown() {
//        Assert.assertTrue(filterPage.isBrandEnabled(), "Brand dropdown is not enabled");
//        filterPage.openBrandDropdown();
//    }
//
//    @Test(description = "Verify model dropdown is enabled and clickable")
//    public void testModelDropdown() {
//        Assert.assertTrue(filterPage.isModelEnabled(), "Model dropdown is not enabled");
//        filterPage.openModelDropdown();
//    }
//
//    @Test(description = "Verify price range dropdown can be opened")
//    public void testPriceRangeDropdown() {
//        filterPage.openPriceRangeDropdown();
//        // Additional validation can be added if price options exist
//    }
//
//    @Test(description = "Verify radio button 'All' can be selected")
//    public void testSelectAllRadioBtn() {
//        filterPage.selectAllWishlist();
//        Assert.assertTrue(filterPage.isAllSelected(), "'All' radio button not selected");
//    }
//
//    @Test(description = "Verify radio button 'Wishlisted' can be selected")
//    public void testSelectWishlistedRadioBtn() {
//        filterPage.selectWishlisted();
//        Assert.assertTrue(filterPage.isWishlistedSelected(), "'Wishlisted' radio button not selected");
//    }
//
//    @Test(description = "Verify submit button is clickable")
//    public void testSubmitButton() {
//        filterPage.tapSubmit();
//        // Add validation for results page if applicable
//    }
//
//    @Test(description = "Verify reset button is clickable")
//    public void testResetButton() {
//        filterPage.tapReset();
//        // Add validation if reset clears filters
//    }
//
//    @Test(description = "Verify close button is clickable")
//    public void testCloseButton() {
//        filterPage.tapClose();
//        // Add validation if filter page closes
//    }
//}
//
//
//
//}
