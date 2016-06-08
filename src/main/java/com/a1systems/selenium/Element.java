package com.a1systems.selenium;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;

/**
 * Created by Aristarkhov on 08.06.2016.
 */

@Getter
@Setter
public class Element {
    private String name;
    private String locator;
    private String text;
    private WebElement webElement;

    public Element(String name, String locator) {
        this.name = name;
        this.locator = locator;
    }

    public Element(String name, String locator, String text) {
        this(name, locator);
        this.text = text;
    }
}
