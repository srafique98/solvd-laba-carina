package com.solvd.carinaexample.web.exam;

import com.solvd.carinaexample.web.lecture.components.ProductCard;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CartTest extends AbstractTest {

    @Test
    public void verifyFirstItemInCart(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        ShopHomePage homePage = new ShopHomePage(driver);
        homePage.open();

        String title = homePage.getCardTitle(0);

        homePage.clickAddToCartButton(0);
        String card = homePage.getProductCard().getTitles().get(0).getText();
        sa.assertEquals(title,card);


        sa.assertAll();

    }
}
