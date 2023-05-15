package LatinafyTests;

import LatinafyPageObjects.CategoryPage;
import LatinafyPageObjects.HomePage;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.bouncycastle.pqc.jcajce.provider.Rainbow;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectAndPurchaseProductFromPage extends BaseTest {
    @Test(description = "Select and addToCart directly from the page", priority = 1, enabled = true)
    public void tc01SelOneProd() {
        //HomePage
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select the Grocery Category
        hp.chooseCategory("Grocery");
        CategoryPage cp = new CategoryPage(driver);
        //Select The Product directly from the Page and add him to Cart
        cp.sleep(5000);
        String quantity_before = cp.getAddToCartCounter();
        System.out.println("quantity before add =  " + quantity_before);
        //cp.sleep(10000);
        cp.addToCartFromProduct("Pico Dulce Chupetín Fruit Rainbow Lollipop, 672 g / 23.7 oz (box of 48)");
        cp.sleep(8000);
        String quantity_after = cp.getAddToCartCounter();
        System.out.println("quantity after add  = " + quantity_after);
        String expected = "1";
        Assert.assertEquals(quantity_after, expected);
        cp.removeItemfromCartList();
        cp.backHome();

    }

    @Test(description = "Select and addToCart directly from the page more than one product", priority = 2, enabled = true)
    public void tc02SelMoreThanOneProd() {
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select the Grocery Category
        hp.chooseCategory("Grocery");
        CategoryPage cp = new CategoryPage(driver);
        //Select The 1rst Product directly from the Page and add him to Cart
        String quantity_before = cp.getAddToCartCounter();
        System.out.println("quantity before add =  " + quantity_before);
        cp.addToCartFromProduct("Bon o Bon Surtido Assorted Chocolate Bites White Chocolate, Milk Chocolate, Chocolinas Cookies & Águila Chocolate Bites, 255 g / 8.9 oz");
        cp.sleep(8000);
        //Select The 2nd Product directly from the Page and add him to Cart
        cp.addToCartFromProduct("La Serenisima Dulce de Leche Classic, Soft Recipe (400 g / 14.1 oz)");
        cp.sleep(8000);
        String quantity_after = cp.getAddToCartCounter();
        System.out.println("quantity after add  = " + quantity_after);
        String expected = "2";
        Assert.assertEquals(quantity_after, expected);
        cp.removeItemfromCartList();
        cp.sleep(2000);
        cp.removeItemfromCartList();
        cp.backHome();
    }

    @Test(description = "Select and addToCart directly from the page and remove", priority = 3, enabled = true)
    public void tc03SelProd_addToCart_Remove() {
        HomePage hp = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select the Sports & Outdoors
        hp.chooseCategory("Sports & Outdoors");
        CategoryPage cp = new CategoryPage(driver);
        //Select The Product directly from the Page and add him to Cart
        String quantity_before = cp.getAddToCartCounter();
        System.out.println("quantity before add =  " + quantity_before);
        cp.addToCartFromProduct("Mundo Lona Grey Colour Folding Camping And Garden Table 60 x 60 x 60 Super Useful");
        cp.sleep(6000);
        String quantity_after = cp.getAddToCartCounter();
        System.out.println("quantity after add  = " + quantity_after);
        cp.removeItemfromCartList();
        String actual = cp.getRemoveItemMsg();
        System.out.println("remove message  : " + actual);
        String expected = "×\n" +
                "NoticeProduct has been deleted successfully.";
        softAssert.assertEquals(actual, expected);
        String actualQuantity_afterRemove = cp.getAddToCartCounter();
        System.out.println("quantity after remove = " + actualQuantity_afterRemove);
        String expectedQuantity_afterRemove = "0";
        Assert.assertEquals(actualQuantity_afterRemove, expectedQuantity_afterRemove);
        softAssert.assertAll();
        cp.backHome();

    }

    @Test(description = "Select, increase quantity and addToCart directly from the page", priority = 4, enabled = true)
    public void tc04SelProdIncr_Quant_addToCart() {
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select Mates & Yerba Mate
        hp.chooseCategory("Mates & Yerba Mate");
        CategoryPage cp = new CategoryPage(driver);
        //Select The Product and increase the quantity  directly from the Page and add him to Cart
        String quantity_before = cp.getAddToCartCounter();
        System.out.println("quantity before add =  " + quantity_before);
        cp.Incr_addToCartFromProduct("Cruz de Malta Yerba Mate Wide Leaf - Since 1874, 1 kg / 2.2 lb", 2);
        cp.sleep(6000);
        String quantity_afterIncrease = cp.getAddToCartCounter();
        System.out.println("quantity after add and increase  = " + quantity_afterIncrease);
        String expected_Increase = "3";
        Assert.assertEquals(quantity_afterIncrease, expected_Increase);
        cp.removeItemfromCartList();
        cp.backHome();

    }

    @Test(description = "Select and add to cart products from different categories", priority = 5, enabled = true)
    public void tc05Select_and_addToCartFromCategories() {
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select the Grocery Category
        hp.chooseCategory("Grocery");
        CategoryPage cp = new CategoryPage(driver);
        cp.addToCartFromProduct("Pico Dulce Chupetín Fruit Rainbow Lollipop, 672 g / 23.7 oz (box of 48)");
        cp.sleep(8000);
        //Select the Sports & Outdoors
        cp.openCategoryMenu();
        cp.chooseCategory("Sports & Outdoors");
        cp.addToCartFromProduct("Mundo Lona Grey Colour Folding Camping And Garden Table 60 x 60 x 60 Super Useful");
        cp.sleep(6000);
        //Select Mates & Yerba Mate
        cp.openCategoryMenu();
        cp.chooseCategory("Mates & Yerba Mate");
        cp.addToCartFromProduct("Armiño Yerba Mate Classic - Bold Yerba Traditional in Uruguay, 1 kg / 2.2 lb");
        cp.sleep(6000);
        //Show the products in the cart
        cp.showaddToCartList();
        cp.sleep(4000);
        List<String> actualListItems3 = cp.getNamesItemsInCart();
        System.out.println("the items in the cart are: " + actualListItems3);
        List<String> expectedListItems3 = new ArrayList<>(Arrays.asList(
                "Armiño Yerba Mate Classic - Bold Yerba Traditional in Uruguay, 1 kg / 2.2 lb",
                "Mundo Lona Grey Colour Folding Camping And Garden Table 60 x 60 x 60 Super Useful",
                "Pico Dulce Chupetín Fruit Rainbow Lollipop, 672 g / 23.7 oz (box of 48)"
        ));
        Assert.assertEquals(expectedListItems3, actualListItems3);
        cp.showaddToCartList();
        cp.removeItemfromCartList();
        cp.sleep(2000);
        cp.removeItemfromCartList();
        cp.sleep(2000);
        cp.removeItemfromCartList();
        cp.backHome();

    }

    @Test(description = "Select a product, add to the cart and remove a selected product from the cart list", priority = 6, enabled = false)
    public void tc06Select_addToCart_RemoveSelectedItem() {
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select Grocery Category
        hp.chooseCategory("Grocery");
        CategoryPage cp = new CategoryPage(driver);
        cp.addToCartFromProduct("Cachafaz Conitos de Dulce de Leche - Cookies based w/dulce de Leche covered in Chocolate - 228g (6u.)");
        cp.sleep(8000);
        //Select Home, Kitchen & Garden Category
        cp.openCategoryMenu();
        cp.chooseCategory("Home, Kitchen & Garden");
        cp.addToCartFromProduct("Taza Scaloneta Argentina ¡Vamos Vamos, Argentina! Diseño Scaloneta Argentina Map Design - Ceramic Cup Printed On Both Sides");
        cp.sleep(6000);
        //Select Pets Category
        cp.openCategoryMenu();
        cp.chooseCategory("Pets");
        cp.sleep(2000);
        cp.addToCartFromProduct("Mundo Lona Orange Pet Cot Medium Size 75 x 60 cm");
        cp.sleep(6000);
        cp.showaddToCartList();
        cp.removeSelectItemCart("Taza Scaloneta Argentina ¡Vamos Vamos, Argentina! Diseño Scaloneta Argentina Map Design - Ceramic Cup Printed On Both Sides");
    }

    @Test(description = "Navigate to the next page, select product add to cart", priority = 7, enabled = true)
    public void tc07GoToNxtPgSelectProd_addToCart() {
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select Grocery Category
        hp.chooseCategory("Grocery");
        CategoryPage cp = new CategoryPage(driver);
        cp.goToNextPage();
        cp.sleep(2000);
        cp.addToCartFromProduct("Cagnoli Salamín Salame Tandil Picado Fino, 1 unit");
        cp.sleep(8000);
        String actualPage = cp.getCurrentPageURL();
        System.out.println("actualPage = " + actualPage);
        String expectedPage = "https://latinafy.com/grocery/page-2/";
        Assert.assertEquals(actualPage, expectedPage);
        cp.removeItemfromCartList();
        cp.backHome();
    }

    @Test(description = "Navigate to the prev page, select product add to cart", priority = 8, enabled = true)
    public void tc08GoToPrevPage() {
        SoftAssert softAssert = new SoftAssert();
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select Home, Kitchen & Garden
        hp.chooseCategory("Home, Kitchen & Garden");
        CategoryPage cp = new CategoryPage(driver);
        String actualPage1 = cp.getCurrentPageURL();
        System.out.println("actual page before go to the next page: " + actualPage1);
        cp.goToNextPage();
        cp.sleep(2000);
        String actualPage2 = cp.getCurrentPageURL();
        System.out.println("actual page after go to the next page: " + actualPage2);
        cp.sleep(2000);
        String expectPage2 = "https://latinafy.com/home-kitchen-and-garden/page-2/";
        softAssert.assertEquals(actualPage2, expectPage2);
        cp.goToPrevPage();
        cp.sleep(2000);
        String actualPage3 = cp.getCurrentPageURL();
        System.out.println("actual page after back  to the previous page: " + actualPage3);
        String expectPage3 = "https://latinafy.com/home-kitchen-and-garden/";
        softAssert.assertEquals(actualPage3, expectPage3);
        softAssert.assertAll();
        cp.backHome();

    }

    @Test(description = "Navigate to the different selected pages by the number", priority = 9, enabled = true)
    public void tc09GoToPageNum() {
        SoftAssert softAssert = new SoftAssert();
        HomePage hp = new HomePage(driver);
        hp.openLanguageMenu();
        hp.chooseLang("English");
        hp.openCategoryMenu();
        //Select Home, Kitchen & Garden
        hp.chooseCategory("Home, Kitchen & Garden");
        CategoryPage cp = new CategoryPage(driver);
        cp.goToPage("8");
        cp.sleep(2000);
        String actualPage1 = cp.getCurrentPageURL();
        System.out.println("actualPage1 = " + actualPage1);
        String expectPage1 = "https://latinafy.com/home-kitchen-and-garden/page-8/";
        softAssert.assertEquals(actualPage1, expectPage1);
        cp.goToPage("15");
        cp.sleep(2000);
        String actualPage2 = cp.getCurrentPageURL();
        System.out.println("actualPage2 = " + actualPage2);
        String expectPage2 = "https://latinafy.com/home-kitchen-and-garden/page-15/";
        softAssert.assertEquals(actualPage2, expectPage2);
        cp.goToPage("22");
        cp.sleep(2000);
        String actualPage3 = cp.getCurrentPageURL();
        System.out.println("actualPage3 = " + actualPage3);
        String expectPage3 = "https://latinafy.com/home-kitchen-and-garden/page-22/";
        softAssert.assertEquals(actualPage3, expectPage3);
        cp.goToPage("28");
        cp.sleep(2000);
        String actualPage4 = cp.getCurrentPageURL();
        System.out.println("actualPage4 = " + actualPage4);
        String expectPage4 = "https://latinafy.com/home-kitchen-and-garden/page-28/";
        softAssert.assertEquals(actualPage4, expectPage4);
        cp.goToPage("22");
        cp.sleep(2000);
        String actualPage5 = cp.getCurrentPageURL();
        System.out.println("actualPage5 = " + actualPage5);
        String expectPage5 = "https://latinafy.com/home-kitchen-and-garden/page-22/";
        softAssert.assertEquals(actualPage5, expectPage5);
        cp.goToPage("15");
        cp.sleep(2000);
        String actualPage6 = cp.getCurrentPageURL();
        System.out.println("actualPage6 = " + actualPage6);
        String expectPage6 = "https://latinafy.com/home-kitchen-and-garden/page-15/";
        softAssert.assertEquals(actualPage6, expectPage6);
        cp.goToPage("8");
        cp.sleep(2000);
        String actualPage7 = cp.getCurrentPageURL();
        System.out.println("actualPage7 = " + actualPage7);
        String expectPage7 = "https://latinafy.com/home-kitchen-and-garden/page-8/";
        softAssert.assertEquals(actualPage7, expectPage7);
        cp.goToPage("1");
        cp.sleep(2000);
        String actualPage8 = cp.getCurrentPageURL();
        System.out.println("actualPage8 = " + actualPage8);
        String expectPage8 = "https://latinafy.com/home-kitchen-and-garden/";
        softAssert.assertEquals(actualPage8, expectPage8);
        softAssert.assertAll();
        cp.backHome();
    }

}
