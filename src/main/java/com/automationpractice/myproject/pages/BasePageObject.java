package com.automationpractice.myproject.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    protected void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    protected WebElement findElement(By elementLocator) {
        return driver.findElement(elementLocator);
    }

    protected List<WebElement> findAllElements(By elementLocator) {
        return driver.findElements(elementLocator);
    }

    protected void clickOnElement(By elementLocator) {
        findElement(elementLocator).click();
    }

    protected void typeText(String input, By locator) {
        findElement(locator).sendKeys(input);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 5;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        wait.until(condition);
    }

    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public void switchToWindowWithTitle(String expectedTitle) {
        // Switching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

    protected void waitForVisibilityOf(By elementLocator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(elementLocator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    protected void highLightElementUsingJavaScript(By locator) {
        WebElement element = findElement(locator);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;')",
                element);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }

        javascriptExecutor.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

    }

    protected void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    protected void switchToFrame(By frameLocator) {
        driver.switchTo().frame(findElement(frameLocator));
    }

    protected void pressKey(By locator, Keys key) {
        findElement(locator).sendKeys(key);
    }

    public void pressKeyWithActions(Keys key) {
        log.info("Pressing " + key.name() + " using Actions class");
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }

    public void scrollToBottom() {
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void performDragAndDrop(By from, By to) {
        // Actions action = new Actions(driver);
        // action.dragAndDrop(find(from), find(to)).build().perform();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                        + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                        + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                        + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n"
                        + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);",
                findElement(from), findElement(to));
    }

    public void setCookie(Cookie cookie) {
        log.info("Adding cookie " + cookie.getName());
        driver.manage().addCookie(cookie);
        log.info("Cookie added");
    }

    public String getCookie(String name) {
        log.info("Getting value of cookie " + name);
        return driver.manage().getCookieNamed(name).getValue();
    }
}