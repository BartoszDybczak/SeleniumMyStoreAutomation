package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePageObject {

    private By searchTextLocator = By.xpath("//h1/span[@class='lighter']");
    //div[@id='center_column']/h1
    //*[@id'center_column]/h1/text()
    //div[@id='center_column']//span[@class='heading-counter']

    SearchResultsPage(WebDriver driver, Logger log) {
        super(driver,log);
    }

    public String getSearchText() {
        String searchText = findElement(searchTextLocator).getText();

        return searchText;
    }



}
