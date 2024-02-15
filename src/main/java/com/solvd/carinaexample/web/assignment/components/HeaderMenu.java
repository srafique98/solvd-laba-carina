package com.solvd.carinaexample.web.assignment.components;

import com.solvd.carinaexample.web.assignment.YahooEntertainmentPage;
import com.solvd.carinaexample.web.assignment.YahooLifePage;
import com.solvd.carinaexample.web.assignment.base.HeaderMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends HeaderMenuBase {

    @FindBy(xpath = "//div[@class='_yb_tlypg']//li[@class='_yb_1dd0s']//a[contains(@href,'lifestyle')]//span")
    private ExtendedWebElement lifeLink;

    @FindBy(xpath = "//div[@class='_yb_tlypg']//span[@class='_yb_g8kr9']")
    public ExtendedWebElement moreButton;
    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public YahooLifePage openLifePage() {
        moreButton.click();
        lifeLink.click();
        return new YahooLifePage(getDriver());
    }
}
