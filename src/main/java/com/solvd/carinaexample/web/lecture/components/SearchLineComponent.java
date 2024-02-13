package com.solvd.carinaexample.web.lecture.components;

import com.solvd.carinaexample.web.lecture.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {
    // not able create instance using new keyword cuz all these fields should be initalized automaticaly

    // dont need full path anymore cuz of Header class and HomePage class
    // "//header//*[@id='nav-search']//*[@id='searchDropdownBox']"
    // need . at beginning cuz telling xpath to find element starting from currect content not from root of html tree
    // Header class has . as well but not HomePage cuz we starting from root in HomePage class
//    @FindBy(xpath = ".//*[@id='searchDropdownBox']")
    @FindBy(xpath = ".//*[@id='nav-search-dropdown-card']")
    private ExtendedWebElement productTypeSelect;
    @FindBy(xpath = ".//input[@id='twotabsearchtextbox']")
    private  ExtendedWebElement searchInput;
    @FindBy(xpath = ".//*[@id='nav-search-submit-button']")
    private  ExtendedWebElement searchButton;

    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductTypeSelect() {
        return productTypeSelect;
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }

    public String getSearchInputPlaceholder(){
        return searchInput.getAttribute("placeholder");
    }

    public void typeSearchInputValue(String value){
        searchInput.type(value);
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public SearchPage clickSearchButton(){
        searchButton.click();
        return new SearchPage(getDriver()); // getDriver() is from extends AbstractUIObject
    }
}
