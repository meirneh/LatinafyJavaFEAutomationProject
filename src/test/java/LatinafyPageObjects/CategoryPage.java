package LatinafyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends ManagementPage{
    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".et-hover-text")
    private WebElement selectCategoryBtn;
   @FindBy(css = "#et_category_title_2181")
   private WebElement categoryTitle;
    //Actions


    //Validations

    public String getItemTxt(){
        implicitWait(1000);
        hoverOverElement(selectCategoryBtn);
        return getText(selectCategoryBtn);
    }

    public String getCategoryTitle(){
        return getText(categoryTitle);
    }
}
