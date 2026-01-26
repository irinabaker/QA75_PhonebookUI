package de.phonebook.fw;

import de.phonebook.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.xpath("//div[2]//h1")).size()>0;
    }

    public void clickOnHomeLink() {
        click(By.cssSelector("[href='/home']"));
    }
}
