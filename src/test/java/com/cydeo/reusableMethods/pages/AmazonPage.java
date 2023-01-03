package com.cydeo.reusableMethods.pages;

import com.cydeo.reusableMethods.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage extends TestBase {

    public AmazonPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy( xpath = "//*[@id=\"twotabsearchtextbox\"]")//FindBy is an annotation. It is a shortcut for FindElement (By.)
    public WebElement searchBox;//Bu ikili yapı standarttır. İstediğimiz kadar oluşturabiliriz. Farklı farklı locator da kullanabiliriz.

    @FindBy( xpath = "//a[@id='nav-cart']")
    public WebElement cart;

    @FindBy( css = "span.a-dropdown-label")
    public WebElement sort;

    @FindBy ( css = "a#s-result-sort-select_1")
    public WebElement sortByPriceLowToHigh;


    public void searchItem(String item){
        searchBox.sendKeys(item+ Keys.ENTER);
    }


    public void goCart(){
        cart.click();
    }


    public void sortItemsByPrice(){
        sort.click();
        sortByPriceLowToHigh.click();
    }
}
