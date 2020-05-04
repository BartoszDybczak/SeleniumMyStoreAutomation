package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePageObject {

    private By accountInfoCaption = By.xpath("//*[@class='info-account']");
    private By myAccountHeader = By.xpath("//*[@class='page-heading']");

    MyAccountPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getAccountInfoText() {
        return findElement(accountInfoCaption).getText();
    }

    public String getHeaderText() {
        return  findElement(myAccountHeader).getText();
    }
}