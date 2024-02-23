package com.solvd.carinaexample.web.lecture;

import com.solvd.carinaexample.web.lecture.components.ProductCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage { //iphone page then i c!!

    // all iphones.. all products can be found using this //*[contains(@class, 's-card-container')].. could have used puis-card-container
    @FindBy(xpath = "//*[contains(@class, 's-card-container')]")
    private List<ProductCard> cards;
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> getCards() {
        return cards;
    }
}
