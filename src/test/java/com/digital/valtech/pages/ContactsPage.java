package com.digital.valtech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends BasePage{

    @FindBy(css = "ul.contactcities li")
    private List<WebElement> offices;


    public ContactsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String urlEndsWith() {
        return "";
    }

    public int getAllOffices() {
        return offices.size();
    }
}
