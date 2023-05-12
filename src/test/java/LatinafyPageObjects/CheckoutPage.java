package LatinafyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(css = "#checkout_info_products_16183 > ul > li:nth-child(2) > div > a > i")
    private WebElement remove_prodBtn;
    //Customer Form
    @FindBy(css = "#litecheckout_step_customer_info #litecheckout_email")
    private WebElement emailField;
    @FindBy(css = ".sd-checkout-body__button-container")
    private WebElement continueAsGuestBtn;
    //Shipping Form
    @FindBy(css = ".shipping-first-name")
    private WebElement first_lastNameField;
    @FindBy(css = ".shipping-address")
    private WebElement addressField;
    @FindBy(css = "#litecheckout_s_address_2")
    private WebElement apartmentField;
    @FindBy(css = "#litecheckout_s_zipcode")
    private WebElement zipField;
    @FindBy(css = "#litecheckout_s_phone")
    private WebElement phoneNumberField;
    @FindBy(css = ".litecheckout__field--small #litecheckout_country")
    private WebElement countrySelect;
    @FindBy(css = ".cm-field-container #litecheckout_state")
    private WebElement stateSelect;
    @FindBy(css = ".litecheckout__group #litecheckout_city")
    private WebElement cityField;
    @FindBy(css = "#form-sbs-step-2  button")
    private WebElement continueBtn;
    @FindBy(css = "#shipping_rates_list")
    private WebElement updateShippingBtn;
    @FindBy(css = ".notification-container  button")
    private WebElement closeNotificationButton;
    //Payment form
    @FindBy(css = "#credit_card_number_16")
    private WebElement credit_cardNumberField;
    @FindBy(css = "#credit_card_month_16")
    private WebElement credit_cardMonthField;
    @FindBy(css = "#credit_card_year_16")
    private WebElement credit_cardYearField;
    @FindBy(css = "#credit_card_name_16")
    private WebElement credit_cardNameField;
    @FindBy(css = "#credit_card_cvv2_16")
    private WebElement credit_cardCode_cvvField;
    @FindBy(css = ".cm-check-agreement")
    private WebElement acceptCheckbox;
    @FindBy(css = "#form-sbs-step-4 .litecheckout__submit-btn ")
    private WebElement payBtn;
    @FindBy(css = ".step_2 .sd-checkout-header__content")
    private WebElement summary;
    @FindBy(css = "#breadcrumbs_2070  a")
    private WebElement backHomeBtn;
    @FindBy(css = "#det_img_1510448284")
    private WebElement logoBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void checkingOutAsGuest(String email) {
        implicitWait(1000);
        explicitWaitClickable(emailField);
        fillText(emailField, email);
        implicitWait(1000);
        click(continueAsGuestBtn);
    }

    public void fillShippingForm(String name, String address, String apartment, String zipCode, String phoneNumber, String country, String district, String city) {
        fillText(first_lastNameField, name);
        fillText(addressField, address);
        fillText(apartmentField, apartment);
        fillText(zipField, zipCode);
        fillText(phoneNumberField, phoneNumber);
        selectByValue(countrySelect, country);
        selectByValue(stateSelect, district);
        explicitWaitClickable(cityField);
        fillText(cityField, city);
        click(updateShippingBtn);
        explicitWaitClickable(continueBtn);
        click(continueBtn);


    }

    public void closeNotification() {
        explicitWaitClickable(closeNotificationButton);
        click(closeNotificationButton);
    }

    public void clickContinue(){
        explicitWaitClickable(continueBtn);
        click(continueBtn);
    }

    public void Payment(String cardNumber, String month, String year, String nameCard, String codeCVV) {
        explicitWaitClickable(credit_cardNumberField);
        fillText(credit_cardNumberField, cardNumber);
        explicitWaitClickable(credit_cardMonthField);
        fillText(credit_cardMonthField, month);
        explicitWaitClickable(credit_cardYearField);
        fillText(credit_cardYearField, year);
        explicitWaitClickable(credit_cardNameField);
        fillText(credit_cardNameField, nameCard);
        explicitWaitClickable(credit_cardCode_cvvField);
        fillText(credit_cardCode_cvvField, codeCVV);
        explicitWaitClickable(acceptCheckbox);
        click(acceptCheckbox);
        click(payBtn);
    }

    public void backHome(){
        explicitWaitClickable(backHomeBtn);
        moveTo(backHomeBtn);
        click(backHomeBtn);
    }

    public void clickLogoBtn(){
        explicitWaitClickable(logoBtn);
        moveTo(logoBtn);
        click(logoBtn);
    }

    public void removeProductFromOrder(){
        explicitWaitClickable(remove_prodBtn);
        click(remove_prodBtn);
    }

    //Validations
    public String getSummary() {
        explicitWaitClickable(summary);
        return getText(summary);
    }
}
