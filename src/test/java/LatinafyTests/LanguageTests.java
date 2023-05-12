package LatinafyTests;

import LatinafyPageObjects.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LanguageTests extends BaseTest {

    @Test
    public void tc01SelectEnglish() {
        SoftAssert softAssert = new SoftAssert();
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        String actualURL = hp.getCurrentPageURL();
        System.out.println("actualURL = " + actualURL);
        String expectedURL = "https://latinafy.com/";
        softAssert.assertEquals(actualURL, expectedURL);
        softAssert.assertAll();
    }

    @Test
    public void tc02SelectSpanish() {
        SoftAssert softAssert = new SoftAssert();
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("Spanish");
        String actualURL = hp.getCurrentPageURL();
        System.out.println("actualURL = " + actualURL);
        String expectedURL = "https://latinafy.com/es/";
        softAssert.assertEquals(actualURL, expectedURL);
        softAssert.assertAll();
    }
    @Test
    public void tc03SelectPortuguese() {
        SoftAssert softAssert = new SoftAssert();
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("Português");
        String actualURL = hp.getCurrentPageURL();
        System.out.println("actualURL = " + actualURL);
        String expectedURL = "https://latinafy.com/pt/";
        softAssert.assertEquals(actualURL, expectedURL);
        softAssert.assertAll();
    }
    @Test
    public void tc04SelectHebrew() {
        SoftAssert softAssert = new SoftAssert();
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("עברית");
        String actualURL = hp.getCurrentPageURL();
        System.out.println("actualURL = " + actualURL);
        String expectedURL = "https://latinafy.com/he/";
        softAssert.assertEquals(actualURL, expectedURL);
        softAssert.assertAll();
    }
    @Test
    public void tc05SelectJapanese() {
        SoftAssert softAssert = new SoftAssert();
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("日本語");
        String actualURL = hp.getCurrentPageURL();
        System.out.println("actualURL = " + actualURL);
        String expectedURL = "https://latinafy.com/ja/";
        softAssert.assertEquals(actualURL, expectedURL);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        softAssert.assertAll();
    }
}
