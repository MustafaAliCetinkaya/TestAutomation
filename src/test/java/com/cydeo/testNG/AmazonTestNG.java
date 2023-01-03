package com.cydeo.testNG;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.reusableMethods.pages.AmazonPage;
import org.testng.annotations.Test;

public class AmazonTestNG extends TestBase {
    AmazonPage pageObject = new AmazonPage();

    @Test
    public void amazonShopping() {

        for (int i = 0; i <= 4; i++) {
            try {
                pageObject.searchItem("game chair");
                pageObject.sortItemsByPrice();
                pageObject.addItem();
                pageObject.goCart();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
