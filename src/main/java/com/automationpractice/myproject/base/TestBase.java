package com.automationpractice.myproject.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    protected WebDriver driver;
    protected Logger log;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void testSetUp(@Optional("chrome") String browser, ITestContext context) {
        String testName = context.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserDriverFactory driverFactory = new BrowserDriverFactory(browser, log);
        driver = driverFactory.createDriver();

        driver.manage().window().maximize();

        this.testSuiteName = context.getSuite().getName();
        this.testName = testName;
        this.testMethodName = testMethodName;
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown() {
        log.info("Quit driver");
        driver.quit();
    }
}