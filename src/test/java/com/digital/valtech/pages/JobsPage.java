package com.digital.valtech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobsPage extends BasePage{
    public JobsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "div.page-header h1")
    private WebElement heading;


    public String urlEndsWith() {
        return "jobs/";
    }

    @Override
    public String heading()
    {
        return heading.getText();
    }
}
