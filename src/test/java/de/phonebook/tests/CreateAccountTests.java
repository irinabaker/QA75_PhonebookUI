package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void existedUserRegisterNegativeTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertPresent());
    }
}
