package com.solvd.carinaexample.web.horoscope;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FacebookShare extends AbstractPage {

    @FindBy(xpath = "//div[@id='loginform']//input[@type = 'text']")
    private ExtendedWebElement emailBox;

    @FindBy(xpath = "//div[@id='loginform']//input[@type = 'password']")
    private ExtendedWebElement passwordBox;

    @FindBy(xpath = "//div[@id='buttons']//input[@value = 'Log In']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//form[@id='login_form']//div[contains(@class,'fwb')]")
    private ExtendedWebElement errorMessage;

    public FacebookShare(WebDriver driver) {
        super(driver);
    }

    public void inputEmail(String prompt) {
        emailBox.click();
        emailBox.type(prompt);
    }

    public void inputPassword(String prompt) {
        passwordBox.click();
        passwordBox.type(prompt);
    }

    public void clickLogIn() {
        logInButton.click();
    }

    public ExtendedWebElement getEmailBox() {
        return emailBox;
    }

    public ExtendedWebElement getPasswordBox() {
        return passwordBox;
    }

    public ExtendedWebElement getLogInButton() {
        return logInButton;
    }

    public ExtendedWebElement getErrorMessage() {
        return errorMessage;
    }
}
