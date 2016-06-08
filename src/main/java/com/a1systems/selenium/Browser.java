package com.a1systems.selenium;

import com.a1systems.utils.DriverFactory;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Aristarkhov on 07.06.2016.
 */
public class Browser {
    final static Logger logger = Logger.getLogger(Browser.class);

    @Getter
    private final WebDriver driver;

    public Browser(WebDriver driver){
        this.driver = driver;
    }

    public Browser(){
        this.driver = DriverFactory.getDriver();
    }

    public void openPage(String url){
        logger.debug("Open page: " + url);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void close(){
        logger.debug("Close browser");
        driver.close();
    }

    public Element findElement(Element element) {
        String locator = convertXPath(element);
        try {
            waitElement(locator);
            element.setWebElement(driver.findElement(By.xpath(locator)));
            return element;
        } catch (Exception e) {
            logger.error("Failed", e);
            throw e;
        }
    }

    private void waitElement(String locator) {
        int totalTryCount = 5;
        int sleepTimeSeconds = 1;
        int countOfTry = 0;
        while (!isElementDisplayed(locator) && countOfTry < totalTryCount) {
            try {
                Thread.sleep(sleepTimeSeconds * 1000);
                countOfTry++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isElementDisplayed(String locator){
        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private String convertXPath(Element element) {
        String xpath;
        if (element.getLocator().startsWith("//")) {
            xpath = element.getLocator();
        } else {
            xpath = String.format("//*[@id='%s' or @class='%s' or @name='%s']",
                    element.getLocator(),
                    element.getLocator(),
                    element.getLocator());
        }
        logger.debug("Find element: '" + element.getName() + "' by xpath: " + xpath);
        return xpath;
    }
}
