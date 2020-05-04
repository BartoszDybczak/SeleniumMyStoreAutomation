package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BasePageObject {

    private By termsOfServiceLocator = By.id("cgv");
    private By shippingPriceLocator = By.xpath("//div[@class='delivery_option_price']");
    private By proceedButton = By.xpath("//*[@name='processCarrier']");

    ShippingPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void clickOnTermsOfService() {
        clickOnElement(termsOfServiceLocator);
    }

    public PaymentPage clickOnProceedButton() {
        clickOnElement(proceedButton);
        return new PaymentPage(driver, log);
    }

    public Boolean isTermsOfServiceChecked() {
        findElement(termsOfServiceLocator).isSelected();
        return true;
    }

    public String getShippingText() {
        return findElement(shippingPriceLocator).getText();
    }
}