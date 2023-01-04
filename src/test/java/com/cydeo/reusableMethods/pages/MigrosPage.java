package com.cydeo.reusableMethods.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MigrosPage {
    public WebDriver driver = Driver.getDriver();

    public MigrosPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Tümünü Kabul Et']")
    public static WebElement cookies;

    @FindBy(xpath = "//input[@id='product-search-combobox--trigger']")
    public static WebElement searchBox;

    @FindBy(xpath = "(//a[@class='mat-caption text-color-black product-name'])[2]")
    public static WebElement findItem;

    @FindBy(xpath = "(//button[contains(@class,'mat-mdc-button-base ng-star-inserted')])[1]")
    public static WebElement addToCart;

    //Fill the address details
    @FindBy(xpath = "//div[.='Tıkla Gel Al']")
    public static WebElement selectTheAddressDetails1;
    @FindBy(xpath = "//span[.='İl']")
    public static WebElement selectTheAddressDetails2;
    @FindBy(xpath = "//span[.=' Ankara ']")
    public static WebElement selectTheAddressDetails3;
    @FindBy(xpath = "//span[.='İlçe']")
    public static WebElement selectTheAddressDetails4;
    @FindBy(xpath = "//span[.=' Yenimahalle ']")
    public static WebElement selectTheAddressDetails5;
    @FindBy(xpath = "//span[.='Mağaza']")
    public static WebElement selectTheAddressDetails6;
    @FindBy(xpath = "//span[.=' ARMADA ']")
    public static WebElement selectTheAddressDetails7;

    //Go to the cart
    @FindBy(css = "#homepage-cart-button")
    public static WebElement goToCartStep1;
    @FindBy(xpath = "//Button[.='Sepete Git']")
    public static WebElement goToCartStep2;


    //Go to payment page
    @FindBy(css = "#checkout-summary-desktop-confirm-button")
    public static WebElement goToCheckout;
    @FindBy(xpath = "//span[.=' Üye olmadan devam et ']")
    public static WebElement continueWithoutSignOut;


    //Enter your personal information
    @FindBy(css = "#mat-input-1")
    public static WebElement personalInfo1;
    @FindBy(css = "#mat-input-2")
    public static WebElement personalInfo2;
    @FindBy(css = "#mat-input-3")
    public static WebElement personalInfo3;


    public static void searchItem(String item) {
        searchBox.sendKeys(item + Keys.ENTER);
    }

    public static void fillAddressDetails() throws InterruptedException {
        selectTheAddressDetails1.click();
        selectTheAddressDetails2.click();
        selectTheAddressDetails3.click();
        selectTheAddressDetails4.click();
        selectTheAddressDetails5.click();
        selectTheAddressDetails6.click();
        selectTheAddressDetails7.click();
        Thread.sleep(10000);
        addToCart.click();
    }

    public void addItem(WebElement element) {
        element.click();
        addToCart.click();
    }


    public static void acceptCookies() {
        cookies.click();
    }


    public static void goToTheCart() {
        goToCartStep1.click();
        goToCartStep2.click();
        goToCheckout.click();
        continueWithoutSignOut.click();
        personalInfo1.sendKeys("Mustafa Ali");
        personalInfo2.  sendKeys("Çetinkaya");
        personalInfo3.sendKeys("I signed the task. Enough for practice!");
    }

}
