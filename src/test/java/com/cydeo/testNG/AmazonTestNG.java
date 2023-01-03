package com.cydeo.testNG;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.reusableMethods.pages.AmazonPage;
import org.testng.annotations.Test;

public class AmazonTestNG extends TestBase {
    AmazonPage pageObject = new AmazonPage();

    @Test
    public void amazonShopping() {
        //First item
        pageObject.searchItem("game chair");
        pageObject.sortItemsByPrice();
        pageObject.addItem(pageObject.gameChair);
        pageObject.goCart();
        //Second item
        pageObject.searchItem("bags");
        pageObject.addItem(pageObject.bag);
        pageObject.goCart();
        //Go to the checkout page
        pageObject.goCheckoutPage();
    }
}
