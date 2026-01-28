package de.phonebook.core;

import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
       // System.out.println("Before suite");
        app.init();
    }

//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("***Before test");
//    }
//
//    @AfterTest
//    public void afterTest() {
//        System.out.println("***After test");
//    }

    @AfterSuite(enabled = true)
    public void tearDown() {
     //   System.out.println("After suite");
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method method) {
        logger.info("Start test {}",method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: {}",result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: {}. Screenshot is {}",result.getMethod().getMethodName(),
                    app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("******************************************************");
    }

}
