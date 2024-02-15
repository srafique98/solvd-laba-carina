package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.HoroscopeMenuBase;
import com.solvd.carinaexample.web.assignment.base.YahooEntertainmentPageBase;
import com.solvd.carinaexample.web.assignment.components.HoroscopeMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooEntertainmentPage extends YahooEntertainmentPageBase {

    @FindBy(xpath = ".//div[@id=\"module-horoscope\"]/div")
    private HoroscopeMenu horoscopeMenu;
    public YahooEntertainmentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HoroscopeMenuBase getHoroscopeMenu() {
        return horoscopeMenu;
    }
}
