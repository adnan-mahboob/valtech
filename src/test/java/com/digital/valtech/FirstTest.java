package com.digital.valtech;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FirstTest extends Setup
{
    @Before
    public void before() throws IOException {
        super.init();
        navigateToStartPage();
    }

    @Test
    public void checkLatestNewsIsDisplayed() {
        Assert.assertTrue("Latest news is not displayed on the home page",
                homePage.isLatestNewsDisplayed() == true);
    }

    @Test
    public void checkCasesPageHeadings() {
        header.goToCases();
        waitForPage(workPage);
        String heading = workPage.heading();

        Assert.assertTrue(heading.equals("Cases"));
    }

    @Test
    public void checkServicesPageHeadings() {
        header.goToServices();
        waitForPage(servicesPage);
        String heading = servicesPage.heading();

        Assert.assertTrue(heading.equals("Services"));
    }

    @Test
    public void checkJobPageHeadings() {
        header.goToJobs();
        waitForPage(jobsPage);
        String heading = jobsPage.heading();

        Assert.assertTrue(heading.equals("Jobs"));
    }

    @Test
    public void checkOfficeTotal(){
        header.openContacts();
        int numberOfOffices = contactsPage.getAllOffices();

        System.out.println(String.format("number of valtech offices = %d", numberOfOffices));
    }

    @After
    public void close()
    {
        closeBrowser();
    }
}
