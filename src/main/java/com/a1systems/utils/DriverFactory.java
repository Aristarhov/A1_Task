package com.a1systems.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * Created by Aristarkhov on 07.06.2016.
 */
public class DriverFactory {
    final static Logger logger = Logger.getLogger(DriverFactory.class);

    public static WebDriver getDriver() {
        WebDriver driver = null;
        try {
            switch (Config.getDriver()) {
                case "chrome" :
                    System.setProperty("webdriver.chrome.driver", Config.getDriverPath() );
                    driver = new ChromeDriver();
                    break;
                case "ie" :
                    System.setProperty("webdriver.ie.driver", Config.getDriverPath() );
                    driver = new InternetExplorerDriver();
                    break;
                case "firefox" :
                    driver = new FirefoxDriver();
                    break;
            }
        } catch (Exception e){
            logger.error("Failed", e);
            throw e;
        }
        return driver;
    }
}
