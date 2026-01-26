package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginRegisteredUserPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginRegisteredUserWithoutEmailNegativeTest() {
        clickOnLoginLink();
        fillLoginRegisterForm( new User()
                .setPassword("Manuel1234$"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());
    }

}
