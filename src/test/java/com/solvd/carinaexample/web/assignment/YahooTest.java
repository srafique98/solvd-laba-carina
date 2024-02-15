package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.YahooHomePageBase;
import com.solvd.carinaexample.web.assignment.base.YahooProductServicePageBase;
import com.solvd.carinaexample.web.lecture.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;

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

    @DataProvider(name = "movies")
    public Object[][] movies(){
        return new Object[][] {
                {"Barbie", "Release date: July 21, 2023", "Greta Gerwig", "https://search.yahoo.com/search?p=barbie+movie&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1"},
                {"Oppenheimer", "Release date: July 21, 2023", "Christopher Nolan", "https://search.yahoo.com/search?p=oppenheimer+movie&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1"},
                {"Sound of Freedom", "Release date: July 4, 2023", "Alejandro Gómez Monteverde", "https://search.yahoo.com/search?p=sound+of+freedom+movie&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1"}
        };
    }
    @Test()
    public void testMovieSearch(){
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
//        System.out.println("Daily --- " + dailyHoroscope);
        YahooLifePage lifePage = entertainmentPage.getHeaderMenu().openLifePage();
        Assert.assertTrue(lifePage.getCurrentUrl().contains("lifestyle"), "Life page is not opened!");

        assertEquals(dailyHoroscope, lifePage.getHoroscopeMenu().readSelectedHoroscope(), "Mismatching Horoscopes!");
    }

    @DataProvider(name = "countries")
    public Object[][] countries(){
        return new Object[][] {
                {"Australia (English)", "Trending Now"},
                {"Canada (English)", "Trending Now"},
                {"Chile (español)", "Lo más buscado"},
                {"Colombia (español)", "Lo más buscado"},
                {"Deutschland (Deutsch)", "Trends des Tages"},
                {"Estados Unidos (español)", "Lo más buscado"},
                {"France (français)","Tendances du jour"},
                {"México (español)", "Lo más buscado"},
                {"Perú (español)", "Lo más buscado"},
                {"Singapore (English)","Trending Now"},
                {"United Kingdom (English)","Trending Now"},
                {"United States (English)","Trending Now"},
                {"Venezuela (español)","Lo más buscado"},
                {"ประเทศไทย (ไทย)","Trending Now"}
        };
    }
    @Test(dataProvider = "countries")
    public void testCountrySwitch(String countryName, String trendingNowLanguage) {
        WebDriver driver = getDriver();
        YahooProductServicePage productServicePage = new YahooProductServicePage(driver);
        productServicePage.open();
        Assert.assertTrue(productServicePage.getCurrentUrl().contains("everything"), "Product and Service page is not opened!");

        YahooInternationalPage internationalPage = productServicePage.clickChooseCountry();
        Assert.assertTrue(internationalPage.getCurrentUrl().contains("world"), "International page is not opened!");

        YahooCountryHomePage countryHomePage = internationalPage.selectCountry(countryName);
        Assert.assertTrue(countryHomePage.getCurrentUrl().contains("?p=dnr"), "Country home page is not opened!");
        Assert.assertEquals(countryHomePage.getTrendingNow(), trendingNowLanguage, "Wrong language!");

        System.out.println();
    }

    @Test
    public void testCryptoInfo(){

    }

}
