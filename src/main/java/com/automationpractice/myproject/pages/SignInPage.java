package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePageObject {

    private String pageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    private By createEmailLocator = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");
    private By logInEmail = By.id("email");
    private By logInPassword = By.id("passwd");
    private By loginButton = By.id("SubmitLogin");
    private By accountErrorMessage = By.xpath("//ol/li");

    public SignInPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openSignInPage() {
        openPage(pageUrl);
    }

    public void createAccountEmail(String username) {
        waitForVisibilityOf(createEmailLocator);
        typeText(username, createEmailLocator);
    }

    public RegisterFormPage clickOnCreateAccount() {
        clickOnElement(createAccountButton);
        return new RegisterFormPage(driver, log);
    }

    public void typeUsername(String username) {
        waitForVisibilityOf(logInEmail);
        typeText(username, logInEmail);
    }

    public void typePassword(String password) {
        typeText(password, logInPassword);
    }

    public MyAccountPage clickOnLoginButton() {
        clickOnElement(loginButton);
        return new MyAccountPage(driver, log);
    }

    public String getErrorText() {
        waitForVisibilityOf(accountErrorMessage);
        return findElement(accountErrorMessage).getText();
    }
}