package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.data.ContactData;
import de.phonebook.data.UserData;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import de.phonebook.utils.MyDataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
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

    @Test(groups = "demo")
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastname(ContactData.LASTNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().verifyContactByName(ContactData.NAME));
        app.getContact().pause(1000);
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

    @Test(dataProvider = "addContact", dataProviderClass = MyDataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name, String lastname, String phone,
                                                       String email, String address, String desc) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastname(lastname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(desc));
        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().verifyContactByName(name));
    }

    @Test(dataProvider = "addContactFromCsv", dataProviderClass = MyDataProviders.class)
    public void addContactPositiveFromDataProviderCSVTest(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().verifyContactByPhone(contact.getPhone()));
    }

}
