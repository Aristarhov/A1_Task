package com.a1systems.entity;


import com.a1systems.selenium.Browser;
import com.a1systems.selenium.Element;
import org.apache.log4j.Logger;

/**
 * Created by Aristarkhov on 07.06.2016.
 */
public class GooglePage {
    final static Logger logger = Logger.getLogger(GooglePage.class);
    public final static String URL = "https://www.google.ru/";
    public static final Element SEARCH_INPUT = new Element("SEARCH_INPUT","lst-ib");
    public static final Element SEARCH_BUTTON = new Element("SEARCH_BUTTON","sblsbb");
    public static final Element SEARCH_RESULTS = new Element("SEARCH_RESULTS","rcnt");
    public static final Element SEARCH_IN_GOOGLE_BUTTON = new Element("SEARCH_IN_GOOGLE_BUTTON", "btnK", "Поиск в Google");
    public static final Element LUCK_BUTTON = new Element("LUCK_BUTTON", "btnI", "Мне повезёт!");
    public static final Element VOICE_BUTTON = new Element("VOICE_BUTTON","gsri_ok0");
    public static final Element MONITOR_KEYBOARD_BUTTON = new Element("MONITOR_KEYBOARD_BUTTON","gs_ok0");
    private final Browser browser;

    public GooglePage(Browser browser) {
        this.browser = browser;
    }

    public String search(String text) throws InterruptedException {
        logger.debug("Search text in google: " + text);
        browser.openPage(URL);
        browser.findElement(SEARCH_INPUT).getWebElement().sendKeys(text);
        browser.findElement(SEARCH_BUTTON).getWebElement().click();
        return browser.findElement(SEARCH_RESULTS).getWebElement().getText();
    }


    public boolean isExistAllElementsOnHomePage() {
        logger.debug("Check all elements on home page");
        browser.openPage(URL);
        browser.findElement(SEARCH_INPUT);
        browser.findElement(SEARCH_BUTTON);
        browser.findElement(VOICE_BUTTON);
        browser.findElement(MONITOR_KEYBOARD_BUTTON);

        if(!compareTextInElementAndWebElement(browser.findElement(SEARCH_IN_GOOGLE_BUTTON))){
            return false;
        }
        if(!compareTextInElementAndWebElement(browser.findElement(LUCK_BUTTON))){
            return false;
        }
        logger.debug("All elements EXIST on home page");
        return true;
    }

    private boolean compareTextInElementAndWebElement(Element element) {
        if (!element.getText().equals(element.getWebElement().getAttribute("value"))) {
            logger.error("Text in: " + element.getName() + " doesn't match with template!");
            logger.error(element.getText() + " != " + element.getWebElement().getAttribute("value"));
            return false;
        }
        return true;
    }

}
