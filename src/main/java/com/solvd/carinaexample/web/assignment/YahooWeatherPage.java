package com.solvd.carinaexample.web.assignment;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooWeatherPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='module-location-heading']//h1")
    private ExtendedWebElement city;
    public YahooWeatherPage(WebDriver driver) {
        super(driver);
    }

    public String readCity() {
        return city.getText();
    }
}
