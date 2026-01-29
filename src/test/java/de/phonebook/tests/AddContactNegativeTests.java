package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.data.ContactData;
import de.phonebook.data.UserData;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactNegativeTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactWithInvalidPhoneTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastname(ContactData.LASTNAME)
                .setPhone(ContactData.INVALID_PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isAlertPresent());
    }

    @AfterMethod(enabled = true)
    public void postCondition() {
        app.getContact().clickOnContactLink();
        while (!app.getContact().isContactListEmpty()) {
            app.getContact().removeContact();
        }
    }
}
