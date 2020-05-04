package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePageObject {

    private By customerServiceHeaderLocator = By.xpath("//*[@class='page-heading bottom-indent']");
    private By dropdownId = By.id("id_contact");
    private By userMailLocator = By.id("email");
    private By userOrderLocator = By.id("id_order");
    private By messageLocator = By.id("message");
    private By fileUploadLocator = By.id("fileUpload");
    private By submitButtonId = By.id("submitMessage");
    private By successMessageLocator = By.xpath("//*[@class='alert alert-success']");

    public ContactUsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectSubject(String text) {
        waitFor(ExpectedConditions.presenceOfElementLocated(dropdownId), 5);
        WebElement subjectHeader = findElement(dropdownId);

        Select subjectDropdown = new Select(subjectHeader);
        subjectDropdown.selectByVisibleText(text);
    }

    public void typeEmail(String userMail) {
        typeText(userMail, userMailLocator);
    }

    public void typeOrder(String orderText) {
        typeText(orderText, userOrderLocator);
    }

    public void typeMessageText(String messageText) {
        typeText(messageText, messageLocator);
    }

    public void clickOnUploadFile() {
        String filePath = "/Users/bartosz.dybczak/Desktop/Rare pepe2.jpg";

        typeText(filePath, fileUploadLocator);
    }

    public void clickOnSubmitButton() {
        clickOnElement(submitButtonId);
    }

    public String getCustomerServiceText() {
        waitForVisibilityOf(customerServiceHeaderLocator);
        return findElement(customerServiceHeaderLocator).getText();
    }

    public String getSuccessMessage() {
        waitForVisibilityOf(successMessageLocator);
        return findElement(successMessageLocator).getText();
    }

    public String getEmailText() {
        waitForVisibilityOf(userMailLocator);
        return findElement(userMailLocator).getAttribute("value");
    }

    public String getOrderText() {
        waitForVisibilityOf(userOrderLocator);
        return findElement(userOrderLocator).getAttribute("value");
    }

    public String getUserMessageText() {
        waitForVisibilityOf(messageLocator);
        return findElement(messageLocator).getAttribute("value");
    }

    public String getSubjectText() {
        WebElement dropdownElement = findElement(dropdownId);
        Select dropdown = new Select(dropdownElement);
        return dropdown.getFirstSelectedOption().getText();
    }

    public String getUploadedFileText() {
       return findElement(fileUploadLocator).getAttribute("value");
    }
}