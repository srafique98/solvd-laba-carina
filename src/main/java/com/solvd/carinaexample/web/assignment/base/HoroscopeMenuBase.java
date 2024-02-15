package com.solvd.carinaexample.web.assignment.base;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HoroscopeMenuBase extends AbstractUIObject {

    public HoroscopeMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public abstract String readSelectedHoroscope();
}
