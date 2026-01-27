package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestBase {

//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("******Before class");
//    }

    @BeforeMethod
    public void ensurePrecondition() {
      //  System.out.println("*********Before method");
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("*********After method");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("******After class");
//    }

    @Test
    public void loginRegisteredUserPositiveTest() {
    //    System.out.println("************Test");
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginRegisteredUserWithoutEmailNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm( new User()
                .setPassword("Manuel1234$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
