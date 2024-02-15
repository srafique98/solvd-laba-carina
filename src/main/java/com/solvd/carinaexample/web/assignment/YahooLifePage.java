package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.HoroscopeMenuBase;
import com.solvd.carinaexample.web.assignment.base.YahooLifePageBase;
import com.solvd.carinaexample.web.assignment.components.HoroscopeMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooLifePage extends YahooLifePageBase {

    @FindBy(xpath = ".//div[@id=\"module-horoscope\"]/div")
    private HoroscopeMenu horoscopeMenu;
    public YahooLifePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HoroscopeMenuBase getHoroscopeMenu() {
        return horoscopeMenu;
    }
}
