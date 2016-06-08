package com.a1systems.test;

import com.a1systems.entity.GooglePage;
import com.a1systems.selenium.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Aristarkhov on 07.06.2016.
 */
public class GoogleTest {
    public static Browser browser;

    @BeforeClass (description = "Start tests for Google")
    public static void createAndStartService() throws IOException {
        browser = new Browser();
    }

    @AfterTest
    public void tearDown() {
        browser.close();
    }

    @Test (description = "Search test, find in google wikipedia")
    public void searchTest() throws InterruptedException {
        GooglePage gp = new GooglePage(browser);
        Assert.assertTrue(gp.search("wikipedia").contains("WikipediA The Free Encyclopedia."));
    }

    @Test (description = "Check elements on home page")
    public void existElementTest() throws InterruptedException {
        GooglePage gp = new GooglePage(browser);
        Assert.assertTrue(gp.isExistAllElementsOnHomePage());
    }

}
