package LatinafyTests;

import LatinafyPageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class E2ETestPurchaseProcessfromProductGroup extends BaseTest {
    // @Test(description = "E2E testing the purchase of product from the product group", priority = 1, enabled = true)
    @Test(description = "Select the Grocery Category", priority = 1, enabled = true)
    public void tc01SelectCategory() {
        //HomePage
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select the Grocery Category
        hp.chooseCategory("Grocery");
        CategoryPage cp = new CategoryPage(driver);
        String actual = cp.getCategoryTitle();
        String expected = "Grocery";
        Assert.assertEquals(actual, expected);
    }

    //Select the subcategory Alfajores & Minicakes
    @Test(description = "select the subcategory Alfajores & Minicakes", priority = 2, enabled = true)
    public void tc02SelectSubcategory() {
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        hp.chooseCategory("Grocery");
        CategoryPage cp = new CategoryPage(driver);
        cp.selectSubCategory("Alfajores & Minicakes");
        SubCategoryPage scp = new SubCategoryPage(driver);
        String actual = scp.getCategoryTitle();
        String expected = "Alfajores & Minicakes";
        Assert.assertEquals(actual, expected);
    }

    //Select the product group from the subcategory
    @Test(description = "select product group White Chocolate & Sugar Frosting", priority = 3, enabled = true)
    public void tc03SelectProductGroup() {
        SubCategoryPage scp = new SubCategoryPage(driver);
        scp.selectSubCategory("White Chocolate & Sugar Frosting");
        ProductsGroupPage pgp = new ProductsGroupPage(driver);
        String actual = pgp.getCategoryTitle();
        String expected = "White Chocolate & Sugar Frosting";
        Assert.assertEquals(actual, expected);
        //Select the product from the product group
        pgp.selectProduct("Jorgito White Alfajor Dulce de Leche with Sugar Coating (55 g / 1.94 oz) (pack of 12)");
        ProductPage pp = new ProductPage(driver);
        pp.addToCart();
    }

    //Add to cart
    @Test(description = "Add to cart", priority = 4, enabled = true)
    public void tc04AddToCart() {
        ProductPage pp = new ProductPage(driver);
        String actual = pp.getAddProdMsg();
        String expected = "The product was added to your cart";
        Assert.assertEquals(actual, expected);
        pp.Checkout();
    }


    //Checkout ,Shipping and payment
    @Test(description = "Checkout,Shipping and payment",priority = 5,enabled = true)
    public void to05CheckoutShippingAndPayment() {
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

