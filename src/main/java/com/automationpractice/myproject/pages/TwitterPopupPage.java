package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterPopupPage extends BasePageObject {

    private By twitterLoginButtonLocator = By.xpath("//*[@value='Log in and Tweet']");

    TwitterPopupPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getTwitterText() {
        waitForVisibilityOf(twitterLoginButtonLocator);
        return findElement(twitterLoginButtonLocator).getAttribute("value");
    }
}