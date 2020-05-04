package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ItemDetailPage extends BasePageObject {

    private String pageUrl = "http://automationpractice.com/index.php?id_product=1&controller=product";

    private By priceLocator = By.id("our_price_display");
    private By plusButtonLocator = By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']");
    private By minusButtonLocator = By.xpath("//*[@class='btn btn-default button-minus product_quantity_down']");
    private By quantityLocator = By.xpath("//*[@id='quantity_wanted']");
    private By sizeDropdownLocator = By.id("group_1");
    private By twitterButtonLocator = By.xpath("//*[@class='btn btn-default btn-twitter']");
    private By tShirtsCategoryLocator = By.xpath("//*[@id='columns']/div[1]/a[4]");
    private By addToCartButtonLocator = By.id("add_to_cart");
    private By addToCartText = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2");
    private By orderedItemQtyText = By.xpath("//*[@class='ajax_cart_product_txt ']");
    private By closeWindowLocator = By.xpath("//*[@title='Close window']");
    private By removeFromCartButtonLocator = By.xpath("//*[@class='ajax_cart_block_remove_link']");
    private By shoppingCardPreviewLocator = By.xpath("//*[@title='View my shopping cart']");
    private By emptyCartText = By.xpath("//*[@class='ajax_cart_no_product']");
    private By proceedToCheckoutButton = By.xpath("//*[@class='btn btn-default button button-medium']");

    public ItemDetailPage(WebDriver driver, Logger log) {
        super(driver,log);
    }

    public void openItemDetailPage() {
        openPage(pageUrl);
    }

    public void clickOnPlusButton() {
        waitForVisibilityOf(plusButtonLocator);
        clickOnElement(plusButtonLocator);
    }

    public void clickOnMinusButton() {
        waitForVisibilityOf(minusButtonLocator);
        clickOnElement(minusButtonLocator);
    }

    public void selectItemSize(String itemSize) {
        waitFor(ExpectedConditions.presenceOfElementLocated(sizeDropdownLocator),5);
        WebElement dropdownElement = findElement(sizeDropdownLocator);

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(itemSize);
    }

    public void clickOnTwitterButton() {
        clickOnElement(twitterButtonLocator);
    }

    public TShirtsCategoryPage clickOnTShirtsCategory() {
        clickOnElement(tShirtsCategoryLocator);
        return new TShirtsCategoryPage(driver,log);
    }

    public TwitterPopupPage switchToTwitterWindow() {
        switchToWindowWithTitle("Post a Tweet on Twitter");
        return new TwitterPopupPage(driver,log);
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCartButtonLocator);
    }

    public void clickOnCloseButton() {
        waitForVisibilityOf(closeWindowLocator);
        clickOnElement(closeWindowLocator);
    }

    public void removeSelectedItemFromCart() {
        waitForVisibilityOf(shoppingCardPreviewLocator);
        hoverOverElement(findElement(shoppingCardPreviewLocator));

        waitFor(ExpectedConditions.elementToBeClickable(removeFromCartButtonLocator),5);
        clickOnElement(removeFromCartButtonLocator);
    }

    public OrderSummaryPage clickOnProceedToCheckout() {
        waitForVisibilityOf(proceedToCheckoutButton);
        clickOnElement(proceedToCheckoutButton);
        return new OrderSummaryPage(driver, log);
    }

    public String getPriceText() {
        waitForVisibilityOf(priceLocator);
        return findElement(priceLocator).getText();
    }

    public String getQuantityText() {
        waitForVisibilityOf(quantityLocator);
        return findElement(quantityLocator).getAttribute("value");
    }

    public String getSizeText() {
        WebElement dropdownElement = findElement(sizeDropdownLocator);
        Select dropdown = new Select(dropdownElement);
        return dropdown.getFirstSelectedOption().getText();
    }

   public String getAddToCartText() {
        waitForVisibilityOf(addToCartText);
        return findElement(addToCartText).getText();
   }

   public String getOrderedItemQtyText() {
        waitForVisibilityOf(orderedItemQtyText);
        return findElement(orderedItemQtyText).getText();
   }

   public String getEmptyCartText() {
        waitForVisibilityOf(emptyCartText);
        return findElement(emptyCartText).getText();
   }
}