package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.YahooEntertainmentPageBase;
import com.solvd.carinaexample.web.assignment.base.YahooHomePageBase;
import com.solvd.carinaexample.web.assignment.base.YahooProductServicePageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooHomePage extends YahooHomePageBase {

    @FindBy(xpath = ".//div[@id='module-weather']//h4")
    private ExtendedWebElement weatherCity;

    @FindBy(xpath = "//div[@class='weather-card-content Pos(r)']/a")
    private ExtendedWebElement seeMoreWeatherButton;

    @FindBy(xpath = ".//div[@id='ybar-search-box-container']//input[@type='text']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//div[@id='ybar-search-box-container']//button[@type='submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@class='_yb_tlypg']//a[contains(@href,'entertainment')][1]")
    public ExtendedWebElement entertainmentLink;

    @FindBy(xpath = "//div[@class='_yb_tlypg']//span[@class='_yb_g8kr9']")
    public ExtendedWebElement moreButton;

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    @Override
    public String getWeatherCity() {
        return weatherCity.getText();
    }

    @Override
    public YahooWeatherPage clickSeeMore() {
        seeMoreWeatherButton.click();
        return new YahooWeatherPage(getDriver());
    }

    @Override
    public YahooMovieSearchPage searchMovie(String prompt, String link) {
        search(prompt);
        return new YahooMovieSearchPage(getDriver(), link);
    }
    @Override
    public void search(String prompt) {
        searchBar.click();
        searchBar.type(prompt);
        searchButton.click();
    }

    @Override
    public YahooEntertainmentPage clickEntertainment() {
        moreButton.click();
        entertainmentLink.click();
        return new YahooEntertainmentPage(getDriver());
    }
}
