package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummaryPage extends BasePageObject {

    private By plusButtonLocator = By.xpath("//*[@class='cart_quantity_up btn btn-default button-plus']");
    private By itemQuantityLocator = By.xpath("//*[@class='cart_quantity_input form-control grey']");
    private By itemPriceLocator = By.xpath("//*[@class='cart_total']");
    private By summaryHeaderLocator = By.xpath("//*[@class='step_current  first']");
    private By proceedToCheckout = By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order&step=1'][@title='Proceed to checkout']");

    OrderSummaryPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void clickOnPlusButton() {
        clickOnElement(plusButtonLocator);
    }

    public SignInPage clickOnProceedToCheckout() {
        waitForVisibilityOf(proceedToCheckout);
        clickOnElement(proceedToCheckout);
        return new SignInPage(driver, log);
    }

    public String getItemTotalPrice() {
        waitForVisibilityOf(itemPriceLocator);
        return findElement(itemPriceLocator).getText();
    }

    public String getSummaryText() {
        return findElement(summaryHeaderLocator).getText();
    }

    public String getOrderQuantityValue() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeContains(findElement(itemQuantityLocator), "value", "2"));
        return findElement(itemQuantityLocator).getAttribute("value");
    }
}