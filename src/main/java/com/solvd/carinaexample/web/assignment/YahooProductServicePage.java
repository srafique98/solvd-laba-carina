package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.YahooProductServicePageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooProductServicePage extends YahooProductServicePageBase {

    @FindBy(xpath = "//div[@id=\"Col1-0-Everything-Proxy\"]/div/div[2]/a")
    private ExtendedWebElement chooseCountryLink;
    public YahooProductServicePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openURL(Configuration.getRequired("product_service_url"));
    }

    @Override
    public YahooInternationalPage clickChooseCountry() {
        chooseCountryLink.scrollTo();
        chooseCountryLink.click();
        return new YahooInternationalPage(getDriver());
    }

}
