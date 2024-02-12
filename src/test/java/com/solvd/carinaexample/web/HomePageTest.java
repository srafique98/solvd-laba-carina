package com.solvd.carinaexample.web;

import com.solvd.carinaexample.web.HomePage;
import com.solvd.carinaexample.web.components.SearchLineComponent;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractTest {
    @Test
    public void verifySearchLineTest(){
//        no need for this anymore because HomePage extends AbstractPage.. instead use new keyword
//        HomePage page = PageFactory.initElements(driver, HomePage.class);
//        System.setProperty("webdriver.chrome.driver", "/Applications/selenium/chromedriver");
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        page.open();
//        driver.get("google.com");
        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        System.out.println();

    }
}
