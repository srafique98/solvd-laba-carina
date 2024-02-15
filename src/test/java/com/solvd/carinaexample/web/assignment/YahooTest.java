package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.lecture.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;
import java.util.regex.Pattern;

public class YahooTest extends AbstractTest {
    @Test
    public void testCityWeather(){
        String cityIdPattern = "\\d+$";
        Pattern pattern = Pattern.compile(cityIdPattern);

        WebDriver driver = getDriver();
        YahooHomePage homePage = new YahooHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Yahoo homepage is not open");
        Assert.assertEquals(homePage.getTitle(), "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos", "Homepage title do not match");

        String homeCity = homePage.getWeatherCity();
//        Assert.assertEquals(homeCity.toLowerCase(), myCity.toLowerCase());

        YahooWeatherPage weatherPage = homePage.clickSeeMore();
//        Assert.assertTrue(weatherPage.getCurrentUrl().contains(cityIdentifier),"URL does not contain ID");
//        Assert.assertEquals(weatherPage.readCity(), myCity,"Not my city!");
        Assert.assertTrue(pattern.matcher(weatherPage.getCurrentUrl()).find(), "URL does not end with a valid city ID");
    }

    @DataProvider(name = "Movies")
    public Object[][] Movies(){
        return new Object[][] {
                {"Barbie", "Release date: July 21, 2023", "Greta Gerwig", "https://search.yahoo.com/search?p=barbie+movie&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1"},
                {"Oppenheimer", "Release date: July 21, 2023", "Christopher Nolan", "https://search.yahoo.com/search?p=oppenheimer+movie&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1"},
                {"Sound of Freedom", "Release date: July 4, 2023", "Alejandro Gómez Monteverde", "https://search.yahoo.com/search?p=sound+of+freedom+movie&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1"}
        };
    }
    @Test(dataProvider = "Movies")
    public void testMovieSearch(String movieTitle, String releaseDate, String director, String url){
        WebDriver driver = getDriver();
        YahooHomePage homePage = new YahooHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        YahooMovieSearchPage moviePage = homePage.searchMovie(Movie.OPPENHEIMER.getTitle(), Movie.OPPENHEIMER.getUrl());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(moviePage.readTitle(), Movie.OPPENHEIMER.getTitle(), "Invalid title!");
        softAssert.assertEquals(moviePage.readReleaseDate(), Movie.OPPENHEIMER.getReleaseDate(), "Invalid release date!");
        softAssert.assertEquals(moviePage.readDirector(), Movie.OPPENHEIMER.getDirector(), "Invalid director!");
        softAssert.assertAll();
        moviePage.goHome();

    }

    @Test
    public void testHoroscope(){
        WebDriver driver = getDriver();
        YahooHomePage homePage = new YahooHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        YahooEntertainmentPage entertainmentPage = homePage.clickEntertainment();
//        System.out.println("pageee -- " + entertainmentPage.getCurrentUrl());
        Assert.assertTrue(entertainmentPage.getCurrentUrl().contains("entertainment"), "Entertainment page is not opened!");
        String dailyHoroscope = entertainmentPage.getHoroscopeMenu().readSelectedHoroscope();

        System.out.println("dailyyyyyy --- " + dailyHoroscope);



    }


}
