package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderAddressPage extends BasePageObject {

    private By lastNameFirstName = By.xpath("//*[@id='address_delivery']/li[@class='address_firstname address_lastname']");
    private By addressLocator = By.xpath("//*[@id='address_delivery']/li[@class='address_address1 address_address2']");
    private By address2Locator = By.xpath("//*[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']");
    private By countryLocator = By.xpath("//*[@id='address_delivery']/li[@class='address_country_name']");
    private By mobilePhoneLocator = By.xpath("//*[@id='address_delivery']/li[@class='address_phone_mobile']");
    private By proceedButtonLocator = By.xpath("//*[@name='processAddress']");

    public OrderAddressPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public ShippingPage clickOnProceedButton() {
        clickOnElement(proceedButtonLocator);
        return new ShippingPage(driver, log);
    }

    public String getNameText() {
        return findElement(lastNameFirstName).getText();
    }

    public String getAddressText() {
        return findElement(addressLocator).getText();
    }

    public String getAddress2Text() {
        return findElement(address2Locator).getText();
    }

    public String getCountryText() {
        return findElement(countryLocator).getText();
    }

    public String getMobilePhoneText() {
        return findElement(mobilePhoneLocator).getText();
    }
}