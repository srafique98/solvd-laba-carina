package com.solvd.carinaexample.web.horoscope;

import com.solvd.carinaexample.web.horoscope.components.ZodiacImage;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoroscopeHomePage extends AbstractPage {

    @FindBy(xpath = "//div[@id='Masterwrap']//div[contains(@class,'horoscope-sign:h_Fil(signGridFallback)')]")
    private List<ZodiacImage> zCards;


    public HoroscopeHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("horoscope_url"));
    }

    public List<ZodiacImage> getzCards() {
        return zCards;
    }

//    public void clickZCard(ZodiacImage card){
//        card.
//    }
}
