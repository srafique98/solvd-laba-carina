package com.solvd.carinaexample.web;

import com.solvd.carinaexample.web.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//header")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
//        setPageURL("/");
//        setPageAbsoluteURL(Configuration.getRequired("home_url"));
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public Header getHeader() {
        return header;
    }
}
