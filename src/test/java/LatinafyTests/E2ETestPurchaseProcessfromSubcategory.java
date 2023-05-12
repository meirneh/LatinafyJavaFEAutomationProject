package LatinafyTests;

import LatinafyPageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class E2ETestPurchaseProcessfromSubcategory extends BaseTest {

    @Test(description = "Select Category Home, Kitchen & Garden", priority = 1, enabled = true)
    public void tc01SelectCategory() {
        //HomePage
        SoftAssert softAssert = new SoftAssert();
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.sleep(1000);
        hp.openCategoryMenu();
        hp.chooseCategory("Home, Kitchen & Garden");
        CategoryPage cp = new CategoryPage(driver);
        String actual = cp.getCategoryTitle();
        String expected = "Home, Kitchen & Garden";
        Assert.assertEquals(actual, expected);

    }

    @Test(description = "select Sub Category Asado & BBQ's", priority = 2, enabled = true)
    public void tc02SelectSubcategory() {
        CategoryPage cp = new CategoryPage(driver);
        cp.open_addToCartList();
        cp.selectSubCategory("Asado & BBQ's");
        SubCategoryPage scp = new SubCategoryPage(driver);
        String actual = scp.getCategoryTitle();
        System.out.println("SubCategory = " + actual);
        String expected = "Asado & BBQ's";
        Assert.assertEquals(actual, expected);
        // scp.selectProduct("Brasero de Mesa Acero Inoxidable Parrilla de Asado Stainless Steel Mini Hot Tray Meat Warmer");

    }

    //Select Product and Add to cart
    @Test(description = "Select product from subcategories and add to cart ", priority = 3, enabled = true)
    public void tc03SelectProductandAddToCart() {
        SubCategoryPage scp = new SubCategoryPage(driver);
        scp.selectProduct("Brasero de Mesa Acero Inoxidable Parrilla de Asado Stainless Steel Mini Hot Tray Meat Warmer");
        ProductPage pp = new ProductPage(driver);
        pp.addToCart();
        String actual = pp.getAddProdMsg();
        String expected = "The product was added to your cart";
        Assert.assertEquals(actual, expected);
        pp.Checkout();
    }

    @Test(description = "Checkout shipping and pay",priority = 4,enabled = true)
    public void tc04CheckoutShippingandPay() {
        CheckoutPage chp = new CheckoutPage(driver);
        chp.checkingOutAsGuest("Colon@gmail.com");
        chp.fillShippingForm("Cristobal Colon", "Ha Palmaj 7", "koma Vav", "999999",
                "9876543", "IL", "Southern District", "Beer Sheva");
        String actual = chp.getSummary();
        System.out.println("actual = " + actual);
        String expected = "Cristobal Colon\n" +
                "Ha Palmaj 7\n" +
                "koma Vav\n" +
                "999999\n" +
                "9876543\n" +
                "Israel\n" +
                "Southern District\n" +
                "Southern District\n" +
                "Beer Sheva";

        Assert.assertEquals(actual, expected);
        chp.clickLogoBtn();
        HomePage hp = new HomePage(driver);
        hp.open_addToCartList();
        hp.viewCart();
        CartPage crp = new CartPage(driver);
        crp.clearCart();
        crp.clickHomeBtn();

    }
}

