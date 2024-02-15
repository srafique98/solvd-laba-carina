package com.solvd.carinaexample.web.assignment.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooCryptoPageBase extends AbstractPage {

    public abstract String readName();
    public YahooCryptoPageBase(WebDriver driver) {
        super(driver);
    }
}
