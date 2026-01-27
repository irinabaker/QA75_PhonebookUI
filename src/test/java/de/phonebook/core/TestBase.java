package de.phonebook.core;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", Browser.CHROME.browserName()));

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

}
