package com.solvd.carinaexample.web.horoscope;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.json.XML;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ZodiacPage extends AbstractPage {

//    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
    @FindBy(xpath = "//a[contains(@class,'batcave') and contains(@href,'daily')]")
    private ExtendedWebElement dailyTab;

    @FindBy(xpath = "//div[@id='module-horoscopePage']//a[contains(@href,'weekly')]")
    private ExtendedWebElement weeklyTab;

    @FindBy(xpath = "//div[@id='module-horoscopePage']//a[contains(@href,'monthly')]")
    private ExtendedWebElement monthlyTab;

    @FindBy(xpath = "//div[@class='Py(20px)']//a")
    private List<ExtendedWebElement> shareByButtons;

    //div[@id='module-horoscopePage']//a[contains(@class,'batcave') ]

    public void goBack(){
        driver.navigate().back();
    };

    public ExtendedWebElement getDailyTab() {
        return dailyTab;
    }

    public ExtendedWebElement getWeeklyTab() {
        return weeklyTab;
    }

    public ExtendedWebElement getMonthlyTab() {
        return monthlyTab;
    }

    public List<ExtendedWebElement> getShareByButtons() {
        return shareByButtons;
    }

    public FacebookShare clickFaceBookShare() {
        shareByButtons.get(0).click();
        return new FacebookShare(driver);
    }
    public TwitterShare clickTwitterShare() {
        shareByButtons.get(1).click();
        return new TwitterShare(driver);
    }


    public ZodiacPage(WebDriver driver) {
        super(driver);
    }




}
