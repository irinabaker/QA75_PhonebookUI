package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        clickOnLoginButton();

        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Oliver")
                .setLastname("Kan")
                .setPhone("1234567890")
                .setEmail("kan@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        clickOnSaveButton();
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();

        removeContact();
        pause(500);
        int sizeAfter = sizeOfContacts();

        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

}
