package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.lecture.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class YahooTest extends AbstractTest {
    @Test
    public void testCityWeather(){
        String myCity = "Lodi";
        String cityIdentifier = "12797649";
        WebDriver driver = getDriver();
        YahooHomePage homePage = new YahooHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Yahoo homepage is not open");
        Assert.assertEquals(homePage.getTitle(), "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos", "Homepage title do not match");

        String homeCity = homePage.getWeatherCity();
        Assert.assertEquals(homeCity.toLowerCase(), myCity.toLowerCase());

        YahooWeatherPage weatherPage = homePage.clickSeeMore();
        Assert.assertTrue(weatherPage.getCurrentUrl().contains(cityIdentifier),"URL does not contain ID");
        Assert.assertEquals(weatherPage.readCity(), myCity,"Not my city!");
    }
}
