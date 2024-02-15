package com.solvd.carinaexample.web.assignment.base;

import com.solvd.carinaexample.web.assignment.YahooCountryHomePage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooInternationalPageBase extends AbstractPage {
    public YahooInternationalPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooCountryHomePage selectCountry(String name);
}
