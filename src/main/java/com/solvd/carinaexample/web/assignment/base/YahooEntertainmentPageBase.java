package com.solvd.carinaexample.web.assignment.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooEntertainmentPageBase extends AbstractPage {
    public YahooEntertainmentPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract HoroscopeMenuBase getHoroscopeMenu();
}
