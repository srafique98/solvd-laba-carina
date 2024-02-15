package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.YahooMovieSearchPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooMovieSearchPage extends YahooMovieSearchPageBase {

    @FindBy(xpath = "//h4[contains(@class,'text-module')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//li[@class='mb-12'][1]")
    private ExtendedWebElement releaseDate;

    @FindBy(xpath = "//li[@class='mb-12'][2]/a")
    private ExtendedWebElement director;

    @FindBy(xpath = "//a[@id='yucs-apps_button']")
    private ExtendedWebElement yahooSites;

    @FindBy(xpath = "//span[@class='uha-ico uha-home']")
    private ExtendedWebElement homeButton;

    public YahooMovieSearchPage(WebDriver driver, String link) {
        super(driver);
        setPageAbsoluteURL(link);
    }

    @Override
    public String readTitle() {
        return title.getText();
    }

    @Override
    public String readReleaseDate() {
        return releaseDate.getText();
    }

    @Override
    public String readDirector() {
        return director.getText();
    }

    @Override
    public YahooHomePage goHome() {
        yahooSites.click();
        homeButton.click();
        return new YahooHomePage(getDriver());
    }
}
