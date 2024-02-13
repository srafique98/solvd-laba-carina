package com.solvd.carinaexample.web.lecture.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

//    @FindBy(id = "nav-search") can have this instead.. wont need . in front
    @FindBy(xpath = ".//*[@id='nav-search']") // look at SearchLineComponent class all xpath will have this xpath then following something different
    private SearchLineComponent searchLineComponent;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchLineComponent getSearchLineComponent() {
        return searchLineComponent;
    }
}
