package com.digital.valtech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(css = "header.block-header h2")
    private List<WebElement> headers;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String urlEndsWith() {
        return "valtech.com";
    }

    public boolean isLatestNewsDisplayed() {
        Boolean isDisplayed = false;
        for(WebElement header : headers)
        {
            if(header.getText().equals("LATEST NEWS"))
            {
                isDisplayed = true;
                break;
            }
        }

        return isDisplayed;
    }
}
