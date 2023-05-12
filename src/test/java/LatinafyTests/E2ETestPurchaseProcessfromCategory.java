package LatinafyTests;

import LatinafyPageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class E2ETestPurchaseProcessfromCategory extends BaseTest{
    @Test(description = "Select the Sports & Outdoors", priority = 1, enabled = true)
    public void tc01SelectCategory() {
        //HomePage
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select the Grocery Category
        hp.chooseCategory("Sports & Outdoors");
        CategoryPage cp = new CategoryPage(driver);
        String actual = cp.getCategoryTitle();
        String expected = "Sports & Outdoors";
        Assert.assertEquals(actual, expected);
    }
    //Select the product group from the Category and add the cart
    @Test(description = "select product group White Chocolate & Sugar Frosting", priority = 2, enabled = true)
    public void tc02SelectProductGroup() {
        CategoryPage cp = new CategoryPage(driver);
        //Select the product from the Category
       cp.selectProduct("Mundo Lona Grey Colour Folding Camping And Garden Table 60 x 60 x 60 Super Useful");
        ProductPage pp = new ProductPage(driver);
        pp.addToCart();
        String actual = pp.getAddProdMsg();
        String expected = "The product was added to your cart";
        Assert.assertEquals(actual, expected);
        pp.Checkout();
    }
    //Checkout ,Shipping and payment
    @Test(description = "Checkout,Shipping and payment",priority = 3,enabled = true)
    public void to03CheckoutShippingAndPayment() {
        SoftAssert softAssert = new SoftAssert();
        CheckoutPage chp = new CheckoutPage(driver);
        String actual1 = chp.getUrl(driver);
        String expected1 = "https://latinafy.com/checkout/";
        softAssert.assertEquals(actual1, expected1);
        chp.sleep(1000);
        chp.checkingOutAsGuest("Jose@gmail.com");
        chp.fillShippingForm("Jose Cortez", "Ha Emek 7", "koma Hei", "8888888",
                "7654321", "IL", "Central District", "Hod ha Sharon");
        String actual2 = chp.getSummary();
        System.out.println("actual2 = " + actual2);
        String expected2= "Jose Cortez\n" +
                "Ha Emek 7\n" +
                "koma Hei\n" +
                "8888888\n" +
                "7654321\n" +
                "Israel\n" +
                "Central District\n" +
                "Central District\n" +
                "Hod ha Sharon";
        softAssert.assertEquals(actual2, expected2);
        chp.clickLogoBtn();
        HomePage hp = new HomePage(driver);
        hp.open_addToCartList();
        hp.viewCart();
        CartPage crp = new CartPage(driver);
        crp.clearCart();
        crp.clickHomeBtn();
        softAssert.assertAll();
    }

}


