package com.solvd.carinaexample.web.assignment.base;

import com.solvd.carinaexample.web.assignment.YahooCryptoPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooFinancePageBase extends AbstractPage {
    public YahooFinancePageBase(WebDriver driver) {
        super(driver);
    }
    public abstract YahooCryptoPage clickCrypto();
    public abstract YahooCryptoPage search(String prompt);


}
