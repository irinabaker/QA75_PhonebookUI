package de.phonebook.core;

import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite(alwaysRun = true)
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

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
     //   System.out.println("After suite");
        app.stop();
    }

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method, Object[] p) {
        logger.info("Start test {} with data: {}",method.getName(), Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
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

    @BeforeGroups("demo")
    public void setUpDemoGroup() {
        logger.info("Start demo group");
    }

    @AfterGroups("demo")
    public void stopDemoGroup() {
        logger.info("Stop demo group");
    }

}
