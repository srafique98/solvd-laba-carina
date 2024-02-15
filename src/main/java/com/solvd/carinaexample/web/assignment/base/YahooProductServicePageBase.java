package com.solvd.carinaexample.web.assignment.base;

import com.solvd.carinaexample.web.assignment.YahooInternationalPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooProductServicePageBase extends AbstractPage {
    public YahooProductServicePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooInternationalPage clickChooseCountry();
}
