package de.phonebook.tests;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void ensurePrecondition() {
        if (!app.getHomePage().isHomeComponentPresent()) {
            app.getHomePage().clickOnHomeLink();
        }
    }

    @Test(groups = "demo")
    public void isHomeComponentPresentTest() {
       //System.out.println("Home component is " + isHomeComponentPresent());
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}
