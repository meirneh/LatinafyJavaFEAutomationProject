package LatinafyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    @FindBy(css = ".ty-float-left #languages_2061")
    private WebElement languageBtn;
    @FindBy (css = "#languages_2061 .ty-select-block__list-item")
    private List<WebElement> languages;
    @FindBy(css = ".et-category-menu.ty-float-left")
    private WebElement categoryMenu;
    @FindBy(css = "#vmenu_2133  .ty-menu__submenu-item-header")
    private WebElement grocerySubmenu;
    @FindBy(css = "#vmenu_2133 .cm-menu-item-responsive.menu-level-1  ")
    private List<WebElement>categories;
    @FindBy(css = "#sw_dropdown_24617 > a > span > span > i")
    private WebElement addToCartIconBtn;
    @FindBy(css = "#dropdown_24617 .ty-cart-content__buttons :nth-child(1) > a")
    private WebElement viewCartBtn;



    public HomePage(WebDriver driver) {
        super(driver);
    }


    //Actions
    public void openLanguageMenu(){
      // implicitWait(1000);
       explicitWaitClickable(languageBtn);
        click(languageBtn);
    }

    public void chooseLang(String language){
        for (WebElement el : languages) {
           implicitWait(1000);
            if (el.getText().equalsIgnoreCase(language)) {
                implicitWait(1000);
                moveTo(el);
                click(el);
                break;
            }

        }
    }

    public void openCategoryMenu(){
        moveTo(categoryMenu);
    }

    public void openGrocerySubmenu(){
        click(grocerySubmenu);
    }

    public void chooseCategory(String category){
        for (WebElement el:categories){
            if (el.getText().equalsIgnoreCase(category)){
                explicitWaitClickable(el);
                click(el);
                break;
            }
        }
    }

    public void open_addToCartList(){
        explicitWaitClickable(addToCartIconBtn);
        moveTo(addToCartIconBtn);
        click(addToCartIconBtn);
    }

    public void viewCart(){
        explicitWaitClickable(viewCartBtn);
        click(viewCartBtn);
    }

    //Validations
    public String getCurrentPageURL(){
        return getUrl(driver);
    }

    public void printSizeCategories(){
        System.out.println("categories.size() = " + categories.size());
    }

    public  void printCategories(){
        for (WebElement el: categories){
            System.out.println(el.getText());
        }
    }

}
