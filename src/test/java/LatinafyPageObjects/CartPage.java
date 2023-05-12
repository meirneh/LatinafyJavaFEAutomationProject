package LatinafyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(css = ".ty-btn__secondary.text-button ")
    public WebElement clearCartBtn;
    @FindBy(css = "#det_img_1510448284")
    private WebElement logoBtn;
    @FindBy(css = "#breadcrumbs_2070  a")
    private WebElement homeBtn;
    public CartPage(WebDriver driver) {
        super(driver);
    }
    //Actions
    public void clearCart(){
        explicitWaitClickable(clearCartBtn);
        click(clearCartBtn);
    }

    public void clickLogoBtn(){
        explicitWaitClickable(logoBtn);
        click(logoBtn);
    }

    public void clickHomeBtn(){
        explicitWaitClickable(homeBtn);
        click(homeBtn);
    }

    //Validations
}
