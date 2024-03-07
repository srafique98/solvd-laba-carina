package com.solvd.carinaexample.web.exam;

import com.solvd.carinaexample.web.exam.component.ProductCard;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopHomePage extends AbstractPage {

    @FindBy(xpath = "//p[contains(@class,'sc-124al1g-4')]")
    private List<ExtendedWebElement> cards;

    @FindBy(xpath = "//button[contains(@class,'sc-124al1g-0')]")
    private List<ExtendedWebElement> addToCartButton;

    @FindBy(xpath = "//div[@class='sc-1h98xa9-1 kQlqIC']")
    private ProductCard productCard;
    public ShopHomePage(WebDriver driver) {
        super(driver);
    }

    public String getCardTitle(int index) {
        return cards.get(index).getText();
    }

    public void clickAddToCartButton(int index) {
        addToCartButton.get(index).click();
    }

    public ProductCard getProductCard() {
        return productCard;
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }


}
