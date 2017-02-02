package com.digital.valtech.pages;

import org.openqa.selenium.WebDriver;

public class ServicesPage extends BasePage{
    public ServicesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String urlEndsWith() {
        return "services/";
    }

}
