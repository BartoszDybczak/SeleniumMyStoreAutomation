package ItemDetailPage;

import com.automationpractice.myproject.base.TestUtilities;
import com.automationpractice.myproject.pages.ItemDetailPage;
import com.automationpractice.myproject.pages.TShirtsCategoryPage;
import com.automationpractice.myproject.pages.TwitterPopupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemDetail extends TestUtilities {

    @Test
    public void userCanIncreaseItemQuantity() {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver, log);
        itemDetailPage.openItemDetailPage();

        itemDetailPage.clickOnPlusButton();

        String expectedQty = "2";
        Assert.assertEquals(itemDetailPage.getQuantityText(), expectedQty);
    }

    @Test
    public void userCanDecreaseItemQuantity() {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver, log);
        itemDetailPage.openItemDetailPage();

        itemDetailPage.clickOnPlusButton();
        itemDetailPage.clickOnMinusButton();

        String expectedQty = "1";
        Assert.assertEquals(itemDetailPage.getQuantityText(), expectedQty);
    }

    @Test
    public void userCanSelectItemSize() {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver, log);
        itemDetailPage.openItemDetailPage();

        itemDetailPage.selectItemSize("M");

        String expectedSize = "M";
        Assert.assertEquals(itemDetailPage.getSizeText(), expectedSize);
    }

    @Test
    public void userCanShareItemOnTwitter() {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver, log);
        itemDetailPage.openItemDetailPage();

        itemDetailPage.clickOnTwitterButton();
        TwitterPopupPage twitterPopupPage = itemDetailPage.switchToTwitterWindow();

        String expectedText = "Log in and Tweet";
        Assert.assertEquals(twitterPopupPage.getTwitterText(), expectedText);
    }

    @Test
    public void userCanNavigateToTShirtsCategory() {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver, log);
        itemDetailPage.openItemDetailPage();

        TShirtsCategoryPage tShirtsCategoryPage = itemDetailPage.clickOnTShirtsCategory();

        String expectedText = "T-shirts";
        Assert.assertEquals(tShirtsCategoryPage.getTShirtsCategoryText(), expectedText);
    }

    @Test
    public void userCanAddItemToCart() {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver, log);
        itemDetailPage.openItemDetailPage();

        itemDetailPage.clickOnAddToCart();

        String addToCartExpectedMsg = "Product successfully added to your shopping cart";
        String orderedItemsQtyExpectedMsg = "There is 1 item in your cart.";
        Assert.assertEquals(itemDetailPage.getAddToCartText(), addToCartExpectedMsg);
        Assert.assertEquals(itemDetailPage.getOrderedItemQtyText(), orderedItemsQtyExpectedMsg);
    }

    @Test
    public void userCanRemoveItemFromCart() {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver, log);
        itemDetailPage.openItemDetailPage();

        itemDetailPage.clickOnAddToCart();
        itemDetailPage.clickOnCloseButton();
        itemDetailPage.removeSelectedItemFromCart();

        String emptyCartString = "(empty)";
        Assert.assertEquals(itemDetailPage.getEmptyCartText(), emptyCartString);
    }
}