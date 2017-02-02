package com.digital.valtech.pages;

import com.digital.ConfigProperty;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.digital.ConfigProperty.TIMEOUT_DOM;

public abstract class BasePage
{
    @FindBy(css = "header.page-header h1")
    private WebElement heading;

    protected WebDriver webDriver = null;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public abstract String urlEndsWith();

    private Wait<WebDriver> waitForDom()
    {
        return new FluentWait<WebDriver>(webDriver)
                .pollingEvery(1, TimeUnit.SECONDS)
                .withTimeout(TIMEOUT_DOM.getValueAsInt(), TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    protected void waitForElementToBeVisible(WebElement element)
    {
        waitForDom().until(ExpectedConditions.visibilityOf(element));
    }

    public String heading() {
        return heading.getText();
    }
}
