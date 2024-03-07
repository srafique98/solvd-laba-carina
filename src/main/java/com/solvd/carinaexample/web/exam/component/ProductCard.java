package com.solvd.carinaexample.web.exam.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = "//p[contains(@class,'sc-11uohgb-2')]")
    private List<ExtendedWebElement> titles;

    public List<ExtendedWebElement> getTitles() {
        return titles;
    }

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
