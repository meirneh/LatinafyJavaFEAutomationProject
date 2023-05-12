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

    @Test(description = "Select a product, add to the cart and remove a selected product from the cart list", priority = 6, enabled = true)
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
        cp.addToCartFromProduct("Mundo Lona Orange Pet Cot Medium Size 75 x 60 cm");
        cp.sleep(6000);
        cp.showaddToCartList();
        cp.removeSelectItemCart("Taza Scaloneta Argentina ¡Vamos Vamos, Argentina! Diseño Scaloneta Argentina Map Design - Ceramic Cup Printed On Both Sides");

    }

}
