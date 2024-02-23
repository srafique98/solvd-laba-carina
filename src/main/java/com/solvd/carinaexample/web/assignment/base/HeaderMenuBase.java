package com.solvd.carinaexample.web.assignment.base;

import com.solvd.carinaexample.web.assignment.YahooEntertainmentPage;
import com.solvd.carinaexample.web.assignment.YahooLifePage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuBase extends AbstractUIObject {
    public HeaderMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

//    public abstract YahooEntertainmentPage openEntertainmentPage();
//
    public abstract YahooLifePage openLifePage();
}
