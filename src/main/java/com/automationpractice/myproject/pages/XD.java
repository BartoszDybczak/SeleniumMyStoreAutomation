package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XD extends BasePageObject {

    private String pageUrl = "https://ultimateqa.com/simple-html-elements-for-automation/";

    private By classNameS = By.className("buttonClass");
    private By byIdS = By.id("idExample");
    private By linkTextS = By.linkText("Click me using this link text!");
    private By cssSelectorId = By.cssSelector("#idExample"); //# w css znajdzie ID
    private By cssSelectorClass = By.cssSelector(".buttonClass"); //. w css sluzy do znajdowania klas
    private By xPathId = By.xpath("//*[@id='idExample']");
    private By xPathClass = By.xpath("//*[@class='buttonClass']");

    public XD(WebDriver driver, Logger log) {
        super(driver, log);
    }



    public void clickOnButtonClassName() {
        openPage(pageUrl);
        HighLightElementUsingJavaScript(classNameS);
        clickOnElement(classNameS);
    }

    public void clickOnButtonId() {
        openPage(pageUrl);
        HighLightElementUsingJavaScript(byIdS);
        clickOnElement(byIdS);
    }

    public void clickOnLinkText() {
        openPage(pageUrl);
        HighLightElementUsingJavaScript(linkTextS);
        clickOnElement(linkTextS);
    }

    public void clickOnCssId() {
        openPage(pageUrl);
        HighLightElementUsingJavaScript(cssSelectorId);
        clickOnElement(cssSelectorId);
    }

    public void clickOnCssClass() {
        openPage(pageUrl);
        HighLightElementUsingJavaScript(cssSelectorClass);
        clickOnElement(cssSelectorClass);
    }

    public void clickOnXPathId() {
        openPage(pageUrl);
        HighLightElementUsingJavaScript(xPathId);
        clickOnElement(xPathId);
    }

    public void clickOnXPathClass() {
        openPage(pageUrl);
        HighLightElementUsingJavaScript(xPathClass);
        clickOnElement(xPathClass);
    }




}
