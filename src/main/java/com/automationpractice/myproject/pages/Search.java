package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search extends BasePageObject {

    private By searchBarLocator = By.id("search_query_top");
    private By searchButtonLocator = By.xpath("//*[@class='btn btn-default button-search']");
    private By searchLocator = By.xpath("//*[@class='page-heading  product-listing']");
    private By dressTextLocator = By.xpath("//*[@class='lighter']");
    private By searchResultsLocator = By.xpath("//*[@class='heading-counter']");

    public Search(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void searchForItem(String itemName) {
        typeText(itemName, searchBarLocator);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButtonLocator);
    }

    public String getSearchHeaderText() {
        waitForVisibilityOf(searchLocator);
        return findElement(searchLocator).getText();
    }

    public String getDressText() {
        waitForVisibilityOf(dressTextLocator);
        return findElement(dressTextLocator).getText();
    }

    public String getResultsFoundText() {
        waitForVisibilityOf(searchResultsLocator);
        return findElement(searchResultsLocator).getText();
    }
}