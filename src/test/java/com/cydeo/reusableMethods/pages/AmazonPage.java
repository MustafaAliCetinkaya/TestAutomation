package com.cydeo.reusableMethods.pages;

import com.cydeo.reusableMethods.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage extends TestBase {

    public AmazonPage(){
        PageFactory.initElements (driver,this);
    }

    @FindBy( xpath = "//*[@id=\"twotabsearchtextbox\"]")//FindBy is an annotation. It is a shortcut for FindElement (By.)
    public static WebElement searchBox;//Bu ikili yapı standarttır. İstediğimiz kadar oluşturabiliriz. Farklı farklı locator da kullanabiliriz.

    @FindBy( xpath = "//a[@id='nav-cart']")
    public static WebElement cart;

    @FindBy( css = "span.a-dropdown-label")
    public static WebElement sort;

    @FindBy ( css = "a#s-result-sort-select_1")
    public static WebElement sortByPriceLowToHigh;


    public static void searchItem(String item){
        searchBox.sendKeys(item+ Keys.ENTER);
    }


    public static void goCart(){
        cart.click();
    }


    public static void sortItemsByPrice(){
        sort.click();
        sortByPriceLowToHigh.click();
    }
}
