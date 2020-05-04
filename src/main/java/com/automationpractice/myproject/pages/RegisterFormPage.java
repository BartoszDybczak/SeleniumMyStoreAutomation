package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterFormPage extends BasePageObject {

    private By genderButtonLocator = By.id("uniform-id_gender1");
    private By customerFirstNameLocator = By.id("customer_firstname");
    private By customerLastNameLocator = By.id("customer_lastname");
    private By registerFormEmailLocator = By.id("email");
    private By registerFormPasswordLocator = By.id("passwd");
    private By registerFormDayLocator = By.id("days");
    private By registerFormMonthLocator = By.id("months");
    private By registerFormYearLocator = By.id("years");
    private By newsletterCheckboxLocator = By.id("newsletter");
    private By specialOffersCheckboxLocator = By.id("optin");
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By address1 = By.id("address1");
    private By city = By.id("city");
    private By country = By.id("id_country");
    private By mobilePhone = By.id("phone_mobile");
    private By state = By.id("id_state");
    private By postalCodeLocator = By.id("postcode");
    private By aliasAddress = By.id("alias");
    private By submitButton = By.id("submitAccount");

    public RegisterFormPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void chooseGender() {
        waitForVisibilityOf(genderButtonLocator);
        clickOnElement(genderButtonLocator);
    }

    public void typeName(String customerFirstName) {
        waitForVisibilityOf(customerFirstNameLocator);
        typeText(customerFirstName, customerFirstNameLocator);
    }

    public void typeLastName(String customerLastName) {
        waitForVisibilityOf(customerLastNameLocator);
        typeText(customerLastName, customerLastNameLocator);
    }

    public void typePassword(String password) {
        typeText(password, registerFormPasswordLocator);
    }

    public void selectBirthDay(String value) {
        WebElement daysDropdown = findElement(registerFormDayLocator);
        Select dropdown = new Select(daysDropdown);
        dropdown.selectByValue(value);
    }

    public void selectBirthMonth(String value) {
        WebElement monthDropdown = findElement(registerFormMonthLocator);
        Select dropdown = new Select(monthDropdown);
        dropdown.selectByValue(value);
    }

    public void selectBirthYear(String value) {
        WebElement yearDropdown = findElement(registerFormYearLocator);
        Select dropdown = new Select(yearDropdown);
        dropdown.selectByValue(value);
    }

    public void clickOnNewsletterCheckbox() {
        clickOnElement(newsletterCheckboxLocator);
    }

    public void clickOnSpecialOfferCheckbox() {
        clickOnElement(specialOffersCheckboxLocator);
    }

    public void typeAddress(String address) {
        typeText(address,address1);
    }

    public void typeCity(String cityName) {
        typeText(cityName,city);
    }

    public void selectCountry(String value) {
        WebElement countryDropdown = findElement(country);
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByValue(value);
    }

    public void selectState(String value) {
        WebElement stateDropdown = findElement(state);
        Select dropdown = new Select(stateDropdown);
        dropdown.selectByValue(value);
    }

    public void typeMobilePhone(String phoneNumber) {
        typeText(phoneNumber,mobilePhone);
    }

    public void typePostalCode(String postalCode) {
        typeText(postalCode,postalCodeLocator);
    }

    public MyAccountPage clickOnSubmitButton() {
        clickOnElement(submitButton);
        return new MyAccountPage(driver, log);
    }

    public Boolean isGenderSelected() {
        findElement(genderButtonLocator).isSelected();
        return true;
    }

    public String getEmailFromRegisterText() {
        return findElement(registerFormEmailLocator).getAttribute("value");
    }

    public String getFirstNameText() {
        return findElement(firstName).getAttribute("value");
    }

    public String getLastNameText() {
        return findElement(lastName).getAttribute("value");
    }

    public String getPasswordText() {
        return findElement(registerFormPasswordLocator).getAttribute("value");
    }

    public String  getBirthDatText() {
        WebElement daysDropdown = findElement(registerFormDayLocator);
        Select dropdown = new Select(daysDropdown);
        String selectedDay = dropdown.getFirstSelectedOption().getText();
        return selectedDay;
    }

    public String  getMonthText() {
        WebElement monthDropdown = findElement(registerFormMonthLocator);
        Select dropdown = new Select(monthDropdown);
        String selectedMonth = dropdown.getFirstSelectedOption().getText();
        return selectedMonth;
    }

    public String  getYearText() {
        WebElement yearDropdown = findElement(registerFormYearLocator);
        Select dropdown = new Select(yearDropdown);
        String selectedYear = dropdown.getFirstSelectedOption().getText();
        return selectedYear;
    }

    public String getAddressText() {
        return findElement(address1).getAttribute("value");
    }

    public String getCityText() {
        return findElement(city).getAttribute("value");
    }

    public String  getCountrySelectedText() {
        WebElement countryDropdown = findElement(country);
        Select dropdown = new Select(countryDropdown);
        String selectedCountry = dropdown.getFirstSelectedOption().getText();
        return selectedCountry;
    }

    public String  getStateSelectedText() {
        WebElement stateDropdown = findElement(state);
        Select dropdown = new Select(stateDropdown);
        String stateCountry = dropdown.getFirstSelectedOption().getText();
        return stateCountry;
    }

    public String getPostCodeText() {
        return findElement(postalCodeLocator).getAttribute("value");
    }

    public String getMobilePhoneText() {
        return findElement(mobilePhone).getAttribute("value");
    }

    public String getAliasText() {
        return findElement(aliasAddress).getAttribute("value");
    }
}