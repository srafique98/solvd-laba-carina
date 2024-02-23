package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.YahooInternationalPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YahooInternationalPage extends YahooInternationalPageBase {

    @FindBy(xpath = "//div[@id=\"Col1-0-World-Proxy\"]//a")
    private List<ExtendedWebElement> countries;

    public YahooInternationalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YahooCountryHomePage selectCountry(String name) {
        return countries.stream()
                .filter(country -> country.getText().equals(name))
                .findFirst()
                .map(country -> {
                    country.scrollTo();
                    country.click();
                    return new YahooCountryHomePage(driver);
                })
                .orElse(null);
//        for (ExtendedWebElement country : countries) {
//            if (country.getText().equals(name)) {
//                country.scrollTo();
//                country.click();
//                return new YahooCountryHomePage(driver);
//            }
//        }
//        return null;
    }
}
