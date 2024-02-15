package com.solvd.carinaexample.web.assignment;

import com.solvd.carinaexample.web.assignment.base.YahooCryptoPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooCryptoPage extends YahooCryptoPageBase {
    @FindBy(xpath = ".//div[@id=\"quote-header-info\"]//h1")
    private ExtendedWebElement name;
    public YahooCryptoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String readName() {
        return name.getText();
    }
}
