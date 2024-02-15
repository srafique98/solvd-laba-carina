package com.solvd.carinaexample.web.assignment.components;

import com.solvd.carinaexample.web.assignment.base.HoroscopeMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HoroscopeMenu extends HoroscopeMenuBase {

    @FindBy(xpath = "//*[@id=\"horoscope-select\"]//option[@selected]")
    private ExtendedWebElement selectedHoroscope;
    public HoroscopeMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String readSelectedHoroscope() {
        return selectedHoroscope.getText();
    }


}
