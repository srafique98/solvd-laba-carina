package com.solvd.carinaexample.web.horoscope.components;


import com.solvd.carinaexample.web.horoscope.ZodiacPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ZodiacImage extends AbstractUIObject {

    @FindBy(xpath = ".//h3[contains(@class,'horoscope-sign')]")
    private List<ExtendedWebElement> zNames;
    @FindBy(xpath = ".//div[contains(@class,'horoscope-sign:h_C($c-fuji-white)')]")
    private List<ExtendedWebElement> zDates;

    public ZodiacImage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getZodiacName() {
        return zNames;
    }

    public List<String> getZodiacText() {
        return zNames.stream().map(ExtendedWebElement::getText)
                .collect(Collectors.toList());

    }

    public List<String> getZodiacDateText() {
        return zDates.stream().map(ExtendedWebElement::getText)
                .collect(Collectors.toList());

    }

    public ZodiacPage clickCard() {
        zNames.get(0).click();
        return new ZodiacPage(driver);
    }


}
