package com.digital.valtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Adee A on 02/02/2017.
 */
public class MainHeader extends BasePage{

    @FindBy(id = "navigationMenuWrapper ")
    private WebElement headerDiv;

    @FindBy(id = "contacticon")
    private WebElement contactsLink;

    @FindBy(css = "p.contactheader")
    private WebElement contactsHeader;


    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public String urlEndsWith() {
        return null;
    }

    public String heading() {
        return null;
    }

    public void goToCases() {
        headerDiv.findElement(By.linkText("Work")).click();
    }

    public void goToServices() {
        headerDiv.findElement(By.linkText("Services")).click();
    }

    public void goToJobs() {
        headerDiv.findElement(By.linkText("Careers")).click();
    }

    public void openContacts() {
        contactsLink.click();
        waitForElementToBeVisible(contactsHeader);
    }
}
