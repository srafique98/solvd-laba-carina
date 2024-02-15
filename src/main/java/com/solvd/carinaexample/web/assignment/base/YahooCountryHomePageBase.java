package com.solvd.carinaexample.web.assignment.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooCountryHomePageBase extends AbstractPage {
    public YahooCountryHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTrendingNow();
}
