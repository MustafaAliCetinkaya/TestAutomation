package com.cydeo.reusableMethods.pages;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    public AmazonPage() {
        WebDriver driver=WebDriverFactory.getDriver(1);
        PageFactory.initElements(driver,this);
        driver.get("https://www.amazon.com");
    }

    @FindBy(css = "input#twotabsearchtextbox")//FindBy is an annotation. It is a shortcut for FindElement (By.)
    public WebElement searchBox;//Bu ikili yapı standarttır. İstediğimiz kadar oluşturabiliriz. Farklı farklı locator da kullanabiliriz.

    @FindBy(xpath = "//a[@href='/gp/cart/view.html?ref_=nav_cart']")
    public WebElement cart;

    @FindBy(xpath = "(//span[.='Add to Cart']//span)[1]")
    public WebElement addToCart;

    @FindBy(css = "span.a-dropdown-label")
    public WebElement sort;

    @FindBy(css = "a#s-result-sort-select_1")
    public WebElement sortByPriceLowToHigh;

    @FindBy(xpath = "(//span[@class=\"a-size-base-plus a-color-base a-text-normal\"])[2]")
    public WebElement selectItem;


    public void searchItem(String item) {
        searchBox.sendKeys(item + Keys.ENTER);
    }


    public void goCart() {
        cart.click();
    }


    public void sortItemsByPrice() {
        sort.click();
        sortByPriceLowToHigh.click();
    }


    public void addItem() {
        selectItem.click();
        addToCart.click();
    }
}
