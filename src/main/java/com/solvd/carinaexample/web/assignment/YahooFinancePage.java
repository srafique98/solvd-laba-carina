package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.YahooFinancePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class YahooFinancePage extends YahooFinancePageBase {

    @FindBy(xpath = "//div[@id='data-util-col']//section[@class='Mb(20px)' and @data-yaft-module='tdv2-applet-crypto_currencies']//a[contains(@class,'C($secondaryColor)')]")
    private ExtendedWebElement cryptoLink;

//    div[contains(@class, 'Lh(itemHeight)')]
//    @FindBy(xpath = "//div[contains(@class,'nr-applet-moreNav')]")
//    private ExtendedWebElement dropDown;

    @FindBy(xpath = "//div[@id='ybar-search-box-container']//input[1]")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//div[@id='ybar-search-box-container']//button[@id='ybar-search']")
    private ExtendedWebElement searchButton;

    public YahooFinancePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YahooCryptoPage clickCrypto() {
        cryptoLink.scrollTo();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement interferingElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("header-profile-menu")));
        cryptoLink.click();
        return new YahooCryptoPage(getDriver());
    }

    @Override
    public YahooCryptoPage search(String prompt) {
        searchBar.click();
        searchBar.type(prompt);
        searchButton.click();
        return new YahooCryptoPage(getDriver());
    }
}
