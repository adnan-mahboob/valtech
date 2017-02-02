package com.digital.valtech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkPage extends BasePage{

    public WorkPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String urlEndsWith() {
        return "cases/";
    }


}
