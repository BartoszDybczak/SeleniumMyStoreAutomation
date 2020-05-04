package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TShirtsCategoryPage extends BasePageObject {

    private By tShirtsText = By.xpath("//*[@class='category-name']");

    TShirtsCategoryPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getTShirtsCategoryText() {
        waitForVisibilityOf(tShirtsText);
        return findElement(tShirtsText).getText();
    }
}