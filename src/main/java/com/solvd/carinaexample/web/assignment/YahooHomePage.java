package com.solvd.carinaexample.web.assignment;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooHomePage extends AbstractPage {

    @FindBy(xpath = ".//div[@id='module-weather']//h4")
    private ExtendedWebElement weatherCity;

    @FindBy(xpath = "//div[@class='weather-card-content Pos(r)']/a")
    private ExtendedWebElement seeMoreWeatherButton;

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public String getWeatherCity() {
        return weatherCity.getText();
    }

    public YahooWeatherPage clickSeeMore() {
        seeMoreWeatherButton.click();
        return new YahooWeatherPage(getDriver());
    }
}
