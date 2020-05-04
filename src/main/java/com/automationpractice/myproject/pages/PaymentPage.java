package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePageObject {

    private By totalItemPriceLocator = By.id("total_price");
    private By payByBankWireLocator = By.xpath("//*[@title='Pay by bank wire']");
    private By bankWire2TextLocator = By.xpath("//strong[contains(text(),'You have chosen to pay by bank wire')]");
    private By confirmOrderButton = By.xpath("//button[@class='button btn btn-default button-medium']");
    private By completeOrderText = By.xpath("//strong[contains(text(),'Your order on My Store is complete')]");

    PaymentPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void clickOnBankWirePayment() {
        clickOnElement(payByBankWireLocator);
    }

    public void clickOnConfirmOrderButton() {
        clickOnElement(confirmOrderButton);
    }

    public String getTotalPriceText() {
        return findElement(totalItemPriceLocator).getText();
    }

    public String getPayByBankWireText() {
        return findElement(payByBankWireLocator).getText();
    }

    public String getBankWireText() {
        return findElement(bankWire2TextLocator).getText();
    }

    public String getCompletedOrderText() {
        return findElement(completeOrderText).getText();
    }
}