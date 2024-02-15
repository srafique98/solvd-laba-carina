package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.YahooCountryHomePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooCountryHomePage extends YahooCountryHomePageBase {

    @FindBy(xpath = "//div[@id=\"module-trending\"]//h3")
    private ExtendedWebElement trendingNow;

    public YahooCountryHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTrendingNow() {
        return trendingNow.getText();
    }
}
