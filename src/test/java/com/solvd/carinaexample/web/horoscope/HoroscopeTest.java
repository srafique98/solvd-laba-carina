package com.solvd.carinaexample.web.horoscope;

import com.solvd.carinaexample.web.horoscope.components.ZodiacImage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HoroscopeTest extends AbstractTest {

    @Test
    public void verifyAllZodiacSigns(){
        int numOfZodiacs = 12;
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HoroscopeHomePage homePage = new HoroscopeHomePage(driver);
        homePage.open();

        List<ZodiacImage> cards = homePage.getzCards();
        sa.assertTrue(cards.size() == numOfZodiacs, "There should be exactly 12 zodiac cards");

        List<String> titles = cards.stream().flatMap(card -> card.getZodiacText().stream()).collect(Collectors.toList());
        sa.assertTrue(titles.size() == numOfZodiacs, "There should be exactly 12 zodiac signs");

        List<String> dates = cards.stream().flatMap(card -> card.getZodiacDateText().stream()).collect(Collectors.toList());
        sa.assertTrue(dates.size() == numOfZodiacs, "There should be exactly 12 zodiac dates");

        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            String date = dates.get(i);
            sa.assertTrue(isTitleOneOfZodiacSigns(title, i), "Title does not match expected Zodiac sign.");
            sa.assertTrue(isDateMatchingZodiacSign(date, i), "Date does not match expected date range.");
        }
        sa.assertAll();
    }

    public static boolean isTitleOneOfZodiacSigns(String title, int index) {
        return title.toLowerCase().contains(ZodiacSign.values()[index].getSign().toLowerCase());
    }

    public static boolean isDateMatchingZodiacSign(String date, int index) {
        return date.toLowerCase().contains(ZodiacSign.values()[index].getDateRange().toLowerCase());
    }

    @Test
    public void verifyAllZodiacSignLinks(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HoroscopeHomePage homePage = new HoroscopeHomePage(driver);
        homePage.open();

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(formatter);
        List<ZodiacImage> cards = homePage.getzCards();

        for (int i = 0; i < cards.size(); i++) {
            ZodiacImage card = cards.get(i);
//            String zName = card.getZodiacName().get(0).getText().toLowerCase();
            String expectedUrl = String.format("%s/daily-%s.html", ZodiacSign.values()[i].getUrl(), formattedDate);
//            System.out.println(expectedUrl);

            ZodiacPage zodiacPage = card.clickCard();
            Assert.assertEquals(driver.getCurrentUrl().toLowerCase(),expectedUrl.toLowerCase(), "Not expected URL");
            Assert.assertTrue(zodiacPage.getDailyTab().isElementPresent(1),"Daily tab is not present");
            Assert.assertTrue(zodiacPage.getWeeklyTab().isElementPresent(1),"Weekly tab is not present");
            Assert.assertTrue(zodiacPage.getMonthlyTab().isElementPresent(1),"Monthly tab is not present");

            sa.assertTrue(zodiacPage.getShareByButtons().size() == 3, "Should have 3 share buttons in total");
            zodiacPage.goBack();
        }
        sa.assertAll();
    }

    @Test
    public void verifyAllShareButtons(){
        WebDriver driver = getDriver();
        HoroscopeHomePage homePage = new HoroscopeHomePage(driver);
        homePage.open();
        List<ZodiacImage> cards = homePage.getzCards();

        for (int i = 0; i < cards.size(); i++) {
            ZodiacImage card = cards.get(i);
            ZodiacPage zodiacPage = card.clickCard();
            List<ExtendedWebElement> shareButtons = zodiacPage.getShareByButtons();

            for (ExtendedWebElement shareButton : shareButtons) {
                String socialSite = shareButton.getAttribute("data-sharetype");
                Assert.assertTrue(shareButton.isElementPresent(1),socialSite + " Icon not Present");
                Assert.assertTrue(socialSite.equalsIgnoreCase("facebook") ||
                                                socialSite.equalsIgnoreCase("twitter") ||
                                                socialSite.equalsIgnoreCase("pinterest"),
                        "Unexpected social site: " + socialSite);
                switch (socialSite.toLowerCase()) {
                    case "facebook":
                        FacebookShare facebookPage = zodiacPage.clickFaceBookShare();
                        String currentHandle = driver.getWindowHandle();
                        Set<String> allHandles = driver.getWindowHandles();
                        for (String handle : allHandles) {
                            if (!handle.equals(currentHandle)) {
                                driver.switchTo().window(handle);
                                Assert.assertEquals(facebookPage.getEmailBox().getAttribute("name"), "email", "Log in field should include email placeholder.");
                                Assert.assertEquals(facebookPage.getPasswordBox().getAttribute("name"), "pass", "Password field should include pass placeholder.");
                                Assert.assertEquals(facebookPage.getLogInButton().getAttribute("name"), "login", "Login button should include login placeholder.");
                                facebookPage.inputEmail("nooo@gmail.com");
                                facebookPage.inputPassword("no");
                                facebookPage.clickLogIn();
                                Assert.assertTrue(facebookPage.getErrorMessage().getText().toLowerCase().contains("incorrect email") ||
                                                facebookPage.getErrorMessage().getText().toLowerCase().contains("phone number")
                                        ,"Facebook login error messages do not match");
                                driver.close();
                            }
                        }
                        driver.switchTo().window(currentHandle);
                        System.out.println("Sharing on Facebook");
                        break;
                    case "twitter":
                        TwitterShare twitterPage = zodiacPage.clickTwitterShare();
                        System.out.println("Sharing on Twitter");
                        break;
                    case "pinterest":
                        System.out.println("Sharing on Pinterest");
                        break;
                }
//                break;

            }
            zodiacPage.goBack();
//            break;
        }
    }



}
