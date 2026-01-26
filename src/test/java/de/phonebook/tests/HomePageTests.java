package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest() {
       //System.out.println("Home component is " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

}
