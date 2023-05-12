package LatinafyPageObjects;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    private JavascriptExecutor js;
    private Actions actions;
    private WebDriverWait wait;
    private int timeOutInSeconds = 50;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        //wait = new WebDriverWait(driver,50);

    }

    public void fillText(WebElement el, String text) {
        // highlight

        // element is the WebElement that get the style

        el.clear();
        el.sendKeys(text);
    }

    public String getInnerText(WebElement el) {
        return el.getAttribute("innerText");

    }

    public String getText(WebElement el) {
        // js.executeScript("arguments[0].setAttribute('style', 'background -color:blue;
        // border: 1px solid orange;');",el);
        return el.getText();
    }

    public String getAttribute(WebElement el) {
        return el.getAttribute("value");
    }

    public void alertOK(String text) {
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public void alertOK() {
        driver.switchTo().alert().accept();
    }

    public void selectByValue(WebElement el, String value) {
        Select s = new Select(el);
        s.selectByValue(value);
    }

    // mouse options
    public void moveTo(WebElement el) {
        // Mouse hover menuOption
        actions.moveToElement(el).build().perform();

    }

    public void MultipleMouseActions(WebElement el){
        sleep(2000);
        hoverOverElement(el);
        sleep(2000);
        actions.moveToElement(el).build().perform();
        sleep(2000);
        actions.clickAndHold();

    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public void implicitWait(long timeunit) {
        driver.manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
    }

   /* public void explicitWaitClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }*/

    public void explicitWaitClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void explicitWaitVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected void waitForTextToDisappear(WebElement element, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(null, text)));
    }

    public void click(WebElement el) {
        // log
        // highlight
        // js.executeScript("arguments[0].setAttribute('style', 'background
        // -color:orange; border: 1px solid green;');",el);
        // explicitWaitClickable(el);
        el.click();
    }
    public String getUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
    //Perform mouse hover over element
    public void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    //Perform slide actionswith mouse

    public void slideActions(WebElement l,int lx,WebElement r,int rx){
        Actions action = new Actions(driver);
        actions.dragAndDropBy(l, lx, 0);
        actions.dragAndDropBy(r, -rx, 0);
        actions.build().perform();


    }

    public void getTitle(){
        driver.getTitle();
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void rollVertical1(){
        sleep(2000);
        js.executeScript("window.scrollBy(0, 1000)");
    }



    public void rollVerticalDinamic(int x, int y){
        sleep(2000);
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

}

