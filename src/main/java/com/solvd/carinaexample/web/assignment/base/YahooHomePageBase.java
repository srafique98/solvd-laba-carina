package com.solvd.carinaexample.web.assignment.base;

import com.solvd.carinaexample.web.assignment.YahooFinancePage;
import com.solvd.carinaexample.web.assignment.YahooWeatherPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooHomePageBase extends AbstractPage {
    public YahooHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooWeatherPage clickSeeMore();

    public abstract String getWeatherCity();

    public abstract void search(String prompt);

    public abstract YahooMovieSearchPageBase searchMovie(String prompt, String link);

    public abstract YahooEntertainmentPageBase clickEntertainment();

    public abstract YahooFinancePage clickFinance();
}
