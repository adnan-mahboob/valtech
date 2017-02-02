package com.digital.valtech;

import com.digital.ConfigProperty;
import com.digital.valtech.pages.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Setup {
    MainHeader header;
    HomePage homePage;
    WorkPage workPage;
    ServicesPage servicesPage;
    JobsPage jobsPage;
    ContactsPage contactsPage;

    WebDriver webDriver;

    private String baseUrl = "http://www.valtech.com";

    public void init() throws IOException {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/seleniumdrivers/geckodriver.exe");

        webDriver = new FirefoxDriver();

        header = new MainHeader(webDriver);
        homePage = new HomePage(webDriver);
        workPage = new WorkPage(webDriver);
        servicesPage = new ServicesPage(webDriver);
        jobsPage = new JobsPage(webDriver);
        contactsPage = new ContactsPage(webDriver);
    }

    protected void navigateToStartPage() {
        webDriver.navigate().to(baseUrl);
    }

    protected void closeBrowser()
    {
        webDriver.close();
        webDriver = null;
    }

    protected void waitForPage(final BasePage nextPage)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, ConfigProperty.TIMEOUT_PAGE.getValueAsInt());
        try
        {
            wait.until(ExpectedConditions.urlContains(nextPage.urlEndsWith()));
        }
        catch (TimeoutException e)
        {
            throw new AssertionError("Timed out waiting for page: " + nextPage.urlEndsWith() + " to load");
        }
    }
}
