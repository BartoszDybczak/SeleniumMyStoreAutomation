package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePageObject {

    private String pageUrl = "http://automationpractice.com/index.php";

    private By phoneNumberLocator = By.cssSelector("nav  strong");
    private By shortSleeveLocator = By.xpath("//h5/a[@title='Faded Short Sleeve T-shirts']");
    private By contactUs = By.xpath("//*[@title='Contact Us']");
    private By signInLocator = By.xpath("//*[@title='Log in to your customer account']");

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openHomePage() {
        openPage(pageUrl);
    }

    public ItemDetailPage clickOnCard() {
        clickOnElement(shortSleeveLocator);
        return new ItemDetailPage(driver,log);
    }

    public ContactUsPage clickOnContactUs() {
        clickOnElement(contactUs);
        return new ContactUsPage(driver,log);
    }

    public SignInPage clickOnSignIn() {
        clickOnElement(signInLocator);
        return new SignInPage(driver, log);
    }

    public String getPhoneNumberText() {
        String phoneNumberText = findElement(phoneNumberLocator).getText();
        return phoneNumberText;
    }
}