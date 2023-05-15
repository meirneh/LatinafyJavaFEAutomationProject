package LatinafyPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ManagementPage extends BasePage {
    //Categories
    @FindBy(css = ".et-category-menu.ty-float-left")
    private WebElement categoryMenu;
    @FindBy(css = "#vmenu_2133 .cm-menu-item-responsive.menu-level-1  ")
    private List<WebElement> categories;
    //Products
    //@FindBy(css = ".ty-grid-list__item.ty-quick-view-button__wrapper.et-grid-item")
    @FindBy(css = ".et-column4.et-grid-item-wrapper")
    private List<WebElement> containerProduct;
    @FindBy(css = ".et-grid-info-wrapper > div.et-grid-product-name > bdi > a")
    private WebElement productTitle;
    @FindBy(css = ".et-add-to-cart.et-in-stock")
    private WebElement ProdaddToCartBTn;
    @FindBy(css = "#button_cart_3150")
    //Categories/Subcategories
    private WebElement productName;
    @FindBy(css = ".ty-subcategories__item")
    private List<WebElement> subcategories;
    @FindBy(css = ".et-hover-text")
    private WebElement selectCategoryBtn;
    @FindBy(css = "#et_category_title_2181")
    private WebElement categoryTitle;
    //addtoCart
    @FindBy(css = "#sw_dropdown_24617 > a > span > span > span.et-cart-content")
    private WebElement addToCartIconBtn;
    @FindBy(css = "#sw_dropdown_24617 > a > span > span > i")
    private WebElement showListaddToCartBtn;
    @FindBy(css = ".et-product-left .et-product-atc")
    private WebElement addToCartBtn;
    @FindBy(css = "#cart_status_24617")
    private WebElement addToCartCounter;
    @FindBy(css = "#dropdown_24617")
    private List<WebElement> itemsInCartList;
    @FindBy(css = "#dropdown_24617 .ty-cart-items__list-item-desc a")
    private List<WebElement> itemsNamesInCart;
    @FindBy(css = "#qty_count_3172")
    private WebElement quantityField;
    @FindBy(css = "#dropdown_24617 .ty-cart-items__list-item-desc ")
    private WebElement nameItemCart;
    @FindBy(css = "#dropdown_24617 .ty-cart-items__list-item-tools.cm-cart-item-delete > a > i")
    private WebElement removeItemsCartBtn;
    @FindBy(css = ".cm-auto-hide")
    private WebElement removeItemMsg;
    @FindBy(css = "#qty_3172 .ty-value-changer__decrease")
    private WebElement decreaseBtn;
    @FindBy(css = "#qty_3172 .ty-value-changer__increase")
    private WebElement increaseBtn;
    @FindBy(css = ".cm-notification-content >h1")
    private WebElement addedProdMsg;
    @FindBy(css = ".notification-body-extended .et-icon-check")
    private WebElement checkoutBtn;
    @FindBy(css = ".ty-btn__secondary.cm-notification-close ")
    private WebElement continueBtn;
    @FindBy(css = ".cm-notification-close.close")
    private WebElement closeNotificationBtn;
    @FindBy(css = "#button_wishlist_3172")
    private WebElement wishing_listBtn;
    //Products
    @FindBy(css = ".et-grid-item-wrapper")
    private List<WebElement> products;
    @FindBy(css = " .et-grid-product-name")
    private List<WebElement> prod_names;
    @FindBy(css = "#breadcrumbs_2070  a")
    private WebElement homeBtn;
    //Pagination
    @FindBy(css = ".ty-pagination__bottom .et-icon-pag-left")
    private WebElement paginationLeftBtn;
    @FindBy(css = ".ty-pagination__bottom .et-icon-pag-right")
    private WebElement paginationRightBtn;
    @FindBy(css = ".ty-pagination__bottom  a")
    private List<WebElement>pages;


    public ManagementPage(WebDriver driver) {
        super(driver);
    }
//actions

    public void openCategoryMenu() {
        moveTo(categoryMenu);
    }


    public void chooseCategory(String category) {
        for (WebElement el : categories) {
            if (el.getText().equalsIgnoreCase(category)) {
                explicitWaitClickable(el);
                click(el);
                break;
            }
        }
    }

    public void open_addToCartList() {
        explicitWaitClickable(addToCartIconBtn);
        moveTo(addToCartIconBtn);
        click(addToCartIconBtn);
    }

    public void selectSubCategory(String subcategory) {
        for (WebElement el : subcategories) {
            implicitWait(500);
            if (el.getText().equalsIgnoreCase(subcategory)) {
                click(el);
                break;
            }

        }
    }


    public void printSubCategory(String subcategory) {
        for (WebElement el : subcategories) {
            implicitWait(500);
            if (el.getText().equalsIgnoreCase(subcategory)) {
                System.out.println("The selected product is: " + el.getText());
                break;
            }

        }
    }


    public void printSubCategories() {
        for (WebElement el : subcategories) {
            implicitWait(2000);
            System.out.println(el.getText());

        }

    }

    public void printProductsList() {
        for (WebElement el : prod_names) {
            implicitWait(1000);
            System.out.println(el.getText());
        }
    }

    public void selectProduct(String product) {
        for (WebElement el : prod_names) {
            implicitWait(1000);
            if (el.getText().equalsIgnoreCase(product)) {
                click(el);
                break;
            }
        }
    }

    public void addToCartFromProduct(String product) {
        implicitWait(3000);
        for (WebElement el : containerProduct) {
            WebElement title = el.findElement(By.cssSelector(":nth-child(1) .et-grid-product-name"));
            WebElement ProdaddToCartBTn = el.findElement(By.cssSelector(".et-add-to-cart.et-in-stock"));
            implicitWait(5000);
            if (title.getText().equalsIgnoreCase(product)) {
                System.out.println("PRODUCT = " + title.getText());
                hoverOverElement(ProdaddToCartBTn);
                click(ProdaddToCartBTn);
                implicitWait(5000);
                break;
            }

        }
    }

    public void Incr_addToCartFromProduct(String product, int times) {
        for (WebElement el : containerProduct) {
            WebElement title = el.findElement(By.cssSelector(":nth-child(1) .et-grid-product-name"));
            WebElement ProdaddToCartBTn = el.findElement(By.cssSelector(".et-add-to-cart.et-in-stock"));
            WebElement btn = el.findElement(By.cssSelector(".cm-increase.ty-value-changer__increase"));
            if (title.getText().equalsIgnoreCase(product)) {
                System.out.println("PRODUCT = " + title.getText());
                for (int i = 0; i < times; i++) {
                    hoverOverElement(btn);
                    explicitWaitClickable(btn);
                    click(btn);
                }
                hoverOverElement(ProdaddToCartBTn);
                click(ProdaddToCartBTn);
                implicitWait(5000);
                break;
            }

        }
    }


    public void PrintProduct() {
        implicitWait(3000);
        for (WebElement productTitle : containerProduct) {
            implicitWait(3000);
            System.out.println(productTitle.getText());

        }
    }


    public void printFromProduct() {
        for (WebElement el : containerProduct) {
            System.out.println(el.getText());
        }
    }


    public void addToCart() {
        click(addToCartBtn);
    }

    public void showaddToCartList() {
        implicitWait(1000);
        hoverOverElement(addToCartIconBtn);
        click(addToCartIconBtn);
    }

    public void removeItemfromCartList() {
        showaddToCartList();
        implicitWait(2000);
        hoverOverElement(nameItemCart);
        hoverOverElement(removeItemsCartBtn);
        click(removeItemsCartBtn);
    }



    public void Checkout() {
        explicitWaitClickable(checkoutBtn);
        click(checkoutBtn);
    }

    public void backHome() {
        hoverOverElement(homeBtn);
        explicitWaitClickable(homeBtn);
        click(homeBtn);
    }

    public void printItemsInCart() {
        implicitWait(1000);
        for (WebElement el : itemsInCartList) {
            System.out.println(el.getText());
        }
    }


    public void printNamesItemsInCart() {
        for (WebElement el : itemsNamesInCart) {
            System.out.println(el.getText());
        }

    }


 public void removeSelectItemCart(String title){
     implicitWait(1000);
     for (WebElement el : itemsInCartList) {
         WebElement removeBtn = el.findElement(By.cssSelector("#dropdown_24617 .ty-cart-items__list-item-tools.cm-cart-item-delete > a > i"));
         WebElement itemName = el.findElement(By.cssSelector("#dropdown_24617 .ty-cart-items__list-item-desc > a"));
         if (itemName.getText().equalsIgnoreCase(title)){
             System.out.println("itemName = " + itemName);
             explicitWaitVisible(itemName);
             hoverOverElement(itemName);
             explicitWaitVisible(removeBtn);
             hoverOverElement(removeBtn);
             click(removeBtn);
             break;
         }

     }

 }
  public void goToNextPage(){
        explicitWaitClickable(paginationRightBtn);
        click(paginationRightBtn);
        implicitWait(2000);
  }

  public void goToPrevPage(){
        explicitWaitClickable(paginationLeftBtn);
        click(paginationLeftBtn);
        implicitWait(2000);
  }

  public void goToPage(String pageNum){
        for (WebElement el :pages){
            if (el.getText().equals(pageNum)){
                explicitWaitClickable(el);
                click(el);
                System.out.println("page:  " + el.getText());
                break;
            }
        }

  }

    //Validations
    public void list() {
        System.out.println(subcategories.size());
    }

    public String getItemTxt() {
        implicitWait(1000);
        hoverOverElement(selectCategoryBtn);
        return getText(selectCategoryBtn);
    }

    public String getAddToCartCounter() {
        implicitWait(3000);
        return getText(addToCartCounter);
    }

    public String getAddProdMsg() {
        implicitWait(3000);
        return getText(addedProdMsg);
    }

    public String getCurrentPageURL() {
        implicitWait(2000);
        return getUrl(driver);
    }

    public String getCategoryTitle() {
        implicitWait(3000);
        return getText(categoryTitle);
    }


    public String getRemoveItemMsg() {
        implicitWait(1000);
        return getText(removeItemMsg);
    }
    public ArrayList<String> getNamesItemsInCart() {
        ArrayList<String> Itemnames = new ArrayList<>();
        for (WebElement el : itemsNamesInCart) {
            Itemnames.add(el.getText());
        }
        return Itemnames;
    }



}
