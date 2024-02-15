package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.HeaderMenuBase;
import com.solvd.carinaexample.web.assignment.base.HoroscopeMenuBase;
import com.solvd.carinaexample.web.assignment.base.YahooEntertainmentPageBase;
import com.solvd.carinaexample.web.assignment.components.HeaderMenu;
import com.solvd.carinaexample.web.assignment.components.HoroscopeMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooEntertainmentPage extends YahooEntertainmentPageBase {

    @FindBy(xpath = "//div[@id=\"module-horoscope\"]/div")
    private HoroscopeMenu horoscopeMenu;

    @FindBy(xpath = "//div[@class='_yb_tlypg']//span[@class='_yb_g8kr9']")
    public ExtendedWebElement moreButton;

    @FindBy(xpath = "//div[@id=\"ybar-inner-wrap\"]/div[1]")
    private HeaderMenu headerMenu;

    public YahooEntertainmentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HoroscopeMenuBase getHoroscopeMenu() {
        return horoscopeMenu;
    }

    @Override
    public HeaderMenuBase getHeaderMenu() {
        return headerMenu;
    }
}
