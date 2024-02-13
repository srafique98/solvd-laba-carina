package com.solvd.carinaexample.web.lecture;

import com.solvd.carinaexample.web.lecture.HomePage;
import com.solvd.carinaexample.web.lecture.SearchPage;
import com.solvd.carinaexample.web.lecture.components.ProductCard;
import com.solvd.carinaexample.web.lecture.components.SearchLineComponent;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends AbstractTest {
    @Test
    public void verifySearchLineTest(){
//        no need for this anymore because HomePage extends AbstractPage.. instead use new keyword
//        HomePage page = PageFactory.initElements(driver, HomePage.class);
//        System.setProperty("webdriver.chrome.driver", "/Applications/selenium/chromedriver");
//        WebDriver driver = new ChromeDriver();

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

//        driver.navigate().back();
//        driver.navigate().refresh();
////        driver.manage().window().setSize(new Dimension(5,5));
////        click on link and it opens in new tab we need to switch to the new tab
//        String currentHandle = driver.getWindowHandle(); // get current tab identifier
//        Set<String> allHandles = driver.getWindowHandles();
//        // iterate through allHandles when find currentHandle then +1 to index cuz it usually opens next to tab
//        driver.close(); // close new tab that open after ur done with it
//        driver.switchTo().window(currentHandle); // switching to original tsb
//
//        //delenium knows when clicking on a content it will open new tab on side called Iframe.. provide identifer or nameof the content the open new tab
//        driver.switchTo().frame()
        
//        2 types of waiters
//                1. implicit wait -- send to web driver directly.. selenium waits until desire element appears on page
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                2. explicit wait
//                new WebDriverWait(driver, Duration.ofSeconds(10))
//                        .pollingEvery(Duration.ofMillis(100)) // this driver will work 10 secs and do some action every 100 milli secound
//                        .until(d -> !spinner.isElementPresent(1));

        HomePage page = new HomePage(driver);
        page.open();
//        driver.get("google.com");
        // check if all search line component exist.. the select.. input.. and the button
        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        //checking if searchline component exist.. searchLineComponent is an AbstractUIObject (extends it check ur SearchLineComponent.. u created it)
        sa.assertTrue(searchLineComponent.getRootExtendedElement().isElementPresent(1)); //getRootExtendedElement() -- returns element of whole of our component
        // or check if this select (all drop down) exist on amazon page could use bottom or top.. i prefer bottom
        sa.assertTrue(searchLineComponent.getProductTypeSelect().isElementPresent(1),"Product type select is not present");
        // next check if input button exist
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(1),"Search Input is not present");
        // search line has placeholder attribute placeholder=Search Amazon.. using getAttribute() from ExtendedWebElement
        sa.assertEquals(searchLineComponent.getSearchInputPlaceholder(),"Search Amazon","Search input has incorrect placeholder");
        Assert.assertTrue(searchLineComponent.getSearchButton().isElementPresent(1),"Search Button is not present");

        searchLineComponent.typeSearchInputValue("iPhone");
        SearchPage searchPage = searchLineComponent.clickSearchButton();

        //checks if new page url contains iphone in url
        sa.assertTrue(driver.getCurrentUrl().toLowerCase().contains("iPhone".toLowerCase()),"url does not contain the brand name: iphone");
        //checking if each product card title has brand name: "iphone" in it as well
        List<ProductCard> cards = searchPage.getCards();
        for (ProductCard card: cards){
//            System.out.println(card.getTitleText());
//            System.out.println(card.getTitleElement());
//            System.out.println(card.getTitle());
            sa.assertTrue(card.getTitleText().toLowerCase().contains("iPhone".toLowerCase()),String.format("Product with name '%s' doesnt contain the brand name in its title", card.getTitleText()));
        }
        sa.assertAll();
    }
}
